package Trabajadores.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

@Getter
@Setter
public class Trabajador {

    Scanner sc = new Scanner(System.in);
    private String nombre, apellido, dni;

    public Trabajador() {
    }

    public Trabajador(String nombre, String apellido, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    //Método para mostrar los datos de un trabajador.
    public void mostrarDatos(){
        System.out.println("Nombre: "+nombre);
        System.out.println("Apellidos: "+apellido);
        System.out.println("DNI: "+dni);
    }

    //Método para rellenar los datos de un trabajador.
    public void rellenarDatos() {
        System.out.println("Introduce nombre:");
         this.nombre = sc.next();
        System.out.println("Introduce apellido:");
         this.apellido = sc.next();
        System.out.println("Introduce DNI");
        this.dni = sc.next();
    }

}