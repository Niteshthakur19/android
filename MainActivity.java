package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textViewOutput;
    private String input = "";
    private double num1 = 0;
    private double num2 = 0;
    private String operator = "";
    private boolean hasDecimal = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewOutput = findViewById(R.id.textViewOutput);
    }

    // Method to handle digit button clicks
    public void onDigitClick(View view) {
        Button button = (Button) view;
        String digit = button.getText().toString();
        input += digit;
        textViewOutput.setText(input);
    }

    // Method to handle decimal button click
    public void onDecimalClick(View view) {
        if (!hasDecimal) {
            input += ".";
            textViewOutput.setText(input);
            hasDecimal = true;
        }
    }

    // Method to handle operator button clicks (+, -, *, /)
    public void onOperatorClick(View view) {
        Button button = (Button) view;
        operator = button.getText().toString();
        num1 = Double.parseDouble(input);
        input = "";
        textViewOutput.setText("0");
        hasDecimal = false;
    }

    // Method to handle clear (C) button click
    public void onClearButtonClick(View view) {
        input = "";
        num1 = 0;
        num2 = 0;
        operator = "";
        textViewOutput.setText("0");
        hasDecimal = false;
    }

    // Method to handle equals (=) button click
    public void onEqualsClick(View view) {
        num2 = Double.parseDouble(input);
        double result = 0;

        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
        }

        textViewOutput.setText(String.valueOf(result));
        input = String.valueOf(result);
        num1 = result;
        num2 = 0;
        operator = "";
        hasDecimal = false;
    }
}
