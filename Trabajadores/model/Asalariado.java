package Trabajadores.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Asalariado extends Trabajador {

    private boolean contratado;

    private int sueldo, numeroPagas;

    public Asalariado(String nombre, String apellido, String dni, boolean contratado, int sueldo, int numeroPagas) {
        super(nombre, apellido, dni);
        this.contratado = contratado;
        this.sueldo =sueldo;
        this.numeroPagas = numeroPagas;
    }

    public Asalariado() {
        this.numeroPagas = (int) (Math.random()*3)+12;
        this.sueldo = (int) (Math.random()*1000)+700;
        this.contratado = true;
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Asalariado:");
        super.mostrarDatos();
        System.out.println("Contratado: " + contratado);
        System.out.println("Salario mensual: " + sueldo);
        System.out.println("Numero de pagas: " + numeroPagas);
        System.out.println("Salario anual: "+sueldo*numeroPagas);
    }
}