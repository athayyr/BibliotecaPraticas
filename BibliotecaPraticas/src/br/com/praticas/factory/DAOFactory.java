/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.factory;

import br.com.praticas.model.dao.AutorDAO;
import br.com.praticas.model.dao.EnderecoDAO;
import br.com.praticas.model.dao.IAutorDAO;
import br.com.praticas.model.dao.IEnderecoDAO;
import br.com.praticas.model.dao.IPessoaDAO;
import br.com.praticas.model.dao.PessoaDAO;

/**
 *
 * @author VAAR
 */
public class DAOFactory {
    
    public static IPessoaDAO createPessoaDAO(){
        return new PessoaDAO();
    }
    
    public static IAutorDAO createAutorDAO(){
        return new AutorDAO();
    }
    
    public static IEnderecoDAO createEnderecoDAO(){
        return new EnderecoDAO();
    }
}
