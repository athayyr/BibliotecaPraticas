/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.principal;

import br.com.praticas.facade.BibliotecaFacadeEmprestimo;
import br.com.praticas.facade.BibliotecaFacadeLivro;
import br.com.praticas.facade.BibliotecaFacadePessoa;
import br.com.praticas.factory.DAOFactory;
import br.com.praticas.model.bean.Aluno;
import br.com.praticas.model.bean.Autor;
import br.com.praticas.model.bean.Endereco;
import br.com.praticas.model.bean.Pessoa;
import br.com.praticas.model.dao.AutorDAO;
import br.com.praticas.model.dao.EnderecoDAO;
import br.com.praticas.model.dao.PessoaDAO;
import br.com.praticas.util.Util;
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
    private static Scanner sc = new Scanner(System.in);
    private static BibliotecaFacadePessoa facadePessoa = new BibliotecaFacadePessoa();
    private static BibliotecaFacadeLivro facadeLivro = new BibliotecaFacadeLivro();
    private static BibliotecaFacadeEmprestimo facadeEmprestimo = new BibliotecaFacadeEmprestimo();
    private static Util util = new Util();
    
    public static void main(String[] args) throws Exception {
        int op;
        
        do{
            System.out.println("MENU");
            System.out.println("1-Cadastrar:");
            System.out.println("2-Editar");
            System.out.println("3-Listar");
            System.out.println("4-Buscar");
            System.out.println("5-Remover");
            System.out.println("6-Emprestimo");
            System.out.println("0-Sair");
            op=sc.nextInt();
            switch(op){
                case 1:{
                    menuCadastrar();
                }
                
                case 2:{
                    
                    break;
                }
                
                case 3:{
                    
                    break;
                }
                
                case 4:{
                    
                    break;
                }
                case 5:{
                    
                    break;
                }
                
                case 6:{
                    
                    break;
                }
                
                case 0:{
                    System.out.println("Saindo...");
                    break;
                }
                
                default:{
                    System.out.println("Opcao Invalida!");
                    break;
                }
                
            }
        }while(op!=0);
        
        
    }

    private static void menuCadastrar(){
        int opCadastrar;
        System.out.println("1- Cadastrar Aluno");
        System.out.println("2- Cadastrar Funcionario");
        System.out.println("3- Cadastrar Autor");
        System.out.println("4- Cadastrar Editora");
        System.out.println("5- Cadastrar Secao");
        System.out.println("6- Cadastrar Livro");
        opCadastrar = sc.nextInt();
        
        switch(opCadastrar){
                case 1:{
                                        
                    System.out.println("Informe o nome:");
                    String nome = sc.nextLine();
                    System.out.println("Informe a data de nascimento:");
                    String dataNascimento = sc.nextLine();
                    System.out.println("Informe a matricula:");
                    int matricula = sc.nextInt();
                    System.out.println("Informe o curso:");
                    String curso = sc.nextLine();
                    System.out.println("Informe sua rua:");
                    String cidade = sc.nextLine();
                    System.out.println("Informe sua rua:");
                    String rua = sc.nextLine();
                    System.out.println("Informe o numero:");
                    String numero = sc.nextLine();
                    
                    Endereco endereco = new Endereco();
                    endereco.setCidade(cidade);
                    endereco.setRua(rua);
                    endereco.setNumero(numero);
                    
                    Pessoa pessoa =  new Pessoa();
                    pessoa.setNome(nome);
                    pessoa.setNascimento(util.stringToDate(dataNascimento));
                    pessoa.setEndereco(endereco);
                    
                    try{
                        facadePessoa.cadastrarPessoa(pessoa);
                    }catch(Exception ex){
                        System.out.println(ex.getMessage());
                    }
                    
                    Aluno aluno = new Aluno();
                }
                
                case 2:{
                    
                    break;
                }
                
                case 3:{
                    
                    break;
                }
                
                case 4:{
                    
                    break;
                }
                
                case 5:{
                    
                    break;
                }
                
                case 6:{
                    
                    break;
                }
                
                default:{
                    System.out.println("Opcao Invalida");
                    break;
                }
                
            }
        
    }
}
