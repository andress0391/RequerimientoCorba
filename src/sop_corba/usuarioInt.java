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
public interface usuarioInt {

    //Metodos set de usuario
    public void setApellidos(String apellidos) ;
    public void setNombres(String nombres);
    public void setLogin(String login) ;
    public void setClave(String clave) ;
        
    //Metodos get de usuario
    public String getApellidos() ;
    public String getNombres() ;
    public String getLogin() ;
    public String getClave() ;
}
