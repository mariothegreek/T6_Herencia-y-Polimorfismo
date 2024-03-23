package Llamadas_herencia.model;

import Llamadas_herencia.Utils.ScannerUtils;

import java.util.Scanner;

public class LlamadaLocal extends Llamada {

    private Scanner sc = ScannerUtils.getSc();
    public LlamadaLocal() {
    }

    public LlamadaLocal(int nOrigen, int ndestino, int coste, int duracion) {
        super(nOrigen, ndestino, coste, duracion);
    }
    @Override
    public void mostrarDatos(){
        System.out.println("Llamada local:");
        super.mostrarDatos();
    }

    @Override
    public void hacerLlamada() {
        System.out.println("Haciendo llamada...(las llamadas locales no tienen ningún coste)");
    }
}