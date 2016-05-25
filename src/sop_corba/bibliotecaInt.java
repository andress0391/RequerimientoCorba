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
public interface bibliotecaInt {
    public boolean ingresarLibro(libroInt libro);
    public boolean modificacionLibro(); 
    public boolean desactivarLibro();
    public String listarLibros();   
    public boolean devolverLibro();
}
