/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.interfaces;

import br.com.praticas.model.bean.Livro;
import java.util.List;

/**
 *
 * @author VAAR
 */
public interface ILivroDAO {

    int create(Livro livro) throws Exception;

    boolean delete(Livro livro) throws Exception;

    List<Livro> list() throws Exception;

    Livro search(int id) throws Exception;

    void update(Livro livro) throws Exception;

}
