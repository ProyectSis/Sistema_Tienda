package Vistas;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import modelos.conexion;
import modelos.ingreso;

public class V_login extends javax.swing.JFrame {

    conexion conexion = new conexion();
    Connection cc = conexion.conectado();

    public V_login() {
        initComponents();
        setLocationRelativeTo(null);
        

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        cboxRol = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        btnIngresar = new javax.swing.JButton();
        txtClave = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setBackground(new java.awt.Color(102, 102, 102));
        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel1.setText("Usuario:");

        jLabel2.setBackground(new java.awt.Color(102, 102, 102));
        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel2.setText("Clave:");

        txtUsuario.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N

        cboxRol.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cboxRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----", "Empleado", "Administrador" }));
        cboxRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxRolActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(102, 102, 102));
        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel3.setText("Rol:");

        btnIngresar.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(149, 149, 149))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(40, 40, 40))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtClave)
                    .addComponent(txtUsuario)
                    .addComponent(cboxRol, 0, 208, Short.MAX_VALUE))
                .addGap(59, 59, 59))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboxRol, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        String clave = new String(txtClave.getPassword());
        if (txtUsuario.getText().length() < 1 && clave.length() < 1) {
            JOptionPane.showMessageDialog(this, "Llenar campos! ");

        } else if ("----".equals(cboxRol.getSelectedItem().toString())) {
            System.out.println(cboxRol.getSelectedItem().toString());
            JOptionPane.showMessageDialog(this, "No se especifico el rol por defecto se colocara en VENDEDOR\n\n¿Continuar?");
            int reply = JOptionPane.showConfirmDialog(null, "No se especifico el rol por defecto se colocara en VENDEDOR", "Atencion", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {

                String sql;
                String login = txtUsuario.getText();
                ingreso ventana_p = new ingreso();
                try {
                    sql = "SELECT VEN_NOMBRE,VEN_USUARIO,VEN_CLAVE from tbl_vendedor where VEN_USUARIO='" + login + "'";
                    Statement st = cc.createStatement();
                    ResultSet rs = st.executeQuery(sql);

                    if (rs.next()) {

                        ventana_p.setNombre(rs.getString("VEN_NOMBRE"));
                        ventana_p.setUsuario(rs.getString("VEN_USUARIO"));
                        ventana_p.setContrasenia(rs.getString("VEN_CLAVE"));

                    } else {
                        ventana_p.setUsuario("");
                        ventana_p.setContrasenia("");

                    }

                    if (ventana_p.getUsuario().equals(login)) {
                        if (ventana_p.getContrasenia().equals(clave)) {
                            dispose();
                            JOptionPane.showMessageDialog(this, "Bienvenido\t\n\n" + rs.getString("VEN_NOMBRE"));

                            V_principal interfaz = new V_principal();
                            interfaz.setVisible(true);
                        } else {
                            txtClave.setText("");
                            txtClave.requestFocus();
                            JOptionPane.showMessageDialog(this, "Clave incorrecta!");
                        }
                    } else {
                        txtUsuario.setText("");
                        txtUsuario.requestFocus();
                        JOptionPane.showMessageDialog(this, "Usuario inexistente!");
                    }

                } catch (SQLException | HeadlessException e) {
                    JOptionPane.showMessageDialog(this, "Error: " + e);
                }
                // String nombre=ventana_p.getNombre();
            }

        }
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void cboxRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxRolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxRolActionPerformed

    public static void main(String args[]) {
      try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new V_login().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JComboBox<String> cboxRol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtClave;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
