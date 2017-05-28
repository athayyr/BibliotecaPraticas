/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.model.dao;

import br.com.praticas.interfaces.IPessoaDAO;
import br.com.praticas.factory.ConnectionFactory;
import br.com.praticas.model.bean.Pessoa;
import br.com.praticas.factory.DAOFactory;
import br.com.praticas.util.Properties;
import br.com.praticas.util.Util;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author VAAR
 */
public class PessoaDAO implements IPessoaDAO {

    private Connection connection;

    @Override
    public boolean create(Pessoa pessoa) throws Exception {
        connection = ConnectionFactory.getConnection();

        PreparedStatement st = null;

        try {
            st = connection.prepareStatement("INSERT INTO pessoa (nome,nascimento,endereco) VALUES(?,?,?)");
            st.setString(1, pessoa.getNome());
            st.setDate(2, Util.dateParaSql(pessoa.getNascimento()));
            st.setInt(3, pessoa.getEndereco().getId());

            st.executeUpdate();

            return true;
        } catch (Exception ex) {
            throw new Exception(Properties.getStringErroValue(Properties.ERRO_INSERIR_PESSOA));
        } finally {
            ConnectionFactory.closeConnection(connection, st);
        }
    }

    @Override
    public Pessoa search(int id) throws Exception {
        Pessoa pessoa = null;
        connection = ConnectionFactory.getConnection();

        PreparedStatement st = null;

        try {
            st = connection.prepareStatement("SELECT id, nome, nascimento, endereco FROM public.pessoa WHERE id=?");

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                pessoa = new Pessoa();

                pessoa.setId(id);
                pessoa.setNome(rs.getString("nome"));
                pessoa.setNascimento(rs.getDate("nascimento"));
                pessoa.setEndereco(DAOFactory.createEnderecoDAO().search(rs.getInt("endereco")));

            }
            return pessoa;
        } catch (Exception ex) {
            throw new Exception(Properties.getStringErroValue(Properties.ERRO_BUSCAR_PESSOA));
        } finally {
            ConnectionFactory.closeConnection(connection, st);
        }

    }

    @Override
    public void update(Pessoa pessoa) throws Exception {
        connection = ConnectionFactory.getConnection();

        PreparedStatement st = null;

        try {
            st = connection.prepareStatement("UPDATE pessoa SET nome = ?, nascimento = ?, endereco = ? WHERE id = ? ");

            st.setString(1, pessoa.getNome());
            st.setDate(2, new java.sql.Date(pessoa.getNascimento().getTime()));
            st.setInt(3, pessoa.getEndereco().getId());
            st.setInt(4, pessoa.getId());

            st.executeUpdate();
            
        } catch (Exception ex) {
            throw new Exception(Properties.getStringErroValue(Properties.ERRO_EDITAR_PESSOA));
        } finally {
            ConnectionFactory.closeConnection(connection, st);
        }
    }

    @Override
    public boolean delete(Pessoa pessoa) throws Exception{
        connection = ConnectionFactory.getConnection();

        PreparedStatement st = null;

        try {
            st = connection.prepareStatement("DELETE FROM pessoa WHERE id = ?");

            st.setInt(1, pessoa.getId());

            st.executeUpdate();


            return true;
        } catch (Exception ex) {
            throw new Exception(Properties.getStringErroValue(Properties.ERRO_DELETAR_PESSOA));
        } finally {
            ConnectionFactory.closeConnection(connection, st);
        }

    }

    @Override
    public List<Pessoa> list() throws Exception {
        List<Pessoa> lista = new ArrayList<>();
        connection = ConnectionFactory.getConnection();

        PreparedStatement st = null;

        try {
            st = connection.prepareStatement("SELECT id, nome, nascimento, endereco FROM public.pessoa WHERE id=?");

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Pessoa pessoa = new Pessoa();

                pessoa.setId(rs.getInt("id"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setNascimento(rs.getDate("nascimento"));
                pessoa.setEndereco(DAOFactory.createEnderecoDAO().search(rs.getInt("enderreco")));

                lista.add(pessoa);
            }
            return lista;
        } catch (Exception ex) {
            throw new Exception(Properties.getStringErroValue(Properties.ERRO_LISTAR_PESSOA));
        } finally {
            ConnectionFactory.closeConnection(connection, st);
        }

        
    }

}
