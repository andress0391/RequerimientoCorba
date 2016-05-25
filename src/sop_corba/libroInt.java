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
public interface libroInt {
        
     //Metodos set de usuario
    public void setAutor(String nombresApellidos);
    public void setAnioPublicacion(int anio);
    public void setTituloLibro(String titulo);
    public void setCiudad(String ciudad);
    public void setPais(String pais);
    public void setEditorial(String editorial);
    public void setISBN(String ISBN);
    public void setTipo(String tipo);
    public void setUnidadesActuales(int unidades);
    public void setTopeMinimo(int tope);
    
    //Metodos get de usuario
    public String getAutor();
    public int getAnioPublicacion();
    public String getTituloLibro();
    public String getCiudad();
    public String getPais();
    public String getEditorial();
    public String getISBN();
    public String getTipo();
    public int getUnidadesActuales(String unidades);
    public int getTopeMinimo();
}
