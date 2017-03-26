/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.praticas.model.bean;

/**
 *
 * @author VAAR
 */
public class Endereco {
    private int id;
    private String rua;
    private String numero;
    private String cidade;
    
    public Endereco(){
        
    }
    
    public Endereco(String rua, String numero, String cidade) {
        this.id = id;
        this.rua = rua;
        this.numero = numero;
        this.cidade = cidade;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRua() {
        return this.rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return this.cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "Endereco{" + "id=" + id + ", rua=" + rua + ", numero=" + numero + ", cidade=" + cidade + '}';
    }
    
}
