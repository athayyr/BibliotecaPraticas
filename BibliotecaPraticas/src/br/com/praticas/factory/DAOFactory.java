/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.factory;

import br.com.praticas.model.dao.AutorDAO;
import br.com.praticas.model.dao.EditoraDAO;
import br.com.praticas.model.dao.EmprestimoDAO;
import br.com.praticas.model.dao.EnderecoDAO;
import br.com.praticas.interfaces.IAutorDAO;
import br.com.praticas.interfaces.IEditoraDAO;
import br.com.praticas.interfaces.IEmprestimoDAO;
import br.com.praticas.interfaces.IEnderecoDAO;
import br.com.praticas.interfaces.ILivroDAO;
import br.com.praticas.interfaces.IPessoaDAO;
import br.com.praticas.interfaces.ISecaoDAO;
import br.com.praticas.model.dao.LivroDAO;
import br.com.praticas.model.dao.PessoaDAO;
import br.com.praticas.model.dao.SecaoDAO;

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
    
    public static IEditoraDAO createEditoraDAO(){
        return new EditoraDAO();
    }
    
    public static ISecaoDAO createSecaoDAO(){
        return new SecaoDAO();
    }
    
    public static IEmprestimoDAO createEmprestimoDAO(){
        return new EmprestimoDAO();
    }
    
    public static ILivroDAO createLivroDAO(){
        return new LivroDAO();
    }
}
