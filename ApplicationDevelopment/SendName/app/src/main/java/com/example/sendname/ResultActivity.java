package com.example.sendname;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {
    TextView jtVr;
    Button jbtnReturn;
    //    Cambio de pantallas
    Intent itn;
    //    Recibo los datos
    Bundle bundle;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_results );

        jtVr = ( TextView ) findViewById( R.id.xtVr );
        jbtnReturn = ( Button ) findViewById( R.id.xbtnReturn );
        bundle = getIntent( ).getExtras( );
        jtVr.setText( bundle.getString( "NAME" ) );
        jbtnReturn.setOnClickListener( this );

    }

    @Override
    public void onClick( View v ) {
        itn = new Intent( ResultActivity.this, MainActivity.class );
        startActivity( itn );

    }
}
