/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.model.dao;

import br.com.praticas.facade.BibliotecaFacadeLivro;
import br.com.praticas.facade.BibliotecaFacadePessoa;
import br.com.praticas.interfaces.IEmprestimoDAO;
import br.com.praticas.factory.ConnectionFactory;
import br.com.praticas.model.bean.Emprestimo;
import br.com.praticas.util.Util;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author VAAR
 */
public class EmprestimoDAO implements IEmprestimoDAO {
    private Connection connection;
    private BibliotecaFacadePessoa facadePessoa;
    private BibliotecaFacadeLivro facadeLivro;
    @Override
    public boolean create(Emprestimo emprestimo) {
        connection = ConnectionFactory.getConnection();
        PreparedStatement st = null;
        try {
            String sql = "INSERT INTO emprestimo(reserva,data,dataPrevista,entrega, idaluno, idlivro) VALUES (?,?,?,?,?,?)";
            st = connection.prepareStatement(sql);

            st.setBoolean(1, emprestimo.getReserva());
            st.setDate(2, Util.dateParaSql(emprestimo.getData()));            
            st.setDate(3, Util.dateParaSql(emprestimo.getDataPrevista()));
            st.setDate(4, Util.dateParaSql(emprestimo.getEntrega()));
            st.setInt(5, emprestimo.getAluno().getId());
            st.setInt(6, emprestimo.getLivro().getId());
            st.executeUpdate();

            return true;
        } catch (SQLException ex) {
            return false;
        } finally {
            ConnectionFactory.closeConnection(connection, st);
        }
    }

    @Override
    public boolean update(Emprestimo emprestimo) {
        connection = ConnectionFactory.getConnection();
        PreparedStatement st = null;
        try {
            String sql = "UPDATE emprestimo SET reserva=?, data=? ,dataPrevista=? ,entrega=?, idaluno = ?, idlivro = ? WHERE id=?;";
            st = connection.prepareStatement(sql);

            
            st.setBoolean(1, emprestimo.getReserva());
            st.setDate(2, Util.dateParaSql(emprestimo.getData()));   
            st.setDate(3, Util.dateParaSql(emprestimo.getDataPrevista()));
            st.setDate(4, Util.dateParaSql(emprestimo.getEntrega()));
            st.setInt(5, emprestimo.getAluno().getId());
            st.setInt(6, emprestimo.getLivro().getId());
            st.setInt(7, emprestimo.getId());
            
            st.executeUpdate();

            return true;
        } catch (SQLException ex) {
            return false;
        } finally {
            ConnectionFactory.closeConnection(connection, st);
        }
    }

    @Override
    public List<Emprestimo> list() {
        List<Emprestimo> lista = new ArrayList<>();

        connection = ConnectionFactory.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT id,reserva,data,dataPrevista,entrega,idaluno,idlivro FROM Emprestimo;";
            st = connection.prepareStatement(sql);

            rs = st.executeQuery();

            while (rs.next()) {
                Emprestimo emprestimo = new Emprestimo();

                int id = rs.getInt("id");
                boolean reserva = rs.getBoolean("reserva");
                Date data = rs.getDate("data");
                Date dataP = rs.getDate("dataPrevista");
                Date entrega = rs.getDate("entrega");
                int idAluno = rs.getInt("idaluno");
                int idLivro = rs.getInt("idlivro");
                
                emprestimo.setId(id);
                emprestimo.setReserva(reserva);
                emprestimo.setData(data);
                emprestimo.setDataPrevista(dataP);
                emprestimo.setEntrega(entrega);
                emprestimo.setAluno(facadePessoa.buscarAluno(idAluno));
                emprestimo.setLivro(facadeLivro.buscarLivro(idLivro));
                
                lista.add(emprestimo);
            }

        } catch (Exception ex) {
            //
        } finally {
            ConnectionFactory.closeConnection(connection, st, rs);
        }

        return lista;
    }

    @Override
    public Emprestimo search(int id) {
        Emprestimo emprestimo = null;

        connection = ConnectionFactory.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT id,reserva,data,dataPrevista,entrega,idaluno,idlivro FROM emprestimo WHERE id=?;";
            st = connection.prepareStatement(sql);

            st.setInt(1, id);

            rs = st.executeQuery();

            if (rs.next()) {
                emprestimo = new Emprestimo();

                boolean reserva = rs.getBoolean("reserva");
                Date data = rs.getDate("data");
                Date dataP = rs.getDate("dataPrevista");
                Date entrega = rs.getDate("entrega");
                int idAluno = rs.getInt("idaluno");
                int idLivro = rs.getInt("idlivro");
                
                emprestimo.setId(id);
                emprestimo.setReserva(reserva);
                emprestimo.setData(data);
                emprestimo.setDataPrevista(dataP);
                emprestimo.setEntrega(entrega);
                emprestimo.setAluno(facadePessoa.buscarAluno(idAluno));
                emprestimo.setLivro(facadeLivro.buscarLivro(idLivro));
            }
            return emprestimo;
        } catch (Exception ex) {
            return null;
        } finally {
            ConnectionFactory.closeConnection(connection, st, rs);
        }
    }

    @Override
    public boolean delete(Emprestimo emprestimo) {
        connection = ConnectionFactory.getConnection();

        PreparedStatement st = null;

        try {
            String sql = "DELETE FROM emprestimo WHERE id=?;";

            st = connection.prepareStatement(sql);

            st.setInt(1, emprestimo.getId());

            st.executeUpdate();


            return true;

        } catch (SQLException ex) {
            return false;
        } finally {
            ConnectionFactory.closeConnection(connection, st);
        }

    }

}
