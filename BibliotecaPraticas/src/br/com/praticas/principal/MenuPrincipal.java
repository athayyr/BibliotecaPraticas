/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.principal;

import br.com.praticas.facade.BibliotecaFacadeEmprestimo;
import br.com.praticas.facade.BibliotecaFacadeLivro;
import br.com.praticas.facade.BibliotecaFacadePessoa;
import br.com.praticas.iReport.IReport;
import br.com.praticas.model.bean.Aluno;
import br.com.praticas.model.bean.Autor;
import br.com.praticas.model.bean.Editora;
import br.com.praticas.model.bean.Emprestimo;
import br.com.praticas.model.bean.Endereco;
import br.com.praticas.model.bean.Funcionario;
import br.com.praticas.model.bean.Livro;
import br.com.praticas.model.bean.Pessoa;
import br.com.praticas.model.bean.Secao;
import br.com.praticas.util.Properties;
import br.com.praticas.util.Util;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author José Higor
 */
public class MenuPrincipal {

    /**
     * @param args the command line arguments
     */
    private Scanner sc = new Scanner(System.in);
    private BibliotecaFacadePessoa facadePessoa = new BibliotecaFacadePessoa();
    private BibliotecaFacadeLivro facadeLivro = new BibliotecaFacadeLivro();
    private BibliotecaFacadeEmprestimo facadeEmprestimo = new BibliotecaFacadeEmprestimo();
    
    public void executar() throws Exception {
        String login,senha;
        do{
            
            System.out.println("Informe o login:");
            login = sc.nextLine();
            System.out.println("Informe a senha:");
            senha = sc.nextLine();
            
        }while(!facadePessoa.login(login, senha));
        
        int op;
        
        do{
            System.out.println("MENU");
            System.out.println("1-Cadastrar:");
            System.out.println("2-Editar:");
            System.out.println("3-Listar:");
            System.out.println("4-Buscar:");
            System.out.println("5-Remover:");
            System.out.println("6-Emprestimo:");
            System.out.println("7 - Relatorio:");
            System.out.println("0-Sair");
            op=sc.nextInt();
            sc.nextLine();
            switch(op){
                case 1:{
                    menuCadastrar();
                    break;
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
                
                case 7:{
                    IReport rp = new IReport();
                    
                    rp.iReport();
                    
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

    private void menuCadastrar(){
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
        sc.nextLine();
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
                        System.out.println(Properties.SUCESSO_INSERIR_ENDERECO);
                    }catch(Exception ex){
                        ex.getMessage();
                    }
                    break;
                }
                
                case 2:{
                    System.out.println("Informe o id:");
                    int idAluno = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Informe o nome:");
                    String nome = sc.nextLine();
                    System.out.println("Informe a data de nascimento:");
                    String dataNascimento = sc.nextLine();
                    System.out.println("Informe a matricula:");
                    int matricula = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Informe o curso:");
                    String curso = sc.nextLine();
                    System.out.println("Informe o id do endereco:");
                    int idEndereco = sc.nextInt();
                    sc.nextLine();
                    
                    try{
                        Endereco e = facadePessoa.buscarEndereco(idEndereco);
                        if(e == null){
                            System.out.println("Endereco não existe!");
                        }
                        else{
                            Pessoa pessoa =  new Pessoa();
                            pessoa.setId(idAluno);
                            pessoa.setNome(nome);
                            pessoa.setNascimento(Util.stringToDate(dataNascimento));
                            pessoa.setEndereco(e);
                            facadePessoa.cadastrarPessoa(pessoa);

                            Aluno aluno = new Aluno();
                            aluno.setId(idAluno);
                            aluno.setNome(nome);
                            aluno.setNascimento(Util.stringToDate(dataNascimento));
                            aluno.setEndereco(e);
                            aluno.setCurso(curso);
                            aluno.setMatricula(matricula);
                            facadePessoa.cadastrarAluno(aluno);
                            System.out.println(Properties.SUCESSO_INSERIR_ALUNO);
                        }
                     }catch(Exception ex){
                        System.out.println(ex.getMessage());
                    }
                    break;
                }
                
                case 3:{
                    System.out.println("Informe o id do funcionario:");
                    int idFuncionario = sc.nextInt();
                    sc.nextLine();
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
                    sc.nextLine();
                    
                    try{
                        Endereco e = facadePessoa.buscarEndereco(idEndereco);
                        if(e == null){
                            System.out.println("Endereco não existe!");
                        }
                        else{
                            Pessoa pessoa =  new Pessoa();
                            pessoa.setId(idFuncionario);
                            pessoa.setNome(nome);
                            pessoa.setNascimento(Util.stringToDate(dataNascimento));
                            pessoa.setEndereco(e);
                            facadePessoa.cadastrarPessoa(pessoa);

                            Funcionario funcionario = new Funcionario();
                            funcionario.setId(pessoa.getId());
                            funcionario.setCargo(cargo);
                            funcionario.setLogin(login);
                            funcionario.setSenha(senha);
                            facadePessoa.cadastrarFuncionario(funcionario);
                            System.out.println(Properties.SUCESSO_INSERIR_FUNCIONARIO);
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
                        System.out.println(Properties.SUCESSO_INSERIR_AUTOR);
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
                        System.out.println(Properties.SUCESSO_INSERIR_EDITORA);
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
                        System.out.println(Properties.SUCESSO_INSERIR_SECAO);
                    }catch(Exception ex){
                        ex.getMessage();
                    }
                    break;
                }
                
                case 7:{
                    try{
                        System.out.println("Informe o titulo do livro:");
                        String titulo = sc.nextLine();
                        System.out.println("Informe o id do autor:");
                        int idAutor = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Informe o id da editora:");
                        int idEditora = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Informe o id da secao");
                        int idSecao = sc.nextInt();
                        sc.nextLine();
                        Secao secao = facadeLivro.buscarSecao(idSecao);
                        Editora editora = facadeLivro.buscarEditora(idEditora);
                        Autor autor = facadeLivro.buscarAutor(idAutor);
                        
                        if(editora == null || secao == null || autor == null){
                            System.out.println("Dados Invalidos!");
                        }
                       
                        else{
                            System.out.println("Informe o numero de exemplares:");
                            int numExemplares = sc.nextInt();
                            sc.nextLine();
                            
                            Livro livro = new Livro();
                            livro.setTitulo(titulo);
                            livro.setAutor(autor);
                            livro.setEditora(editora);
                            livro.setSecao(secao);
                            livro.setExemplares(numExemplares);
                            livro.setExemplaresDisponiveis(numExemplares);
                            
                            facadeLivro.cadastrarLivro(livro);
                            System.out.println(Properties.SUCESSO_INSERIR_LIVRO);
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
    
    private void menuEditar(){
        System.out.println("1- Editar Endereco:");
        System.out.println("2- Editar Aluno:");
        System.out.println("3- Editar Funcionario:");
        System.out.println("4- Editar Autor:");
        System.out.println("5- Editar Editora:");
        System.out.println("6- Editar Secao:");
        System.out.println("7- Editat Livro:");
        System.out.println("0- Sair:");
        int opEditar = sc.nextInt();
        sc.nextLine();
        switch(opEditar){
                case 1:{
                    System.out.println("Informe o id do endereco:");
                    int idEndereco = sc.nextInt();
                    sc.nextLine();
                    
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
                    
                    break;
                }
                
                case 2:{
                    System.out.println("Informe o id do aluno:");
                    int idAluno = sc.nextInt();
                    sc.nextLine();
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
                            sc.nextLine();
                            System.out.println("Informe o curso:");
                            String curso = sc.nextLine();
                            System.out.println("Informe o id do endereco:");
                            int idEndereco = sc.nextInt();
                            sc.nextLine();
                            
                            Endereco endereco = facadePessoa.buscarEndereco(idEndereco);
                            if(endereco == null){
                                System.out.println("Endereco não encontrado!");
                            }
                            else{
                                Pessoa pessoa =  new Pessoa();
                                pessoa.setNome(nome);
                                pessoa.setNascimento(Util.stringToDate(dataNascimento));
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
                    sc.nextLine();
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
                            sc.nextLine();
                            
                            Endereco endereco = facadePessoa.buscarEndereco(idEndereco);
                            if(endereco == null){
                                System.out.println("Endereco não encontrado!");
                            }
                            else{
                                Pessoa pessoa =  new Pessoa();
                                pessoa.setNome(nome);
                                pessoa.setNascimento(Util.stringToDate(dataNascimento));
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
                    sc.nextLine();
                    
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
                    sc.nextLine();
                    
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
                    sc.nextLine();
                    
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
                    sc.nextLine();
                    
                    try{
                        Livro livro = facadeLivro.buscarLivro(idLivro);
                        if(livro == null){
                            System.out.println("Livro não encontrado!");
                        }
                        else{
                            System.out.println("Informe o titulo do livro:");
                            String titulo = sc.nextLine();
                            System.out.println("Informe o id do autor:");
                            int idAutor = sc.nextInt();  
                            sc.nextLine();
                            System.out.println("Informe o id da editora:");
                            int idEditora = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Informe o id da secao");
                            int idSecao = sc.nextInt();
                            sc.nextLine();
                            
                            Secao secao = facadeLivro.buscarSecao(idSecao);
                            Editora editora = facadeLivro.buscarEditora(idEditora);
                            Autor autor = facadeLivro.buscarAutor(idAutor);

                            if(editora == null || secao == null || autor == null){
                                System.out.println("Dados Invalidos!");
                            }

                            else{
                                System.out.println("Informe o numero de exemplares:");
                                int numExemplares = sc.nextInt();
                                sc.nextLine();
                                
                                livro.setTitulo(titulo);
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
    
    private void menuBuscar(){
        System.out.println("1- Buscar Endereco:");
        System.out.println("2- Buscar Aluno:");
        System.out.println("3- Buscar Funcionario:");
        System.out.println("4- Buscar Autor:");
        System.out.println("5- Buscar Editora:");
        System.out.println("6- Buscar Secao:");
        System.out.println("7- Buscar Livro:");
        System.out.println("0- Sair:");
        int opEditar = sc.nextInt();
        sc.nextLine();
        
        switch(opEditar){
                case 1:{
                    System.out.println("Informe o id do endereco:");
                    int idEndereco = sc.nextInt();
                    sc.nextLine();
                    
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
                    break;
                }
                
                case 2:{
                    System.out.println("Informe o id do aluno:");
                    int idAluno = sc.nextInt();
                    sc.nextLine();
                    
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
                    sc.nextLine();
                    
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
                    sc.nextLine();
                    
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
                    sc.nextLine();
                    
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
                    sc.nextLine();
                    
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
                    sc.nextLine();
                    
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
    
    private void menuListar(){
        System.out.println("1- Listar Endereco:");
        System.out.println("2- Listar Aluno:");
        System.out.println("3- Listar Funcionario:");
        System.out.println("4- Listar Autor:");
        System.out.println("5- Listar Editora:");
        System.out.println("6- Listar Secao:");
        System.out.println("7- Listar Livro:");
        System.out.println("0- Sair:");
        int opListar = sc.nextInt();
        sc.nextLine();
        
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
                    break;
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
        
    public void menuDeletar(){
        System.out.println("1- Deletar Endereco:");
        System.out.println("2- Deletar Aluno:");
        System.out.println("3- Deletar Funcionario:");
        System.out.println("4- Deletar Autor:");
        System.out.println("5- Deletar Editora:");
        System.out.println("6- Deletar Secao:");
        System.out.println("7- Deletar Livro:");
        System.out.println("0- Sair:");
        int opEditar = sc.nextInt();
        sc.nextLine();
        switch(opEditar){
                case 1:{
                    System.out.println("Informe o id do endereco:");
                    int idEndereco = sc.nextInt();
                    sc.nextLine();
                    
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
                    break;
                }
                
                case 2:{
                    System.out.println("Informe o id do aluno:");
                    int idAluno = sc.nextInt();
                    sc.nextLine();
                    
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
                    sc.nextLine();
                    
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
                    sc.nextLine();
                    
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
                    sc.nextLine();
                    
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
                    sc.nextLine();
                    
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
                    sc.nextLine();
                    
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
   //faltando ajeitar a dataprevista 
    private void MenuEmprestimo(){
        System.out.println("1- Emprestimo:");
        System.out.println("2- Devolucao:");
        System.out.println("0- Sair:");
        int opEmprestimo = sc.nextInt();
        sc.nextLine();
        switch(opEmprestimo){
            case 1:{
                System.out.println("Informe o id do aluno:");
                int idAluno = sc.nextInt();
                sc.nextLine();
                System.out.println("Informe o id do livro:");
                int idLivro = sc.nextInt();
                sc.nextLine();
                try{
                    Aluno aluno = facadePessoa.buscarAluno(idAluno);
                    Livro livro = facadeLivro.buscarLivro(idLivro);
                    if(aluno == null || livro == null){
                        System.out.println("Dados Invalidos!");
                    }
                    else{
                        if(livro.getExemplaresDisponiveis()== 0){
                            System.out.println("O livro nao tem exempares disponiveis!");
                        }
                        else{
                            System.out.println("Informe a quantidade de dias do emprestimo:");
                            int entrega = sc.nextInt();
                            
                            Emprestimo emprestimo = new Emprestimo();
                            emprestimo.setAluno(aluno);
                            emprestimo.setLivro(livro);
                            emprestimo.setReserva(true);
                            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                            Calendar calendar = new GregorianCalendar();
                            calendar= calendar.getInstance();
                            Date data = calendar.getTime();
                            formato.format(data);
                            calendar.add(Calendar.DATE, entrega);
                            
                            calendar.set(Calendar.DAY_OF_MONTH,calendar.get(Calendar.DAY_OF_MONTH)+1);
                            Date dataPrevista = calendar.getTime();
                            formato.format(dataPrevista);
                            emprestimo.setData(data);
                            emprestimo.setDataPrevista(dataPrevista);
                            
                            
                            facadeEmprestimo.cadastrarEmprestimo(emprestimo);
                            
                            livro.setExemplaresDisponiveis(livro.getExemplaresDisponiveis()-1);
                            facadeLivro.editarLivro(livro);
                        }
                        
                    }
                    
                }catch(Exception ex){
                    ex.printStackTrace();
                    ex.getMessage();
                }
                
                break;
            }
   
            case 2:{
                System.out.println("Informe o id do emprestimo:");
                int idEmprestimo = sc.nextInt();
                sc.nextLine();
                try{
                    Emprestimo emprestimo = facadeEmprestimo.buscarEmprestimo(idEmprestimo);
                    if(emprestimo == null){
                        System.out.println("Emprestimo não existe!");
                    }
                    else{
                        emprestimo.setReserva(false);
                        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                        Calendar calendar = new GregorianCalendar();
                        calendar = calendar.getInstance();
                        Date entrega = new Date(System.currentTimeMillis());
                        formato.format(entrega);
                        emprestimo.setEntrega(entrega);
                        if(entrega.getTime()>emprestimo.getDataPrevista().getTime()){
                            System.out.println("Entrega atrasada, cobre a multa!");
                        }
                        
                        facadeEmprestimo.editarEmprestimo(emprestimo);
                        
                        emprestimo.getLivro().setExemplaresDisponiveis(emprestimo.getLivro().getExemplaresDisponiveis()+1);
                        facadeLivro.editarLivro(emprestimo.getLivro());
                    }
                }catch (Exception ex){
                   ex.printStackTrace();
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
