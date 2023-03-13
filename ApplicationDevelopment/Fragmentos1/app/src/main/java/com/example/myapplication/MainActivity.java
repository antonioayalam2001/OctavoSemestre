package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.MiFragmento.FragmentoListener;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements FragmentoListener {

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        TextView xtv;
        Button jbn;

        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        xtv = ( TextView ) findViewById( R.id.xtv );
        jbn = ( Button ) findViewById( R.id.xbn );
        jbn.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick( View v ) {
                FragmentManager fm = getFragmentManager( );
                Fragment f = fm.findFragmentByTag( "editor" );
                if ( null == f ) {
                    FragmentTransaction ft = fm.beginTransaction( );
                    ft.add( R.id.xfl,  new MiFragmento() , "editor" );
                    ft.commit( );
                }
                xtv.setText( "" );
                Toast.makeText( MainActivity.this, "Utilizando Fragment",
                        Toast.LENGTH_LONG ).show( );
            }
        } );
    }

    @Override
    public void digitado( int r, String s ) {
        TextView jtv = ( TextView ) findViewById( R.id.xtv );
        if ( r == MiFragmento.OK ) {

            jtv.setText( s );
        }
        FragmentManager fm = getFragmentManager( );
        Fragment fe = fm.findFragmentByTag( "editor" );
        FragmentTransaction ft = fm.beginTransaction( );
        ft.remove( fe );
        ft.commit( );

    }
}