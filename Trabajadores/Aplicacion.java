package Trabajadores;

import Trabajadores.model.Autonomo;
import Trabajadores.model.Empresa;

import java.util.Scanner;

public class Aplicacion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Empresa empresa = new Empresa();
        boolean salir = false;
        do {
            System.out.println("""
                MENU
                Selecciona una opción
                1.- Registrar o despedir un trabajador
                2.- Listar trabajadores
                3.- Mostrar datos
                4.- Salir""");
            int opcionmenu = sc.nextInt();
            switch (opcionmenu){
                case 1:
                    empresa.registrarTrabajador();
                    break;
                case 2:
                    empresa.listarTrabajadores();
                    break;
                case 3:
                    empresa.mostrarDatosTrabajadores();
                    break;
                case 4:
                    salir = true;
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }while(!salir);
    }
}