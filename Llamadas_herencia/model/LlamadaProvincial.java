package Llamadas_herencia.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LlamadaProvincial extends Llamada implements LlamadaConCoste {

    private int costeTotal;
    public LlamadaProvincial() {
    }

    public LlamadaProvincial(int nOrigen, int ndestino, int coste, int duracion) {
        super(nOrigen, ndestino, coste, duracion);
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Llamada provincial:");
        super.mostrarDatos();
        System.out.println("costeTotal = " + costeTotal);
    }

    @Override
    public void hacerLlamada() {
        System.out.println("Haciendo llamada provincial...");
        this.costeTotal = getCoste()*getDuracion();
        System.out.println("El coste total de la llamada es "+costeTotal);
    }

    /*Calcúlo como quiero el costeTOTAL que va a tener esta llamada para poder asociarlo a que sea una llamada con la
    interfaz de LlamadaConCoste, es decir, quiero hacer que LLamadaProvincial sea una LlamadaConCoste, y así
    poder asociar a que tanto LlamadaProvincial como LLamadaNacional tienen ambas costes totales, es decir un método
    que calcula los costes totales, una vez hecho esto, cuando recorro la lista de llamadas, como ambas son
    instance of LlamadaConCoste puedo hacer que ambas sean "iguales"(llamadas que tienen un coste total) pero
    que calculen de forma distinta la forma en la que lo calculan(el método es distinto en cada clase)*/
    @Override
    public int getCosteTotal(){
        this.costeTotal = getCoste()*getDuracion();
        return costeTotal;
    }
}