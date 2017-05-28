/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.model.dao;

import br.com.praticas.interfaces.IAutorDAO;
import br.com.praticas.factory.ConnectionFactory;
import br.com.praticas.model.bean.Autor;
import br.com.praticas.util.Properties;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JoséHigor
 */
public class AutorDAO implements IAutorDAO {

    private Connection connection;

    public int create(Autor a) {
        connection = ConnectionFactory.getConnection();
        PreparedStatement st = null;
        try {
            String sql = "INSERT INTO autor(nome) VALUES (?)";
            st = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            st.setString(1, a.getNome());
            st.executeUpdate();

            int idAutor = 0;
            
            ResultSet rs = st.getGeneratedKeys();
            
            if (rs.next()) {
                idAutor = rs.getInt(1);
            }
            return idAutor;
        } catch (SQLException ex) {
            System.out.println(Properties.getStringErroValue(Properties.ERRO_INSERIR_AUTOR));
            return -1;
        } finally {
            ConnectionFactory.closeConnection(connection, st);
        }
    }

    public boolean update(Autor a) {
        connection = ConnectionFactory.getConnection();
        PreparedStatement st = null;
        try {
            String sql = "UPDATE Autor SET nome=? WHERE id=?;";
            st = connection.prepareStatement(sql);

            st.setString(1, a.getNome());
            st.setInt(2, a.getId());

            st.executeUpdate();

            return true;
        } catch (SQLException ex) {
            System.out.println(Properties.getStringErroValue(Properties.ERRO_EDITAR_AUTOR));
            return false;
        } finally {
            ConnectionFactory.closeConnection(connection, st);
        }
    }

    public List<Autor> list() {
        List<Autor> lista = new ArrayList<Autor>();

        connection = ConnectionFactory.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM autor;";
            st = connection.prepareStatement(sql);

            rs = st.executeQuery();

            while (rs.next()) {
                Autor a = new Autor();

                int id = rs.getInt("id");
                String nome = rs.getString("Nome");

                a.setId(id);
                a.setNome(nome);

                lista.add(a);
            }

        } catch (SQLException ex) {
            System.out.println(Properties.getStringErroValue(Properties.ERRO_LISTAR_AUTOR));
        } finally {
            ConnectionFactory.closeConnection(connection, st, rs);
        }

        return lista;
    }

    public Autor search(int id) {
        Autor a = null;

        connection = ConnectionFactory.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM autor WHERE id=?;";
            st = connection.prepareStatement(sql);

            st.setInt(1, id);

            rs = st.executeQuery();

            if (rs.next()) {
                a = new Autor();

                String nome = rs.getString("nome");

                a.setId(id);
                a.setNome(nome);
            }
            return a;
        } catch (SQLException ex) {
            System.out.println(Properties.getStringErroValue(Properties.ERRO_BUSCAR_AUTOR));
            return null;
        } finally {
            ConnectionFactory.closeConnection(connection, st, rs);
        }
    }

    public boolean delete(Autor a) {
        connection = ConnectionFactory.getConnection();

        PreparedStatement st = null;

        try {
            String sql = "DELETE FROM autor WHERE id=?;";

            st = connection.prepareStatement(sql);

            st.setInt(1, a.getId());

            st.executeUpdate();

            System.out.println(Properties.getStringErroValue(Properties.SUCESSO_DELETAR_AUTOR));

            return true;

        } catch (SQLException ex) {
            System.out.println(Properties.getStringErroValue(Properties.ERRO_DELETAR_AUTOR));
            return false;
        } finally {
            ConnectionFactory.closeConnection(connection, st);
        }

    }

}
