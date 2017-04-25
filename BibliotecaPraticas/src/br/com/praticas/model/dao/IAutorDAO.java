/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.model.dao;

import br.com.praticas.model.bean.Autor;
import java.util.List;

/**
 *
 * @author VAAR
 */
public interface IAutorDAO {

    boolean create(Autor a);

    boolean delete(Autor a);

    List<Autor> list();

    Autor search(int id);

    boolean update(Autor a);
    
}
