package ListaMultimedia;

import ListaMultimedia.model.Elemento;
import ListaMultimedia.model.Persona;

import java.util.Scanner;

public class Aplicacion {
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Elemento elemento = new Elemento();
        Persona persona = new Persona();

        boolean salir = false;
        do {
            System.out.println("""
                    1.- Añadir a la colección
                    2.- Eliminar de la colección
                    3.- Listar elementos
                    4.- Buscar por autor
                    5.- Buscar por actor
                    6.- Buscar por director
                    7.- Salir
                    """);
            int opcionMenu = sc.nextInt();
            switch (opcionMenu) {
                case 1: //Añadir un elemento a la lista
                    elemento.agregarElemento();
                    break;
                case 2: //Eliminar un elemento de la lista
                    elemento.eliminarElemento();
                    break;
                case 3: //Ver los elementos por categorías
                    elemento.listarElementos();
                    break;
                case 4: //Buscar por autor
                    elemento.buscarAutor();
                    break;
                case 5: //Buscar por actor

                    break;
                case 6: //Buscar por director

                    break;
                case 7://Salir del menú
                    salir = true;
                    break;
            }
        } while (!salir);
    }
}