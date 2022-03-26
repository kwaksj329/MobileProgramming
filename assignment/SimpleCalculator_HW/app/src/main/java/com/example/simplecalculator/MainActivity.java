package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.TestLooperManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int opnd = 0;
    private int oper = 0;
    private int value0 = 0;
    private int value1 = 0;
    private float text_result = 0;

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
                    value0 = 0;
                    final TextView txtResult = (TextView)findViewById(R.id.textView);
                    txtResult.setText("0");
                }
        );
        ((Button)findViewById(R.id.button_plus)).setOnClickListener(
                (v) -> {add();}
        );
        ((Button)findViewById(R.id.button_sub)).setOnClickListener(
                (v) -> {sub();}
        );
        ((Button)findViewById(R.id.button_mul)).setOnClickListener(
                (v) -> {mul();}
        );
        ((Button)findViewById(R.id.button_div)).setOnClickListener(
                (v) -> {div();}
        );
        ((Button)findViewById(R.id.button_calc)).setOnClickListener(
                (v) -> {calc();}
        );
    }

    private void appendDigit(int a){
        opnd = opnd*10 + a;
        final TextView txtResult = (TextView)findViewById(R.id.textView);
        txtResult.setText(""+opnd);
    }

    private void add(){
        value0 = opnd;
        opnd = 0;
        oper = 1;
    }

    private void sub(){
        value0 = opnd;
        opnd = 0;
        oper = 2;
    }

    private void mul(){
        value0 = opnd;
        opnd = 0;
        oper = 3;
    }

    private void div(){
        value0 = opnd;
        opnd = 0;
        oper = 4;
    }

    private void calc(){
        value1 = opnd;
        if (oper == 1){
            final TextView txtResult = (TextView)findViewById(R.id.textView);
            txtResult.setText(""+(value0 + value1));
        }
        else if (oper == 2){
            final TextView txtResult = (TextView)findViewById(R.id.textView);
            txtResult.setText(""+(value0 - value1));
        }
        else if (oper == 3){
            final TextView txtResult = (TextView)findViewById(R.id.textView);
            txtResult.setText(""+(value0 * value1));
        }
        else if (oper == 4){
            if (value1 != 0) {
                if (value0 % value1 == 0) {
                    final TextView txtResult = (TextView) findViewById(R.id.textView);
                    txtResult.setText("" + (value0 / value1));
                }else {
                    final TextView txtResult = (TextView) findViewById(R.id.textView);
                    txtResult.setText("" + (value0 / (float) value1));
                }
            }else{
                final TextView txtResult = (TextView) findViewById(R.id.textView);
                txtResult.setText("Divide by zero error");
            }
        }
        value0 = 0;
        value1 = 0;
        opnd = 0;
    }

}