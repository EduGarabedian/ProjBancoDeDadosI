package projeto.bancodados.Persistencia;

import projeto.bancodados.Entidades.Aplicativo;

import java.sql.*;
import java.util.*;

public class AplicativoDAOMySQL implements AplicaticoDAO{
    private String createSQL = "INSERT INTO Aplicativo VALUES (?,?,?,?)";
    private String readSQL = "SELECT * FROM Aplicativo";
    private String updateSQL = "UPDATE Aplicativo SET id=?, nome=?, desenvolvedor=?, numeroDownloads=? WHERE id=?";
    private String deleteSQL = "DELETE FROM Aplicativo id=?";

    private final MySQLConnection mysql = new MySQLConnection();

    @Override
    public boolean create(Aplicativo aplicativo) {
        Connection conexao = mysql.getConnection();
        try {
            PreparedStatement statement = conexao.prepareStatement(createSQL);

            statement.setString(1, aplicativo.getId());
            statement.setString(2, aplicativo.getNome());
            statement.setString(3, aplicativo.getDesenvolvedor());
            statement.setInt(4, aplicativo.getNumeroDownloads());

            int registros = statement.executeUpdate();

            return registros > 0 ? true : false;
        } catch (final SQLException ex) {
            System.out.println("Falha de conexão com base de dados!");
            ex.printStackTrace();
        } catch (final Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                conexao.close();
            } catch (final Exception ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public List<Aplicativo> read() {
        Connection conexao = mysql.getConnection();
        List<Aplicativo> aplicativos = new ArrayList();

        try {
            PreparedStatement statement = conexao.prepareStatement(readSQL);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Aplicativo aplicativo = new Aplicativo();
                aplicativo.setId(rs.getString("id"));
                aplicativo.setNome(rs.getString("nome"));
                aplicativo.setDesenvolvedor(rs.getString("desenvolvedor"));
                aplicativo.setNumeroDownloads(rs.getInt("numeroDownloads"));
                aplicativos.add(aplicativo);
            }
            return aplicativos;
        } catch (final SQLException ex) {
            System.out.println("Falha de conexão com a base de dados!");
            ex.printStackTrace();
        } catch (final Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                conexao.close();
            } catch (final Exception ex) {
                ex.printStackTrace();
            }
        }
        return aplicativos;
    }

    @Override
    public boolean update(Aplicativo aplicativo) {
        Connection conexao= mysql.getConnection();
        try{
            PreparedStatement statement= conexao.prepareStatement(updateSQL);

            statement.setString(1,aplicativo.getId());
            statement.setString(2,aplicativo.getNome());
            statement.setString(3,aplicativo.getDesenvolvedor());
            statement.setInt(3,aplicativo.getNumeroDownloads());

            int registros= statement.executeUpdate();

            return registros>0 ? true:false;
        }catch (final SQLException ex){
            System.out.println("Falha de conexão com a base de dados!");
            ex.printStackTrace();
        }catch (final Exception ex){
            ex.printStackTrace();
        }finally{
            try{
                conexao.close();
            }catch (final Exception ex){
                ex.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean delete(Aplicativo aplicativo) {
        Connection conexao = mysql.getConnection();
        try {
            PreparedStatement statement = conexao.prepareStatement(deleteSQL);


            statement.setString(1, aplicativo.getId());

            int registros = statement.executeUpdate();

            return registros > 0;
        } catch (final SQLException ex) {
            System.out.println("Falha de conexao com a base de dados");
            ex.printStackTrace();
        } catch (final Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                conexao.close();
            } catch (final Exception ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }
}
