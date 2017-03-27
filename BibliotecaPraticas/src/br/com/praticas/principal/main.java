/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.principal;

import br.com.praticas.model.bean.Autor;
import br.com.praticas.model.bean.Endereco;
import br.com.praticas.model.bean.Pessoa;
import br.com.praticas.model.dao.AutorDAO;
import br.com.praticas.model.dao.EnderecoDAO;
import br.com.praticas.model.dao.PessoaDAO;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author VAAR
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        AutorDAO autorDao = new AutorDAO();
        Autor a= new Autor();
        a.setNome("TesteAutor");
        
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        Endereco e = new Endereco();
        e.setCidade("CidadeTeste");
        e.setNumero("NumeroTeste");
        e.setRua("TesteRua");
        
        PessoaDAO pessoaDAO = new PessoaDAO();
        Pessoa p = new Pessoa();
        p.setNome("TesteNome");
        Date date = new Date();
        date.getTime();
        p.setDataNascimento(date);
        p.setEndereco(e);
        
        int op;
        
        do{
            System.out.println("MENU");
            System.out.println("1-Executar Creates:");
            System.out.println("2-Executar Updates");
            System.out.println("3-Executar Listar");
            System.out.println("4-Executar Remove");
            System.out.println("0-Sair");
            op=sc.nextInt();
            switch(op){
                case 1:{
                    autorDao.create(a);
                    
                    enderecoDAO.create(e);
                    
                    pessoaDAO.create(p);
                    
                    System.out.println("Criados...");
                    break;
                }
                case 2:{
                    a.setNome("NomeEditado");
                    autorDao.update(a);
                    
                    e.setCidade("CidadeEditada");
                    enderecoDAO.update(e);
                        
                    p.setNome("NomeEditado");
                    pessoaDAO.update(p);
                    break;
                }
                case 3:{
                    System.out.println("Listando Pessoas...");
                    for(Pessoa lp : pessoaDAO.list()){
                        System.out.println(lp);
                    }
                    
                    System.out.println("Listando Autores...");
                    for(Autor la : autorDao.list()){
                        System.out.println(la);
                    }
                    
                    System.out.println("Listando Enderecos...");
                    for(Endereco le : enderecoDAO.list()){
                        System.out.println(le);
                    }
                    
                    
                    break;
                }
                case 4:{
                    pessoaDAO.delete(p);
                    
                    autorDao.delete(a);
                    
                    enderecoDAO.delete(e);
                    
                    break;
                }
                case 0:{
                    System.out.println("Saindo...");
                    break;
                }
                default:{
                    
                    break;
                }
                
            }
        }while(op!=0);
        
        
    }

    
}
