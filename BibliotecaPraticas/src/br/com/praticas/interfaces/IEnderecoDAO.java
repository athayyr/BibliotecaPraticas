/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.interfaces;

import br.com.praticas.model.bean.Endereco;
import java.util.List;

/**
 *
 * @author VAAR
 */
public interface IEnderecoDAO {

    int create(Endereco endereco) throws Exception;

    boolean delete(Endereco endereco) throws Exception;

    List<Endereco> list() throws Exception;

    Endereco search(int id) throws Exception;

    void update(Endereco endereco) throws Exception;
    
}
