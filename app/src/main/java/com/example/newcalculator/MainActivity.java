package com.example.newcalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView resultTextView;
    private EditText inputEditText;
    private double valueOne = Double.NaN;
    private double valueTwo;
    private char currentAction;

    private final char ADDITION = '+';
    private final char SUBTRACTION = '-';
    private final char MULTIPLICATION = '*';
    private final char DIVISION = '/';
    private final char EQUAL = '=';

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.resultTextView);
        inputEditText = findViewById(R.id.inputEditText);

        Button button0 = findViewById(R.id.button_0);
        Button button1 = findViewById(R.id.button_1);
        Button button2 = findViewById(R.id.button_2);
        Button button3 = findViewById(R.id.button_3);
        Button button4 = findViewById(R.id.button_4);
        Button button5 = findViewById(R.id.button_5);
        Button button6 = findViewById(R.id.button_6);
        Button button7 = findViewById(R.id.button_7);
        Button button8 = findViewById(R.id.button_8);
        Button button9 = findViewById(R.id.button_9);
        Button buttonAdd = findViewById(R.id.button_add);
        Button buttonSubtract = findViewById(R.id.button_subtract);
        Button buttonMultiply = findViewById(R.id.button_multiply);
        Button buttonDivide = findViewById(R.id.button_divide);
        Button buttonEquals = findViewById(R.id.button_equals);
        Button buttonDot = findViewById(R.id.button_dot);


        button0.setOnClickListener(v -> appendToInputText("0"));
        button1.setOnClickListener(v -> appendToInputText("1"));
        button2.setOnClickListener(v -> appendToInputText("2"));
        button3.setOnClickListener(v -> appendToInputText("3"));
        button4.setOnClickListener(v -> appendToInputText("4"));
        button5.setOnClickListener(v -> appendToInputText("5"));
        button6.setOnClickListener(v -> appendToInputText("6"));
        button7.setOnClickListener(v -> appendToInputText("7"));
        button8.setOnClickListener(v -> appendToInputText("8"));
        button9.setOnClickListener(v -> appendToInputText("9"));
        buttonDot.setOnClickListener(v -> appendToInputText("."));


        buttonAdd.setOnClickListener(v -> performOperation(ADDITION));
        buttonSubtract.setOnClickListener(v -> performOperation(SUBTRACTION));
        buttonMultiply.setOnClickListener(v -> performOperation(MULTIPLICATION));
        buttonDivide.setOnClickListener(v -> performOperation(DIVISION));


        buttonEquals.setOnClickListener(v -> calculateResult());
    }


    private void appendToInputText(String value) {
        inputEditText.append(value);
    }


    private void performOperation(char operation) {
        if (!Double.isNaN(valueOne)) {
            valueTwo = Double.parseDouble(inputEditText.getText().toString());
            inputEditText.setText(null);
            switch (currentAction) {
                case ADDITION:
                    valueOne = valueOne + valueTwo;
                    break;
                case SUBTRACTION:
                    valueOne = valueOne - valueTwo;
                    break;
                case MULTIPLICATION:
                    valueOne = valueOne * valueTwo;
                    break;
                case DIVISION:
                    valueOne = valueOne / valueTwo;
                    break;
            }
        } else {
            valueOne = Double.parseDouble(inputEditText.getText().toString());
        }
        currentAction = operation;
        resultTextView.setText(String.valueOf(valueOne));
        inputEditText.setText(null);
    }

    
    private void calculateResult() {
        valueTwo = Double.parseDouble(inputEditText.getText().toString());
        switch (currentAction) {
            case ADDITION:
                valueOne = valueOne + valueTwo;
                break;
            case SUBTRACTION:
                valueOne = valueOne - valueTwo;
                break;
            case MULTIPLICATION:
                valueOne = valueOne * valueTwo;
                break;
            case DIVISION:
                valueOne = valueOne / valueTwo;
                break;
        }
        resultTextView.setText(String.valueOf(valueOne));
        inputEditText.setText(null);
        valueOne = Double.NaN;
        currentAction = EQUAL;
    }
}