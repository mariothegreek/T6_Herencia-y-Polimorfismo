package Llamadas_herencia;

import Llamadas_herencia.Utils.ScannerUtils;
import Llamadas_herencia.model.Centralita;

import java.util.Scanner;

public class Entrada {
    public static void main(String[] args) {
        Scanner sc = ScannerUtils.getSc();
        Centralita centralita = new Centralita();
        System.out.println("Bienvenido al centro de llamadas");
        boolean salir = false;

        do {
            System.out.println("""
                ¿Qué deseas hacer?
                1.- Hacer una llamada
                2.- Mostrar llamadas realizadas
                3.- Mostrar costes totales""");
            int opcionAccion = sc.nextInt();
            switch (opcionAccion){
                case 1 :
                    centralita.hacerLlamada();
                    break;
                case 2:
                    centralita.mostrarLlamadas();
                    break;
                case 3:
                    centralita.mostrarCostesTotales();
                    break;
                case 4:
                    salir = true;
                    break;
            }
        }while (!salir);
    }
}
//EXPLICACIÓN IMPORTANTE (caso en: LlamadaProvincial line 32 to 43)
    /*Calcúlo como quiero el costeTOTAL que va a tener esta llamada para poder asociarlo a que sea una llamada con la
    interfaz de LlamadaConCoste, es decir, quiero hacer que LLamadaProvincial sea una LlamadaConCoste, y así
    poder asociar a que tanto LlamadaProvincial como LLamadaNacional tienen ambas costes totales, es decir un método
    que calcula los costes totales, una vez hecho esto, cuando recorro la lista de llamadas, como ambas son
    instance of LlamadaConCoste puedo hacer que ambas sean "iguales"(llamadas que tienen un coste total) pero
    que calculen de forma distinta la forma en la que lo calculan(el método es distinto en cada clase)*/