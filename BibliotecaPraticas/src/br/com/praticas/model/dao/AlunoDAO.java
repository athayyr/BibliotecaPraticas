/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.model.dao;

import br.com.praticas.factory.ConnectionFactory;
import br.com.praticas.factory.DAOFactory;
import br.com.praticas.interfaces.IAlunoDAO;
import br.com.praticas.model.bean.Aluno;
import br.com.praticas.model.bean.Pessoa;
import br.com.praticas.util.Properties;
import br.com.praticas.util.Util;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
            
            if(DAOFactory.createPessoaDAO().create(pessoa)){
            st = connection.prepareStatement("INSERT INTO aluno (id, matricula, curso) VALUES(?,?,?)");
            st.setInt(1, aluno.getId());
            st.setInt(2, aluno.getMatricula());
            st.setString(3, aluno.getCurso());

            st.executeUpdate();

            return true;
            }
            else{
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
        connection = ConnectionFactory.getConnection();

        PreparedStatement st = null;

        try {
            st = connection.prepareStatement("DELETE FROM aluno WHERE id = ?");
            st.setInt(1, aluno.getId());
            st.executeUpdate();
            
            st = connection.prepareStatement("DELETE FROM pessoa WHERE id = ?");
            st.setInt(1, aluno.getId());
            st.executeUpdate();
            
            return true;
        }
        
        catch (Exception ex) {
            throw new Exception(Properties.getStringErroValue(Properties.ERRO_DELETAR_ALUNO));
        } finally {
            ConnectionFactory.closeConnection(connection, st);
        }
    }

    @Override
    public List<Aluno> list() throws Exception {
        List<Aluno> lista = new ArrayList<>();
        connection = ConnectionFactory.getConnection();
        PreparedStatement st = null;

        try {
            st = connection.prepareStatement("SELECT id, matricula, curso FROM aluno");

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setId(rs.getInt("id"));
                Pessoa pessoa = DAOFactory.createPessoaDAO().search(aluno.getId());
                aluno.setEndereco(pessoa.getEndereco());
                aluno.setNome(pessoa.getNome());
                aluno.setNascimento(pessoa.getNascimento());
                aluno.setMatricula(rs.getInt("matricula"));
                aluno.setCurso(rs.getString("curso"));
                lista.add(aluno);
            }
            return lista;
        } catch (Exception ex) {
            throw new Exception(Properties.getStringErroValue(Properties.ERRO_LISTAR_ALUNO));
        } finally {
            ConnectionFactory.closeConnection(connection, st);
        }
    }

    @Override
    public Aluno search(int id) throws Exception {
        Aluno aluno = null;
        connection = ConnectionFactory.getConnection();
        PreparedStatement st = null;

        try {
            st = connection.prepareStatement("SELECT id, matricula, curso FROM aluno WHERE id=?");

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            
            if (rs.next()) {
                Pessoa pessoa = DAOFactory.createPessoaDAO().search(id);
                aluno = new Aluno();
                aluno.setId(id);
                aluno.setNome(pessoa.getNome());
                aluno.setEndereco(pessoa.getEndereco());
                aluno.setNascimento(pessoa.getNascimento());
                aluno.setMatricula(rs.getInt("matricula"));
                aluno.setCurso(rs.getString("curso"));
            }
            return aluno;
        } catch (Exception ex) {
            throw new Exception(Properties.getStringErroValue(Properties.ERRO_BUSCAR_ALUNO));
        } finally {
            ConnectionFactory.closeConnection(connection, st);
        }
    }

    @Override
    public void update(Aluno aluno) throws Exception {
        connection = ConnectionFactory.getConnection();

        PreparedStatement st = null;
        
        try {
            st = connection.prepareStatement("UPDATE pessoa SET nome = ?, nascimento = ?, endereco = ? WHERE id = ? ");

            st.setString(1, aluno.getNome());
            st.setDate(2, new java.sql.Date(aluno.getNascimento().getTime()));
            st.setInt(3, aluno.getEndereco().getId());
            st.setInt(4, aluno.getId());

            st.executeUpdate();
            
            st = connection.prepareStatement("UPDATE aluno SET matricula = ?, curso = ? WHERE id = ?");
            
            st.setInt(1, aluno.getMatricula());
            st.setString(2, aluno.getCurso());
            st.setInt(3, aluno.getId());
            
            st.executeUpdate();
            
        } catch (Exception ex) {
            throw new Exception(Properties.getStringErroValue(Properties.ERRO_EDITAR_ALUNO));
        } finally {
            ConnectionFactory.closeConnection(connection, st);
        }
    }
    
}
