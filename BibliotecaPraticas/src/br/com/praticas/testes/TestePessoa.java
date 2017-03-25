/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.praticas.testes;

import br.com.praticas.model.bean.Endereco;
import br.com.praticas.model.bean.Pessoa;
import br.com.praticas.model.dao.EnderecoDAO;
import br.com.praticas.model.dao.PessoaDAO;
import br.com.praticas.util.Util;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author VAAR
 */
public class TestePessoa {
    
        private Scanner sc = new Scanner(System.in); 
        private String nome;
        private String data;
        private Date nascimento;
        private int cpf;
        private int rg;
        private String cidade;
        private String rua;
        private String numero;
        
        private Pessoa pessoa;
        private Endereco endereco;
        
        private PessoaDAO pessoaDAO;
        private EnderecoDAO enderecoDAO;
        
    public void iniciar(){
        
        System.out.println("Menu");
        System.out.println("Informe o nome");
        nome = sc.nextLine();
        System.out.println("Informe sua data de nascimento como no exemplo");
        System.out.println("exemplo: 30/05/1997");
        data = sc.nextLine();
        System.out.println("ENDEREÇO");
        System.out.println("Informe sua Cidade");
        cidade = sc.nextLine();
        System.out.println("Informe sua Rua");
        rua = sc.nextLine();
        System.out.println("Informe o Numero de sua residencia");
        numero = sc.nextLine();
        
        Endereco enderec = new Endereco("teste", "teste", "teste");
        enderecoDAO = new EnderecoDAO();
        System.out.println("Aqui");
        if(enderecoDAO.create(enderec)){
            System.out.println("Teste de inserção de endereco SUCESSO");
        }else{
            System.out.println("Teste de inserção de endereco deu ERRO");
        }
        nascimento = Util.stringParaDate(data);
        
        pessoa = new Pessoa(nome, nascimento, endereco);
        pessoaDAO = new PessoaDAO();
        if(pessoaDAO.create(pessoa)){
            System.out.println("Teste de inserção da pessoa SUCESSO");
        }else{
            System.out.println("Teste de inserção da pessoa deu ERRO");
        }
    }

}
