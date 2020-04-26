package projeto.bancodados.Persistencia;

import projeto.bancodados.Entidades.Carro;

import java.util.List;

public interface CarrosDAO {
    boolean create(Carro carro);
    List<Carro> read ();
    boolean update(Carro carro);
    boolean delete(Carro carro);
}
