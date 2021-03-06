package Vistas;
import modelos.ButtonColumn;
import Controlador.cliente_crud;
import Controlador.factura_crud;
import Controlador.producto_crud;
import modelos.EnviarFactura;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import modelos.conexion;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class V_gestionar_factura extends javax.swing.JInternalFrame {

    factura_crud fc = new factura_crud();

    DefaultTableModel tabla = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int Fila, int Colum) {
            return false;
        }
    };
    producto_crud pc = new producto_crud();
    float descuento = 0;

    public V_gestionar_factura() {
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        initComponents();
        pc.mostraarProductoporNombre("", tblPorNomrbe);
        pc.mostrarProductoporImagen("", PanelImagen, lblnombre, lblID, txtprecio, lblstock);
        Random numAleatorio = new Random();
        txtNFactura.setText(fc.getIdFactura() + 1 + "");

        tabla.setColumnCount(0);
        tabla.setRowCount(0);
        tabla.addColumn("ID");
        tabla.addColumn("Descripcion");
        tabla.addColumn("Cantidad");
        tabla.addColumn("P.U.");
        tabla.addColumn("Precio");
        tblFactura.setModel(tabla);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngrup = new javax.swing.ButtonGroup();
        btngrup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        btnBorrar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        txtCedula = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtcodigo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtVendedor = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtNFactura = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtBuscarcliente = new javax.swing.JTextField();
        cboxBuscar = new javax.swing.JComboBox<>();
        txtMach = new javax.swing.JLabel();
        txtMachcedula = new javax.swing.JLabel();
        btnCambiarCliente = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnAgregar2 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPorNomrbe = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        PanelImagen = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtprecio = new javax.swing.JTextField();
        lblnombre = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        l3 = new javax.swing.JLabel();
        l4 = new javax.swing.JLabel();
        lblstock = new javax.swing.JLabel();
        txtbuscarpro = new javax.swing.JTextField();
        btnBuscarPro = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblFactura = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        txtSubtotal = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtIva = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        cboxFormaPago = new javax.swing.JComboBox<>();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel15 = new javax.swing.JLabel();
        txtdescuento = new javax.swing.JTextField();
        btnAgregar3 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        btnAgregar4 = new javax.swing.JButton();
        btnBorrarProducto = new javax.swing.JButton();
        lblDetalleProducto = new javax.swing.JLabel();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();

        setTitle("Nueva compra");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnBorrar.setBackground(new java.awt.Color(255, 51, 51));
        btnBorrar.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btnBorrar.setText("Borrar");
        btnBorrar.setBorderPainted(false);
        btnBorrar.setFocusable(false);
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cabecera", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 24))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel1.setText("Cliente:");

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel2.setText("RUC/CI:");

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel3.setText("Direccion:");

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel4.setText("Telefono:");

        txtCliente.setEditable(false);
        txtCliente.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N

        txtCedula.setEditable(false);
        txtCedula.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        txtCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedulaActionPerformed(evt);
            }
        });

        txtDireccion.setEditable(false);
        txtDireccion.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N

        txtTelefono.setEditable(false);
        txtTelefono.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel5.setText("Codigo:");

        txtcodigo.setEditable(false);
        txtcodigo.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        txtcodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodigoActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel6.setText("Vendedor:");

        txtVendedor.setEditable(false);
        txtVendedor.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel8.setText("N° Factura:");

        txtNFactura.setEditable(false);
        txtNFactura.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N

        jLabel17.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel17.setText("Seleccionar:");

        txtBuscarcliente.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        txtBuscarcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarclienteActionPerformed(evt);
            }
        });
        txtBuscarcliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarclienteKeyTyped(evt);
            }
        });

        cboxBuscar.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        cboxBuscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CI", "Nombre" }));

        txtMach.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        txtMach.setText(" ");

        txtMachcedula.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        txtMachcedula.setText(" ");

        btnCambiarCliente.setBackground(new java.awt.Color(0, 204, 204));
        btnCambiarCliente.setText("Cambiar");
        btnCambiarCliente.setToolTipText("Cambiar Cliente");
        btnCambiarCliente.setEnabled(false);
        btnCambiarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarClienteActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel7.setText("Correo:");

        txtCorreo.setEditable(false);
        txtCorreo.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTelefono)
                                    .addComponent(txtDireccion)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel2))
                                .addGap(49, 49, 49)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCedula)
                                    .addComponent(txtCliente)
                                    .addComponent(txtcodigo))))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCorreo)
                            .addComponent(txtVendedor)
                            .addComponent(txtNFactura)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtMach, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtMachcedula, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCambiarCliente))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboxBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(txtBuscarcliente)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMach, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMachcedula, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCambiarCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtBuscarcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboxBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Productos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 24))); // NOI18N

        btnAgregar2.setBackground(new java.awt.Color(0, 204, 51));
        btnAgregar2.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btnAgregar2.setText("Añadir");
        btnAgregar2.setBorderPainted(false);
        btnAgregar2.setEnabled(false);
        btnAgregar2.setFocusable(false);
        btnAgregar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar2ActionPerformed(evt);
            }
        });

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N

        tblPorNomrbe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblPorNomrbe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPorNomrbeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPorNomrbe);

        jTabbedPane1.addTab("Por Nombre", jScrollPane1);

        PanelImagen.setBackground(new java.awt.Color(255, 255, 255));
        PanelImagen.setPreferredSize(new java.awt.Dimension(400, 32000));
        PanelImagen.setRequestFocusEnabled(false);
        PanelImagen.setLayout(null);
        jScrollPane2.setViewportView(PanelImagen);
        PanelImagen.getAccessibleContext().setAccessibleParent(jScrollPane2);

        jTabbedPane1.addTab("Por Imagen", jScrollPane2);

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel9.setText("Cant:");

        txtCantidad.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel10.setText("Precio:");

        txtprecio.setEditable(false);
        txtprecio.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N

        lblnombre.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N

        lblID.setForeground(new java.awt.Color(255, 255, 255));

        l3.setForeground(new java.awt.Color(255, 255, 255));

        l4.setForeground(new java.awt.Color(255, 255, 255));

        lblstock.setForeground(new java.awt.Color(255, 255, 255));

        txtbuscarpro.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        txtbuscarpro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscarproActionPerformed(evt);
            }
        });

        btnBuscarPro.setBackground(new java.awt.Color(0, 153, 153));
        btnBuscarPro.setText("Buscar");
        btnBuscarPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtbuscarpro)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregar2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblstock, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarPro)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lblnombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(txtprecio, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtbuscarpro)
                    .addComponent(btnBuscarPro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnAgregar2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(txtprecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(l3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(l4, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblstock, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Factura", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 24))); // NOI18N

        tblFactura.setModel(tabla);
        tblFactura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFacturaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblFactura);

        jLabel11.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel11.setText("Subtotal:");

        txtSubtotal.setEditable(false);
        txtSubtotal.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel12.setText("IVA:");

        txtIva.setEditable(false);
        txtIva.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel13.setText("Total:");

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel14.setText("Forma de Pago:");

        cboxFormaPago.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        cboxFormaPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Efectivo", "Tarjeta de Credito", "Tarjeta de Debito" }));

        jCheckBox1.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel15.setText("¿Descuento?");

        txtdescuento.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        txtdescuento.setEnabled(false);
        txtdescuento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdescuentoKeyTyped(evt);
            }
        });

        btnAgregar3.setBackground(new java.awt.Color(255, 153, 0));
        btnAgregar3.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btnAgregar3.setText("Enviar factura al correo");
        btnAgregar3.setBorderPainted(false);
        btnAgregar3.setFocusable(false);
        btnAgregar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar3ActionPerformed(evt);
            }
        });

        jRadioButton1.setBackground(new java.awt.Color(255, 255, 255));
        btngrup.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jRadioButton1.setText("En Proceso");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setBackground(new java.awt.Color(255, 255, 255));
        btngrup.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jRadioButton2.setSelected(true);
        jRadioButton2.setText("Finalizado");

        jLabel16.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel16.setText("%");

        jLabel18.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 0, 0));
        jLabel18.setText(" ");

        btnAgregar4.setBackground(new java.awt.Color(0, 204, 51));
        btnAgregar4.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btnAgregar4.setText("Imprimir Factura");
        btnAgregar4.setBorderPainted(false);
        btnAgregar4.setFocusable(false);
        btnAgregar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar4ActionPerformed(evt);
            }
        });

        btnBorrarProducto.setBackground(new java.awt.Color(255, 51, 51));
        btnBorrarProducto.setText("Borrar");
        btnBorrarProducto.setToolTipText("Cambiar Cliente");
        btnBorrarProducto.setEnabled(false);
        btnBorrarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarProductoActionPerformed(evt);
            }
        });

        lblDetalleProducto.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jCheckBox1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel15))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(txtdescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel16)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSubtotal, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                            .addComponent(txtIva)
                            .addComponent(txtTotal)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboxFormaPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jRadioButton2)
                                .addGap(39, 39, 39)
                                .addComponent(jRadioButton1)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnAgregar3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgregar4, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(lblDetalleProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBorrarProducto)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnBorrarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDetalleProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)
                        .addComponent(jLabel15))
                    .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtdescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel13)
                                .addComponent(jLabel18))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel14)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboxFormaPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton2)))
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jRadioButton3.setBackground(new java.awt.Color(255, 255, 255));
        btngrup2.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jRadioButton3.setSelected(true);
        jRadioButton3.setText("Factura con datos");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        jRadioButton4.setBackground(new java.awt.Color(255, 255, 255));
        btngrup2.add(jRadioButton4);
        jRadioButton4.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jRadioButton4.setText("Consumidor final");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jRadioButton3)
                                .addGap(39, 39, 39)
                                .addComponent(jRadioButton4)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton4)
                            .addComponent(jRadioButton3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(60, Short.MAX_VALUE))
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

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        borrarCliente();
        borrarTabla();
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void txtcodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodigoActionPerformed

    private void btnAgregar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar2ActionPerformed
        float res = Integer.parseInt(txtCantidad.getText()) * Float.parseFloat(txtprecio.getText());
        boolean estado = true;
        if (Integer.parseInt(txtCantidad.getText()) > Integer.parseInt(lblstock.getText()) && Integer.parseInt(txtCantidad.getText())>0) {
            JOptionPane.showMessageDialog(null, "No hay suficientes existencias de este producto");
        } else if (tblFactura.getRowCount() > 0) {
            for (int i = 0; i < tblFactura.getRowCount(); i++) {
                if (tblFactura.getValueAt(i, 0).equals(lblID.getText())) {
                    JOptionPane.showMessageDialog(null, "El producto ya esta en la lista");
                    estado = false;
                }
            }

        }
        if (estado) {
            Object datos[] = new Object[6];
            datos[0] = lblID.getText();
            datos[1] = lblnombre.getText();
            datos[2] = txtCantidad.getText();
            datos[3] = txtprecio.getText();
            datos[4] = res + "";
            tabla.addRow(datos);
            subtotal();
        }
    }//GEN-LAST:event_btnAgregar2ActionPerformed

    private void txtCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedulaActionPerformed

    private void btnAgregar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar3ActionPerformed
        factura_crud fc = new factura_crud();
        if (tblFactura.getRowCount()>0) {
            if (txtCorreo.getText().length()>5) {
                int formaPago = 1;
                if (cboxFormaPago.getSelectedItem() == "Efectivo") {
                    formaPago = 1;
                } else if (cboxFormaPago.getSelectedItem() == "Tajeta de Credito") {
                    formaPago = 2;
                } else if (cboxFormaPago.getSelectedItem() == "Tajeta de Debito") {
                    formaPago = 3;
                }
                if (getSelectedButtonText(btngrup2) == "Factura con datos") {
                    fc.insertarFactura(formaPago, txtcodigo.getText(),
                            Float.parseFloat(txtSubtotal.getText()), Float.parseFloat(txtIva.getText()),
                            Float.parseFloat(txtTotal.getText()), getSelectedButtonText(btngrup));
                } else {
                    fc.insertarFactura(formaPago, "null",
                            Float.parseFloat(txtSubtotal.getText()), Float.parseFloat(txtIva.getText()),
                            Float.parseFloat(txtTotal.getText()), getSelectedButtonText(btngrup));
                }
                System.out.println("filas " + tblFactura.getRowCount());
                for (int i = 0; i < tblFactura.getRowCount(); i++) {
                    
                    fc.InsertarDetalle(Integer.parseInt(tblFactura.getValueAt(i, 0) + ""), Integer.parseInt(tblFactura.getValueAt(i, 2) + ""));
                    System.out.println("id de producto" + tblFactura.getValueAt(i, 0));
                    fc.actualizarCantidad(tblFactura.getValueAt(i, 0) + "", Integer.parseInt(tblFactura.getValueAt(i, 2) + ""));
                }
                guardarPDF();
                enviarfactura();
                borrarCliente();
                borrarTabla();
                int nfactura = Integer.parseInt(txtNFactura.getText()) + 1;
                
                txtNFactura.setText(nfactura + "");
            } else {
            JOptionPane.showMessageDialog(null, "El cliente no tiene asociado ningun correo");
                
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay productos que facturar");
        }
    }//GEN-LAST:event_btnAgregar3ActionPerformed

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void txtBuscarclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarclienteActionPerformed

        if (txtMach.getText() != "" && txtMach.getText() != "No existe") {
            cliente_crud cc = new cliente_crud();
            txtCliente.setText(txtMach.getText());
            txtCedula.setText(txtMachcedula.getText());
            txtcodigo.setText(cc.llenarDatos(txtCedula.getText())[0]);
            txtDireccion.setText(cc.llenarDatos(txtCedula.getText())[3]);
            txtTelefono.setText(cc.llenarDatos(txtCedula.getText())[4]);
            txtCorreo.setText(cc.llenarDatos(txtCedula.getText())[6]);
            txtBuscarcliente.setText("");
            txtMachcedula.setText("");
            txtMach.setText("");
            txtBuscarcliente.setEnabled(false);
            cboxBuscar.setEnabled(false);
            btnCambiarCliente.setEnabled(true);

        } else {
            JOptionPane.showMessageDialog(null, "Usuario invalido");
        }
    }//GEN-LAST:event_txtBuscarclienteActionPerformed

    private void txtBuscarclienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarclienteKeyTyped
        cliente_crud cc = new cliente_crud();

        if (cboxBuscar.getSelectedItem() == "CI") {
            if (txtBuscarcliente.getText().length() < 1) {
                txtMach.setText("");
                txtMachcedula.setText("");
            } else {
                cc.buscarPorCedula(txtBuscarcliente, txtMach, txtMachcedula);
            }
            if (txtMach.getText().length() <= 0 && txtMachcedula.getText().length() <= 0) {
                txtMach.setForeground(Color.red);
                txtMach.setText("No existe");
                txtMachcedula.setText("");
            }
        } else {
            if (txtBuscarcliente.getText().length() <= 0) {
                txtMach.setText("");
                txtMachcedula.setText("");
            } else {
                cc.buscarPorNombre(txtBuscarcliente, txtMach, txtMachcedula);
            }
            if (txtMach.getText().length() <= 0 && txtMachcedula.getText().length() <= 0) {
                txtMach.setForeground(Color.red);
                txtMach.setText("No existe");
                txtMachcedula.setText("");

            }
        }
    }//GEN-LAST:event_txtBuscarclienteKeyTyped

    private void btnCambiarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarClienteActionPerformed
        txtBuscarcliente.setEnabled(true);
        cboxBuscar.setEnabled(true);
        borrarCliente();
    }//GEN-LAST:event_btnCambiarClienteActionPerformed

    private void tblPorNomrbeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPorNomrbeMouseClicked
        txtprecio.setText(tblPorNomrbe.getValueAt(tblPorNomrbe.getSelectedRow(), 2).toString());
        lblstock.setText(tblPorNomrbe.getValueAt(tblPorNomrbe.getSelectedRow(), 3).toString());
        lblnombre.setText(tblPorNomrbe.getValueAt(tblPorNomrbe.getSelectedRow(), 1).toString());
        lblID.setText(tblPorNomrbe.getValueAt(tblPorNomrbe.getSelectedRow(), 0).toString());
        txtCantidad.setText("1");
        btnAgregar2.setEnabled(true);


    }//GEN-LAST:event_tblPorNomrbeMouseClicked

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
        if (!"".equals(txtCantidad.getText()) && Integer.parseInt(txtCantidad.getText()) + 0 != 0) {
            btnAgregar2.setEnabled(true);
        }
    }//GEN-LAST:event_txtCantidadKeyTyped

    private void txtbuscarproActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscarproActionPerformed
        busqueda();
    }//GEN-LAST:event_txtbuscarproActionPerformed

    private void btnBuscarProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProActionPerformed
        busqueda();
    }//GEN-LAST:event_btnBuscarProActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if (jCheckBox1.isSelected()) {
            txtdescuento.setEnabled(true);
        } else {
            txtdescuento.setEnabled(false);
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void txtdescuentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdescuentoKeyTyped

        subtotal();
        float des = Float.parseFloat(txtdescuento.getText() + ".0");
        descuento = des / Float.valueOf(10);
        System.out.println(descuento);
        subtotal();
    }//GEN-LAST:event_txtdescuentoKeyTyped

    private void btnAgregar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar4ActionPerformed
        
        factura_crud fc = new factura_crud();
        if (tblFactura.getRowCount()>0) {
            int formaPago = 1;
            if (cboxFormaPago.getSelectedItem() == "Efectivo") {
                formaPago = 1;
            } else if (cboxFormaPago.getSelectedItem() == "Tajeta de Credito") {
                formaPago = 2;
            } else if (cboxFormaPago.getSelectedItem() == "Tajeta de Debito") {
                formaPago = 3;
            }
            if (getSelectedButtonText(btngrup2) == "Factura con datos") {
                fc.insertarFactura(formaPago, txtcodigo.getText(),
                        Float.parseFloat(txtSubtotal.getText()), Float.parseFloat(txtIva.getText()),
                        Float.parseFloat(txtTotal.getText()), getSelectedButtonText(btngrup));
            } else {
                fc.insertarFactura(formaPago, "null",
                        Float.parseFloat(txtSubtotal.getText()), Float.parseFloat(txtIva.getText()),
                        Float.parseFloat(txtTotal.getText()), getSelectedButtonText(btngrup));
            }
            for (int i = 0; i < tblFactura.getRowCount(); i++) {
                
                fc.InsertarDetalle(Integer.parseInt(tblFactura.getValueAt(i, 0) + ""), Integer.parseInt(tblFactura.getValueAt(i, 2) + ""));
                fc.actualizarCantidad(tblFactura.getValueAt(i, 0) + "", Integer.parseInt(tblFactura.getValueAt(i, 2) + ""));
            }
            guardarPDF();
            borrarCliente();
            borrarTabla();
            int nfactura = Integer.parseInt(txtNFactura.getText()) + 1;
            
            txtNFactura.setText(nfactura + "");
        } else {
            JOptionPane.showMessageDialog(null, "No ha ingresado ningun producto");
        }

    }//GEN-LAST:event_btnAgregar4ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        txtBuscarcliente.setEnabled(false);
        cboxBuscar.setEnabled(false);
        borrarCliente();
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        txtBuscarcliente.setEnabled(true);
        cboxBuscar.setEnabled(true);
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void btnBorrarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarProductoActionPerformed
        DefaultTableModel m = (DefaultTableModel) tblFactura.getModel();
        m.removeRow(tblFactura.getSelectedRow());
        btnBorrarProducto.setEnabled(true);
        lblDetalleProducto.setText("");

    }//GEN-LAST:event_btnBorrarProductoActionPerformed

    private void tblFacturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFacturaMouseClicked
        
        btnBorrarProducto.setEnabled(true);
        lblDetalleProducto.setText(tblFactura.getValueAt(tblFactura.getSelectedRow(), 1)+"");
        
    }//GEN-LAST:event_tblFacturaMouseClicked
    public void busqueda() {
        PanelImagen.removeAll();
        PanelImagen.repaint();
        pc.mostraarProductoporNombre(txtbuscarpro.getText(), tblPorNomrbe);
        pc.mostrarProductoporImagen(txtbuscarpro.getText(), PanelImagen, lblnombre, lblID, txtprecio, lblstock);
        txtbuscarpro.setText("");
    }

    public void subtotal() {
        float subtotal = 0;

        for (int i = 0; i < tblFactura.getRowCount(); i++) {

            subtotal += Float.valueOf(tblFactura.getValueAt(i, 4) + "");
        }
        if (descuento != 0) {
            subtotal = subtotal - (descuento * subtotal);

        }
        float iva = (float) (subtotal * 0.12);
        float total = subtotal + iva;
        txtSubtotal.setText(subtotal + "");
        txtIva.setText(iva + "");
        txtTotal.setText(total + "");
    }

    public String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }

    public void guardarPDF() {
        try {
                conexion con = new conexion();
                Connection conn = con.conectado();

                JasperReport reporte = null;
                String path = "src\\reportes\\DetalleFactura.jasper";

                Map parametro = new HashMap();
                parametro.put("id_factura", txtNFactura.getText());

                reporte = (JasperReport) JRLoader.loadObjectFromFile(path);

                JasperPrint jprint = JasperFillManager.fillReport(reporte, parametro, conn);

                JasperViewer view = new JasperViewer(jprint, false);

                view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

                view.setVisible(true);

            } catch (JRException ex) {
                Logger.getLogger(V_reporte_facturas.class.getName()).log(Level.SEVERE, null, ex);
            }

    }

    public void enviarfactura() {
        EnviarFactura ef = new EnviarFactura();
        ef.enviarFactura(txtCorreo.getText(), txtNFactura.getText());
    }

    public void imprimirFactura() {
        try {
            conexion con = new conexion();
            Connection conn = con.conectado();

            JasperReport reporte = null;
            String path = "src\\reportes\\DetalleFactura.jasper";

            Map parametro = new HashMap();
            parametro.put("id_factura", txtNFactura.getText());

            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);

            JasperPrint jprint = JasperFillManager.fillReport(reporte, parametro, conn);

            JasperViewer view = new JasperViewer(jprint, false);

            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

            view.setVisible(true);

        } catch (JRException ex) {
            Logger.getLogger(V_reporte_facturas.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    }
    public void borrarCliente(){
        txtcodigo.setText("");
        txtCliente.setText("");
        txtCedula.setText("");
        txtCorreo.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");
    }
    public void borrarTabla(){
        tabla.setColumnCount(0);
        tabla.setRowCount(0);
        txtSubtotal.setText("");
        txtTotal.setText("");
        txtIva.setText("");
        txtdescuento.setText("");
        tabla.setColumnCount(0);
        tabla.setRowCount(0);
        tabla.addColumn("ID");
        tabla.addColumn("Descripcion");
        tabla.addColumn("Cantidad");
        tabla.addColumn("P.U.");
        tabla.addColumn("Precio");
        tblFactura.setModel(tabla);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelImagen;
    private javax.swing.JButton btnAgregar2;
    private javax.swing.JButton btnAgregar3;
    private javax.swing.JButton btnAgregar4;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnBorrarProducto;
    private javax.swing.JButton btnBuscarPro;
    private javax.swing.JButton btnCambiarCliente;
    private javax.swing.ButtonGroup btngrup;
    private javax.swing.ButtonGroup btngrup2;
    private javax.swing.JComboBox<String> cboxBuscar;
    private javax.swing.JComboBox<String> cboxFormaPago;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel l3;
    private javax.swing.JLabel l4;
    private javax.swing.JLabel lblDetalleProducto;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblnombre;
    private javax.swing.JLabel lblstock;
    private javax.swing.JTable tblFactura;
    private javax.swing.JTable tblPorNomrbe;
    private javax.swing.JTextField txtBuscarcliente;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtIva;
    private javax.swing.JLabel txtMach;
    private javax.swing.JLabel txtMachcedula;
    private javax.swing.JTextField txtNFactura;
    private javax.swing.JTextField txtSubtotal;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtTotal;
    public javax.swing.JTextField txtVendedor;
    private javax.swing.JTextField txtbuscarpro;
    private javax.swing.JTextField txtcodigo;
    private javax.swing.JTextField txtdescuento;
    private javax.swing.JTextField txtprecio;
    // End of variables declaration//GEN-END:variables
}
