/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.model.dao;

import br.com.praticas.model.bean.Autor;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author athay
 */
public class AutorDAOTest {
    
    public AutorDAOTest() {
    }

    @Test
    public void testSomeMethod() {
        
        Autor autor = new Autor();
        
        autor.setNome("Teste AUTOR2");
        
        AutorDAO autorDAO = new AutorDAO();
        
        if(autorDAO.create(autor)){
            System.out.println("Sucesso!");
        }else{
            fail("ERRO");
        }
        
        autor = autorDAO.search(4);
        
        autor.setNome("Teste update");
        
        autorDAO.update(autor);
        
        autor = autorDAO.search(2);
        
        autorDAO.delete(autor);
    }
    
}
