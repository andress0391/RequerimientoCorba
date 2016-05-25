package sop_corba;


import sop_corba.usuarioInt;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andres
 */
public interface Ministerio {
    
    public boolean validarAdministrador(String login, String password);
    public boolean registrarUsuario(usuarioInt u);
      public boolean eliminarUsuario(String login);
    public boolean modificarUsuario(String login,usuarioInt usu) ;
    
}
