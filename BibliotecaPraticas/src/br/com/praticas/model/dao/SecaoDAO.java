/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.model.dao;

import br.com.praticas.interfaces.ISecaoDAO;
import br.com.praticas.factory.ConnectionFactory;
import br.com.praticas.model.bean.Secao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author VAAR
 */
public class SecaoDAO implements ISecaoDAO {
    
    private Connection connection;

    @Override
    public int create(Secao secao) {
        connection = ConnectionFactory.getConnection();
        PreparedStatement st = null;
        String sql = "INSERT INTO secao(descricao) VALUES (?)";
        try {
            st = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            st.setString(1, secao.getDescricao());
            st.executeUpdate();

            int idSecao = 0;
            
            ResultSet rs = st.getGeneratedKeys();
            
            if (rs.next()) {
                idSecao = rs.getInt(1);
            }
            return idSecao;
        } catch (SQLException ex) {
            return -1;
        } finally {
            ConnectionFactory.closeConnection(connection, st);
        }
    }

    @Override
    public boolean update(Secao secao) {
        connection = ConnectionFactory.getConnection();
        PreparedStatement st = null;
        try {
            String sql = "UPDATE secao SET descricao=? WHERE id=?;";
            st = connection.prepareStatement(sql);

            st.setString(1, secao.getDescricao());
            st.setInt(2, secao .getId());

            st.executeUpdate();

            return true;
        } catch (SQLException ex) {
            return false;
        } finally {
            ConnectionFactory.closeConnection(connection, st);
        }
    }

    @Override
    public List<Secao> list() {
        List<Secao> lista = new ArrayList<>();

        connection = ConnectionFactory.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM secao;";
            st = connection.prepareStatement(sql);

            rs = st.executeQuery();

            while (rs.next()) {
                Secao secao = new Secao();

                int id = rs.getInt("id");
                String descricao = rs.getString("descricao");

                secao.setId(id);
                secao.setDescricao(descricao);

                lista.add(secao);
            }

        } catch (SQLException ex) {
            //
        } finally {
            ConnectionFactory.closeConnection(connection, st, rs);
        }

        return lista;
    }

    @Override
    public Secao search(int id) {
        Secao secao = null;

        connection = ConnectionFactory.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM secao WHERE id=?;";
            st = connection.prepareStatement(sql);

            st.setInt(1, id);

            rs = st.executeQuery();

            if (rs.next()) {
                secao = new Secao();

                String descriicao = rs.getString("descricao");

                secao.setId(id);
                secao.setDescricao(descriicao);
            }
            return secao;
        } catch (SQLException ex) {
            return null;
        } finally {
            ConnectionFactory.closeConnection(connection, st, rs);
        }
    }

    @Override
    public boolean delete(Secao secao) {
        connection = ConnectionFactory.getConnection();

        PreparedStatement st = null;

        try {
            String sql = "DELETE FROM secao WHERE id=?;";

            st = connection.prepareStatement(sql);

            st.setInt(1, secao.getId());

            st.executeUpdate();


            return true;

        } catch (SQLException ex) {
            return false;
        } finally {
            ConnectionFactory.closeConnection(connection, st);
        }

    }

}
