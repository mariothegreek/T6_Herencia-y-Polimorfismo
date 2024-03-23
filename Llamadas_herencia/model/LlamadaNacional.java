package Llamadas_herencia.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LlamadaNacional extends Llamada implements LlamadaConCoste {

    private int franja;
    private int costeTotal;
    public LlamadaNacional() {
    }

    public LlamadaNacional(int nOrigen, int nDestino, int coste, int duracion) {
        super(nOrigen, nDestino, coste, duracion);
        this.franja = (int) (Math.random()*24);
    }

    //Método para el cáculo de las llamadas y mensajes según la franja
    @Override
    public void hacerLlamada() {
        System.out.println("Haciendo llamada nacional...");
        if (this.franja >= 0 && this.franja <=6){
            System.out.println("Estás en franja horaria 1");
            getCosteTotal();
            System.out.println("El coste total de la llamada ha sido "+costeTotal);
        }else if (this.franja >= 6 && this.franja <=12){
            System.out.println("Estás en franja horaria 2");
            getCosteTotal();
            System.out.println("El coste total de la llamada ha sido "+costeTotal);
        } else if (this.franja > 12 && this.franja <=23) {
            System.out.println("Estás en franja horaria 3");
            getCosteTotal();
            System.out.println("El coste total de la llamada ha sido "+costeTotal);
        }
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Llamada nacional:");
        super.mostrarDatos();
        System.out.println("franja = " + franja);
        System.out.println("costeTotal = " + costeTotal);
    }

    //Método para poder calcular el coste de las llamadas.
    @Override
    public int getCosteTotal() {
        if (this.franja >= 0 && this.franja <=6){
            setCoste(20);
            this.costeTotal = getCoste()*getDuracion();
        }else if (this.franja >= 6 && this.franja <=12){
            setCoste(25);
            this.costeTotal = getCoste()*getDuracion();
        } else if (this.franja > 12 && this.franja <=23) {
            setCoste(25);
            this.costeTotal = getCoste()*getDuracion();
        }
        return costeTotal;
    }
}