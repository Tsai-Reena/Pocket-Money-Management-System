package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class ExpensesOption extends AppCompatActivity implements View.OnClickListener{

    int var1;
    int var2 = 0;
    String str = "";
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    Button btn_plus, btn_minus, btn_clear, btn_equals;
    ImageButton btn_del;
    TextView string_ans, result;
    String before;
    String operator = "";
    RadioGroup expensesType;
    int answer = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expenses_option);

        Intent it = getIntent();
        before = it.getStringExtra("total");

        btn0 = findViewById(R.id.btn_0);
        btn1 = findViewById(R.id.btn_1);
        btn2 = findViewById(R.id.btn_2);
        btn3 = findViewById(R.id.btn_3);
        btn4 = findViewById(R.id.btn_4);
        btn5 = findViewById(R.id.btn_5);
        btn6 = findViewById(R.id.btn_6);
        btn7 = findViewById(R.id.btn_7);
        btn8 = findViewById(R.id.btn_8);
        btn9 = findViewById(R.id.btn_9);

        btn_plus = findViewById(R.id.btn_plus);
        btn_minus = findViewById(R.id.btn_minus);
        btn_clear = findViewById(R.id.btn_clear);
        btn_del = findViewById(R.id.btn_del);
        btn_equals = findViewById(R.id.btn_equals);

        string_ans = findViewById(R.id.answer);
        result = findViewById(R.id.result);

        expensesType = findViewById(R.id.expensesType);
    }

    public void send(View v)
    {
        Intent it = new Intent();
        String str;
        it.setClass(ExpensesOption.this, MainActivity.class);
        if(answer > 0){
            answer = answer * (-1);
        }
        it.putExtra("expenses", Integer.toString(answer));
        answer += Integer.parseInt(before);
        str = Integer.toString(answer);
        it.putExtra("total", str);
        startActivity(it);
    }

    public void onClick(View view)
    {
        //string_ans.setText("btn0");
        if(view.getId() == btn0.getId()) {
            str = str + btn0.getText().toString();
            string_ans.setText("" + str);
        }
        else if(view.getId() == btn1.getId()) {
            str = str + btn1.getText().toString();
            string_ans.setText("" + str);
        }
        else if(view.getId() == btn2.getId()) {
            str = str + btn2.getText().toString();
            string_ans.setText("" + str);
        }
        else if(view.getId() == btn3.getId()) {
            str = str + btn3.getText().toString();
            string_ans.setText("" + str);
        }
        else if(view.getId() == btn4.getId()) {
            str = str + btn4.getText().toString();
            string_ans.setText("" + str);
        }
        else if(view.getId() == btn5.getId()) {
            str = str + btn5.getText().toString();
            string_ans.setText("" + str);
        }
        else if(view.getId() == btn6.getId()) {
            str = str + btn6.getText().toString();
            string_ans.setText("" + str);
        }
        else if(view.getId() == btn7.getId()) {
            str = str + btn7.getText().toString();
            string_ans.setText("" + str);
        }
        else if(view.getId() == btn8.getId()) {
            str = str + btn8.getText().toString();
            string_ans.setText("" + str);
        }
        else if(view.getId() == btn9.getId()) {
            str = str + btn9.getText().toString();
            string_ans.setText("" + str);
        }
        else if(view.getId() == btn_equals.getId()) {
            // ?????? var2
            var2 = Integer.parseInt(str);
            str = "";

            // ???????????????
            if (operator.equals("plus")){
                answer = var1 + var2;
            }
            else if (operator.equals("minus")){
                answer = var1 - var2;
            }
            else{
                answer = var1;
            }
            string_ans.setText(Integer.toString(answer));

            // ??????????????????????????????
            switch (expensesType.getCheckedRadioButtonId()){
                case R.id.eatingUnit:
                    result.setText("You spent TWD " + Integer.toString(answer) + " on Eating.");
                    break;
                case R.id.dressingUnit:
                    result.setText("You spent TWD " + Integer.toString(answer) + " on Dressing.");
                    break;
                case R.id.roomUnit:
                    result.setText("You spent TWD " + Integer.toString(answer) + " on Room.");
                    break;
                case R.id.transportationUnit:
                    result.setText("You spent TWD " + Integer.toString(answer) + " on Transportation.");
                    break;
                case R.id.studyUnit:
                    result.setText("You spent TWD " + Integer.toString(answer) + " on Studying.");
                    break;
                case R.id.entertainmentUnit:
                    result.setText("You spent TWD " + Integer.toString(answer) + " on Entertainment.");
                    break;
            }
        }
        else if(view.getId() == btn_clear.getId()){
            // ??????????????????
            str = "";
            string_ans.setText("" + str);
        }
        else if (view.getId() == btn_del.getId()) {
            str = str.substring(0, str.length()-1);
            string_ans.setText("" + str);
        }
        else{
            // ?????? var1 ??????
            var1 = Integer.parseInt(str);
            str = "";
            if(view.getId() == btn_plus.getId()){
                operator = "plus";
            }
            else if (view.getId() == btn_minus.getId()) {
                operator = "minus";
            }
            else {
                string_ans.setText("Error!!");
                string_ans.setTextColor(Color.RED);
            }
        }
    }
}