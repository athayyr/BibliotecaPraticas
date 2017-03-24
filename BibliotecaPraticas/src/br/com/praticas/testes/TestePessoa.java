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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        //converter String para calendar
        data = sc.nextLine();
        System.out.println("DOCUMENTAÇÂO");
        System.out.println("Informe seu CPF");
        sc.nextLine();
        cpf = sc.nextInt();
        System.out.println("Informe seu RG");
        rg = sc.nextInt();
        System.out.println("ENDEREÇO");
        System.out.println("Informe sua Cidade");
        cidade = sc.nextLine();
        System.out.println("Informe sua Rua");
        rua = sc.nextLine();
        System.out.println("Informe o Numero de sua residencia");
        numero = sc.nextLine();
        
        endereco.setCidade(cidade);
        endereco.setRua(rua);
        endereco.setNumero(numero);
        enderecoDAO.create(endereco);
        
        pessoa.setNome(nome);
        pessoa.setDataNascimento(nascimento);
        pessoaDAO.create(pessoa);
    }

}
