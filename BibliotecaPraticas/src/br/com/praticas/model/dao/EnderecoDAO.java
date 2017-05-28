package br.com.praticas.model.dao;

import br.com.praticas.interfaces.IEnderecoDAO;
import br.com.praticas.factory.ConnectionFactory;
import br.com.praticas.model.bean.Endereco;
import br.com.praticas.util.Properties;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VAAR
 */
public class EnderecoDAO implements IEnderecoDAO {
    private Connection connection;
    
    @Override
    public int create(Endereco endereco) throws Exception {
        
        connection = ConnectionFactory.getConnection();
        
        PreparedStatement st = null;
        
        String sql = "INSERT INTO endereco (rua,numero,cidade) VALUES (?,?,?)";
        
        try {
            st = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            st.setString(1, endereco.getRua());
            st.setString(2, endereco.getNumero());
            st.setString(3, endereco.getCidade());
            
            st.executeUpdate();
            
            int idEndereco = 0;
            
            ResultSet rs = st.getGeneratedKeys();
            
            if (rs.next()) {
                idEndereco = rs.getInt(1);
            }
            return idEndereco;
        } catch (Exception e) {
            throw new Exception(Properties.getStringErroValue(Properties.ERRO_INSERIR_ENDERECO));
            //return -1;
        } finally {
            ConnectionFactory.closeConnection(connection, st);
        }
    }
    
    @Override
    public Endereco search(int id) throws Exception{
        Endereco endereco = null;
        connection = ConnectionFactory.getConnection();

        PreparedStatement st = null;

        try {
            st = connection.prepareStatement("SELECT id, rua, numero, cidade FROM public.endereco e WHERE id=?");
            
            st.setInt(1, id);
            
            ResultSet rs = st.executeQuery();

            if(rs.next()) {
                endereco = new Endereco();
                
                endereco.setId(id);
                endereco.setRua(rs.getString("rua"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setNumero("numero");
                
            }
        } catch (Exception ex) {
            throw new Exception(Properties.getStringErroValue(Properties.ERRO_BUSCAR_ENDERECO));
        } finally {
            ConnectionFactory.closeConnection(connection, st);
        }

        return endereco;
    }
    
    @Override
    public void update(Endereco endereco) throws Exception{
        connection = ConnectionFactory.getConnection();

        PreparedStatement st = null;

        try {
            st = connection.prepareStatement("UPDATE endereco SET rua = ?, numero = ?, cidade = ? WHERE id = ? ");

            st.setString(1, endereco.getRua());
            st.setString(2, endereco.getNumero());
            st.setString(3, endereco.getCidade());
            st.setInt(4, endereco.getId());

            st.executeUpdate();

            System.out.println(Properties.getStringErroValue(Properties.SUCESSO_EDITAR_ENDERECO));
        } catch (Exception ex) {
            throw new Exception(Properties.getStringErroValue(Properties.ERRO_EDITAR_ENDERECO));
        } finally {
            ConnectionFactory.closeConnection(connection, st);
        }
    }

    @Override
    public boolean delete(Endereco endereco) throws Exception{
        connection = ConnectionFactory.getConnection();
        
        PreparedStatement st = null;
        
        try {
            st = connection.prepareStatement("DELETE FROM endereco WHERE id = ?");
            
            st.setInt(1, endereco.getId());
            
            st.executeUpdate();
            
            System.out.println(Properties.getStringErroValue(Properties.SUCESSO_DELETAR_ENDERECO));
            
            return true;
        } catch (Exception ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            
            throw new Exception(Properties.getStringErroValue(Properties.ERRO_DELETAR_ENDERECO));
            
            //return false;
        }finally{
            ConnectionFactory.closeConnection(connection, st);
        }
        
    }
    
    @Override
    public List<Endereco> list() throws Exception{
        List<Endereco> lista = new ArrayList<>();
        connection = ConnectionFactory.getConnection();

        PreparedStatement st = null;

        try {
            st = connection.prepareStatement("SELECT id , rua, numero, cidade FROM public.endereco");

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Endereco endereco = new Endereco();
                
                endereco.setId(rs.getInt("id"));
                endereco.setRua(rs.getString("rua"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setNumero("numero");
                
                lista.add(endereco);
            }
        } catch (Exception ex) {
            throw new Exception(Properties.getStringErroValue(Properties.ERRO_LISTAR_ENDERECO));
        } finally {
            ConnectionFactory.closeConnection(connection, st);
        }

        return lista;
    }

}