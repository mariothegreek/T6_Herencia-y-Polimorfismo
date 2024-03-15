package ListaMultimedia.model;

import java.util.Scanner;

public class Persona {

    Scanner sc = new Scanner(System.in);
    private String nombre, dni;

    public Persona() {
    }

    public Persona(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public void mostrarDatosPersona() {
        System.out.println("Nombre: " + nombre);
        System.out.println("DNI: " + dni);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

}