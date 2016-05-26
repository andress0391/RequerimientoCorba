package sop_corba;

import sop_corba.Ministerio;
import sop_corba.usuarioInt;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andres
 */
public class MinisterioImpl implements Ministerio{
    
   String directorio = System.getProperty("user.dir");
   String separador = System.getProperty("file.separator");
    
    
    @Override
    public boolean validarAdministrador(String login, String password)  {
        imprimir("En validar Administrador ministerio");
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        int cont = 0;
        String login_arch = "";
        String pass_arch = "";

        try {
            String ruta="./AdminMinisterio/adminMinisterio.txt";
            
            archivo = new File(ruta);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                if (cont == 0) {
                    login_arch = linea;
                }
                if (cont == 1) {
                    pass_arch = linea;
                }
                cont++;
                if (cont == 2) {
                    if ((login_arch.equals(login)) && (pass_arch.equals(password))) {
                        br.close();
                        fr.close();
                        System.out.println("en iguales funcion validarAdministrador \n");
                        return true;

                    } else {
                        br.close();
                        fr.close();
                        System.out.println("en diferentes funcion validarAdministrador \n");
                        return false;
                    }
                }
            }
        } catch (Exception e) {

            return false;
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                
                return false;
            }
        }
        return false;
    }
    
    public void imprimir(String cadena){
        System.out.println(cadena);
    }

    @Override
    public boolean registrarUsuario(usuarioInt u) {
        imprimir("En registra usuario");
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            String loginArchivo;
            loginArchivo = u.getLogin();
            fichero = new FileWriter(directorio+separador+"users" + separador+loginArchivo + ".txt", true);
            pw = new PrintWriter(fichero);
            pw.println(u.getNombres() + " " + u.getApellidos() + " " + u.getLogin() + " " + u.getClave() + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return true;
        
       
    }

    @Override
    public boolean eliminarUsuario(String login) {
        imprimir("en eliminar Usuario");
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        int cont = 0;
        boolean eliminacion;
        String cadena;
        String particion[] = new String[200];
        String cod;
        try {
            archivo = new File(directorio+separador+"users" + separador+login + ".txt");
            if (archivo.delete()) {
                eliminacion = true;
            } else {
                eliminacion = false;
            }
        } catch (Exception e) {
            return false;
        }
        return eliminacion;
       
    }

    @Override
    public boolean modificarUsuario(String login, usuarioInt usu) {
       imprimir("En modificar usuario");
        eliminarUsuario(login);
        registrarUsuario(usu);
        return true;  
    }

    @Override
    public boolean editarCredenciales(String login, String password) {
        eliminarAdmin();
        validarAdministrador(login, password);
        return true;
    }
    
    public boolean eliminarAdmin() {
        
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        int cont = 0;
        boolean eliminacion;
        String cadena;
        String particion[] = new String[200];
        String cod;
         String ruta="./AdminMinisterio/adminMinisterio.txt";
        try {
            archivo = new File(ruta);
            if (archivo.delete()) {
                eliminacion = true;
            } else {
                eliminacion = false;
            }
        } catch (Exception e) {
            return false;
        }
        return eliminacion;
       
    }
    
    
}
