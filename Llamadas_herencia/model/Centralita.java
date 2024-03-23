package Llamadas_herencia.model;

import Llamadas_herencia.Utils.ScannerUtils;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Scanner;

@Getter
@Setter
public class Centralita {

    private ArrayList<Llamada>listaLlamadas;

    private Scanner sc = ScannerUtils.getSc();

    public Centralita() {
        listaLlamadas = new ArrayList<>();
    }

    public Centralita(ArrayList<Llamada> listaLlamadas) {
        this.listaLlamadas = listaLlamadas;
    }

    public void registrarLlamada(Llamada llamada){
        listaLlamadas.add(llamada);
        System.out.println("La llamada ha quedado registrada");
    }

    public void hacerLlamada(){
        System.out.println("""
                ¿Qué tipo de llamada desea realizar?
                1.- Llamada local
                2.- Llamada Provincial
                3.- Llamada Nacional""");
        int opcionllamada = sc.nextInt();

        switch (opcionllamada) {
            case 1:
                System.out.println("Que duración tendrá tu llamada?");
                int duracionllamadaLocal = sc.nextInt();
                Llamada llamadaLocal = new LlamadaLocal(1,2,0,duracionllamadaLocal);
                llamadaLocal.hacerLlamada();
                registrarLlamada(llamadaLocal);
                break;
            case 2:
                System.out.println("Que duración tendrá tu llamada?");
                int duracionLlamadaProvincial = sc.nextInt();
                Llamada llamadaProvincial = new LlamadaProvincial(3,4,15,duracionLlamadaProvincial);
                llamadaProvincial.hacerLlamada();
                registrarLlamada(llamadaProvincial);
                break;
            case 3:
                System.out.println("Que duración tendrá tu llamada?");
                int duracionLlamadaNacional = sc.nextInt();
                Llamada llamadaNacional = new LlamadaNacional(5,6,0,duracionLlamadaNacional);
                llamadaNacional.hacerLlamada();
                registrarLlamada(llamadaNacional);
                break;
        }
    }

    //Método para mostrar todas las llamadas de la lista
    public void mostrarLlamadas() {
        System.out.println("Se mostraran todas las llamadas realizadas");
        for (Llamada item : listaLlamadas) {
            item.mostrarDatos();
            System.out.println();
        }
    }

    //Método para mostrar los costes totales de todas las llamadas
    public void mostrarCostesTotales() {
        System.out.println("A continuación se mostrarán los costes totales de todas las llamadas registradas");
        int total = 0;
        System.out.println("Coste por llamada:");
        //Recorro la lista de llamadas
        for (Llamada item : listaLlamadas) {
            /*Como las llamadas locales no tienen valor, no necesitamos filtrar por tipo de llamada.
             * */
            if (item instanceof LlamadaConCoste){
                System.out.println("|"+((LlamadaConCoste) item).getCosteTotal());
                total += ((LlamadaConCoste) item).getCosteTotal();
            }
        }
        System.out.println("El coste total de todas las llamadas es: " + total);
    }
}