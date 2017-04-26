/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.model.dao;

import br.com.praticas.model.bean.Autor;
import br.com.praticas.model.bean.Editora;
import java.util.List;

/**
 *
 * @author VAAR
 */
public interface IEditoraDAO {

    boolean create(Editora editora);

    boolean delete(Editora editora);

    List<Editora> list();

    Editora search(int id);

    boolean update(Editora editora);
    
}
