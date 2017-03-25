/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.model.dao;

import br.com.praticas.model.bean.Endereco;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author VAAR
 */
public class EnderecoDAOTest {
    
    public EnderecoDAOTest() {
    }

    @Test
    public void create() {
        
        Endereco endereco = new Endereco("Maria", "251", "Coremas");     
        
        EnderecoDAO dao = new EnderecoDAO();
        
        if(dao.create(endereco)){
            System.out.println("Sucesso");
        }else{
            fail("ERRO");
        }
    }
    
}
