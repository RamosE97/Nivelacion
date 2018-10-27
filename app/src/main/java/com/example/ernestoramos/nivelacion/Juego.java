package com.example.ernestoramos.nivelacion;

import android.os.VibrationEffect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Juego extends AppCompatActivity implements View.OnClickListener {

    TextView lblPuntos, lblNickname, lblGanados, lblPerdidos, lblEmpatados;
    Button btnFinalizar, btnCPU, btnPiedra, btnTijera, btnPapel;
    public final int Piedra=1;
    public final int Papel=2;
    public final int Tijera=3;
    public static Jugador j;
    public static int posicion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);
        //Inicializando controles
        lblPuntos=findViewById(R.id.lblPuntos);
        lblNickname=findViewById(R.id.lblNickname);
        lblGanados=findViewById(R.id.lblGanados);
        lblPerdidos=findViewById(R.id.lblPerdidos);
        lblEmpatados=findViewById(R.id.lblEmpatados);
        btnFinalizar=findViewById(R.id.btnFinalizar);
        btnCPU=findViewById(R.id.btnCPU);
        btnPiedra=findViewById(R.id.btnPiedra);
        btnPapel=findViewById(R.id.btnPapel);
        btnTijera=findViewById(R.id.btnTijera);

        //Obteniendo posicion elegida por el usuario en los items de la lista
        posicion=getIntent().getIntExtra("Posicion", 0);
       //Creo un objeto en base a la posicion
        j=MainActivity.listaJugadores.get(posicion);
        //Lleno los parametros ya existentes
        lblNickname.setText(j.getNick());
        lblPuntos.setText("0");
        lblGanados.setText("Ganados: "+String.valueOf(j.getVictoria()));
        lblPerdidos.setText("Perdidos: "+String.valueOf(j.getDerrota()));
        lblEmpatados.setText("Empatados: "+String.valueOf(j.getEmpate()));

        //Definimos los listener
        btnTijera.setOnClickListener(this);
        btnPapel.setOnClickListener(this);
        btnPiedra.setOnClickListener(this);
        btnFinalizar.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MainActivity.listaJugadores.set(posicion, j);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnPapel:
                Evaluacion(Papel);
                break;
            case R.id.btnTijera:
                Evaluacion(Tijera);
                break;
            case R.id.btnPiedra:
                Evaluacion(Piedra);
                break;
            case R.id.btnFinalizar:
                finish();
                break;
        }
    }

    private void Evaluacion(int Jug){
        Random r = new Random();
        int i = r.nextInt(4 - 1) + 1;
        int puntos=Integer.parseInt(lblPuntos.getText().toString());
        switch(i){
            case 1: {
                btnCPU.setText("O");
                if (Jug == Piedra) {
                    j.setEmpate(j.getEmpate() + 1);
                    lblEmpatados.setText("Empatados: "+String.valueOf(j.getEmpate()));
                } else {
                    if (Jug == Papel) {
                        j.setVictoria(j.getVictoria() + 1);
                        puntos+=6;
                        lblPuntos.setText(String.valueOf(puntos));
                        lblGanados.setText("Ganados: "+String.valueOf(j.getVictoria()));
                    } else {
                        puntos-=3;
                        lblPuntos.setText(String.valueOf(puntos));
                        j.setDerrota(j.getDerrota() + 1);
                        lblPerdidos.setText("Perdidos: "+String.valueOf(j.getDerrota()));
                    }
                }
            }
                break;
            case 2:
            {
                btnCPU.setText("[_]");
                if (Jug == Piedra) {
                    puntos-=3;
                    lblPuntos.setText(String.valueOf(puntos));
                    j.setDerrota(j.getDerrota() + 1);
                    lblPerdidos.setText("Perdidos: "+String.valueOf(j.getDerrota()));
                } else {
                    if (Jug == Papel) {
                        j.setEmpate(j.getEmpate() + 1);
                        lblEmpatados.setText("Empatados: "+String.valueOf(j.getEmpate()));
                    } else {
                        puntos+=6;
                        lblPuntos.setText(String.valueOf(puntos));
                        j.setVictoria(j.getVictoria() + 1);
                        lblGanados.setText("Ganados: "+String.valueOf(j.getVictoria()));
                    }
                }
            }
                break;
            case 3:
            {
                btnCPU.setText("X");
                if (Jug == Piedra) {
                    puntos+=6;
                    lblPuntos.setText(String.valueOf(puntos));
                    j.setVictoria(j.getVictoria() + 1);
                    lblGanados.setText("Ganados: "+String.valueOf(j.getVictoria()));

                } else {
                    if (Jug == Papel) {
                        puntos-=3;
                        lblPuntos.setText(String.valueOf(puntos));
                        j.setDerrota(j.getDerrota() + 1);
                        lblPerdidos.setText("Perdidos: "+String.valueOf(j.getDerrota()));
                    } else {
                        j.setEmpate(j.getEmpate() + 1);
                        lblEmpatados.setText("Empatados: "+String.valueOf(j.getEmpate()));
                    }
                }
            }

                break;
        }

    }
}
