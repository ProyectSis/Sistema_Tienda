/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import modelos.RelojVisual;
import sistema_tienda.Sistema_Tienda;

/**
 *
 * @author Admin
 */
public class V_principal extends javax.swing.JFrame {
//
//    Date date = new Date();
//
//    DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");

    static V_casa v_casa = new V_casa();

    public V_principal() {

        //Image img = new ImageIcon("logo2.png").getImage();
        //ImageIcon img2 = new ImageIcon(img.getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH));
        initComponents();
        // ImageIcon fot = new ImageIcon("/Imagenes/logo2.png");
        // Icon icono = new ImageIcon(fot.getImage().getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_DEFAULT));
        try {
            this.setIconImage(new ImageIcon(getClass().getResource("../Imagenes/computer.png")).getImage());
        } catch (Exception e) {
        }
        // this.repaint();
        RelojVisual r = new RelojVisual(new Sistema_Tienda());
        setExtendedState(MAXIMIZED_BOTH);
        PanelEscritorio.add(v_casa);
        try {
            v_casa.setMaximum(true);
        } catch (PropertyVetoException ex) {
        }
        v_casa.show();
        lblTitulo.setText("Inicio");
        if ("Vendedor".equals(V_principal.lblRol.getText())) {
            mAuditoria.setEnabled(false);
            mUsuarios.setEnabled(false);
        }
//        lblFecha.setText(hourdateFormat.format(date));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblRol = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        PanelEscritorio = new javax.swing.JDesktopPane();
        Salir = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        mgproductos = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        jMenuItem12 = new javax.swing.JMenuItem();
        mgClientes = new javax.swing.JMenuItem();
        jMenu10 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu11 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        mUsuarios = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu12 = new javax.swing.JMenu();
        jMenuItem15 = new javax.swing.JMenuItem();
        mAuditoria = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TecnoShop-UIO");
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(51, 153, 255));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        lblNombre.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel2.setText("Usuario: ");

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel3.setText("Fecha:");

        lblRol.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N

        lblFecha.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N

        lblID.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lblID.setForeground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblRol, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblRol, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(14, 14, 14))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logo3.png"))); // NOI18N
        jLabel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        lblTitulo.setFont(new java.awt.Font("Century Gothic", 0, 48)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Inicio");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        PanelEscritorio.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout PanelEscritorioLayout = new javax.swing.GroupLayout(PanelEscritorio);
        PanelEscritorio.setLayout(PanelEscritorioLayout);
        PanelEscritorioLayout.setHorizontalGroup(
            PanelEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        PanelEscritorioLayout.setVerticalGroup(
            PanelEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 270, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelEscritorio)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelEscritorio))
        );

        Salir.setBackground(new java.awt.Color(255, 255, 255));
        Salir.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Salir.setForeground(new java.awt.Color(255, 0, 0));
        Salir.setText("x");
        Salir.setFocusable(false);
        Salir.setMargin(new java.awt.Insets(1, 14, 1, 14));
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 946, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(Salir)))
                .addGap(2, 2, 2)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jMenuBar1.setBorder(null);
        jMenuBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jMenu1.setBorder(null);
        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/home.png"))); // NOI18N
        jMenu1.setText("Casa");
        jMenu1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);

        jMenuItem8.setText("Cambiar Usuario");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem8);
        jMenu1.add(jSeparator1);

        jMenuItem9.setText("Salir ");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem9);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/box (1).png"))); // NOI18N
        jMenu2.setText("Productos");

        jMenuItem1.setText("Nuevo");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        mgproductos.setText("Gestionar");
        mgproductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mgproductosActionPerformed(evt);
            }
        });
        jMenu2.add(mgproductos);

        jMenuBar1.add(jMenu2);

        jMenu9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/user (2).png"))); // NOI18N
        jMenu9.setText("Clientes");

        jMenuItem12.setText("Nuevo");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevoCliente(evt);
            }
        });
        jMenu9.add(jMenuItem12);

        mgClientes.setText("Gestionar");
        mgClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GestionarCliente(evt);
            }
        });
        jMenu9.add(mgClientes);

        jMenuBar1.add(jMenu9);

        jMenu10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/outlets (1).png"))); // NOI18N
        jMenu10.setText("Proveedores");

        jMenuItem6.setText("Nuevo");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem6);

        jMenuItem7.setText("Gestionar");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem7);

        jMenuBar1.add(jMenu10);

        jMenu11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/shopping.png"))); // NOI18N
        jMenu11.setText("Facturacion");

        jMenuItem10.setText("Nueva Factura");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu11.add(jMenuItem10);

        jMenuBar1.add(jMenu11);

        mUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/user (1).png"))); // NOI18N
        mUsuarios.setText("Usuarios");

        jMenuItem3.setText("Nuevo");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        mUsuarios.add(jMenuItem3);

        jMenuItem4.setText("Gestionar");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        mUsuarios.add(jMenuItem4);

        jMenuBar1.add(mUsuarios);

        jMenu12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/document (1).png"))); // NOI18N
        jMenu12.setText("Reportes");

        jMenuItem15.setText("Historial de ventas");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu12.add(jMenuItem15);

        jMenuBar1.add(jMenu12);

        mAuditoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/business.png"))); // NOI18N
        mAuditoria.setText("Auditoria");
        mAuditoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mAuditoriaMouseClicked(evt);
            }
        });
        jMenuBar1.add(mAuditoria);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/contact.png"))); // NOI18N
        jMenu5.setText("Contacto");
        jMenu5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu5MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu5);

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/help.png"))); // NOI18N
        jMenu6.setText("Ayuda");

        jMenu7.setText("Manual");
        jMenu7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu7MouseClicked(evt);
            }
        });
        jMenu6.add(jMenu7);

        jMenu4.setText("Acerca de");
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu4MouseClicked(evt);
            }
        });
        jMenu6.add(jMenu4);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mgproductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mgproductosActionPerformed
        V_gestionar_producto pro_gestionar = new V_gestionar_producto();

        if (JInternalFrames_Abiertos(pro_gestionar)) {

        } else {
            PanelEscritorio.add(pro_gestionar);
            try {
                pro_gestionar.setMaximum(true);
            } catch (PropertyVetoException ex) {
            }
            pro_gestionar.show();
        }
    }//GEN-LAST:event_mgproductosActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        if (V_principal.lblRol.getText() == "Vendedor") {

            JOptionPane.showMessageDialog(null, "Solo el/los administrador/s tiene acceso");
        } else {
            V_gestionar_vendedor gest_vendedor = new V_gestionar_vendedor();
            if (JInternalFrames_Abiertos(gest_vendedor)) {

            } else {
                PanelEscritorio.add(gest_vendedor);
                try {
                    gest_vendedor.setMaximum(true);
                } catch (PropertyVetoException ex) {
                }
                gest_vendedor.show();
            }
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        V_login vl = new V_login();
        vl.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        V_nuevo_producto pro_nuevo = new V_nuevo_producto();
        if (JInternalFrames_Abiertos(pro_nuevo)) {

        } else {

            PanelEscritorio.add(pro_nuevo);
            try {
                pro_nuevo.setMaximum(true);
            } catch (PropertyVetoException ex) {
            }
            lblTitulo.setText(pro_nuevo.getTitle());
            pro_nuevo.show();
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        if (V_principal.lblRol.getText() == "Vendedor") {
            JOptionPane.showMessageDialog(null, "Solo el/los administrador/s tiene acceso");

        } else {
            V_nuevo_vendedor nuevo_vendedor = new V_nuevo_vendedor();

            if (JInternalFrames_Abiertos(nuevo_vendedor)) {

            } else {
                PanelEscritorio.add(nuevo_vendedor);
                try {
                    nuevo_vendedor.setMaximum(true);
                } catch (PropertyVetoException ex) {
                }

                lblTitulo.setText(nuevo_vendedor.getTitle());
                nuevo_vendedor.show();
            }
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        V_nuevo_proveedor nuv_proveedor = new V_nuevo_proveedor();
        if (JInternalFrames_Abiertos(nuv_proveedor)) {

        } else {
            PanelEscritorio.add(nuv_proveedor);
            try {
                nuv_proveedor.setMaximum(true);
            } catch (PropertyVetoException ex) {
            }

            lblTitulo.setText(nuv_proveedor.getTitle());
            nuv_proveedor.show();
        }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        V_gestionar_proveedor gest_proveedor = new V_gestionar_proveedor();

        if (JInternalFrames_Abiertos(gest_proveedor)) {

        } else {
            PanelEscritorio.add(gest_proveedor);
            try {
                gest_proveedor.setMaximum(true);
            } catch (PropertyVetoException ex) {
            }

            lblTitulo.setText(gest_proveedor.getTitle());
            gest_proveedor.show();
        }

    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        LimpiarEscritorio();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        V_gestionar_factura vf = new V_gestionar_factura();

        if (JInternalFrames_Abiertos(vf)) {

        } else {
            PanelEscritorio.add(vf);
            try {
                vf.setMaximum(true);
            } catch (PropertyVetoException ex) {
            }

            lblTitulo.setText(vf.getTitle());
            vf.txtVendedor.setText(lblNombre.getText());
            vf.show();
        }
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    public static boolean JInternalFrames_Abiertos(JInternalFrame jif) { // Creamos un metodo publico de tipo boolean.

        JInternalFrame[] jif_Activos = PanelEscritorio.getAllFrames(); // Este arreglo almacena todos los JInternalFrames que esten abierto en el jDesktopPane.

        for (int i = 0; i < jif_Activos.length; i++) { // Creamos un ciclo for para recorrer nuestro arreglo utilizando la propiedad length de nuestro arreglo.

            // Validamos con un if si nuestro arreglo en la posición i es igual al JInternalFrame que esta activo en el jDesktopPane, si es igual devolverá true.
            if (jif.getClass().isInstance(jif_Activos[i])) {
                JOptionPane.showMessageDialog(null, "La ventana que esta intentando abrir ya esta abierta.", "Aviso", JOptionPane.INFORMATION_MESSAGE);

                return true;

            }
            jif_Activos[i].dispose();
            PanelEscritorio.remove(jif_Activos[i]);

        }

        PanelEscritorio.add(v_casa);
        v_casa.show();

        lblTitulo.setText(jif.getTitle());

        return false;
    }

    public void LimpiarEscritorio() {

        /*
        JInternalFrame[] jifAbiertos = PanelEscritorio.getAllFrames();
        for (int i = 0; i < jifAbiertos.length; i++) {
            remove(jifAbiertos[i]);
        }
        if (v_casa.isShowing()) {

        } else {
            PanelEscritorio.add(v_casa);
            v_casa.show();
        }
         */
        JInternalFrame[] jif_Activos = PanelEscritorio.getAllFrames(); // Este arreglo almacena todos los JInternalFrames que esten abierto en el jDesktopPane.

        for (int i = 0; i < jif_Activos.length; i++) { // Creamos un ciclo for para recorrer nuestro arreglo utilizando la propiedad length de nuestro arreglo.

            // Validamos con un if si nuestro arreglo en la posición i es igual al JInternalFrame que esta activo en el jDesktopPane, si es igual devolverá true.
            jif_Activos[i].dispose();
            PanelEscritorio.remove(jif_Activos[i]);

        }
        lblTitulo.setText("Inicio");
        PanelEscritorio.add(v_casa);
        v_casa.show();
    }

    private void NuevoCliente(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevoCliente
        V_nuevo_cliente nue_cliente = new V_nuevo_cliente();
        if (JInternalFrames_Abiertos(nue_cliente)) {

        } else {
            PanelEscritorio.add(nue_cliente);
            try {
                nue_cliente.setMaximum(true);
            } catch (PropertyVetoException ex) {
            }

            lblTitulo.setText(nue_cliente.getTitle());
            nue_cliente.show();
        }
    }//GEN-LAST:event_NuevoCliente

    private void GestionarCliente(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GestionarCliente
        V_gestionar_cliente gest_cliente = new V_gestionar_cliente();
        if (JInternalFrames_Abiertos(gest_cliente)) {

        } else {
            PanelEscritorio.add(gest_cliente);
            try {
                gest_cliente.setMaximum(true);
            } catch (PropertyVetoException ex) {
            }

            lblTitulo.setText(gest_cliente.getTitle());
            gest_cliente.show();
        }
    }//GEN-LAST:event_GestionarCliente

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        V_reporte_facturas vf = new V_reporte_facturas();

        if (JInternalFrames_Abiertos(vf)) {

        } else {
            PanelEscritorio.add(vf);
            try {
                vf.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(V_principal.class.getName()).log(Level.SEVERE, null, ex);
            }

            lblTitulo.setText(vf.getTitle());
            vf.show();
        }
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        LimpiarEscritorio();
    }//GEN-LAST:event_SalirActionPerformed

    private void jMenu5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu5MouseClicked
        V_contacto v_contacto = new V_contacto();

        if (JInternalFrames_Abiertos(v_contacto)) {

        } else {
            PanelEscritorio.add(v_contacto);
            try {
                v_contacto.setMaximum(true);
            } catch (PropertyVetoException ex) {
            }

            lblTitulo.setText(v_contacto.getTitle());
            v_contacto.show();
        }
    }//GEN-LAST:event_jMenu5MouseClicked

    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked
        V_acerca_de vsd = new V_acerca_de();
        vsd.setVisible(true);
    }//GEN-LAST:event_jMenu4MouseClicked

    private void mAuditoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mAuditoriaMouseClicked
        V_auditoria a = new V_auditoria();

        if (JInternalFrames_Abiertos(a)) {

        } else {
            PanelEscritorio.add(a);
            try {
                a.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(V_principal.class.getName()).log(Level.SEVERE, null, ex);
            }

            lblTitulo.setText(a.getTitle());
            a.show();
        }
    }//GEN-LAST:event_mAuditoriaMouseClicked

    private void jMenu7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu7MouseClicked
        try {
            Process p = Runtime.getRuntime().exec("rundll32 SHELL32.DLL,ShellExec_RunDLL " + "C:\\Users\\Admin\\Documents\\NetBeansProjects\\Sistema_Tienda\\Sistema_Tienda\\src\\Facturas\\Manual.pdf");
        } catch (Exception evvv) {
            JOptionPane.showMessageDialog(null, "No se puede abrir el archivo de ayuda, probablemente fue borrado", "ERROR", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_jMenu7MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        java.awt.EventQueue.invokeLater(() -> {
            new V_principal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane PanelEscritorio;
    private javax.swing.JButton Salir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    public static javax.swing.JLabel lblFecha;
    public static javax.swing.JLabel lblID;
    public static javax.swing.JLabel lblNombre;
    public static javax.swing.JLabel lblRol;
    public static javax.swing.JLabel lblTitulo;
    private javax.swing.JMenu mAuditoria;
    private javax.swing.JMenu mUsuarios;
    private javax.swing.JMenuItem mgClientes;
    private javax.swing.JMenuItem mgproductos;
    // End of variables declaration//GEN-END:variables
}
