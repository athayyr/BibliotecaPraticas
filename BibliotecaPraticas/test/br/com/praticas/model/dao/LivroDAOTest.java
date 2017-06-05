/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.model.dao;

import br.com.praticas.facade.BibliotecaFacadeLivro;
import br.com.praticas.model.bean.Autor;
import br.com.praticas.model.bean.Editora;
import br.com.praticas.model.bean.Livro;
import br.com.praticas.model.bean.Secao;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 *
 * @author athay
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LivroDAOTest {
    
    private static BibliotecaFacadeLivro facade;
    private Livro livro;
    
    @BeforeClass
    public static void inicializar(){
        facade = new BibliotecaFacadeLivro();
    }
    
    @Before
    public void inicializarObjetos() throws Exception{
        livro = new Livro();
        facade.limparDadosLivro();
    }
    
    
    private void inserir() throws Exception{
        
        Autor autor = new Autor();
        autor.setId(46);
        
        Editora editora = new Editora();
        editora.setId(1);
        
        Secao secao = new Secao();
        secao.setId(1);
        
        livro.setTitulo("Teste VAAR");
        livro.setExemplares(2);
        livro.setExemplaresDisponiveis(2);
        livro.setAutor(autor);
        
        facade.cadastrarLivro(livro);
    }
 /*   
    @Test
    public void testeInserir() throws Exception{

        int tamanhoAnterior = facade.getContatos().size();

        inserir();
        
        int tamanhoAtual = facade.getContatos().size();
        
        assertEquals(tamanhoAnterior + 1, tamanhoAtual);
        
    }
    

    @Test
    public void testeEditar() throws Exception{
    
        inserir();
        
        livro = facade.getContatos().get(0);
       
        livro.setNome("Teste Editado");
        
        facade.editarContato(livro);
        
        livro = facade.getContatos().get(0);
        
        assertEquals("Teste Editado", livro.getNome());
    }

    @Test
    public void testeExcluir() throws Exception{
        
        inserir();
        
        livro = facade.getContatos().get(0);
       
        int tamanhoAnterior = facade.getContatos().size();
        
        facade.removerContato(livro);
        
        assertEquals(tamanhoAnterior - 1, facade.getContatos().size());
        
    }
*/    
}
