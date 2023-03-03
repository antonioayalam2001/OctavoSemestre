package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView jtVr;
    EditText jeTa, jeTb, jeTc;
    Button jbtnRes;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        jtVr = ( TextView ) findViewById( R.id.xtVr );
        jbtnRes = ( Button ) findViewById( R.id.xbtnSol );

        jbtnRes.setOnClickListener( this );


    }

    @Override
    public void onClick( View v ) {
        getSolution( );
    }

    private void getSolution( ) {
        jtVr.setText( "" );

        jeTa = ( EditText ) findViewById( R.id.xeTa );
        jeTb = ( EditText ) findViewById( R.id.xeTb );
        jeTc = ( EditText ) findViewById( R.id.xeTc );
        String aText = jeTa.getText( ).toString( ).trim( );
        String bText = jeTb.getText( ).toString( ).trim( );
        String cText = jeTc.getText( ).toString( ).trim( );

        if ( aText.equals( "" ) || bText.equals( "" ) || cText.equals( "" ) ) {
            Context context = getApplicationContext( );
            CharSequence text = "Alguno de los valores esta vacio!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText( context, text, duration );
            toast.show( );
        } else {


            double a = Double.parseDouble( aText );
            double b = Double.parseDouble( bText );
            double c = Double.parseDouble( cText );


            if ( a == 0 ) {
                jtVr.setText( "El valor de a no puede ser 0" );
                Context context = getApplicationContext( );
                CharSequence text = "El valor de a no puede ser 0 ";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText( context, text, duration );
                toast.show( );
            } else {

                DecimalFormat decimalFormat = new DecimalFormat( "#.00" );
                double potencia = Math.pow( b, 2 ) - ( 4 * a * c );

                if ( potencia > 0 ) {
                    double x1 = ( -b - Math.sqrt( potencia ) ) / ( 2 * a );
                    double x2 = ( -b + Math.sqrt( potencia ) ) / ( 2 * a );
                    jtVr.setText( "\n Resultados \n  X1:" + decimalFormat.format( x1 ) + "\n" + "X2: " + decimalFormat.format( x2 ) );

                } else if ( potencia == 0 ) {
                    double x1 = ( ( -b ) - ( 4 * a * c ) ) / ( 2 * a );
                    jtVr.setText( "\n Solo hay una solucion ya que la potencia fue 0\n X1 :  " + decimalFormat.format( x1 ) );

                } else {
                    //Parte positiva de la raiz
                    double x1 = ( Math.sqrt( potencia * -1 ) ) / ( 2 * a );
                    //Parte negativa de la raiz
                    double x2 = -( Math.sqrt( potencia * -1 ) ) / ( 2 * a );
                    //Parte real de la raiz
                    double x3 = -b / ( 2 * a );

                    String sign = x2 > 0 ? " + " : " ";
                    jtVr.setText(
                            "\n Resultados \n  X1: " +
                                    x3 + "  +  " + decimalFormat.format( x1 ) + "i \n" + "X2:   " + x3 + sign + decimalFormat.format( x2 ) + "i" );
                }
            }
        }
    }
}