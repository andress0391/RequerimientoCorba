/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

//import Controlador.Modelo_Jtable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import sop_corba.MinisterioImpl;
import sop_corba.usuarioImpl;


/**
 *
 * @author ANDRES
 */
public class GUI_RegistrarUser extends javax.swing.JFrame {

    ArrayList<String> lstLogin = new ArrayList<>();
    ;
    static DefaultTableModel modelo;
    private String accion;
    String directorio = System.getProperty("user.dir");
    String separador = System.getProperty("file.separator");
   // adminInt obj_r = new adminImpl();
    MinisterioImpl obj_r=new MinisterioImpl();
    //Conexion con=new Conexion();
     usuarioImpl user;

    // GUI_Admin objAdmin=new GUI_Admin();
    GUI_AdminMinisterio objAdmin;
   
    

    public GUI_RegistrarUser() {
        initComponents();
        setLocationRelativeTo(this);
        //setTitle("Registrar Usuario");
        setResizable(false);
        // objAdmin=new GUI_Admin();                    
    }

    

    public GUI_RegistrarUser(GUI_AdminMinisterio padre, usuarioImpl usu, String accion)  {
        initComponents();
        setLocationRelativeTo(this);
        etiquetas();

        setResizable(false);
        //obj_r=con.getObjetoRemoto();
        this.objAdmin = padre;
        this.user = usu;
        this.accion = accion;
        if (accion.equals("editar")) {
            lbltit.setText("Modificar Usuario");
            llenarDatosUsuario();
        }

    }

    public void etiquetas() {
        jtxtNom.setToolTipText("Máximo 30 caracteres");
        jtxtApell.setToolTipText("Máximo 20 caracteres");
        jtxtLogin.setToolTipText("Mínimo 8 caracteres, máximo 15 caracteres");
        jpassClave.setToolTipText("Mínimo 8 caracteres, máximo 15 caracteres");
    }

    public boolean validarNombre(String nomobre) {
        int cont = 0;
        String nom = nomobre;
        char[] lstLetras = nom.toCharArray();
        for (int i = 0; i < lstLetras.length; i++) {
            cont++;
        }
        if (cont > 30) {
            return false;
        } else {
            return true;
        }
    }

    public boolean validarApellido(String nomobre) {
        int cont = 0;
        String nom = nomobre;
        char[] lstLetras = nom.toCharArray();
        for (int i = 0; i < lstLetras.length; i++) {
            cont++;
        }
        if (cont > 20) {
            return false;
        } else {
            return true;
        }
    }

    public boolean validarLoginContra(String nomobre) {
        int cont = 0;
        String nom = nomobre;
        char[] lstLetras = nom.toCharArray();
        for (int i = 0; i < lstLetras.length; i++) {
            cont++;
        }
        if (cont < 8 || cont > 15) {
            return false;
        } else {
            return true;
        }
    }

    public boolean validarId(long num) {
        int cont = 0;
        while (num != 0) {
            num = num / 10;
            cont++;

        }
        if (cont > 10) {
            return false;
        } else {
            return true;
        }
    }

    public int validar()  {

        int contador = 0;

        if (jtxtNom.getText().equals("")) {
            lblNom.setText("Debe ingresar el nombre");
        }
        if (!jtxtNom.getText().equals("")) {
            if (validarNombre(jtxtNom.getText())) {
                lblNom.setText("");
                user.setNombres(jtxtNom.getText());
                contador++;
            } else {
                lblNom.setText("Máximo 30 caracteres");
            }
        }
        if (jtxtApell.getText().equals("")) {
            lblApell.setText("Debe ingresar el apellido");

        }
        if (!jtxtApell.getText().equals("")) {
            if (validarApellido(jtxtApell.getText())) {
                lblApell.setText("");
                user.setApellidos(jtxtApell.getText());
                contador++;
            } else {
                lblApell.setText("Máximo 20 caracteres");
            }
        }
       
        if (jtxtLogin.getText().equals("")) {
            lblLogin.setText("Debe ingresar el login");
        }
        if (!jtxtLogin.getText().equals("")) {

            lblLogin.setText("");
            if (validarLoginContra(jtxtLogin.getText())) {
                if (validarLogin(jtxtLogin.getText())) {
                    lblLogin.setText("Login ya está asigando, digíte otro login");
                } else {
                    user.setLogin(jtxtLogin.getText());
                    lstLogin.add(jtxtLogin.getText());
                    contador++;
                }

            } else {
                lblLogin.setText("Mínimo 8 caracteres, máximo 15 caracteres");

            }
        }
        if (jpassClave.getText().equals("")) {
            lblclave.setText("Debe ingresar la clave");
        }

        if (!jpassClave.getText().equals("")) {
            String password = new String(jpassClave.getPassword());
            if(validarLoginContra(password)){
            lblclave.setText("");
            user.setClave(password);
            contador++;
            }else
                lblclave.setText("Mínimo 8 caracteres, máximo 15 caracteres");
        }
        return contador;
    }

    public boolean validarLogin(String login) {
        for (int i = 0; i < lstLogin.size(); i++) {
            if (login.equals(lstLogin.get(i))) {
                return true;
            }
        }
        return false;

    }

    public void llenarDatosUsuario() {
        
            jtxtNom.setText("" + user.getNombres());
            jtxtApell.setText(user.getApellidos());
            jtxtLogin.setText(user.getLogin());
            jpassClave.setText(user.getClave());
       

    }

    public void editar() {
        
            int res=0;
            res = validar();
            
            if(res==4){

            //Modificar el dato en la tabla
            int fila = objAdmin.getTabla().getSelectedRow();
            objAdmin.getTabla().setValueAt(jtxtNom.getText(), fila, 0);
            objAdmin.getTabla().setValueAt(jtxtApell.getText(), fila, 1);
            objAdmin.getTabla().setValueAt(jtxtLogin.getText(), fila, 2);
            objAdmin.getTabla().setValueAt(jpassClave.getPassword(), fila, 3);
            JOptionPane.showConfirmDialog(this, "Datos del usuario: "+ jtxtLogin.getText()+"  editados exitosamente", "Información", JOptionPane.DEFAULT_OPTION, 0, new ImageIcon(directorio + separador + "src" + separador + "iconos" + separador + "muybien.jpg"));
            obj_r.modificarUsuario(jtxtLogin.getText(), user);
            this.dispose();
            }
      
    }

    public void registrar() {
        int resultado=0;
       
            resultado = validar();

            if (resultado == 4) {

                JOptionPane.showConfirmDialog(this, "Usuario registrado exitosamente", "Información", JOptionPane.DEFAULT_OPTION, 0, new ImageIcon(directorio + separador + "src" + separador + "iconos" + separador + "muybien.jpg"));
                obj_r.registrarUsuario(user);
                String pass = new String(jpassClave.getPassword());
                Object NuevaFila[] = {jtxtNom.getText(), jtxtApell.getText(),jtxtLogin.getText(), jpassClave.getPassword()};
                //objAdmin.registrar1(NuevaFila);
                DefaultTableModel modelo = (DefaultTableModel) objAdmin.getTabla().getModel();

                modelo.addRow(NuevaFila);
                    //valores();
                //this.dispose();
                this.setVisible(false);
                objAdmin.setVisible(true);

            }
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField4 = new javax.swing.JTextField();
        jtxtNom = new javax.swing.JTextField();
        jtxtApell = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbltit = new javax.swing.JLabel();
        jtxtLogin = new javax.swing.JTextField();
        jpassClave = new javax.swing.JPasswordField();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblNom = new javax.swing.JLabel();
        lblApell = new javax.swing.JLabel();
        lblLogin = new javax.swing.JLabel();
        lblclave = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jTextField4.setText("jTextField4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jtxtNom, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 125, -1));
        getContentPane().add(jtxtApell, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 125, -1));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel1.setText("Nombre");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 120, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel2.setText("Apellido");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 92, 110, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel5.setText("Login");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 120, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel6.setText("Clave");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 88, -1));

        lbltit.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lbltit.setText("Registrar Usuario");
        getContentPane().add(lbltit, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 210, -1));
        getContentPane().add(jtxtLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 125, -1));
        getContentPane().add(jpassClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 125, -1));

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 88, -1));

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, -1, -1));

        lblNom.setForeground(new java.awt.Color(204, 0, 0));
        lblNom.setText(" ");
        getContentPane().add(lblNom, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 69, 150, -1));

        lblApell.setForeground(new java.awt.Color(204, 0, 0));
        lblApell.setText(" ");
        getContentPane().add(lblApell, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 115, 170, -1));

        lblLogin.setForeground(new java.awt.Color(204, 0, 0));
        lblLogin.setText(" ");
        getContentPane().add(lblLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 250, -1));

        lblclave.setForeground(new java.awt.Color(204, 0, 0));
        lblclave.setText(" ");
        getContentPane().add(lblclave, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 250, 20));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/fondoregistra.jpg"))); // NOI18N
        jLabel3.setText(" ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        if (accion.equals("registrar")) {
            registrar();
        } else {
            editar();
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        objAdmin.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(GUI_RegistrarUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_RegistrarUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_RegistrarUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_RegistrarUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                    new GUI_RegistrarUser().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JPasswordField jpassClave;
    private javax.swing.JTextField jtxtApell;
    private javax.swing.JTextField jtxtLogin;
    private javax.swing.JTextField jtxtNom;
    private javax.swing.JLabel lblApell;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblNom;
    private javax.swing.JLabel lblclave;
    private javax.swing.JLabel lbltit;
    // End of variables declaration//GEN-END:variables
}
