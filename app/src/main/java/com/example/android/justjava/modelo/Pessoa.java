package com.example.android.justjava.modelo;

/**
 * Created by leand on 9/26/2017.
 */

public class Pessoa {
    private String pid;
    private String nome;
    private String email;

    public Pessoa(String pid) {
        this.pid = pid;
    }

    public String getPid() {
        return pid;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return nome;
    }
}
