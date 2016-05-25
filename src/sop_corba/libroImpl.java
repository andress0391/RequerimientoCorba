package sop_corba;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Carlos
 */
public class libroImpl implements libroInt{
    //Campos de un libro    
    String autor;
    int anioPublicacion;
    String titulo;
    String ciudad;
    String pais;
    String editorial;
    String ISBN;
    String tipo;
    int unidadesDisponibles;
    int topeMinimo;
    
    public libroImpl()   {
        super();
    }
    
    public libroImpl(String autor, int anioPublicacion, String titulo, String ciudad, String pais, String editorial,
    String ISBN, String tipo, int unidadesDisponibles, int topeMinimo){
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.titulo = titulo;
        this.ciudad = ciudad;
        this.pais = pais;
        this.editorial = editorial;
        this.ISBN = ISBN;
        this.tipo = tipo;
        this.unidadesDisponibles = unidadesDisponibles;
        this.topeMinimo = topeMinimo;
    }

    @Override
    public void setAutor(String nombresApellidos) {
        this.autor = nombresApellidos;
    }

    @Override
    public void setAnioPublicacion(int anio) {
        this.anioPublicacion = anio;
    }

    @Override
    public void setTituloLibro(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
    @Override
    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    @Override
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    @Override
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public void setUnidadesActuales(int unidades) {
        this.unidadesDisponibles = unidades;
    }

    @Override
    public void setTopeMinimo(int tope) {
        this.topeMinimo = tope;
    }

    @Override
    public String getAutor() {
        return autor;
    }

    @Override
    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    @Override
    public String getTituloLibro() {
        return titulo;
    }

    @Override
    public String getCiudad() {
        return ciudad;
    }

    @Override
    public String getPais() {
        return pais;
    }

    @Override
    public String getEditorial() {
        return editorial;
    }

    @Override
    public String getISBN() {
        return ISBN;
    }

    @Override
    public String getTipo() {
        return tipo;
    }

    @Override
    public int getUnidadesActuales(String unidades) {
        return unidadesDisponibles;
    }

    @Override
    public int getTopeMinimo() {
        return topeMinimo;
    }
        
}
