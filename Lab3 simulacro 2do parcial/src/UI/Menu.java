package UI;

import Contenedores.Repositorio;
import Modelo.ContenidoAV;
import Modelo.Libro;
import Modelo.Novela;

import java.util.Scanner;

public class Menu {
    Repositorio repositorio = new Repositorio();
    Scanner scanner = new Scanner(System.in);
    private int continuar;
    private int seleccion;

    public Menu() {
        continuar = 1;
        seleccion = 0;
    }

    public void inicializar() {
        while ( continuar == 1 ) {
            mostrarMenu();
            seleccionarOpcion();
            switch ( seleccion ) {
                case 1:
                    crearAlgunosContenidos();
                    break;
                case 2:
                    agregarUnLibro();
                    break;
                case 3:
                    agregarUnaNovela();
                    break;
                case 4:
                    mostrarTodo();
                    break;
                case 5:
                    modificarContenido();
                    break;
                case 0:
                    continuar = 0;
                    break;
                default:
                    System.out.println("La opcion ingresada no se encuentra en el menu.");
                    break;
            }
        }
        System.out.println("\nSaliendo del programa...");
    }

    private void crearAlgunosContenidos() {
        repositorio.agregar(new Libro(
                "l1",
                "libro uno",
                "autor numero 1",
                "1948"
        ));
        repositorio.agregar(new Libro(
                "l2",
                "libro dos",
                "autor numero dos",
                "2004"
        ));
        repositorio.agregar(new Novela(
                "n1",
                "novela uno",
                "autora numero 1",
                "1998"
        ));
        repositorio.agregar(new Novela(
                "n2",
                "novela dos",
                "autora numero 2",
                "2020"
        ));
    }

    private void mostrarMenu() {
        System.out.println("MENU");
        System.out.println(" 1. Agregar algunos contenidos");
        System.out.println(" 2. Agregar un libro");
        System.out.println(" 3. Agregar una novela");
        System.out.println(" 4. Mostrar Todo");
        System.out.println(" 5. Modificar contenido");
        System.out.println(" 0. salir");
    }

    private void seleccionarOpcion() {
        System.out.println("Seleccione una opcion del menu: ");
        seleccion = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
    }

    private void agregarUnLibro() {
        System.out.println("Ingrese un id para el libro");
        String id = scanner.nextLine();
        System.out.println();
        System.out.println("Ingrese un titulo para el libro");
        String titulo = scanner.nextLine();
        System.out.println();
        System.out.println("Ingrese un autor para el libro");
        String autor = scanner.nextLine();
        System.out.println();
        System.out.println("Ingrese una fecha para el libro");
        String fecha = scanner.nextLine();
        System.out.println();
        ContenidoAV contenido = new Libro(
                id,
                titulo,
                autor,
                fecha
        );
        repositorio.agregar(contenido);
    }


    private void agregarUnaNovela() {
        System.out.println("Ingrese un id para el libro");
        String id = scanner.nextLine();
        System.out.println();
        System.out.println("Ingrese un titulo para el libro");
        String titulo = scanner.nextLine();
        System.out.println();
        System.out.println("Ingrese un autor para el libro");
        String autor = scanner.nextLine();
        System.out.println();
        System.out.println("Ingrese una fecha para el libro");
        String fecha = scanner.nextLine();
        System.out.println();
        ContenidoAV contenido = new Novela(
                id,
                titulo,
                autor,
                fecha
        );
        repositorio.agregar(contenido);
        System.out.println(contenido);
        System.out.println("Contenido agregado con exito :D");
    }

    private void mostrarTodo() {
        repositorio.mostrarTodo();
    }

    private void modificarContenido() {
        System.out.println("Ingrese el id del contenido que desea modificar: ");
        String id = scanner.nextLine();

        if( repositorio.leer(id) == null )
            System.out.println("El contenido no se encuentra en la biblioteca");
        else {
            ContenidoAV contenidoAModificar = repositorio.leer(id);
            System.out.println("Ingrese el nuevo titulo del contenido: ");
            String titulo = scanner.nextLine();
            contenidoAModificar.setTitulo(titulo);
            System.out.println("Ingrese el nuevo autor del contenido: ");
            String autor = scanner.nextLine();
            contenidoAModificar.setTitulo(autor);
            System.out.println("Ingrese la nueva fecha del contenido: ");
            String fecha = scanner.nextLine();
            contenidoAModificar.setTitulo(fecha);
            repositorio.agregar(contenidoAModificar);
        }
    }


}
