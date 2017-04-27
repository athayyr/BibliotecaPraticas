/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.model.dao;

import br.com.praticas.model.bean.Secao;
import java.util.List;

/**
 *
 * @author VAAR
 */
public interface ISecaoDAO {

    boolean create(Secao secao);

    boolean delete(Secao secao);

    List<Secao> list();

    Secao search(int id);

    boolean update(Secao secao);
    
}
