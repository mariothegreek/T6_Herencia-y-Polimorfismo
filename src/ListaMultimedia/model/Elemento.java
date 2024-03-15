package ListaMultimedia.model;

import java.util.ArrayList;
import java.util.Scanner;

public class Elemento {
    Scanner sc = new Scanner(System.in);
    private int identificador;

    private String titulo, autor, formato, tamano;

    private ArrayList<Elemento> listaElementos;

    public Elemento() {
        listaElementos = new ArrayList<>();
    }

    //Método para mostrar todos los datos.
    public void mostrarDatos() {
        System.out.println("El tamaño es " + tamano);
        System.out.println("El identificador es " + identificador);
        System.out.println("El titulo es " + titulo);
        System.out.println("El autor es " + autor);
        System.out.println("El formato es " + formato);
    }

    //Método para rellenar detos comunes.
    public void rellenarDatos() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el identificador(solo números):");
        int nuevoId = sc.nextInt();
        sc.nextLine();
        for (Elemento item : listaElementos) {
            if (item.getIdentificador() == nuevoId) {
                System.out.println("identificador existe");
                return;
            }
        }
        if (listaElementos.isEmpty()) {
            System.out.println("La lista está vacía");
            this.identificador = nuevoId;
        }

        System.out.println("Introduce el autor");
        this.autor = sc.next();
        sc.nextLine();

        System.out.println("Introduce el título:");
        this.titulo = sc.nextLine();


        System.out.println("Introduce el tamaño:");
        this.tamano = sc.next();
        sc.nextLine();

        System.out.println("Introduce el formato:");
        this.formato = sc.nextLine();
    }

    /* Añadir a la colección (preguntará que tipo de objeto y los elementos correspondientes)
a. Los datos serán pedidos por consola
b. Una vez añadido el programa mostrará una confirmación de que el elemento
está bien añadido*/
    public void agregarElemento() {
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                ¿Qué elemento quieres añadir?
                1.-Libro
                2.-Video
                3.-Audio
                """);
        int opcionElemento = sc.nextInt();

        Elemento nuevoElemento;
        switch (opcionElemento) {
            case 1:
                nuevoElemento = new Libro();
                System.out.println("Que libro quieres añadir?");
                break;
            case 2:
                nuevoElemento = new Video();
                System.out.println("Que video quieres añadir?");
                break;
            case 3:
                nuevoElemento = new Audio();
                System.out.println("Que audio quieres añadir?");
                break;
            default:
                System.out.println("Operación no válida");
                return;
        }
        nuevoElemento.rellenarDatos();
        listaElementos.add(nuevoElemento);
        System.out.println("Elemento añadido correctamente");
        nuevoElemento.mostrarDatos();
    }

    /* Eliminar de la colección
a. Se pedirá el identificador del elemento a eliminar
b. Una vez eliminado el programa mostrará una confirmación de que el elemento
está bien eliminado*/
    public void eliminarElemento() {
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                ¿Qué elemento quieres eliminar?
                1.-Libro
                2.-Video
                3.-Audio
                """);
        int opcionEliminarElemento = sc.nextInt();
        System.out.println("Introduce el identificador del elemento");
        int opcionIdentificador = sc.nextInt();
        for (Elemento item : listaElementos) {
            if (opcionIdentificador == item.getIdentificador()) {
                System.out.println("Los identificadores coinciden, eliminando elemento...\nElemento eliminado\n");
                listaElementos.remove(item);
                break;
            }
        }
    }

    //Método para mostrar todos los elementos de la lista.
    public void mostrarListaElementos() {
        System.out.println("Los elementos de la colección son: ");
        for (Elemento item : listaElementos) {
            if (item instanceof Libro) {
                System.out.println("Libro:");
            } else if (item instanceof Video) {
                System.out.println("Video:");
            } else if (item instanceof Audio) {
                System.out.println("Audio:");
            }
            item.mostrarDatos();
            System.out.println();
        }
    }

    //Método para listar por elemento
    public void listarElementos() {
        System.out.println("""
                ¿Qué elementos quieres listar?
                1.- Libro
                2.- Video
                3.- Audio
                4.- Todos""");
        int opcionListar = sc.nextInt();
        switch (opcionListar) {

            case 1:
                for (Elemento item : listaElementos) {
                    if (item instanceof Libro) {
                        item.mostrarDatos();
                    }
                }
                break;
            case 2:
                System.out.println("Se listan los Videos");
                for (Elemento item : listaElementos) {
                    if (item instanceof Video) {
                        item.mostrarDatos();
                    }
                }
                break;
            case 3:
                System.out.println("Se listan los audios");
                for (Elemento item : listaElementos) {
                    if (item instanceof Audio) {
                        item.mostrarDatos();
                    }
                }
                break;
            case 4:
                System.out.println("Se lista todo");
                System.out.println("Los elementos de la colección son: ");
                for (Elemento item : listaElementos) {
                    item.mostrarDatos();
                    System.out.println();
                }
                break;
            default:
                System.out.println("Opción no vádi inténtalo de nuevo");
                return;
        }
    }

    //Buscar por autor: introduciré el nombre de un autor y me dirá el título de todos los libros que tenga
    public void buscarAutor() {
        if (listaElementos.isEmpty()) {
            System.out.println("La lista está vacía");
        } else {
            System.out.println("Introduce el autor");
            String nombreAutor = sc.next();
            for (Elemento item : listaElementos) {
                if (nombreAutor.equalsIgnoreCase(item.getAutor())) {
                    item.mostrarDatos();
                }
            }
        }
    }

    public void verificarId(int identificador) {
        for (Elemento item : listaElementos) {
            if (item.getIdentificador() == identificador) {
                System.out.println("Los id son iguales");
            }
        }
    }

    //GETTERS N SETTERS
    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public ArrayList<Elemento> getListaElementos() {
        return listaElementos;
    }

    public void setListaElementos(ArrayList<Elemento> listaElementos) {
        this.listaElementos = listaElementos;
    }
}