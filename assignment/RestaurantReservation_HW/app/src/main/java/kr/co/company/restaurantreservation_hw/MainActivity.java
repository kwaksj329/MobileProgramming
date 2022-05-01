package kr.co.company.restaurantreservation_hw;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

import kr.co.company.restaurantreservation.R;

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
        Button reservationButton = (Button) findViewById(R.id.button);
        reservationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open(view);
            }
        });
    }
    public void open(View view){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        EditText date = (EditText) findViewById(R.id.textDate);
        EditText time =(EditText) findViewById(R.id.textTime);

        String[] dateArray = date.getText().toString().split("/");

        alertDialogBuilder.setMessage(dateArray[0]+"년 " + dateArray[1] + "월 " + dateArray[2] + "일 " +time.getText().toString() + "분에 예약하시겠습니까?");
        alertDialogBuilder.setPositiveButton("예약",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        Toast.makeText(MainActivity.this,
                                dateArray[0] + "년 " + dateArray[1] + "월 " + dateArray[2] + "일 " +time.getText().toString() +
                                        "분에 예약되었습니다.",Toast.LENGTH_LONG).show();
                    }
                });
        alertDialogBuilder.setNegativeButton("취소",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,
                        "예약이 취소되었습니다.",Toast.LENGTH_LONG).show();
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
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