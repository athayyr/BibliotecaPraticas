/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.interfaces;

import br.com.praticas.model.bean.Autor;
import java.util.List;

/**
 *
 * @author VAAR
 */
public interface IAutorDAO {

    int create(Autor a) throws Exception;

    boolean delete(Autor a) throws Exception;

    List<Autor> list() throws Exception;

    Autor search(int id) throws Exception;

    boolean update(Autor a) throws Exception;
    
}
