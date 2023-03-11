package com.example.layouts;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnFocusChangeListener {

    EditText jeTmS;
    Button jButtonCnf;


    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        jButtonCnf = ( Button ) findViewById( R.id.xButtonCnf );
        jeTmS = ( EditText ) findViewById( R.id.xeTmS );
        jeTmS.setOnFocusChangeListener( this );
        jButtonCnf.setOnClickListener( this );

    }


    @Override
    public void onFocusChange( View v, boolean hasFocus ) {

        if ( hasFocus ) {
            jeTmS.setText( "" );
        } else if ( jeTmS.getText( ).toString( ).equals( "" ) ) {
            jeTmS.setText( "Ingresa un numero impar" );
        }

    }

    @Override
    public void onClick( View v ) {
        cleanLayout( );
        jeTmS = ( EditText ) findViewById( R.id.xeTmS );
        try {
            int n = Integer.parseInt( jeTmS.getText( ).toString( ) );
            if ( n % 2 == 0 ) {
                Toast.makeText( getApplicationContext( ), "El numero debe ser impar", Toast.LENGTH_LONG ).show( );
                return;
            }
            getSolution( n );
        } catch ( NumberFormatException e ) {
            Toast.makeText( getApplicationContext( ), "No ingresaste un numero", Toast.LENGTH_LONG ).show( );
        }
    }

    private void cleanLayout( ) {
        // Obtener el TableLayout de la vista
        TableLayout tableLayout = ( TableLayout ) findViewById( R.id.table_layout );
        int rowCount = tableLayout.getChildCount( );
        for ( int i = tableLayout.getChildCount( ) - 1; i >= 0; i-- ) {
            View view = tableLayout.getChildAt( i );
            if ( view instanceof TableRow ) {
                tableLayout.removeView( view );
            }
        }
    }

    private void getSolution( int n ) {
        int matrix[][] = new int[ n ][ n ];

        // Llena de ceros la matrix
        for ( int i = 0; i < n; i++ ) {
            for ( int j = 0; j < n; j++ ) {
                matrix[ i ][ j ] = 0;
            }
        }

        fillMatrix( n, matrix );
        generateAndroidSolution( matrix, n );

    }

    private void generateAndroidSolution( int[][] matrix, int n ) {
        TableLayout tableLayout = ( TableLayout ) findViewById( R.id.table_layout );
        // Generar las filas y columnas
        for ( int i = 0; i < n; i++ ) {
            // Crear una nueva fila
            TableRow tableRow = new TableRow( this );

            // Configurar el layout de la fila
            TableLayout.LayoutParams tableRowParams = new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.WRAP_CONTENT );
            tableRow.setLayoutParams( tableRowParams );

            // Agregar las celdas a la fila
            for ( int j = 0; j < n; j++ ) {
                // Crear una nueva celda
                TextView textView = new TextView( this );

                // Configurar el texto de la celda
                textView.setText( matrix[ i ][ j ] + "" );
                textView.setGravity( Gravity.CENTER );
                System.out.println( textView.findViewById( textView.getId( ) ) );
                // Configurar el layout de la celda
                textView.setLayoutParams( new TableRow.LayoutParams(
                        0, TableRow.LayoutParams.WRAP_CONTENT, 1 ) ); // Establecer peso 1 y ancho 0dp


                // Agregar la celda a la fila
                tableRow.addView( textView );

//                matrix[ i ][ j ] = 0;
            }

            // Agregar la fila al TableLayout
            tableLayout.addView( tableRow );
        }
    }

    private void fillMatrix( int n, int[][] matrix ) {

        //Ubicando primer numero en la posicion central
        int counter = 1;
        int row = 0;
        int col = n / 2;
        do {

            matrix[ row ][ col ] = counter;

            //Sali del renglon
            if ( ( row - 1 ) < 0 && ( col + 1 ) < n ) {
                row = n - 1;
                col = col + 1;
            } else if ( col + 1 == n ) { //Salgo de columnas
                //Salgo de renglon y de columna
                if ( row - 1 < 0 ) {
                    row = row + 1;
                } else {
                    col = 0;
                    row = row - 1;
                }
            } else {
                if ( matrix[ row - 1 ][ col + 1 ] == 0 ) {
                    row -= 1;
                    col += 1;
                } else {
                    row += 1;
                }
            }
            counter++;
        } while ( counter < n * n + 1 );
    }

}