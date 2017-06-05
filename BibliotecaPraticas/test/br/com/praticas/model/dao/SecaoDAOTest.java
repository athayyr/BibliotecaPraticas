/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.model.dao;

import br.com.praticas.facade.BibliotecaFacadeLivro;
import br.com.praticas.facade.BibliotecaFacadePessoa;
import br.com.praticas.model.bean.Autor;
import br.com.praticas.model.bean.Endereco;
import br.com.praticas.model.bean.Secao;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author VAAR
 */
public class SecaoDAOTest {
    
    private static BibliotecaFacadeLivro facade;
    private Secao secao;
    
    @BeforeClass
    public static void inicializar(){
        facade = new BibliotecaFacadeLivro();
    }
    
    @Before
    public void inicializarObjetos() throws Exception{
        secao = new Secao();
        //facade.limparDadosSecao();
    }
    
    
    private void inserir() throws Exception{
        secao.setDescricao("Teste");
        
        facade.cadastrarSecao(secao);
    }
    
    @Test
    public void testeInserir() throws Exception{

        int tamanhoAnterior = facade.listarSecao().size();

        inserir();
        
        int tamanhoAtual = facade.listarSecao().size();
        
        assertEquals(tamanhoAnterior + 1, tamanhoAtual);
    }
    
    @Test
    public void testeEditar() throws Exception{
        
        secao = facade.listarSecao().get(0);
       
        secao.setDescricao("Teste Editado");
        
        facade.editarSecao(secao);
        
        secao = facade.listarSecao().get(0);
        
        assertEquals(secao.getDescricao(),"Teste Editado");
    }
    
    @Test
    public void testeExcluir() throws Exception{
        
        inserir();
        
        secao = facade.listarSecao().get(0);
       
        int tamanhoAnterior = facade.listarAutor().size();
        
        facade.deletarSecao(secao);
        
        assertEquals(tamanhoAnterior - 1, facade.listarAutor().size());
        
    }
    
}
