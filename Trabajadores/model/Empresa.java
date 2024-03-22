package Trabajadores.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Scanner;

@Getter
@Setter
public class Empresa {
    Scanner sc = new Scanner(System.in);

    private ArrayList<Trabajador> listaTrabajadores;

    public Empresa() {
        listaTrabajadores = new ArrayList<>();
    }

    public void registrarTrabajador() {
        boolean salir = false;
        boolean opcionValida= false;
        do {
            System.out.println("""
                    ¿Qué acción deseas realizar?
                    1.- Registrar trabajador
                    2.- Despedir trabajador
                    3.- Volver""");
            int opcionAccion = sc.nextInt();
            if (opcionAccion == 2) {
                boolean despedirDeNuevo = false;
                do {
                    despedirDeNuevo = false;
                    for (Trabajador item : listaTrabajadores) {
                        if (item instanceof Jefe) {
                            ((Jefe) item).despedirTrabajador(listaTrabajadores);
                        }
                    }
                    System.out.println("""
                            ¿Deseas despedir otro trabajador?
                            1.- SI
                            2.- NO""");
                    int continuarDespidos = sc.nextInt();
                    if (continuarDespidos == 1) {
                        despedirDeNuevo = true;
                    }
                }while (despedirDeNuevo);
            }else if(opcionAccion == 1){

                boolean jefeRegistrado;
                do {
                System.out.println("""
                    ¿Qué trabajador deseas registrar?
                    1.- Jefe
                    2.- Asalariado
                    3.- Autónomo
                    4.- Salir""");
                int opcionTrabajador = sc.nextInt();
                switch (opcionTrabajador) {
                    case 1:
                            Jefe jefe = new Jefe();
                            jefe.rellenarDatos();
                            comprobarTrabajador(jefe);
                            jefeRegistrado = true;
                        break;
                    case 2:
                        Asalariado asalariado = new Asalariado();
                        asalariado.rellenarDatos();
                        comprobarTrabajador(asalariado);
                        break;
                    case 3:
                        Autonomo autonomo = new Autonomo();
                        autonomo.rellenarDatos();
                        comprobarTrabajador(autonomo);
                    case 4:
                        salir = true;
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción no válida");
                }
            /*Si elige salir no se ejecuta este código, si lo elige le da la opción de registrar
            otro trabajador seguidamente sin necesidad de volver al menú*/
                        System.out.println("""
            ¿Deseas registrar o despedir otro trabajador?
            1.- SI
            2.- NO""");
                        int opcionContinuarRegistro = sc.nextInt();
                        if (opcionContinuarRegistro == 1){
                            opcionValida = true;
                        } else if (opcionContinuarRegistro == 2) {
                            opcionValida = true;
                            salir = true;
                        }else {
                            System.out.println("Elige una opción válida");
                        }
                }while (!opcionValida);
            }else {
                salir = true;
            }
        } while (!salir);
    }

    //Método para comprobar si el trabajador ya está en la lista.
    public void comprobarTrabajador(Trabajador trabajador) {
        boolean estaTrabajador = false;

        for (Trabajador item : listaTrabajadores) {
            //Comprobación para ver si coincide el nombre por parámetros con el introducido por Scanner
            if (trabajador.getDni().equalsIgnoreCase(item.getDni())) {
                System.out.println("El trabajador con DNI " + trabajador.getDni() + " ya está en la lista");
                estaTrabajador = true;
                break;
            }
        }
        //Si no coincide lo agrega a la lista de trabajadores.
        if (!estaTrabajador) {
            System.out.println("Se ha añadido el trabajador");
            trabajador.mostrarDatos();
            listaTrabajadores.add(trabajador);
        }
    }

    //Método para listar los trabajadores por categoría.
    public void listarTrabajadores() {
        System.out.println("""
                ¿Qué categoría de trabajadores quieres listar?
                1.- Asalariado
                2.- Autónomo
                3.- Jefe
                4.- Todos""");
        int opcionCategoria = sc.nextInt();
        switch (opcionCategoria) {
            case 1:
                System.out.println("Se mostrarán todos los asalariados de la empresa");
                for (Trabajador item : listaTrabajadores) {
                    if (item instanceof Asalariado) {
                        System.out.println("- " + item.getNombre());
                    }
                }
                break;
            case 2:
                System.out.println("Se mostrarán todos los autónomos de la empresa");
                for (Trabajador item : listaTrabajadores) {
                    if (item instanceof Autonomo) {
                        System.out.println(item.getNombre());
                    }
                }
                break;
            case 3:
                System.out.println("Se mostrarán todos los jefes de la empresa");
                for (Trabajador item : listaTrabajadores) {
                    if (item instanceof Jefe) {
                        System.out.println(item.getNombre());
                    }
                }
                break;
            case 4:
                System.out.println("Se mostrarán todos los trabajadores");
                for (Trabajador item : listaTrabajadores) {
                    item.mostrarDatos();
                    System.out.println();
                }
                break;
            default:
                System.out.println("Opción no válida");
        }
    }

    //Método para mostrar los datos del trabajador pedido por teclado según su DNI.
    public void mostrarDatosTrabajadores(){
        boolean trabajadorEncontrado = false;
        System.out.println("Introduce DNI del trabajador");
        String dni = sc.next();
        for (Trabajador item : listaTrabajadores){
            if (dni.equalsIgnoreCase(item.getDni())){
                trabajadorEncontrado = true;
                item.mostrarDatos();
            }
        }
        if (!trabajadorEncontrado){
            System.out.println("No existe ningún trabajador que coincida con el DNI: "+dni);
        }
    }
}