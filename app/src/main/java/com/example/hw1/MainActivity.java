package com.example.hw1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Serializable {

    private TextView textResult;
    private Result result;
    private String number1;
    private String number2;
    private int flag;
    private double answer;
    private final static String KEY_RESULT_1 = "Result 1";
    private final static String KEY_RESULT_2 = "Result 2";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        result = new Result();

        initView();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if(number2.equals("")) {
            outState.putSerializable(KEY_RESULT_1, number1);
        } else {
            outState.putSerializable(KEY_RESULT_2, number2);
        }
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if(number2.equals("")) {
            number1 = (String) savedInstanceState.getSerializable(KEY_RESULT_1);
            setTextResult(number1);
        } else {
            number2 = (String) savedInstanceState.getSerializable(KEY_RESULT_2);
            setTextResult(number2);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_0:
                clickNumber(result.getBottom0());
                break;
            case R.id.button_1:
                clickNumber(result.getBottom1());
                break;
            case R.id.button_2:
                clickNumber(result.getBottom2());
                break;
            case R.id.button_3:
                clickNumber(result.getBottom3());
                break;
            case R.id.button_4:
                clickNumber(result.getBottom4());
                break;
            case R.id.button_5:
                clickNumber(result.getBottom5());
                break;
            case R.id.button_6:
                clickNumber(result.getBottom6());
                break;
            case R.id.button_7:
                clickNumber(result.getBottom7());
                break;
            case R.id.button_8:
                clickNumber(result.getBottom8());
                break;
            case R.id.button_9:
                clickNumber(result.getBottom9());
                break;
            case R.id.button_ac:
                clear();
                textResult.setText("");
                break;
            case R.id.button_degree:
                flag = 4;
                break;
            case R.id.button_multi:
                flag = 3;
                break;
            case R.id.button_minus:
                flag = 2;
                break;
            case R.id.button_plus:
                flag = 1;
                break;
            case R.id.button_equal:
                try {
                    calculator();
                    break;
                } catch (NumberFormatException e) {
                    Toast.makeText(this, "Введите второе число!", Toast.LENGTH_LONG).show();
                }
            case R.id.button_comma:
                comma();
                break;
        }
    }

    private void initView() {
        textResult = findViewById(R.id.text_result);
        number1 = "";
        number2 = "";
        flag = 0;
        answer = 0;

        initButton0ClickListener();
        initButton1ClickListener();
        initButton2ClickListener();
        initButton3ClickListener();
        initButton4ClickListener();
        initButton5ClickListener();
        initButton6ClickListener();
        initButton7ClickListener();
        initButton8ClickListener();
        initButton9ClickListener();
        initButtonACClickListener();
        initButtonCommaClickListener();
        initButtonDegreeClickListener();
        initButtonEqualClickListener();
        initButtonMinusClickListener();
        initButtonMultiClickListener();
        initButtonPlusClickListener();
    }

    private void initButton0ClickListener() {
        Button button0 = findViewById(R.id.button_0);
        button0.setOnClickListener(this);
    }

    private void initButton1ClickListener() {
        Button button1 = findViewById(R.id.button_1);
        button1.setOnClickListener(this);
    }

    private void initButton2ClickListener() {
        Button button2 = findViewById(R.id.button_2);
        button2.setOnClickListener(this);
    }

    private void initButton3ClickListener() {
        Button button3 = findViewById(R.id.button_3);
        button3.setOnClickListener(this);
    }

    private void initButton4ClickListener() {
        Button button4 = findViewById(R.id.button_4);
        button4.setOnClickListener(this);
    }

    private void initButton5ClickListener() {
        Button button5 = findViewById(R.id.button_5);
        button5.setOnClickListener(this);
    }

    private void initButton6ClickListener() {
        Button button6 = findViewById(R.id.button_6);
        button6.setOnClickListener(this);
    }

    private void initButton7ClickListener() {
        Button button7 = findViewById(R.id.button_7);
        button7.setOnClickListener(this);
    }

    private void initButton8ClickListener() {
        Button button8 = findViewById(R.id.button_8);
        button8.setOnClickListener(this);
    }

    private void initButton9ClickListener() {
        Button button9 = findViewById(R.id.button_9);
        button9.setOnClickListener(this);
    }

    private void initButtonCommaClickListener() {
        Button buttonComma = findViewById(R.id.button_comma);
        buttonComma.setOnClickListener(this);
    }

    private void initButtonEqualClickListener() {
        Button buttonEqual = findViewById(R.id.button_equal);
        buttonEqual.setOnClickListener(this);
    }

    private void initButtonPlusClickListener() {
        Button buttonPlus = findViewById(R.id.button_plus);
        buttonPlus.setOnClickListener(this);
    }

    private void initButtonMinusClickListener() {
        Button buttonMinus = findViewById(R.id.button_minus);
        buttonMinus.setOnClickListener(this);
    }

    private void initButtonMultiClickListener() {
        Button buttonMulti = findViewById(R.id.button_multi);
        buttonMulti.setOnClickListener(this);
    }

    private void initButtonDegreeClickListener() {
        Button buttonDegree = findViewById(R.id.button_degree);
        buttonDegree.setOnClickListener(this);
    }

    private void initButtonACClickListener() {
        Button buttonAC = findViewById(R.id.button_ac);
        buttonAC.setOnClickListener(this);
    }

    private void setTextResult(String number) {
            textResult.setText(number);
    }

    private void clickNumber(String number) {
        if (flag == 0) {
            number1 = number1 + number;
            setTextResult(number1);
        } else {
            number2 = number2 + number;
            setTextResult(number2);
        }
    }

    private void clear() {
        number1 = "";
        number2 = "";
        flag = 0;
    }

    private void calculator() {
        double numb1;
        double numb2;

        numb1 = Double.parseDouble(number1);
        numb2 = Double.parseDouble(number2);

        switch (flag) {
            case 1:
                answer = numb1 + numb2;
                setTextResult(Double.toString(answer));
                number1 = Double.toString(answer);
                number2 = "";
                break;
            case 2:
                answer = numb1 - numb2;
                setTextResult(Double.toString(answer));
                number1 = Double.toString(answer);
                number2 = "";
                break;
            case 3:
                answer = numb1 * numb2;
                setTextResult(Double.toString(answer));
                number1 = Double.toString(answer);
                number2 = "";
                break;
            case 4:
                try {
                    answer = numb1 / numb2;
                    setTextResult(Double.toString(answer));
                    number1 = Double.toString(answer);
                    number2 = "";
                    break;
                } catch (ArithmeticException e) {
                    Toast.makeText(this, "Нельзя делить на ноль!", Toast.LENGTH_LONG).show();
                }
        }
    }

    private void comma() {
        if (flag == 0) {
            if (number1.length() != 0) {
                clickNumber(".");
            } else {
                clickNumber("0.");
            }
        } else {
            if (number2.length() != 0) {
                clickNumber(".");
            } else {
                clickNumber("0.");
            }
        }
    }
}