/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.model.dao;

import br.com.praticas.factory.ConnectionFactory;
import br.com.praticas.interfaces.IAlunoDAO;
import br.com.praticas.model.bean.Aluno;
import br.com.praticas.model.bean.Pessoa;
import br.com.praticas.util.Properties;
import br.com.praticas.util.Util;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

/**
 *
 * @author José Higor
 */
public class AlunoDAO implements IAlunoDAO{
    private Connection connection;
    
    @Override
    public boolean create(Aluno aluno) throws Exception {
        connection = ConnectionFactory.getConnection();

        PreparedStatement st = null;

        try {
            Pessoa pessoa = new Pessoa();
            pessoa.setId(aluno.getId());
            pessoa.setNome(aluno.getNome());
            pessoa.setEndereco(aluno.getEndereco());
            pessoa.setNascimento(aluno.getNascimento());
            PessoaDAO pessoaDAO = new PessoaDAO();
            
            if(pessoaDAO.create(pessoa)){
            st = connection.prepareStatement("INSERT INTO aluno (id, matricula, curso) VALUES(?,?,?)");
            st.setInt(1, aluno.getId());
            st.setInt(2, aluno.getMatricula());
            st.setString(3, aluno.getCurso());

            st.executeUpdate();

            return true;
            }else{
                throw new Exception(Properties.getStringErroValue(Properties.ERRO_INSERIR_PESSOA));
            }
            
        } catch (Exception ex) {
            throw new Exception(Properties.getStringErroValue(Properties.ERRO_INSERIR_ALUNO));
        } finally {
            ConnectionFactory.closeConnection(connection, st);
        }
    }

    @Override
    public boolean delete(Aluno aluno) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Aluno> list() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Aluno search(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Aluno aluno) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
