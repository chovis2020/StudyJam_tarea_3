package com.gdgandroidbolivia.nombredeflores;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NombreAdapter.onNombreSelectedListener{
    RecyclerView nombreRecyclerView;
    NombreAdapter nombreAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombreRecyclerView = (RecyclerView) findViewById(R.id.recycler_main);
        nombreRecyclerView.setHasFixedSize(true);
        nombreRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        nombreAdapter = new NombreAdapter(this, this);

        llenarDatos();

        nombreRecyclerView.setAdapter(nombreAdapter);
    }

    private void llenarDatos() {
        List<Flor> lista = new ArrayList<>();
        lista.add(new Flor(R.drawable.margarita, "Margarita", getString(R.string.Descripcion_Margarita)));
        lista.add(new Flor(R.drawable.flor3, "Hortencia", getString(R.string.Descripcion_Hortencia)));
        lista.add(new Flor(R.drawable.flor2, "Cala", getString(R.string.Descripcion_Cala)));
        lista.add(new Flor(R.drawable.dalia, "Dalia", getString(R.string.Descripcion_Dalia)));
        lista.add(new Flor(R.drawable.dalia1, "Rosa", getString(R.string.Descripcion_Rosa)));
        lista.add(new Flor(R.drawable.flor, "Violeta", getString(R.string.Descripcion_Violeta)));
        lista.add(new Flor(R.drawable.aleli, "Aleli", getString(R.string.Descripcion_Aleli)));
        lista.add(new Flor(R.drawable.camelias, "Camelia", getString(R.string.Descripcion_Camelia)));
        lista.add(new Flor(R.drawable.jazmin, "Jazmin", getString(R.string.Descripcion_Jazmin)));
        lista.add(new Flor(R.drawable.lila, "Lila", getString(R.string.Descripcion_Lila)));
        lista.add(new Flor(R.drawable.azucena, "Azucena", getString(R.string.Descripcion_Azucena)));
        lista.add(new Flor(R.drawable.cc900, "Amapola", getString(R.string.Descripcion_Amapola)));
        lista.add(new Flor(R.drawable.azalea, "Rosalia", getString(R.string.Descripcion_Rosalia)));
        lista.add(new Flor(R.drawable.margaritas, "Acacia", getString(R.string.Descripcion_Acacia)));

        nombreAdapter.setDataset(lista);
    }

    public void onNombreSelected(Flor flor) {
        Intent intent = new Intent(getApplicationContext(), DetalleActivity.class);
        intent.putExtra("equipo", flor);
        startActivity(intent);
    }

}
