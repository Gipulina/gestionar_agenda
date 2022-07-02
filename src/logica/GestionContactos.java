package logica;
import beans.Contacto;
import java.util.Collection;
import java.util.HashMap;

public class GestionContactos {
    // almaceno la información.
    HashMap<String, Contacto> agenda;

    public GestionContactos() {
        agenda = new HashMap<>();
    }

    public void agregar(String name, Integer edad, String email) {
        //si no existe, se añade
        if (!agenda.containsKey(email)) {
            Contacto c = new Contacto(name, email, edad);
            agenda.put(email, c);
        } else {
        }
    }

    public Contacto buscar(String email) {
        Contacto c = null;
        if (agenda.containsKey(email)) {
            c = agenda.get(email);
        }
        return c;
    }

    public Contacto[] eliminar(String email) {
        if (agenda.containsKey(email)) {
            agenda.remove(email);
            return true;
        } else {
            return false;
        }
        public Contacto[] recuperarContactos(){
            Contacto[] existentes = new Contacto[agenda.size()];
            Integer i = 0;
            Collection<Contacto> valores = agenda.values();
            for (Contacto con : valores) {
                existentes[i] = con;
                i++;
            }
            return existentes;

        }

    }

    public Contacto[] recuperarContacto() {
    }
}