package Trabajadores.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Autonomo extends Trabajador {

    private boolean contratado;

    private int sueldo;

    public Autonomo() {
        this.sueldo = (int) (Math.random()*1000)+1500;
        this.contratado = true;
    }

    public Autonomo(String nombre, String apellido, String dni, boolean contratado, int sueldo) {
        super(nombre, apellido, dni);
        this.contratado = contratado;
        this.sueldo = sueldo;
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Autónomo:");
        super.mostrarDatos();
        System.out.println("Contratado: " + contratado);
        System.out.println("Salario anual: "+sueldo*12);
    }
}