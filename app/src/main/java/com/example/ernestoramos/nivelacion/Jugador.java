package com.example.ernestoramos.nivelacion;

import java.io.Serializable;

public class Jugador  {
    private int id;
    private String Nick;
    private int Victoria;
    private int Derrota;
    private int Empate;

    Jugador(int i, String n, int v, int d, int e){
        this.id=i;
        this.Nick=n;
        this.Victoria=v;
        this.Derrota=d;
        this.Empate=e;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNick() {
        return Nick;
    }

    public void setNick(String nick) {
        Nick = nick;
    }

    public int getVictoria() {
        return Victoria;
    }

    public void setVictoria(int victoria) {
        Victoria = victoria;
    }

    public int getDerrota() {
        return Derrota;
    }

    public void setDerrota(int derrota) {
        Derrota = derrota;
    }

    public int getEmpate() {
        return Empate;
    }

    public void setEmpate(int empate) {
        Empate = empate;
    }
}
