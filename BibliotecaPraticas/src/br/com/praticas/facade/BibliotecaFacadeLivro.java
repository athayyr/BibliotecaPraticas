/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.facade;

import br.com.praticas.factory.DAOFactory;
import br.com.praticas.model.bean.Autor;
import br.com.praticas.model.bean.Editora;
import br.com.praticas.model.bean.Livro;
import br.com.praticas.model.bean.Secao;
import br.com.praticas.interfaces.IAutorDAO;
import br.com.praticas.interfaces.IEditoraDAO;
import br.com.praticas.interfaces.ILivroDAO;
import br.com.praticas.interfaces.ISecaoDAO;

/**
 *
 * @author VAAR
 */
public class BibliotecaFacadeLivro {
    
    private IAutorDAO autorDAO;
    private ISecaoDAO secaoDAO;
    private IEditoraDAO editoraDAO;
    private ILivroDAO livroDAO;

    public BibliotecaFacadeLivro() {
        autorDAO = DAOFactory.createAutorDAO();
        secaoDAO = DAOFactory.createSecaoDAO();
        editoraDAO = DAOFactory.createEditoraDAO();
        livroDAO = DAOFactory.createLivroDAO();        
    }
    
    public void cadastrarAutor(Autor autor) throws Exception{
        autorDAO.create(autor);
    }
    
    public void cadastrarSecao(Secao secao) throws Exception{
        secaoDAO.create(secao);
    }
    
    public void cadastrarEditora(Editora editora) throws Exception{
        editoraDAO.create(editora);
    }
    
    public void cadastrarLivro(Livro livro) throws Exception{
        livroDAO.create(livro);
    }
    
    public void editarAutor(Autor autor) throws Exception{
        autorDAO.update(autor);
    }
    
    public void editarSecao(Secao secao) throws Exception{
        secaoDAO.update(secao);
    }
    
    public void editarEditora(Editora editora) throws Exception{
        editoraDAO.update(editora);
    }
    
    public void editarLivro(Livro livro) throws Exception{
        livroDAO.update(livro);
    }
    
   public void deletarAutor(Autor autor ) throws Exception{
       autorDAO.delete(autor);
   }
   
   public void deletarSecao(Secao secao ) throws Exception{
       secaoDAO.delete(secao);
   }
   
   public void deletarEditora(Editora  editora) throws Exception{
       editoraDAO.delete(editora);
   }
   
   public void deletarLivro(Livro livro) throws Exception{
       livroDAO.delete(livro);
   }
   
   public void listarAutor() throws Exception{
       autorDAO.list();
   }
   
   public void listarEditora() throws Exception{
       editoraDAO.list();
   }
   
   public void listarSecao() throws Exception{
       secaoDAO.list();
   }
   
   public void listarLivro() throws Exception{
       livroDAO.list();
   }
   
    
}
