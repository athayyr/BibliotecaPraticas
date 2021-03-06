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
public class Livro {
    private int id;
    private int exemplares;
    private int exemplaresDisponiveis;
    private Autor autor;
    private Editora editora;
    private Secao secao;
    private String titulo;

    public Livro() {
    }

    public Livro(int exemplares, int exemplaresDisponiveis, Autor autor, Editora editora, Secao secao) {
        this.exemplares = exemplares;
        this.exemplaresDisponiveis = exemplaresDisponiveis;
        this.autor = autor;
        this.editora = editora;
        this.secao = secao;
    }

    public Livro(int id, int exemplares, int exemplaresDisponiveis, Autor autor, Editora editora, Secao secao) {
        this.id = id;
        this.exemplares = exemplares;
        this.exemplaresDisponiveis = exemplaresDisponiveis;
        this.autor = autor;
        this.editora = editora;
        this.secao = secao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getExemplares() {
        return exemplares;
    }

    public void setExemplares(int exemplares) {
        this.exemplares = exemplares;
    }

    public int getExemplaresDisponiveis() {
        return exemplaresDisponiveis;
    }

    public void setExemplaresDisponiveis(int exemplaresDisponiveis) {
        this.exemplaresDisponiveis = exemplaresDisponiveis;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public Secao getSecao() {
        return secao;
    }

    public void setSecao(Secao secao) {
        this.secao = secao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Livro{" + "id=" + id + ", titulo=" + titulo + ", exemplares=" + exemplares + ", exemplaresDisponiveis=" + exemplaresDisponiveis + ", autor=" + autor + ", editora=" + editora + ", secao=" + secao + '}';
    }
    
    

}
