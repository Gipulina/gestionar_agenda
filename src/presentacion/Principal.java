package presentacion;
import beans.Contacto;
import logica.GestionContactos;
import javax.sql.rowset.serial.SQLOutputImpl;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        GestionContactos gestor =new GestionContactos();
        Scanner sc= new Scanner(System.in);
        Integer op, edad;
        String nombre, email;

        do{
            System.out.println("1.- Anadir contacto");
            System.out.println("2.- Buscar Contacto");
            System.out.println("3.- Eliminar Contacto");
            System.out.println("4.- Mostrar todos");
            System.out.println("5.- Salir");
            op = Integer.parseInt(sc.nextLine());
            switch (op){
                case 1:
                    System.out.println("Nombre: ");
                    nombre = sc.nextLine();
                    System.out.println("Edad: ");
                    edad=Integer.parseInt(sc.nextLine());
                    System.out.println("Email: ");
                    email = sc.nextLine();
                    gestor.agregar(nombre, edad, email);
                    break;
                case 2:
                    System.out.println("Email: ");
                    email=sc.nextLine();
                    Contacto c = gestor.buscar(email);
                    if(c==null){
                        System.out.println("No se encontró el contacto");
                    }else {
                        System.out.println(c.getNombre()+"-"+c.getEmail()+"-"+c.getEdad());
                    }
                    break;
                case 4:
                    Contacto[] todos = gestor.recuperarContacto();
                    for(Contacto con:todos){
                        System.out.println(con.getNombre()+"-"+con.getEmail()+"-"+con.getEdad());
                    }
                    break;
                case 5: break;
                default:
                    System.out.println("debes escribir una opción válida");

            }
        }while(op!=5);

    }
}
