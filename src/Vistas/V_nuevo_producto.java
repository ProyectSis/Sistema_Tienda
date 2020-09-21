
package Vistas;

import Controlador.categoria_crud;
import Controlador.marca_crud;
import Controlador.producto_crud;

/**
 *
 * @author Admin
 */
public class V_nuevo_producto extends javax.swing.JInternalFrame {

    /**
     * Creates new form test
     */
    producto_crud pro_crud = new producto_crud();
    public V_nuevo_producto() {
        initComponents();
        categoria_crud cat_crud = new categoria_crud();
        cat_crud.llenarComboboxCategoria(cboxCategoria);
        marca_crud mar_crud = new marca_crud();
        mar_crud.llenarComboboxMarca(cboxMarca);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        txtCosto = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        cboxCategoria = new javax.swing.JComboBox<>();
        cboxMarca = new javax.swing.JComboBox<>();
        btnGestionarCategoria = new javax.swing.JLabel();
        btnGestionarMarca = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cboxEstado = new javax.swing.JComboBox<>();
        btnAgregar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        setClosable(true);
        setTitle("Nuevo producto");

        jLabel1.setBackground(new java.awt.Color(102, 102, 102));
        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel1.setText("Descripcion:");

        jLabel2.setBackground(new java.awt.Color(102, 102, 102));
        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel2.setText("Costo:");

        jLabel3.setBackground(new java.awt.Color(102, 102, 102));
        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel3.setText("Precio:");

        jLabel4.setBackground(new java.awt.Color(102, 102, 102));
        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel4.setText("Marca:");

        jLabel5.setBackground(new java.awt.Color(102, 102, 102));
        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel5.setText("Categoria:");

        txtDescripcion.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        txtDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripcionActionPerformed(evt);
            }
        });

        txtCosto.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        txtCosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCostoActionPerformed(evt);
            }
        });

        txtPrecio.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        txtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioActionPerformed(evt);
            }
        });

        cboxCategoria.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        cboxMarca.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        btnGestionarCategoria.setBackground(new java.awt.Color(102, 102, 102));
        btnGestionarCategoria.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        btnGestionarCategoria.setForeground(new java.awt.Color(51, 102, 255));
        btnGestionarCategoria.setText("Gestionar...");
        btnGestionarCategoria.setToolTipText("Gestionar categorias");
        btnGestionarCategoria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGestionarCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGestionarCategoriaMouseClicked(evt);
            }
        });

        btnGestionarMarca.setBackground(new java.awt.Color(102, 102, 102));
        btnGestionarMarca.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        btnGestionarMarca.setForeground(new java.awt.Color(51, 102, 255));
        btnGestionarMarca.setText("Gestionar...");
        btnGestionarMarca.setToolTipText("Gestionar marcas");
        btnGestionarMarca.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGestionarMarca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGestionarMarcaMouseClicked(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(102, 102, 102));
        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel8.setText("Stock:");

        txtStock.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        txtStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStockActionPerformed(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(102, 102, 102));
        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel9.setText("Estado:");

        cboxEstado.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cboxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));

        btnAgregar.setBackground(new java.awt.Color(0, 204, 51));
        btnAgregar.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        btnAgregar.setText("Añadir");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnBorrar.setBackground(new java.awt.Color(255, 51, 51));
        btnBorrar.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        btnVolver.setBackground(new java.awt.Color(255, 102, 51));
        btnVolver.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtStock, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboxCategoria, javax.swing.GroupLayout.Alignment.LEADING, 0, 559, Short.MAX_VALUE)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCosto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE)
                            .addComponent(cboxMarca, javax.swing.GroupLayout.Alignment.LEADING, 0, 559, Short.MAX_VALUE)
                            .addComponent(cboxEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGestionarCategoria)
                    .addComponent(btnGestionarMarca))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cboxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnGestionarCategoria)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cboxMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnGestionarMarca)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(cboxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void txtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcionActionPerformed

    private void txtCostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCostoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCostoActionPerformed

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioActionPerformed

    private void btnGestionarCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGestionarCategoriaMouseClicked
         V_gestionar_categoria cat_gestionar = new V_gestionar_categoria();
        V_principal.PanelEscritorio.add(cat_gestionar);
        cat_gestionar.toFront();
        cat_gestionar.setVisible(true);
        System.out.println("hola");
    }//GEN-LAST:event_btnGestionarCategoriaMouseClicked

    private void btnGestionarMarcaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGestionarMarcaMouseClicked
       
         V_gestionar_marca mar_gestionar = new V_gestionar_marca();
        V_principal.PanelEscritorio.add(mar_gestionar);
        mar_gestionar.toFront();
        mar_gestionar.setVisible(true);
    }//GEN-LAST:event_btnGestionarMarcaMouseClicked

    private void txtStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStockActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        System.out.println(cboxCategoria.getSelectedIndex());
        System.out.println(cboxMarca.getSelectedIndex());
        String descripcion = txtDescripcion.getText();
        String costo = txtCosto.getText();
        String precio = txtPrecio.getText();
        String stock = txtStock.getText();
        int categoria = cboxCategoria.getSelectedIndex();
        int marca = cboxMarca.getSelectedIndex();
        String estado;
        if (cboxEstado.getSelectedIndex() == 0) {
            estado = "1";
        } else {
            estado = "0";
        }

        pro_crud.InsertaNuevoProducto(descripcion, Integer.parseInt(stock), Float.parseFloat(precio), Float.parseFloat(costo), estado, categoria, marca);
        borrarCampos();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        borrarCampos();
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVolverActionPerformed
    public void borrarCampos() {
        txtCosto.setText("");
        txtDescripcion.setText("");
        txtPrecio.setText("");
        txtStock.setText("");
        cboxCategoria.setSelectedIndex(0);
        cboxEstado.setSelectedIndex(0);
        cboxMarca.setSelectedIndex(0);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JLabel btnGestionarCategoria;
    private javax.swing.JLabel btnGestionarMarca;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cboxCategoria;
    private javax.swing.JComboBox<String> cboxEstado;
    private javax.swing.JComboBox<String> cboxMarca;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtCosto;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables
}
