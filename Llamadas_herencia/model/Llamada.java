package Llamadas_herencia.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Llamada {

    private int nOrigen, nDestino, coste, duracion;

    public Llamada() {
    }

    public Llamada(int nOrigen, int nDestino, int coste, int duracion) {
        this.nOrigen = nOrigen;
        this.nDestino = nDestino;
        this.coste = coste;
        this.duracion = duracion;
    }
    public void mostrarDatos(){
        System.out.println("nOrigen = " + nOrigen);
        System.out.println("nDestino = " + nDestino);
        System.out.println("coste = " + coste);
    }
    public abstract void hacerLlamada();
}