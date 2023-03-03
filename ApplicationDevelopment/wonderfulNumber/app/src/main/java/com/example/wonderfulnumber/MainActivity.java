package com.example.wonderfulnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button jbtnN;
    TextView jtvR;
    EditText jetN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Getting the text view panel to show the results
        jtvR = (TextView) findViewById(R.id.xtvR);
        //        Getting the input field
        jetN = (EditText) findViewById(R.id.xet1);
//        Getting the button to trigger the results
        jbtnN = (Button) findViewById(R.id.xbt);
//        Adding the listener


        jbtnN.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        wonderful();
    }

    public void wonderful() {
        int number = Integer.parseInt((jetN.getText() + ""));
        int initialNumber = Integer.parseInt((jetN.getText() + ""));

        jtvR.setText("");
        do {
            if (number % 2 == 0) {
                number /= 2;
            } else {
                number = (number * 3) + 1;
            }
            jtvR.append(number + "\n");
        } while (number != 1);

        jtvR.append("El numero ingresado por el usuario : " + initialNumber + " ES MARAVILLOSO \n");

    }
}