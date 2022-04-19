package kr.co.company.restaurantreservation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CalendarView cal = (CalendarView) findViewById(R.id.calendarView);
        cal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {
                EditText date = (EditText) findViewById(R.id.textDate);
                date.setText(year+"/"+(month+1)+"/"+dayOfMonth);
            }
        });

        TimePicker time = (TimePicker) findViewById(R.id.timePicker);
        time.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int hourOfDay, int minute) {
                EditText time =(EditText) findViewById(R.id.textTime);
                time.setText(hourOfDay+":"+minute);
            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.reservemenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.clear) {
            final Calendar c = Calendar.getInstance();
            CalendarView cal = (CalendarView) findViewById(R.id.calendarView);
            TimePicker timePicker = (TimePicker) findViewById(R.id.timePicker);
            cal.setDate(c.getTimeInMillis());
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH );
            int dayOfMonth = c.get(Calendar.DAY_OF_MONTH);
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int min = c.get(Calendar.MINUTE);
            timePicker.setHour(hour);
            timePicker.setMinute(min);
            EditText time =(EditText) findViewById(R.id.textTime);
            time.setText(hour+":"+min);
            EditText date = (EditText) findViewById(R.id.textDate);
            date.setText(year+"/"+(month+1)+"/"+dayOfMonth);
        }
        return true;
    }
}