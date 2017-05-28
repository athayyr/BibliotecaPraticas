/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.facade;

import br.com.praticas.factory.DAOFactory;
import br.com.praticas.model.bean.Endereco;
import br.com.praticas.model.bean.Pessoa;
import br.com.praticas.interfaces.IEnderecoDAO;
import br.com.praticas.interfaces.IPessoaDAO;

/**
 *
 * @author VAAR
 */
public class BibliotecaFacadePessoa {
    
    private IPessoaDAO pessoaDAO;
    private IEnderecoDAO enderecoDAO;

    public BibliotecaFacadePessoa() {
        this.pessoaDAO = DAOFactory.createPessoaDAO();
        this.enderecoDAO = DAOFactory.createEnderecoDAO();
    }
    
    public void cadastrarPessoa(Pessoa pessoa) throws Exception{
        pessoaDAO.create(pessoa);
    }
    
    public void cadastrarEndereco(Endereco endereco) throws Exception{
        enderecoDAO.create(endereco);
    }
    
    public void editarEndereco(Endereco endereco) throws Exception{
        enderecoDAO.update(endereco);
    }
    
    public void editarPessoa(Pessoa pessoa) throws Exception{
        pessoaDAO.update(pessoa);
    }
    
    public void deletarEndereco(Endereco endereco) throws Exception{
        enderecoDAO.delete(endereco);
    }
    
    public void deletarPessoa(Pessoa pessoa) throws Exception{
        pessoaDAO.delete(pessoa);
    }
    
    public void listarPessoa(Pessoa pessoa) throws Exception{
        pessoaDAO.list();
    }
    
    public void listarEndereco(Endereco endereco) throws Exception{
        enderecoDAO.list();
    }
    
    
    
    
    
}
