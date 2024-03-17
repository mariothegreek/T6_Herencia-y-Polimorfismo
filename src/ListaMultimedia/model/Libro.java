package ListaMultimedia.model;

public class Libro extends Elemento {
    public Libro() {
        this.isbn = (int) (Math.random() * 1000) + 100;
        this.numero_paginas = (int) (Math.random() * 500) + 100;
    }

    private int isbn, numero_paginas;

    @Override
    public void mostrarDatos() {
        System.out.println("Libro:");
        super.mostrarDatos();
        System.out.println("El isbn es " + isbn);
        System.out.println("El numero de páginas " + numero_paginas);
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public int getNumero_paginas() {
        return numero_paginas;
    }

    public void setNumero_paginas(int numero_paginas) {
        this.numero_paginas = numero_paginas;
    }
}