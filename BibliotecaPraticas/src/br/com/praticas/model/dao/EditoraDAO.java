/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.model.dao;

import br.com.praticas.interfaces.IEditoraDAO;
import br.com.praticas.factory.ConnectionFactory;
import br.com.praticas.model.bean.Editora;
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
public class EditoraDAO implements IEditoraDAO {
    private Connection connection;

    @Override
    public int create(Editora editora) {
        connection = ConnectionFactory.getConnection();
        PreparedStatement st = null;
        
        String sql = "INSERT INTO editora(nome) VALUES (?)";
        
        try {
            st = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            st.setString(1, editora.getNome());
            st.executeUpdate();

            int idEditora = 0;
            
            ResultSet rs = st.getGeneratedKeys();
            
            if (rs.next()) {
                idEditora = rs.getInt(1);
            }
            return idEditora;
        } catch (SQLException ex) {
            return -1;
        } finally {
            ConnectionFactory.closeConnection(connection, st);
        }
    }

    @Override
    public boolean update(Editora editora) {
        connection = ConnectionFactory.getConnection();
        PreparedStatement st = null;
        try {
            String sql = "UPDATE editora SET nome=? WHERE id=?;";
            st = connection.prepareStatement(sql);

            st.setString(1, editora.getNome());
            st.setInt(2, editora.getId());

            st.executeUpdate();

            return true;
        } catch (SQLException ex) {
            return false;
        } finally {
            ConnectionFactory.closeConnection(connection, st);
        }
    }

    @Override
    public List<Editora> list() {
        List<Editora> lista = new ArrayList<>();

        connection = ConnectionFactory.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM editora;";
            st = connection.prepareStatement(sql);

            rs = st.executeQuery();

            while (rs.next()) {
                Editora editora = new Editora();

                int id = rs.getInt("id");
                String nome = rs.getString("Nome");

                editora.setId(id);
                editora.setNome(nome);

                lista.add(editora);
            }

        } catch (SQLException ex) {
            //
        } finally {
            ConnectionFactory.closeConnection(connection, st, rs);
        }

        return lista;
    }

    @Override
    public Editora search(int id) {
        Editora editora = null;

        connection = ConnectionFactory.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM editora WHERE id=?;";
            st = connection.prepareStatement(sql);

            st.setInt(1, id);

            rs = st.executeQuery();

            if (rs.next()) {
                editora = new Editora();

                String nome = rs.getString("nome");

                editora.setId(id);
                editora.setNome(nome);
            }
            return editora;
        } catch (SQLException ex) {
            return null;
        } finally {
            ConnectionFactory.closeConnection(connection, st, rs);
        }
    }

    @Override
    public boolean delete(Editora editora) {
        connection = ConnectionFactory.getConnection();

        PreparedStatement st = null;

        try {
            String sql = "DELETE FROM editora WHERE id=?;";

            st = connection.prepareStatement(sql);

            st.setInt(1, editora.getId());

            st.executeUpdate();


            return true;

        } catch (SQLException ex) {
            return false;
        } finally {
            ConnectionFactory.closeConnection(connection, st);
        }

    }

}
