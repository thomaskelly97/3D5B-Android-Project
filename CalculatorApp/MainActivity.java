package com.example.test01;

import android.widget.Button;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button button0, button1, button2, button3,button4,button5,button6,button7,button8,button9,buttonAdd,button10,buttonSub,buttonMul,buttonDivision,
    buttonC, buttonEqual;
    EditText crunchifyEditText;

    float value1, value2;

    boolean Cadd,Csub,Cmult, Cdiv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        button10 = (Button) findViewById(R.id.button10);
        buttonAdd = (Button) findViewById(R.id.buttonadd);
        buttonSub = (Button) findViewById(R.id.buttonsub);
        buttonMul = (Button) findViewById(R.id.buttonmul);
        buttonDivision = (Button) findViewById(R.id.buttondiv);
        buttonC = (Button) findViewById(R.id.buttonC);
        buttonEqual = (Button) findViewById(R.id.buttoneql);
        crunchifyEditText = (EditText) findViewById(R.id.edt1);

        button1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                crunchifyEditText.setText(crunchifyEditText.getText() + "1");
            }
    });

        button2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                crunchifyEditText.setText(crunchifyEditText.getText() + "2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                crunchifyEditText.setText(crunchifyEditText.getText() + "3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                crunchifyEditText.setText(crunchifyEditText.getText() + "4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                crunchifyEditText.setText(crunchifyEditText.getText() + "5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                crunchifyEditText.setText(crunchifyEditText.getText() + "6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                crunchifyEditText.setText(crunchifyEditText.getText() + "7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                crunchifyEditText.setText(crunchifyEditText.getText() + "8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                crunchifyEditText.setText(crunchifyEditText.getText() + "9");
            }
        });

        button0.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                crunchifyEditText.setText(crunchifyEditText.getText() + "0");
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(crunchifyEditText == null){
                    crunchifyEditText.setText("");
                } else {
                    value1 = Float.parseFloat(crunchifyEditText.getText()+ "");
                    Cadd = true;
                    crunchifyEditText.setText(null);
                }
            }
        });
        buttonSub.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                    value1 = Float.parseFloat(crunchifyEditText.getText()+ "");
                    Csub = true;
                    crunchifyEditText.setText(null);

            }
        });

        buttonMul.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                value1 = Float.parseFloat(crunchifyEditText.getText()+ "");
                Csub = true;
                crunchifyEditText.setText(null);

            }
        });

        buttonDivision.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                value1 = Float.parseFloat(crunchifyEditText.getText()+ "");
                Csub = true;
                crunchifyEditText.setText(null);

            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value2 = Float.parseFloat(crunchifyEditText.getText() + "");

                if (Cadd == true) {
                    crunchifyEditText.setText(value1 + value2 + "");
                    Cadd = false;
                }

                if (Csub == true) {
                    crunchifyEditText.setText(value1 - value2 + "");
                    Csub = false;
                }

                if (Cmult == true) {
                    crunchifyEditText.setText(value1 * value2 + "");
                    Cmult = false;
                }

                if (Cdiv == true) {
                    crunchifyEditText.setText(value1 / value2 + "");
                    Cdiv = false;
                }
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crunchifyEditText.setText("");
            }
        });

        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crunchifyEditText.setText(crunchifyEditText.getText() + ".");
            }
        });

  }
}

