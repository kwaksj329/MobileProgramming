package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.TestLooperManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int opnd = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((Button)findViewById(R.id.button_0)).setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View view){
                        appendDigit(0);
                    }
                }
        );
        ((Button)findViewById(R.id.button_1)).setOnClickListener(
                (v) -> {appendDigit(1);}
        );
        ((Button)findViewById(R.id.button_2)).setOnClickListener(
                (v) -> {appendDigit(2);}
        );
        ((Button)findViewById(R.id.button_3)).setOnClickListener(
                (v) -> {appendDigit(3);}
        );
        ((Button)findViewById(R.id.button_4)).setOnClickListener(
                (v) -> {appendDigit(4);}
        );
        ((Button)findViewById(R.id.button_5)).setOnClickListener(
                (v) -> {appendDigit(5);}
        );
        ((Button)findViewById(R.id.button_6)).setOnClickListener(
                (v) -> {appendDigit(6);}
        );
        ((Button)findViewById(R.id.button_7)).setOnClickListener(
                (v) -> {appendDigit(7);}
        );
        ((Button)findViewById(R.id.button_8)).setOnClickListener(
                (v) -> {appendDigit(8);}
        );
        ((Button)findViewById(R.id.button_9)).setOnClickListener(
                (v) -> {appendDigit(9);}
        );
        ((Button)findViewById(R.id.button_c)).setOnClickListener(
                (v) -> { opnd = 0;
                    final TextView txtResult = (TextView)findViewById(R.id.textView);
                    txtResult.setText("0");
                }
        );
    }

    private void appendDigit(int a){
        opnd = opnd*10 + a;
        final TextView txtResult = (TextView)findViewById(R.id.textView);
        txtResult.setText(""+opnd);
    }

}