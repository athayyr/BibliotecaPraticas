/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.interfaces;

import br.com.praticas.model.bean.Secao;
import java.util.List;

/**
 *
 * @author VAAR
 */
public interface ISecaoDAO {

    int create(Secao secao) throws Exception;

    boolean delete(Secao secao) throws Exception;

    List<Secao> list() throws Exception;

    Secao search(int id) throws Exception;

    boolean update(Secao secao) throws Exception;
    
}
