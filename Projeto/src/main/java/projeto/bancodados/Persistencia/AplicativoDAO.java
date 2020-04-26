package projeto.bancodados.Persistencia;

import projeto.bancodados.Entidades.Aplicativo;
import java.util.*;

public interface AplicativoDAO {
    boolean create (Aplicativo aplicativo);
    List<Aplicativo> read();
    boolean update (Aplicativo aplicativo);
    boolean delete (Aplicativo aplicativo);
}
