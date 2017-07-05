package com.cms.zup.escolacms;

/**
 * Created by ZUP on 05/07/2017.
 */

public class Aluno {
    private int id;
    private String nome;
    private String data_nasc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(String data_nasc) {
        this.data_nasc = data_nasc;
    }
    @Override
    public String toString(){
        return getId() + getNome() + getData_nasc();
    }
}
