/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.interfaces;

import br.com.praticas.model.bean.Autor;
import br.com.praticas.model.bean.Editora;
import java.util.List;

/**
 *
 * @author VAAR
 */
public interface IEditoraDAO {

    int create(Editora editora) throws Exception;

    boolean delete(Editora editora) throws Exception;

    List<Editora> list() throws Exception;

    Editora search(int id) throws Exception;

    boolean update(Editora editora) throws Exception;
    
}
