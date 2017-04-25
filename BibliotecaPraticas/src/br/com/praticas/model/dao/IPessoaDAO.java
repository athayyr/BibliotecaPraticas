/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.model.dao;

import br.com.praticas.model.bean.Pessoa;
import java.util.List;

/**
 *
 * @author VAAR
 */
public interface IPessoaDAO {

    boolean create(Pessoa pessoa);

    boolean delete(Pessoa pessoa);

    List<Pessoa> list();

    Pessoa search(int id);

    void update(Pessoa pessoa);
    
}
