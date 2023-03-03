package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.*;
import android.os.*;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView jtv1;
    EditText jet1;
    Button jbt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jtv1 = (TextView) findViewById(R.id.xtv1);
        jet1 = (EditText) findViewById(R.id.xet1);
        jbt1 = (Button) findViewById(R.id.xbt);

        jbt1.setOnClickListener(this);

        jtv1.setText("ESCOM");
    }

    public void onClick(View v) {
        jtv1.setText("Viva Mexico");
    }

}