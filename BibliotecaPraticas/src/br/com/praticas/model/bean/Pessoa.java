/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.praticas.model.bean;

import java.util.Date;

/**
 *
 * @author VAAR
 */
public class Pessoa {
    
    private int id;
    private String nome;
    private Date nascimento;
    private Endereco endereco;

    public Pessoa() {
    }
    
    public Pessoa(String nome, Date nascimento, Endereco endereco) {
        this.nome = nome;
        this.nascimento = nascimento;
        this.endereco = endereco;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getNascimento() {
        return this.nascimento;
    }

    public void setNascimento(Date dataNascimento) {
        this.nascimento = dataNascimento;
    }

    public Endereco getEndereco() {
        return this.endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "id=" + id + ", nome=" + nome + ", nascimento=" + nascimento + ", endereco=" + endereco + '}';
    }

}
