/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.model.dao;

import br.com.praticas.model.bean.Endereco;
import java.util.List;

/**
 *
 * @author VAAR
 */
public interface IEnderecoDAO {

    boolean create(Endereco endereco);

    boolean delete(Endereco endereco);

    List<Endereco> list();

    Endereco search(int id);

    void update(Endereco endereco);
    
}
