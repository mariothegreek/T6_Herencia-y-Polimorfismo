package ListaMultimedia.model;

public class Audio extends Elemento{
    public Audio() {
    }
    private int duracion;

    private String soporte;


    @Override
    public void rellenarDatos(){
        System.out.println("Audio:");
        super.rellenarDatos();
        System.out.println("Introduce la duración del audio");
        this.duracion = sc.nextInt();
        System.out.println("Introduce el soporte del audio");
        this.soporte = sc.next();
        System.out.println();
    }

    //GETTERS N SETTERS
    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getSoporte() {
        return soporte;
    }

    public void setSoporte(String soporte) {
        this.soporte = soporte;
    }
}
