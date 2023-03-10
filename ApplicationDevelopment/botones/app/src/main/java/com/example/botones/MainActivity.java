package com.example.botones;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button jbn2;

    @Override
    public void onCreate( Bundle b ) {
        super.onCreate( b );
        setContentView( R.layout.activity_main );
        jbn2 = ( Button ) findViewById( R.id.xbn2 );    // MÉTODO 2
        jbn2.setOnClickListener( new OnClickListener( ) {
            public void onClick( View v ) {
                showToastMessage( "Botón digitado: xbn2\nUtiliza: new OnClickListener{}" );
            }
        } );
    }

    private void showToastMessage( String msg ) {
        Toast toast = Toast.makeText( this, msg, Toast.LENGTH_SHORT );
        toast.show( );
    }

}