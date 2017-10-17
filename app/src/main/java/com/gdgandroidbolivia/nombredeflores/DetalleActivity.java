package com.gdgandroidbolivia.nombredeflores;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Yolanda on 16/10/2017.
 */

public class DetalleActivity extends AppCompatActivity {

    ImageView imagenDetalle;
    TextView nombre, descripcion;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        getSupportActionBar().setTitle("Descripción de Nombre");

        imagenDetalle = (ImageView) findViewById(R.id.imagen_detalle);
        nombre = (TextView) findViewById(R.id.texto_detalle);
        descripcion = (TextView) findViewById(R.id.descripcion_detalle);

        Bundle bundle = getIntent().getExtras();
        Flor flor = (Flor) bundle.getSerializable("flor");

        imagenDetalle.setImageResource(flor.getImagen());
        nombre.setText(flor.getNombre());
        descripcion.setText(flor.getDescripcion());
    }

}
