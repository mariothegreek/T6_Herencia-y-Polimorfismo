package ListaMultimedia.model;

public class Audio extends Elemento {
    public Audio() {
    }

    private String duracion;

    private String soporte;


    @Override
    public void rellenarDatos() {
        System.out.println("Audio:");
        super.rellenarDatos();
        System.out.println("Introduce la duración del audio");
        this.duracion = sc.next();
        System.out.println("Introduce el soporte del audio");
        this.soporte = sc.next();
        System.out.println();
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Audio:");
        super.mostrarDatos();
        System.out.println("La duración es " + duracion);
        System.out.println("El soporte es " + soporte);
    }

    //GETTERS N SETTERS


    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getSoporte() {
        return soporte;
    }

    public void setSoporte(String soporte) {
        this.soporte = soporte;
    }
}