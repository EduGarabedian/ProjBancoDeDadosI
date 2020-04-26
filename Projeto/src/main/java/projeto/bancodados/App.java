package projeto.bancodados;

import projeto.bancodados.Persistencia.AplicativoDAOMySQL;
import projeto.bancodados.Persistencia.CarroDAOMySQL;
import projeto.bancodados.Persistencia.InterfaceUsuario;
import projeto.bancodados.Persistencia.TimeDAOMySQL;

public class App
{
    public static void main(final String[] args) {
        CarroDAOMySQL DAOMySQL1 = new CarroDAOMySQL();
        AplicativoDAOMySQL DAOMySQL2 = new AplicativoDAOMySQL();
        TimeDAOMySQL DAOMySQL3 = new TimeDAOMySQL();
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario(DAOMySQL1, DAOMySQL2, DAOMySQL3);
        interfaceUsuario.Iniciar();
    }
}
