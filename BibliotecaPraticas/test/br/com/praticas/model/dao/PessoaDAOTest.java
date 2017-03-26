/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.model.dao;

import br.com.praticas.model.bean.Endereco;
import br.com.praticas.model.bean.Pessoa;
import br.com.praticas.util.Util;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author athay
 */
public class PessoaDAOTest {
    
    public PessoaDAOTest() {
    }

    @Test
    @Ignore
    public void testSomeMethod() {
        Endereco endereco = new Endereco();
        endereco.setId(11);
        
        
        Pessoa pessoa = new Pessoa("teste", Util.stringParaDate("30/05/1997"), endereco);
        
        PessoaDAO pessoaDAO = new PessoaDAO();
        
        if(pessoaDAO.create(pessoa)){
            System.out.println("Sucesso!");
        }else{
            fail("ERRO");
        }
        
        pessoa = pessoaDAO.search(7);
        
        pessoa.setNome("teste atualização");
        
        pessoaDAO.update(pessoa);
    }
    
    @Test
    @Ignore
    public void testSomeMethodListar() {
        Endereco endereco = new Endereco();       
        
        Pessoa pessoa = new Pessoa("teste", Util.stringParaDate("30/05/1997"), endereco);
        
        PessoaDAO pessoaDAO = new PessoaDAO();
        
        for(Pessoa p : pessoaDAO.list()){
            System.out.println(p);
        }
    }
    
    @Test
    public void testSomeMethodExcluir() {
        Endereco endereco = new Endereco();       
        
        Pessoa pessoa = new Pessoa("teste", Util.stringParaDate("30/05/1997"), endereco);
        
        PessoaDAO pessoaDAO = new PessoaDAO();
        
        
        for(int i = 11; i<21; i++){
          pessoa = pessoaDAO.search(i);
        
            pessoaDAO.delete(pessoa);  
        }
        
    }
}
