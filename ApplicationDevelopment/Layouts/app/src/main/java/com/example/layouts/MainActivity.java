package com.example.layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        // Obtener el TableLayout de la vista
        TableLayout tableLayout = ( TableLayout ) findViewById( R.id.table_layout);

// Obtener el número de filas y columnas
        int n = 5;

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
                textView.setText( "Celda " + ( i * n + j + 1 ) );

                // Configurar el layout de la celda
                TableRow.LayoutParams textViewParams = new TableRow.LayoutParams(
                        TableRow.LayoutParams.WRAP_CONTENT,
                        TableRow.LayoutParams.WRAP_CONTENT );
                textView.setLayoutParams( textViewParams );

                // Agregar la celda a la fila
                tableRow.addView( textView );
            }

            // Agregar la fila al TableLayout
            tableLayout.addView( tableRow );
        }


    }
}