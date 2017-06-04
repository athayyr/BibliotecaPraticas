/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.praticas.util;

import java.util.ResourceBundle;

/**
 *
 * @author VAAR
 */
public class Properties {
    
    public static final ResourceBundle RESOURCE_CONFIGURACAO = ResourceBundle.getBundle("br\\com\\praticas\\properties\\configuracao");
    public static final ResourceBundle RESOURCE_STRINGS_ERRO = ResourceBundle.getBundle("br\\com\\praticas\\properties\\stringsErro");
    public static final ResourceBundle RESOURCE_STRINGS_SUCESSO = ResourceBundle.getBundle("br\\com\\praticas\\properties\\stringsSucesso");
    
    //Parte de configuração
    public static final String JDBC_DRIVER = "jdbc_driver";
    public static final String JDBC_URL = "jdbc_url";
    public static final String JDBC_USER = "jdbc_user";
    public static final String JDBC_PASS = "jdbc_password";
    
    public static String getConfiguracaoValue(String chave){
        return RESOURCE_CONFIGURACAO.getString(chave);
    }
    
    //String de erro do sistema
    
    public static final String ERRO_INSERIR_SECAO = "erro_inserir_secao";
    public static final String ERRO_EDITAR_SECAO = "erro_editar_secao";
    public static final String ERRO_DELETAR_SECAO = "erro_deletar_secao";
    public static final String ERRO_BUSCAR_SECAO = "erro_buscar_secao";
    public static final String ERRO_LISTAR_SECAO = "erro_listar_secao";
    
    public static final String ERRO_INSERIR_EDITORA = "erro_inserir_editora";
    public static final String ERRO_EDITAR_EDITORA = "erro_editar_editora";
    public static final String ERRO_DELETAR_EDITORA = "erro_deletar_editora";
    public static final String ERRO_BUSCAR_EDITORA = "erro_buscar_editora";
    public static final String ERRO_LISTAR_EDITORA = "erro_listar_editora";
    
    public static final String ERRO_INSERIR_AUTOR = "erro_inserir_autor";
    public static final String ERRO_EDITAR_AUTOR = "erro_editar_autor";
    public static final String ERRO_DELETAR_AUTOR = "erro_deletar_autor";
    public static final String ERRO_BUSCAR_AUTOR = "erro_buscar_autor";
    public static final String ERRO_LISTAR_AUTOR = "erro_listar_autor";
    
    public static final String ERRO_INSERIR_LIVRO = "erro_inserir_livro";
    public static final String ERRO_EDITAR_LIVRO = "erro_editar_livro";
    public static final String ERRO_DELETAR_LIVRO = "erro_deletar_livro";
    public static final String ERRO_BUSCAR_LIVRO = "erro_buscar_livro";
    public static final String ERRO_LISTAR_LIVRO = "erro_listar_livro";
    
    public static final String ERRO_INSERIR_ENDERECO = "erro_inserir_endereco";
    public static final String ERRO_EDITAR_ENDERECO = "erro_editar_endereco";
    public static final String ERRO_DELETAR_ENDERECO = "erro_deletar_endereco";
    public static final String ERRO_BUSCAR_ENDERECO = "erro_buscar_endereco";
    public static final String ERRO_LISTAR_ENDERECO = "erro_listar_endereco";
    
    public static final String ERRO_INSERIR_PESSOA = "erro_inserir_pessoa";
    public static final String ERRO_EDITAR_PESSOA = "erro_editar_pessoa";
    public static final String ERRO_DELETAR_PESSOA = "erro_deletar_pessoa";
    public static final String ERRO_BUSCAR_PESSOA = "erro_buscar_pessoa";
    public static final String ERRO_LISTAR_PESSOA = "erro_listar_pessoa";
    
    public static final String ERRO_INSERIR_ALUNO = "erro_inserir_aluno";
    public static final String ERRO_EDITAR_ALUNO = "erro_editar_aluno";
    public static final String ERRO_DELETAR_ALUNO = "erro_deletar_aluno";
    public static final String ERRO_BUSCAR_ALUNO = "erro_buscar_aluno";
    public static final String ERRO_LISTAR_ALUNO = "erro_listar_aluno";
    
    public static final String ERRO_INSERIR_FUNCIONARIO = "erro_inserir_funcionario";
    public static final String ERRO_EDITAR_FUNCIONARIO = "erro_editar_funcionario";
    public static final String ERRO_DELETAR_FUNCIONARIO = "erro_deletar_funcionario";
    public static final String ERRO_BUSCAR_FUNCIONARIO = "erro_buscar_funcionario";
    public static final String ERRO_LISTAR_FUNCIONARIO = "erro_listar_funcionario";
    
    public static String getStringErroValue(String chave){
        return RESOURCE_STRINGS_ERRO.getString(chave);
    }
    
    //String de Sucesso do sistema

    public static final String SUCESSO_INSERIR_SECAO = "sucesso_inserir_secao";
    public static final String SUCESSO_EDITAR_SECAO = "sucesso_editar_secao";
    public static final String SUCESSO_DELETAR_SECAO = "sucesso_deletar_secao";
    public static final String SUCESSO_BUSCAR_SECAO = "sucesso_buscar_secao";
    public static final String SUCESSO_LISTAR_SECAO = "sucesso_listar_secao";
    
    public static final String SUCESSO_INSERIR_EDITORA = "sucesso_inserir_editora";
    public static final String SUCESSO_EDITAR_EDITORA = "sucesso_editar_editora";
    public static final String SUCESSO_DELETAR_EDITORA = "sucesso_deletar_editora";
    public static final String SUCESSO_BUSCAR_EDITORA = "sucesso_buscar_editora";
    public static final String SUCESSO_LISTAR_EDITORA = "sucesso_listar_editora";
    
    public static final String SUCESSO_INSERIR_AUTOR = "sucesso_inserir_autor";
    public static final String SUCESSO_EDITAR_AUTOR = "sucesso_editar_autor";
    public static final String SUCESSO_DELETAR_AUTOR = "sucesso_deletar_autor";
    public static final String SUCESSO_BUSCAR_AUTOR = "sucesso_buscar_autor";
    public static final String SUCESSO_LISTAR_AUTOR = "sucesso_listar_autor";
    
    public static final String SUCESSO_INSERIR_LIVRO = "sucesso_inserir_livro";
    public static final String SUCESSO_EDITAR_LIVRO = "sucesso_editar_livro";
    public static final String SUCESSO_DELETAR_LIVRO = "sucesso_deletar_livro";
    public static final String SUCESSO_BUSCAR_LIVRO = "sucesso_buscar_livro";
    public static final String SUCESSO_LISTAR_LIVRO = "sucesso_listar_livro";
    
    public static final String SUCESSO_INSERIR_ENDERECO = "sucesso_inserir_endereco";
    public static final String SUCESSO_EDITAR_ENDERECO = "sucesso_editar_endereco";
    public static final String SUCESSO_DELETAR_ENDERECO = "sucesso_deletar_endereco";
    public static final String SUCESSO_BUSCAR_ENDERECO = "sucesso_buscar_endereco";
    public static final String SUCESSO_LISTAR_ENDERECO = "sucesso_listar_endereco";
    
    public static final String SUCESSO_INSERIR_PESSOA = "sucesso_inserir_pessoa";
    public static final String SUCESSO_EDITAR_PESSOA = "sucesso_editar_pessoa";
    public static final String SUCESSO_DELETAR_PESSOA = "sucesso_deletar_pessoa";
    public static final String SUCESSO_BUSCAR_PESSOA = "sucesso_buscar_pessoa";
    public static final String SUCESSO_LISTAR_PESSOA = "sucesso_listar_pessoa";
    
    public static final String SUCESSO_INSERIR_ALUNO = "sucesso_inserir_aluno";
    public static final String SUCESSO_EDITAR_ALUNO = "sucesso_editar_aluno";
    public static final String SUCESSO_DELETAR_ALUNO = "sucesso_deletar_aluno";
    public static final String SUCESSO_BUSCAR_ALUNO = "sucesso_buscar_aluno";
    public static final String SUCESSO_LISTAR_ALUNO = "sucesso_listar_aluno";
    
    public static final String SUCESSO_INSERIR_FUNCIONARIO = "sucesso_inserir_funcionario";
    public static final String SUCESSO_EDITAR_FUNCIONARIO = "sucesso_editar_funcionario";
    public static final String SUCESSO_DELETAR_FUNCIONARIO = "sucesso_deletar_funcionario";
    public static final String SUCESSO_BUSCAR_FUNCIONARIO = "sucesso_buscar_funcionario";
    public static final String SUCESSO_LISTAR_FUNCIONARIO = "sucesso_listar_funcionario";
    
    
    
    public static String getStringSucessoValue(String chave){
        return RESOURCE_STRINGS_SUCESSO.getString(chave);
    }
    
}
