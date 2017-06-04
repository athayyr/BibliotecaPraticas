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
import br.com.praticas.model.bean.Editora;
import br.com.praticas.model.bean.Emprestimo;
import br.com.praticas.model.bean.Endereco;
import br.com.praticas.model.bean.Funcionario;
import br.com.praticas.model.bean.Livro;
import br.com.praticas.model.bean.Pessoa;
import br.com.praticas.model.bean.Secao;
import br.com.praticas.model.dao.AutorDAO;
import br.com.praticas.model.dao.EnderecoDAO;
import br.com.praticas.model.dao.PessoaDAO;
import br.com.praticas.util.Util;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
            System.out.println("2-Editar:");
            System.out.println("3-Listar:");
            System.out.println("4-Buscar:");
            System.out.println("5-Remover:");
            System.out.println("6-Emprestimo:");
            System.out.println("0-Sair");
            op=sc.nextInt();
            switch(op){
                case 1:{
                    menuCadastrar();
                }
                
                case 2:{
                    menuEditar();
                    break;
                }
                
                case 3:{
                    menuListar();
                    break;
                }
                
                case 4:{
                    menuBuscar();
                    break;
                }
                case 5:{
                    menuDeletar();
                    break;
                }
                
                case 6:{
                    MenuEmprestimo();
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
        System.out.println("1- Cadastrar Endereco:");
        System.out.println("2- Cadastrar Aluno:");
        System.out.println("3- Cadastrar Funcionario:");
        System.out.println("4- Cadastrar Autor:");
        System.out.println("5- Cadastrar Editora:");
        System.out.println("6- Cadastrar Secao:");
        System.out.println("7- Cadastrar Livro:");
        System.out.println("0- Sair:");
        opCadastrar = sc.nextInt();
        
        switch(opCadastrar){
                case 1:{
                    System.out.println("Informe a cidade:");
                    String cidade = sc.nextLine();
                    System.out.println("Informe a rua:");
                    String rua = sc.nextLine();
                    System.out.println("Informe o numero:");
                    String numero = sc.nextLine();
                    
                    Endereco endereco = new Endereco();
                    endereco.setCidade(cidade);
                    endereco.setRua(rua);
                    endereco.setNumero(numero);
                    
                    try{
                        facadePessoa.cadastrarEndereco(endereco);
                    }catch(Exception ex){
                        ex.getMessage();
                    }
                    
                }
                
                case 2:{
                    System.out.println("Informe o nome:");
                    String nome = sc.nextLine();
                    System.out.println("Informe a data de nascimento:");
                    String dataNascimento = sc.nextLine();
                    System.out.println("Informe a matricula:");
                    int matricula = sc.nextInt();
                    System.out.println("Informe o curso:");
                    String curso = sc.nextLine();
                    System.out.println("Informe o id do endereco:");
                    int idEndereco = sc.nextInt();
                    
                    try{
                        Endereco e = facadePessoa.buscarEndereco(idEndereco);
                        if(e == null){
                            System.out.println("Endereco não existe!");
                        }
                        else{
                            Pessoa pessoa =  new Pessoa();
                            pessoa.setNome(nome);
                            pessoa.setNascimento(util.stringToDate(dataNascimento));
                            pessoa.setEndereco(e);
                            facadePessoa.cadastrarPessoa(pessoa);

                            Aluno aluno = new Aluno();
                            aluno.setId(pessoa.getId());
                            aluno.setCurso(curso);
                            aluno.setMatricula(matricula);
                            facadePessoa.cadastrarAluno(aluno);
                        }
                     }catch(Exception ex){
                        System.out.println(ex.getMessage());
                    }
                    break;
                }
                
                case 3:{
                    System.out.println("Informe o nome:");
                    String nome = sc.nextLine();
                    System.out.println("Informe a data de nascimento:");
                    String dataNascimento = sc.nextLine();
                    System.out.println("Informe o cargo:");
                    String cargo = sc.nextLine();
                    System.out.println("Informe o login:");
                    String login = sc.nextLine();
                    System.out.println("Informe a senha:");
                    String senha = sc.nextLine();
                    System.out.println("Informe o id do endereco:");
                    int idEndereco = sc.nextInt();
                    
                    try{
                        Endereco e = facadePessoa.buscarEndereco(idEndereco);
                        if(e == null){
                            System.out.println("Endereco não existe!");
                        }
                        else{
                            Pessoa pessoa =  new Pessoa();
                            pessoa.setNome(nome);
                            pessoa.setNascimento(util.stringToDate(dataNascimento));
                            pessoa.setEndereco(e);
                            facadePessoa.cadastrarPessoa(pessoa);

                            Funcionario funcionario = new Funcionario();
                            funcionario.setId(pessoa.getId());
                            funcionario.setCargo(cargo);
                            funcionario.setLogin(login);
                            funcionario.setSenha(senha);
                            facadePessoa.cadastrarFuncionario(funcionario);
                            
                        }
                     }catch(Exception ex){
                        System.out.println(ex.getMessage());
                    }
                    break;
                }
                
                case 4:{
                    System.out.println("Informe o nome do autor:");
                    String nome = sc.nextLine();
                    
                    Autor autor = new Autor();
                    autor.setNome(nome);
                    try{
                        facadeLivro.cadastrarAutor(autor);
                    }catch(Exception ex){
                        ex.getMessage();
                    }
                    break;
                }
                
                case 5:{
                    System.out.println("Informe o nome da editora:");
                    String nome = sc.nextLine();
                    
                    Editora editora = new Editora();
                    editora.setNome(nome);
                    try{
                        facadeLivro.cadastrarEditora(editora);
                    }catch(Exception ex){
                        ex.getMessage();
                    }
                    break;
                }
                
                case 6:{
                    System.out.println("Informe a descricao da secao:");
                    String descricao = sc.nextLine();
                    
                    Secao secao = new Secao();
                    secao.setDescricao(descricao);
                    try{
                        facadeLivro.cadastrarSecao(secao);
                    }catch(Exception ex){
                        ex.getMessage();
                    }
                    break;
                }
                
                case 7:{
                    try{
                        System.out.println("Informe o id do autor:");
                        int idAutor = sc.nextInt();  
                        System.out.println("Informe o id da editora:");
                        int idEditora = sc.nextInt();
                        System.out.println("Informe o id da secao");
                        int idSecao = sc.nextInt();
                        Secao secao = facadeLivro.buscarSecao(idSecao);
                        Editora editora = facadeLivro.buscarEditora(idEditora);
                        Autor autor = facadeLivro.buscarAutor(idAutor);
                        
                        if(editora == null || secao == null || autor == null){
                            System.out.println("Dados Invalidos!");
                        }
                       
                        else{
                            System.out.println("Informe o numero de exemplares:");
                            int numExemplares = sc.nextInt();
                            
                            Livro livro = new Livro();
                            livro.setAutor(autor);
                            livro.setEditora(editora);
                            livro.setSecao(secao);
                            livro.setExemplares(numExemplares);
                            livro.setExemplaresDisponiveis(numExemplares);
                            
                            facadeLivro.cadastrarLivro(livro);
                        }
                    
                    }
                    catch (Exception ex){
                        ex.getMessage();
                    }
                    break;
                }
                
                case 0:{
                    System.out.println("Saindo...");
                }
                
                default:{
                    System.out.println("Opcao Invalida!");
                    break;
                }
                
            }     
    }
    
    private static void menuEditar(){
        System.out.println("1- Editar Endereco:");
        System.out.println("2- Editar Aluno:");
        System.out.println("3- Editar Funcionario:");
        System.out.println("4- Editar Autor:");
        System.out.println("5- Editar Editora:");
        System.out.println("6- Editar Secao:");
        System.out.println("7- Editat Livro:");
        System.out.println("0- Sair:");
        int opEditar = sc.nextInt();
        switch(opEditar){
                case 1:{
                    System.out.println("Informe o id do endereco:");
                    int idEndereco = sc.nextInt();
                    
                    try{
                        Endereco endereco = facadePessoa.buscarEndereco(idEndereco);
                        if(endereco == null){
                            System.out.println("Endereco não encontrado");
                        }
                        else{
                            System.out.println("Informe a cidade:");
                            String cidade = sc.nextLine();
                            System.out.println("Informe a rua:");
                            String rua = sc.nextLine();
                            System.out.println("Informe o numero:");
                            String numero = sc.nextLine();

                            endereco.setCidade(cidade);
                            endereco.setRua(rua);
                            endereco.setNumero(numero);

                            facadePessoa.editarEndereco(endereco);
                        }
                    }
                    catch(Exception ex){
                        ex.getMessage();
                    }
                }
                
                case 2:{
                    System.out.println("Informe o id do aluno:");
                    int idAluno = sc.nextInt();
                    try{
                        Aluno aluno = facadePessoa.buscarAluno(idAluno);
                        if(aluno == null){
                            System.out.println("Aluno não encontrado!");
                        }
                        else{
                            System.out.println("Informe o nome:");
                            String nome = sc.nextLine();
                            System.out.println("Informe a data de nascimento:");
                            String dataNascimento = sc.nextLine();
                            System.out.println("Informe a matricula:");
                            int matricula = sc.nextInt();
                            System.out.println("Informe o curso:");
                            String curso = sc.nextLine();
                            System.out.println("Informe o id do endereco:");
                            int idEndereco = sc.nextInt();
                            
                            Endereco endereco = facadePessoa.buscarEndereco(idEndereco);
                            if(endereco == null){
                                System.out.println("Endereco não encontrado!");
                            }
                            else{
                                Pessoa pessoa =  new Pessoa();
                                pessoa.setNome(nome);
                                pessoa.setNascimento(util.stringToDate(dataNascimento));
                                pessoa.setEndereco(endereco);
                                facadePessoa.editarPessoa(pessoa);

                                aluno.setId(pessoa.getId());
                                aluno.setCurso(curso);
                                aluno.setMatricula(matricula);
                                facadePessoa.editarAluno(aluno);
                                }
                        }
                    }catch(Exception ex){
                        ex.getMessage();
                    }
                    break;
                }
                
                case 3:{
                    System.out.println("Informe o id do Funcionario:");
                    int idFuncionario = sc.nextInt();
                    try{
                        Funcionario funcionario = facadePessoa.buscarFuncionario(idFuncionario);
                        if(funcionario == null){
                            System.out.println("Aluno não encontrado!");
                        }
                        else{
                            System.out.println("Informe o nome:");
                            String nome = sc.nextLine();
                            System.out.println("Informe a data de nascimento:");
                            String dataNascimento = sc.nextLine();
                            System.out.println("Informe o cargo:");
                            String cargo = sc.nextLine();
                            System.out.println("Informe o login:");
                            String login = sc.nextLine();
                            System.out.println("Informe a senha:");
                            String senha = sc.nextLine();
                            System.out.println("Informe o id do endereco:");
                            int idEndereco = sc.nextInt();
                            
                            Endereco endereco = facadePessoa.buscarEndereco(idEndereco);
                            if(endereco == null){
                                System.out.println("Endereco não encontrado!");
                            }
                            else{
                                Pessoa pessoa =  new Pessoa();
                                pessoa.setNome(nome);
                                pessoa.setNascimento(util.stringToDate(dataNascimento));
                                pessoa.setEndereco(endereco);
                                facadePessoa.editarPessoa(pessoa);

                                funcionario.setCargo(cargo);
                                funcionario.setLogin(login);
                                funcionario.setSenha(senha);
                                facadePessoa.editarFuncionario(funcionario);
                                }
                        }
                    }catch(Exception ex){
                        ex.getMessage();
                    }
                    break;
                }
                
                case 4:{
                    System.out.println("Informe o id do autor:");
                    int idAutor = sc.nextInt();
                    
                    try{
                        Autor autor = facadeLivro.buscarAutor(idAutor);
                        if(autor == null){
                            System.out.println("Autor não encontrado!");
                        }
                        else{
                            System.out.println("Informe o nome do autor:");
                            String nome = sc.nextLine();
                            autor.setNome(nome);
                            
                            facadeLivro.editarAutor(autor);
                        }
                    }
                    catch(Exception ex){
                        ex.getMessage();
                    }
                    break;
                }
                case 5:{
                    System.out.println("Informe o id da editora:");
                    int idEditora = sc.nextInt();
                    
                    try{
                        Editora editora = facadeLivro.buscarEditora(idEditora);
                        if(editora == null){
                            System.out.println("Editora não encontrada!");
                        }
                        else{
                            System.out.println("Informe o nome da editora:");
                            String nome = sc.nextLine();
                            editora.setNome(nome);
                            facadeLivro.editarEditora(editora);
                        }
                    }
                    catch(Exception ex){
                        ex.getMessage();
                    }
                    break;
                }
                
                case 6:{
                    System.out.println("Informe o id da secao:");
                    int idSecao = sc.nextInt();
                    
                    try{
                        Secao secao = facadeLivro.buscarSecao(idSecao);
                        if(secao == null){
                            System.out.println("Secao não encontrada!");
                        }
                        else{
                            System.out.println("Informe a descricao da secao:");
                            String descricao = sc.nextLine();
                            secao.setDescricao(descricao);
                            
                            facadeLivro.editarSecao(secao);
                        }
                    }
                    catch(Exception ex){
                        ex.getMessage();
                    }
                    break;
                }
                
                case 7:{
                    System.out.println("Informe o id do livro:");
                    int idLivro = sc.nextInt();
                    
                    try{
                        Livro livro = facadeLivro.buscarLivro(idLivro);
                        if(livro == null){
                            System.out.println("Livro não encontrado!");
                        }
                        else{
                            System.out.println("Informe o id do autor:");
                            int idAutor = sc.nextInt();  
                            System.out.println("Informe o id da editora:");
                            int idEditora = sc.nextInt();
                            System.out.println("Informe o id da secao");
                            int idSecao = sc.nextInt();
                            Secao secao = facadeLivro.buscarSecao(idSecao);
                            Editora editora = facadeLivro.buscarEditora(idEditora);
                            Autor autor = facadeLivro.buscarAutor(idAutor);

                            if(editora == null || secao == null || autor == null){
                                System.out.println("Dados Invalidos!");
                            }

                            else{
                                System.out.println("Informe o numero de exemplares:");
                                int numExemplares = sc.nextInt();
                            
                                livro.setAutor(autor);
                                livro.setEditora(editora);
                                livro.setSecao(secao);
                                livro.setExemplares(numExemplares);
                                livro.setExemplaresDisponiveis(numExemplares);
                                
                                facadeLivro.editarLivro(livro);
                            }
                        }
                    }
                    catch(Exception ex){
                        ex.getMessage();
                    }
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
    }
    
    private static void menuBuscar(){
        System.out.println("1- Buscar Endereco:");
        System.out.println("2- Buscar Aluno:");
        System.out.println("3- Buscar Funcionario:");
        System.out.println("4- Buscar Autor:");
        System.out.println("5- Buscar Editora:");
        System.out.println("6- Buscar Secao:");
        System.out.println("7- Buscar Livro:");
        System.out.println("0- Sair:");
        int opEditar = sc.nextInt();
        switch(opEditar){
                case 1:{
                    System.out.println("Informe o id do endereco:");
                    int idEndereco = sc.nextInt();
                    
                    try{
                        Endereco endereco = facadePessoa.buscarEndereco(idEndereco);
                        if(endereco == null){
                            System.out.println("Endereco não encontrado");
                        }
                        else{
                            System.out.println(endereco.toString());
                        }
                    }
                    catch(Exception ex){
                        ex.getMessage();
                    }
                }
                
                case 2:{
                    System.out.println("Informe o id do aluno:");
                    int idAluno = sc.nextInt();
                    
                    try{
                        Aluno aluno = facadePessoa.buscarAluno(idAluno);
                        if(aluno == null){
                            System.out.println("Aluno não encontrado!");
                        }
                        else{
                            System.out.println(aluno.toString());
                        }
                    }
                    catch(Exception ex){
                        ex.getMessage();
                    }
                    break;
                }
                
                case 3:{
                    System.out.println("Informe o id do funcionario:");
                    int idFuncionario = sc.nextInt();
                    
                    try{
                        Funcionario funcionario = facadePessoa.buscarFuncionario(idFuncionario);
                        if(funcionario == null){
                            System.out.println("Funcionario não encontrado!");
                        }
                        else{
                            System.out.println(funcionario.toString());
                        }
                    }
                    catch(Exception ex){
                        ex.getMessage();
                    }
                    break;
                }
                
                case 4:{
                    System.out.println("Informe o id do autor:");
                    int idAutor = sc.nextInt();
                    
                    try{
                        Autor autor = facadeLivro.buscarAutor(idAutor);
                        if(autor == null){
                            System.out.println("Autor não encontrado!");
                        }
                        else{
                            System.out.println(autor.toString());
                        }
                    }
                    catch(Exception ex){
                        ex.getMessage();
                    }
                    break;
                }
                case 5:{
                    System.out.println("Informe o id da editora:");
                    int idEditora = sc.nextInt();
                    
                    try{
                        Editora editora = facadeLivro.buscarEditora(idEditora);
                        if(editora == null){
                            System.out.println("Editora não encontrada!");
                        }
                        else{
                            System.out.println(editora.toString());
                        }
                    }
                    catch(Exception ex){
                        ex.getMessage();
                    }
                    break;
                }
                
                case 6:{
                    System.out.println("Informe o id da secao:");
                    int idSecao = sc.nextInt();
                    
                    try{
                        Secao secao = facadeLivro.buscarSecao(idSecao);
                        if(secao == null){
                            System.out.println("Secao não encontrada!");
                        }
                        else{
                            System.out.println(secao.toString());
                        }
                    }
                    catch(Exception ex){
                        ex.getMessage();
                    }
                    break;
                }
                
                case 7:{
                    System.out.println("Informe o id do livro:");
                    int idLivro = sc.nextInt();
                    
                    try{
                        Livro livro = facadeLivro.buscarLivro(idLivro);
                        if(livro == null){
                            System.out.println("Livro não encontrado!");
                        }
                        else{
                            System.out.println(livro.toString());
                        }
                    }
                    catch(Exception ex){
                        ex.getMessage();
                    }
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
    }
    
    private static void menuListar(){
        System.out.println("1- Listar Endereco:");
        System.out.println("2- Listar Aluno:");
        System.out.println("3- Listar Funcionario:");
        System.out.println("4- Listar Autor:");
        System.out.println("5- Listar Editora:");
        System.out.println("6- Listar Secao:");
        System.out.println("7- Listar Livro:");
        System.out.println("0- Sair:");
        int opListar = sc.nextInt();
        
        switch(opListar){
                case 1:{
                    try{
                        List<Endereco> lista = facadePessoa.listarEndereco();
                        for(Endereco e:lista){
                            System.out.println(e.toString());    
                        }
                    }catch(Exception ex){
                        ex.getMessage();
                    }
                }
                
                case 2:{
                    try{
                        List<Aluno> lista = facadePessoa.listarAluno();
                        for(Aluno a:lista){
                            System.out.println(a.toString());    
                        }
                    }catch(Exception ex){
                        ex.getMessage();
                    }
                    break;
                }
                
                case 3:{
                    try{
                        List<Funcionario> lista = facadePessoa.listarFuncionario();
                        for(Funcionario f:lista){
                            System.out.println(f.toString());    
                        }
                    }catch(Exception ex){
                        ex.getMessage();
                    }
                    break;
                }
                
                case 4:{
                    try{
                        List<Autor> lista = facadeLivro.listarAutor();
                        for(Autor a:lista){
                            System.out.println(a.toString());    
                        }
                    }catch(Exception ex){
                        ex.getMessage();
                    }
                    break;
                }
                case 5:{
                    try{
                        List<Editora> lista = facadeLivro.listarEditora();
                        for(Editora e:lista){
                            System.out.println(e.toString());    
                        }
                    }catch(Exception ex){
                        ex.getMessage();
                    }
                    break;
                }
                
                case 6:{
                    try{
                        List<Secao> lista = facadeLivro.listarSecao();
                        for(Secao s:lista){
                            System.out.println(s.toString());    
                        }
                    }catch(Exception ex){
                        ex.getMessage();
                    }
                    break;
                }
                case 7:{
                    try{
                        List<Livro> lista = facadeLivro.listarLivro();
                        for(Livro l:lista){
                            System.out.println(l.toString());    
                        }
                    }catch(Exception ex){
                        ex.getMessage();
                    }
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
    }
        
    public static void menuDeletar(){
        System.out.println("1- Deletar Endereco:");
        System.out.println("2- Deletar Aluno:");
        System.out.println("3- Deletar Funcionario:");
        System.out.println("4- Deletar Autor:");
        System.out.println("5- Deletar Editora:");
        System.out.println("6- Deletar Secao:");
        System.out.println("7- Deletar Livro:");
        System.out.println("0- Sair:");
        int opEditar = sc.nextInt();
        switch(opEditar){
                case 1:{
                    System.out.println("Informe o id do endereco:");
                    int idEndereco = sc.nextInt();
                    
                    try{
                        Endereco endereco = facadePessoa.buscarEndereco(idEndereco);
                        if(endereco == null){
                            System.out.println("Endereco não encontrado");
                        }
                        else{
                            facadePessoa.deletarEndereco(endereco);
                        }
                    }
                    catch(Exception ex){
                        ex.getMessage();
                    }
                }
                
                case 2:{
                    System.out.println("Informe o id do aluno:");
                    int idAluno = sc.nextInt();
                    
                    try{
                        Aluno aluno = facadePessoa.buscarAluno(idAluno);
                        if(aluno == null){
                            System.out.println("Aluno não encontrado!");
                        }
                        else{
                            facadePessoa.deletarAluno(aluno);
                        }
                    }
                    catch(Exception ex){
                        ex.getMessage();
                    }
                    break;
                }
                
                case 3:{
                    System.out.println("Informe o id do funcionario:");
                    int idFuncionario = sc.nextInt();
                    
                    try{
                        Funcionario funcionario = facadePessoa.buscarFuncionario(idFuncionario);
                        if(funcionario == null){
                            System.out.println("Funcionario não encontrado!");
                        }
                        else{
                            facadePessoa.deletarFuncionario(funcionario);
                        }
                    }
                    catch(Exception ex){
                        ex.getMessage();
                    }
                    break;
                }
                
                case 4:{
                    System.out.println("Informe o id do autor:");
                    int idAutor = sc.nextInt();
                    
                    try{
                        Autor autor = facadeLivro.buscarAutor(idAutor);
                        if(autor == null){
                            System.out.println("Autor não encontrado!");
                        }
                        else{
                            facadeLivro.deletarAutor(autor);
                        }
                    }
                    catch(Exception ex){
                        ex.getMessage();
                    }
                    break;
                }
                case 5:{
                    System.out.println("Informe o id da editora:");
                    int idEditora = sc.nextInt();
                    
                    try{
                        Editora editora = facadeLivro.buscarEditora(idEditora);
                        if(editora == null){
                            System.out.println("Editora não encontrada!");
                        }
                        else{
                            facadeLivro.deletarEditora(editora);
                        }
                    }
                    catch(Exception ex){
                        ex.getMessage();
                    }
                    break;
                }
                
                case 6:{
                    System.out.println("Informe o id da secao:");
                    int idSecao = sc.nextInt();
                    
                    try{
                        Secao secao = facadeLivro.buscarSecao(idSecao);
                        if(secao == null){
                            System.out.println("Secao não encontrada!");
                        }
                        else{
                            facadeLivro.deletarSecao(secao);
                        }
                    }
                    catch(Exception ex){
                        ex.getMessage();
                    }
                    break;
                }
                
                case 7:{
                    System.out.println("Informe o id do livro:");
                    int idLivro = sc.nextInt();
                    
                    try{
                        Livro livro = facadeLivro.buscarLivro(idLivro);
                        if(livro == null){
                            System.out.println("Livro não encontrado!");
                        }
                        else{
                            facadeLivro.deletarLivro(livro);
                        }
                    }
                    catch(Exception ex){
                        ex.getMessage();
                    }
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
    }
   //faltando ajeitar a dataprevista 
    private static void MenuEmprestimo(){
        System.out.println("1- Emprestimo:");
        System.out.println("2- Devolucao:");
        System.out.println("0- Sair:");
        int opEmprestimo = sc.nextInt();
        switch(opEmprestimo){
            case 1:{
                System.out.println("Informe o id do aluno:");
                int idAluno = sc.nextInt();
                System.out.println("Informe o id do livro:");
                int idLivro = sc.nextInt();
                try{
                    Aluno aluno = facadePessoa.buscarAluno(idAluno);
                    Livro livro = facadeLivro.buscarLivro(idLivro);
                    if(aluno == null || livro == null){
                        System.out.println("Dados Invalidos!");
                    }
                    else{
                        //System.out.println("Informe a data de entrega:");
                        //int dataprevista
                        
                        Emprestimo emprestimo = new Emprestimo();
                        if(livro.getExemplaresDisponiveis()== 0){
                            System.out.println("O livro nao tem exempares disponiveis!");
                        }
                        else{
                            emprestimo.setAluno(aluno);
                            emprestimo.setLivro(livro);
                            emprestimo.setReserva(true);
                            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                            Date data = new Date(System.currentTimeMillis());
                            formato.format(data);
                            emprestimo.setData(data);
                            
                            facadeEmprestimo.cadastrarEmprestimo(emprestimo);
                            
                            livro.setExemplaresDisponiveis(livro.getExemplaresDisponiveis()-1);
                            facadeLivro.editarLivro(livro);
                        }
                        
                    }
                    
                }catch(Exception ex){
                    ex.getMessage();
                }
                
                break;
            }
   
            case 2:{
                System.out.println("Informe o id do emprestimo:");
                int idEmprestimo = sc.nextInt();
                try{
                    Emprestimo emprestimo = facadeEmprestimo.buscarEmprestimo(idEmprestimo);
                    if(emprestimo == null){
                        System.out.println("Emprestimo não existe!");
                    }
                    else{
                        emprestimo.setReserva(false);
                        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                        Date entrega = new Date(System.currentTimeMillis());
                        formato.format(entrega);
                        emprestimo.setEntrega(entrega);
                        
                        facadeEmprestimo.editarEmprestimo(emprestimo);
                        
                        emprestimo.getLivro().setExemplaresDisponiveis(emprestimo.getLivro().getExemplaresDisponiveis()+1);
                        facadeLivro.editarLivro(emprestimo.getLivro());
                    }
                }catch (Exception ex){
                   ex.getMessage();
                }
                
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
    } 
    
}
