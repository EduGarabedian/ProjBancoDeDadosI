package projeto.bancodados.Persistencia;

import projeto.bancodados.Entidades.Carro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarroDAOMySQL implements CarrosDAO {
    private String createSQL = "INSERT INTO carros VALUES (?, ?, ?, ?, ?)";
    private String readSQL = "SELECT * FROM carros";
    private String updateSQL = "UPDATE carros SET modelo=?, marca=?, ano=?, categoria=? WHERE id=?";
    private String deleteSQL = "DELETE FROM carros WHERE id=?";

    private final MySQLConnection mysql = new MySQLConnection();

    @Override
    public boolean create(Carro carro) {
        Connection conexao = mysql.getConnection();
        try{
            PreparedStatement stm = conexao.prepareStatement(createSQL);

            stm.setString(1, carro.getId());
            stm.setString(2, carro.getModelo());
            stm.setString(3, carro.getMarca());
            stm.setString(4, carro.getAno());
            stm.setString(5, carro.getCategoria());


            int registros = stm.executeUpdate();

            return registros > 0;

        } catch (final SQLException ex){
            System.out.println("Falha de conexão com a base de dados");
            ex.printStackTrace();
        } catch (final Exception ex){
            ex.printStackTrace();
        } finally {
            try{
                conexao.close();
            } catch (final  Exception ex){
                ex.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public List<Carro> read() {
        Connection conexao = mysql.getConnection();
        List<Carro> carros = new ArrayList<>();

        try {
            PreparedStatement stm = conexao.prepareStatement(readSQL);
            ResultSet rs = stm.executeQuery();

            while (rs.next()){
                Carro carro1 = new Carro();
                carro1.setId(rs.getString("id"));
                carro1.setModelo(rs.getString("modelo"));
                carro1.setMarca(rs.getString("marca"));
                carro1.setAno(rs.getString("ano"));
                carro1.setCategoria(rs.getString("categoria"));
                carros.add(carro1);
            }

            return carros;
        } catch (final SQLException ex){
            System.out.println("Falha de conexao com a base de dados");
            ex.printStackTrace();
        } catch (final Exception ex){
            ex.printStackTrace();
        } finally {
            try{
                conexao.close();
            } catch (final Exception ex){
                ex.printStackTrace();
            }
        }
        return carros;
    }

    @Override
    public boolean update(Carro carro) {
        Connection conexao = mysql.getConnection();
        try {
            PreparedStatement stm = conexao.prepareStatement(updateSQL);

            //Inicializando os valores
            // cuidado com a ordem, eh diferente do insert
            stm.setString(1, carro.getModelo());
            stm.setString(2, carro.getMarca());
            stm.setString(3, carro.getAno());
            stm.setString(4, carro.getCategoria());
            stm.setString(5, carro.getId());

            int registros = stm.executeUpdate();

            // Se a quantidade de registros modificados
            // forem maiores que 1, significa que os dados
            // foram inserido corretamente
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
    public boolean delete(Carro carros) {
        Connection conexao = mysql.getConnection();
        try{
            PreparedStatement stm = conexao.prepareStatement(deleteSQL);


            stm.setString(1, carros.getId());

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
