package ListaMultimedia.model;

import java.util.ArrayList;

public class Video extends Elemento {

    private Persona director, actor;
    private ArrayList<Actor> listaActores;

    public Video() {
        listaActores = new ArrayList<>();
    }

    @Override
    public void rellenarDatos() {
        super.rellenarDatos();
        System.out.println("¿Quien es el director?");
        System.out.println("Introduce nombre");
        String nombreDirector = sc.next();
        System.out.println("Introduce DNI");
        String dniDirector = sc.next();
        this.director = new Director(nombreDirector, dniDirector);
        System.out.println("Se ha agregado un director al video con los siguientes datos: ");
        director.mostrarDatosPersona();

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
        System.out.println("El director es " + director.getNombre());
        System.out.println();
        System.out.println("Los actores que aparecen en esta película son: ");
        for (Actor item : listaActores) {
            item.mostrarDatosPersona();
            System.out.println();
        }
    }

    public void buscarActor() {
        System.out.println("Introduce el nombre del actor");
        String nombreBuscarActor = sc.next();
        for (Persona item : listaActores) {
            if (nombreBuscarActor.equalsIgnoreCase(item.getNombre())) {
                System.out.println("El actor ha sido encontrado");
            }
        }
    }

    public ArrayList<Actor> getListaActores() {
        return listaActores;
    }

    public void setListaActores(ArrayList<Actor> listaActores) {
        this.listaActores = listaActores;
    }
}