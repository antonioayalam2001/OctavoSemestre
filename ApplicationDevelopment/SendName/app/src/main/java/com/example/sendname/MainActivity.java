package com.example.sendname;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText jeditTextName;
    Button jconfirmName;
    Intent itn;
    //    Recibo los datos
    Bundle bundle;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        jeditTextName = ( EditText ) findViewById( R.id.editTextName );
        jconfirmName = ( Button ) findViewById( R.id.confirm_button );

        jconfirmName.setOnClickListener( this );
    }

    @Override
    public void onClick( View v ) {
        itn = new Intent( MainActivity.this, ResultActivity.class );
        bundle = new Bundle( );
        bundle.putString( "NAME", jeditTextName.getText( ).toString( ) );
        itn.putExtras( bundle );
        startActivity( itn );
    }
}