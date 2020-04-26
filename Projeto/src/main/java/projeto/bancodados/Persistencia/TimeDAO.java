package projeto.bancodados.Persistencia;
import projeto.bancodados.Entidades.Time;

import java.util.List;

public interface TimeDAO {
    boolean create(Time time);
    List<Time> read();
    boolean update(Time time);
    boolean delete(Time time);


}
