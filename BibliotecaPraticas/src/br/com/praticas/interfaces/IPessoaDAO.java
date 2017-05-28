/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.interfaces;

import br.com.praticas.model.bean.Pessoa;
import java.util.List;

/**
 *
 * @author VAAR
 */
public interface IPessoaDAO {

    boolean create(Pessoa pessoa) throws Exception;

    boolean delete(Pessoa pessoa) throws Exception;

    List<Pessoa> list() throws Exception;

    Pessoa search(int id) throws Exception;

    void update(Pessoa pessoa) throws Exception;
    
}
