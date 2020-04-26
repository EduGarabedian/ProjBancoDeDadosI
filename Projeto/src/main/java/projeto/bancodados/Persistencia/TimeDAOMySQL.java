package projeto.bancodados.Persistencia;
import projeto.bancodados.Entidades.Time;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TimeDAOMySQL  implements TimeDAO{
    private String createSQL = "INSERT INTO Time VALUES(?,?,?,?,?)";
    private String readSQL = "SELECT * FROM Time";
    private String updateSQL = "UPDATE ";
    private String deleteSQL = "DELETE FROM Time WHERE id_time =?";


    private final MySQLConnection mysql = new MySQLConnection();

    @Override
    public boolean create(Time time){
        Connection conexao = mysql.getConnection();
        try{
            PreparedStatement stm = conexao.prepareStatement(createSQL);

            stm.setString(1, time.getIdTime());
            stm.setString(2, time.getNome());
            stm.setInt(3, time.getAnoFund());
            stm.setString(4, time.getCidade());
            stm.setString(5, time.getEstado());

            int registros = stm.executeUpdate();
            return registros >0 ? true:false;
        }
        catch(final SQLException ex){
            System.out.println("Falha de conexão com a base de dados");
            ex.printStackTrace();
        }
        catch(final Exception ex){
            ex.printStackTrace();
        }
        finally{
            try{
                conexao.close();
            }
            catch(final Exception ex){
                ex.printStackTrace();
            }
        }
        return false;
    }



    @Override
    public List<Time> read() {
        Connection conexao = mysql.getConnection();
        List<Time> time = new ArrayList();

        try {
            PreparedStatement stm = conexao.prepareStatement(readSQL);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Time time1 = new Time();
                time1.setIdTime(rs.getString("id_time"));
                time1.setNome(rs.getString("nome"));
                time1.setAnoFund(rs.getInt("anoFund"));
                time1.setCidade(rs.getString("curso"));
                time1.setEstado(rs.getString("estado"));
            }

            return time;

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
        return time;
    }



    @Override
    public boolean update(Time time) {
        Connection conexao = mysql.getConnection();
        try {
            PreparedStatement stm = conexao.prepareStatement(updateSQL);

            stm.setString(1, time.getIdTime());
            stm.setString(2, time.getNome());
            stm.setInt(3, time.getAnoFund());
            stm.setString(4, time.getCidade());
            stm.setString(5, time.getEstado());

            int registros = stm.executeUpdate();


            return  registros > 0 ? true : false;

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
        return false;
    }



    @Override
    public boolean delete(Time time) {
        Connection conexao = mysql.getConnection();
        try{
            PreparedStatement stm = conexao.prepareStatement(deleteSQL);


            stm.setString(1, time.getIdTime());
            stm.setString(2, time.getNome());
            stm.setInt(3, time.getAnoFund());
            stm.setString(4, time.getCidade());
            stm.setString(5, time.getEstado());

            int registros = stm.executeUpdate();

            return registros > 0;
        } catch (final SQLException ex){
            System.out.println("Falha de conexao com a base de dados");
            ex.printStackTrace();
        } catch (final Exception ex){
            ex.printStackTrace();
        } finally{
            try{
                conexao.close();
            } catch (final Exception ex){
                ex.printStackTrace();
            }
        }
        return false;
    }
}
