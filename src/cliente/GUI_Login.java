/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import sop_corba.usuarioImpl;
import java.rmi.RemoteException;
import java.rmi.server.ObjID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import sop_corba.MinisterioImpl;


/**
 *
 * @author ANDRES
 */
public class GUI_Login extends javax.swing.JFrame {
    static int sesion=0;
    static GUI_Inicio  objInicio;
    String directorio = System.getProperty("user.dir");
    String separador = System.getProperty("file.separator");
    MinisterioImpl obj_r=new MinisterioImpl();
    //Conexion con=new Conexion();
   GUI_AdminMinisterio objAdminMin;
    //GUI_User objUser;
    
    //adminInt obj_r;
    
   public GUI_Login(GUI_Inicio objInicio,int sesion){
       initComponents();
       this.objInicio=objInicio;
       jLabel2.setVisible(false);
        
       //obj_r=this.con.getObjetoRemoto();
        this.setLocationRelativeTo(this);
        this.setResizable(false);
        this.setTitle("Login");             
        this.sesion=sesion;
        if(sesion==1 || sesion==2)
            jLabel2.setVisible(true);
    }


   

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        usuariotxt = new javax.swing.JTextField();
        passwordtxt = new javax.swing.JPasswordField();
        btnOk = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        usuariotxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuariotxtActionPerformed(evt);
            }
        });
        getContentPane().add(usuariotxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, 140, -1));
        getContentPane().add(passwordtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, 140, -1));

        btnOk.setText("OK");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });
        getContentPane().add(btnOk, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 240, -1, -1));

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 240, -1, -1));

        jLabel1.setFont(new java.awt.Font("Algerian", 0, 36)); // NOI18N
        jLabel1.setText("Bienvenido");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 331, 80));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/log.jpg"))); // NOI18N
        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 140, 130));

        jLabel3.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        jLabel3.setText("Usuario");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 90, 20));

        jLabel5.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        jLabel5.setText("Contraseña");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 90, -1));

        jLabel2.setFont(new java.awt.Font("SansSerif", 3, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("¿Olvidó el nombre de usuario y/o la contraseña?");
        jLabel2.setToolTipText("Click aquí para cambiar el nombre de usuario y/o la contraseña");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                olvideContra(evt);
            }
        });
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 280, 30));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/fondo pasword.jpg"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

      
        int opcMP = -1;
        int opcMA = -1;
        int opcMJ = -1;
        String apellidosJugador;
        String nombresJugador;
        String loginJugador;
        String claveJugador;
        String loginAdministrador;
        String claveAdministrador;
        
        usuarioImpl u = new usuarioImpl();
    private void usuariotxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuariotxtActionPerformed

    }//GEN-LAST:event_usuariotxtActionPerformed

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        if (sesion == 2) {
            
                boolean validacionAdministrador = obj_r.validarAdministrador(usuariotxt.getText(), passwordtxt.getText());

                if (validacionAdministrador) {
                    
                    JOptionPane.showConfirmDialog(null, "BIENVEDIDO AL SISTEMA", "Estado", JOptionPane.DEFAULT_OPTION, 0, new ImageIcon(directorio + separador + "src" + separador + "iconos" + separador + "bienvenidonew.jpg"));
                    try {
                        objAdminMin = new GUI_AdminMinisterio(this);
                       objAdminMin.setVisible(true);
                        this.setVisible(false);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Usuario y/o contraseña incorrecta", "Atención", JOptionPane.ERROR_MESSAGE);
                    usuariotxt.setText("");
                    passwordtxt.setText("");
                }
           

        } else {
            /*if(sesion==2){
            
                boolean validacionUsuario = obj_r.validarUsuario(usuariotxt.getText(), passwordtxt.getText());

                if (validacionUsuario) {

                    JOptionPane.showConfirmDialog(null, "BIENVEDIDO AL SISTEMA", "Estado", JOptionPane.DEFAULT_OPTION, 0, new ImageIcon(directorio + separador + "src" + separador + "iconos" + separador + "bienvenidonew.jpg"));
                    try {
                        objUser = new GUI_User(this);
                        objUser.setVisible(true);
                        this.setVisible(false);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Usuario y/o contraseña incorrecta", "Atención", JOptionPane.ERROR_MESSAGE);
                    usuariotxt.setText("");
                    passwordtxt.setText("");
                }
            

        }
            else{
                
                //Ventana de usuario
            
            }
        }*/
                
        }     
    }//GEN-LAST:event_btnOkActionPerformed

        
    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        objInicio.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void olvideContra(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_olvideContra
        JTextField nombreUsuario=new JTextField();
        JPasswordField contraNueva=new JPasswordField();
        JPasswordField contraRepeat=new JPasswordField();
        int contDatos=0;
        
        Object [] datos={"Ingrese el nuevo nombre de usuario:\t",nombreUsuario,"Ingrese la nueva contraseña:\t",contraNueva,"Vuelva a ingresar la contraseña:\t",contraRepeat};
        int accion=JOptionPane.showConfirmDialog(this, datos,"Cambiar la contraseña",JOptionPane.DEFAULT_OPTION);
        if(accion==JOptionPane.OK_OPTION){
            if(nombreUsuario.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Debe ingresar un nombre de usuario","Atención",JOptionPane.DEFAULT_OPTION);
                
            }else
                contDatos++;
            if(!(contraNueva.getText().equals(contraRepeat.getText())))
                JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden","Atención",JOptionPane.WARNING_MESSAGE);
            else
                contDatos++;
            if(contDatos==2){
                obj_r.editarCredenciales(nombreUsuario.getText(), contraNueva.getText());
                JOptionPane.showConfirmDialog(this, "Se ha cambiado la contraseña exitosamente", "Información", JOptionPane.DEFAULT_OPTION, 0, new ImageIcon(directorio + separador + "src" + separador + "iconos" + separador + "muybien.jpg"));
            }
        }
        else
            return;
        
    }//GEN-LAST:event_olvideContra

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
                    new GUI_Login(objInicio,sesion).setVisible(true);
                

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnOk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPasswordField passwordtxt;
    private javax.swing.JTextField usuariotxt;
    // End of variables declaration//GEN-END:variables
}
