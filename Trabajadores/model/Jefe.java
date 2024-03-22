package Trabajadores.model;


import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Scanner;

@Setter
@Getter
public class Jefe extends Trabajador {

    Scanner sc = new Scanner(System.in);
    private int beneficio, acciones;

    public Jefe() {
        this.beneficio = (int) (Math.random()*2000)+3000;
        this.acciones = (int) (Math.random()*10)+2;
    }
    @Override
    public void mostrarDatos() {
        System.out.println("Jefe:");
        super.mostrarDatos();
        System.out.println("Beneficio: "+beneficio);
        System.out.println("Acciones: "+acciones);
    }

    public Jefe(String nombre, String apellido, String dni, int beneficio, int acciones) {
        super(nombre, apellido, dni);
        this.beneficio = beneficio;
        this.acciones = acciones;
    }

    @Override
    public void rellenarDatos() {
        super.rellenarDatos();
    }

    public void despedirTrabajador(ArrayList<Trabajador> listaTrabajadores) {
        System.out.println("¿A qué trabajador vas a despedir?");
        String dniDespidoTrabajador = sc.next();
        boolean trabajadorEncontrado = false;
        for (Trabajador item : listaTrabajadores) {
            if ((item instanceof Asalariado || item instanceof Autonomo) && dniDespidoTrabajador.equalsIgnoreCase(item.getDni())) {
                trabajadorEncontrado= true;
                listaTrabajadores.remove(item);
                System.out.println("Despedirás al trabajador con datos:");
                item.mostrarDatos();
                System.out.println("Eliminando trabajador...");
                break;
            } else if (item instanceof Jefe && dniDespidoTrabajador.equalsIgnoreCase(item.getDni())) {
                System.out.println("No se puede despedir a un jefe");
                trabajadorEncontrado = true;
                break;
            }
        }
        if (!trabajadorEncontrado){
            System.out.println("No se encontró ningún trabajador con DNI: "+dniDespidoTrabajador);
        }
    }
}