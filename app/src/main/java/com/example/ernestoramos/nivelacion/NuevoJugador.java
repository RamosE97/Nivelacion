package com.example.ernestoramos.nivelacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NuevoJugador extends AppCompatActivity implements View.OnClickListener {

    Button btnGuardar;
    EditText txtNombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_jugador);
        btnGuardar=findViewById(R.id.btnGuardar);
        txtNombre=findViewById(R.id.txtNombre);
        btnGuardar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnGuardar:
                String Nombre=txtNombre.getText().toString();
                Intent resultado = new Intent();
                resultado.putExtra("Nombre",Nombre);
                setResult(MainActivity.JUGADORNUEVO,resultado);
                finish();
                break;
        }
    }
}
