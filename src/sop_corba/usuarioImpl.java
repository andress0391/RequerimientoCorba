package sop_corba;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import sop_corba.usuarioInt;
import java.rmi.RemoteException;

/**
 *
 * @author Carlos
 */
public class usuarioImpl implements usuarioInt{
    
    String apellidos;
    String nombres;
    int identificacion;
    int edad;
    String login;
    String clave;
    
    public usuarioImpl()   {
        super();
    }
    
    public usuarioImpl( String nombres,String apellidos, String login, String clave) throws RemoteException {
       
        
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.login = login;
        this.clave = clave;
    }

    @Override
    public void setApellidos(String apellidos)  {
        this.apellidos = apellidos;
    }

    @Override
    public void setNombres(String nombres)  {
        this.nombres = nombres;
    }

    @Override
    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public void setClave(String clave)  {
        this.clave = clave;
    }

    @Override
    public String getApellidos() {
        return this.apellidos;
    }

    @Override
    public String getNombres()  {
        return this.nombres;
    }

    @Override
    public String getLogin()  {
        return this.login;
    }

    @Override
    public String getClave() {
        return this.clave;
    }
    
    
}
