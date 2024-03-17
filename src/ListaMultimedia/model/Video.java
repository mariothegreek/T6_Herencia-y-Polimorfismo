package ListaMultimedia.model;

import java.util.ArrayList;

public class Video extends Elemento {

    private Persona actor;

    private String director, dniDirector;
    private ArrayList<Actor> listaActores;

    public Video() {
        listaActores = new ArrayList<>();
    }

    @Override
    public void rellenarDatos() {
        super.rellenarDatos();
        System.out.println("¿Quien es el director?");
        System.out.println("Introduce nombre");
        this.director = sc.next();
        System.out.println("Introduce DNI");
        this.dniDirector = sc.next();

        System.out.printf("Se ha agregado un director al video con los siguientes datos:\nNombre: %s\nDNI: %s\n",this.director,this.dniDirector);

        System.out.println("¿Cuantos actores la componen?");
        int numeroActores = sc.nextInt();
        for (int i = 1; i <= numeroActores; i++) {
            System.out.println("Introduce nombre del actor numero " + i);
            String nombreActor = sc.next();
            System.out.println("Introduce DNI del actor numero " + i);
            String dniActor = sc.next();
            this.actor = new Actor(nombreActor, dniActor);
            listaActores.add((Actor) actor);
        }
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Video:");
        super.mostrarDatos();
        System.out.println("El director es " +this.director);
        System.out.println();
        System.out.println("Los actores que aparecen en esta película son: ");
        for (Actor item : listaActores) {
            item.mostrarDatosPersona();
            System.out.println();
        }
    }

    public ArrayList<Actor> getListaActores() {
        return listaActores;
    }

    public void setListaActores(ArrayList<Actor> listaActores) {
        this.listaActores = listaActores;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDniDirector() {
        return dniDirector;
    }

    public void setDniDirector(String dniDirector) {
        this.dniDirector = dniDirector;
    }
}