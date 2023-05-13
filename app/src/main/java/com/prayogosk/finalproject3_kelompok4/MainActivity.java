package com.prayogosk.finalproject3_kelompok4;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    String oldNumber = "";
    String op = "+";
    Boolean isNewOp = true;
    TextView edl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edl = findViewById(R.id.textView);
    }

    public void numberEvent(View view) {
        if (isNewOp)
            edl.setText("");
        isNewOp = false;

        String number = edl.getText().toString();
        switch (view.getId()){
            case R.id.bu1:
                number +="1";
                break;
            case R.id.bu2:
                number +="2";
                break;
            case R.id.bu3:
                number +="3";
                break;
            case R.id.bu4:
                number +="4";
                break;
            case R.id.bu5:
                number +="5";
                break;
            case R.id.bu6:
                number +="6";
                break;
            case R.id.bu7:
                number +="7";
                break;
            case R.id.bu8:
                number +="8";
                break;
            case R.id.bu9:
                number +="9";
                break;
            case R.id.buNol:
                number +="0";
                break;
            case R.id.buKoma:
                if (!edl.getText().toString().contains(".")) {
                    number += ".";
                }
                break;
        }

        edl.setText(number);
    }

    public void OperatorEvent(View view) {
        isNewOp = true;
        oldNumber = edl.getText().toString();
        switch (view.getId()){
            case R.id.buPlus:
                op = "+"; break;
            case R.id.buMinus:
                op = "-"; break;
            case R.id.buDivide:
                op = "/"; break;
            case R.id.buMultiply:
                op = "X"; break;
        }
    }

    public void answerEvent(View view) {
        String newNumber = edl.getText().toString();
        double result = 0.0 ;
        switch (op){
            case "+":
                result = Double.parseDouble(oldNumber)+Double.parseDouble(newNumber);
                break;
            case "-":
                result = Double.parseDouble(oldNumber)-Double.parseDouble(newNumber);
                break;
            case "X":
                result = Double.parseDouble(oldNumber)*Double.parseDouble(newNumber);
                break;
            case "/":
                result = Double.parseDouble(oldNumber)/Double.parseDouble(newNumber);
                break;
        }
        edl.setText(result+"");
    }

    public void delEvent(View view) {
        edl.setText("0");
        isNewOp = true;
    }

    public void persenEvent(View view) {
        double no = Double.parseDouble(edl.getText().toString())/100;
        edl.setText(no+"");
        isNewOp = true;
    }
}