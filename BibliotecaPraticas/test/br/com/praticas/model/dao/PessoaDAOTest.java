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

/**
 *
 * @author athay
 */
public class PessoaDAOTest {
    
    public PessoaDAOTest() {
    }

    @Test
    public void testSomeMethod() {
        
        Endereco endereco = new Endereco();
        endereco.setId(4);
        
        
        Pessoa pessoa = new Pessoa("VAAR", Util.stringParaDate("30/05/1997"), endereco);
        
        PessoaDAO pessoaDAO = new PessoaDAO();
        
        if(pessoaDAO.create(pessoa)){
            System.out.println("Sucesso!");
        }else{
            fail("ERRO");
        }
    }
    
}
