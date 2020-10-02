package Controlador;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import javax.swing.table.DefaultTableModel;
import modelos.TablaImagen;
import modelos.conexion;

public class producto_crud {

    conexion conexion = new conexion();
    Connection cc = conexion.conectado();
    PreparedStatement preparedStatement = null;
    Statement st = null;
    DefaultTableModel tabla = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int Fila, int Colum) {
            return false;
        }
    };

    public void InsertaNuevoProducto(String descripcion, int stock, float precio, float costo, String estado, int categoria, int marca, String ruta) {
        String query = "INSERT INTO tbl_producto (ID_PRODUCTO,PRO_DESCRIPCION,PRO_STOCK,PRO_PRECIO,PRO_COSTO,PRO_ESTADO,ID_CATEGORIA,ID_MARCA,PRO_FOTO) values (null,? , ?, ?, ?, ?, ?, ?, ?)";
        FileInputStream fi = null;

        try {
            File file = new File(ruta);
            fi = new FileInputStream(file);
            preparedStatement = cc.prepareStatement(query);

            preparedStatement.setString(1, descripcion);
            preparedStatement.setInt(2, stock);
            preparedStatement.setFloat(3, precio);
            preparedStatement.setFloat(4, costo);
            preparedStatement.setString(5, estado);
            preparedStatement.setInt(6, categoria);
            preparedStatement.setInt(7, marca);
            preparedStatement.setBinaryStream(8, fi);

            // execute insert SQL stetement
            preparedStatement.executeUpdate();

            System.out.println("Se añadio correctamente el registro");

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        } catch (FileNotFoundException ex) {
            Logger.getLogger(producto_crud.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void mostrarDatosConTableModel(JTable jTable1) {
        jTable1.setDefaultRenderer(Object.class, new TablaImagen());
        tabla.addColumn("ID");
        tabla.addColumn("Descripcion");
        tabla.addColumn("Costo");
        tabla.addColumn("Precio");
        tabla.addColumn("Stock");
        tabla.addColumn("Categoria");
        tabla.addColumn("Marca");
        tabla.addColumn("Estado");
        tabla.addColumn("Imagen");
        jTable1.setModel(tabla);
        Object datos[] = new Object[9];    //Variable que almacena los datos de la consulta
        String sql = "select * from tbl_producto";  //Consulta sql
        try {
            preparedStatement = cc.prepareStatement(sql);
            ResultSet resultado = preparedStatement.executeQuery();  //Linea que ejecuta la consulta sql y almacena los datos en resultado

            while (resultado.next()) {                                    //Bucle que recorre la consulta obtenida
                datos[0] = resultado.getInt("ID_PRODUCTO") + "";
                datos[1] = resultado.getString("PRO_DESCRIPCION");
                datos[2] = resultado.getFloat("PRO_COSTO") + "";
                datos[3] = resultado.getFloat("PRO_PRECIO") + "";
                datos[4] = resultado.getInt("PRO_STOCK") + "";
                datos[5] = resultado.getInt("ID_CATEGORIA") + "";
                datos[6] = resultado.getInt("ID_MARCA") + "";
                datos[7] = resultado.getString("PRO_ESTADO");

                Blob blob = resultado.getBlob("PRO_FOTO");
                byte[] data = blob.getBytes(1, (int) blob.length());
                BufferedImage img = null;
                try {
                    img = ImageIO.read(new ByteArrayInputStream(data));
                } catch (Exception e) {
                }
                JLabel lb = new JLabel();
                lb.setSize(40, 40);
                ImageIcon icono = new ImageIcon(img);
                Icon icono2 = new ImageIcon(icono.getImage().getScaledInstance(lb.getWidth(), lb.getHeight(), Image.SCALE_SMOOTH));
                lb.setIcon(icono2);
                datos[8] = lb;
                tabla.addRow(datos);
            }
            jTable1.setRowHeight(64);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar los Datos\n" + ex);
        }
    }

    public void buscarProducto(JTable tbl_producto, String keyword) {

        tabla.setColumnCount(0);
        tabla.setRowCount(0);
        tabla.addColumn("ID");
        tabla.addColumn("Descripcion");

        tabla.addColumn("Costo");
        tabla.addColumn("Precio");
        tabla.addColumn("Stock");
        tabla.addColumn("Categoria");
        tabla.addColumn("Marca");
        tabla.addColumn("Estado");
        tbl_producto.setModel(tabla);
        String datos[] = new String[8];    //Variable que almacena los datos de la consulta
        String sql = "SELECT * FROM tbl_producto WHERE PRO_DESCRIPCION LIKE '%" + keyword + "%'";  //Consulta sql
        try {
            st = cc.createStatement();
            ResultSet resultado = st.executeQuery(sql);  //Linea que ejecuta la consulta sql y almacena los datos en resultado

            while (resultado.next()) {                                    //Bucle que recorre la consulta obtenida
                datos[0] = resultado.getInt("ID_PRODUCTO") + "";
                datos[1] = resultado.getString("PRO_DESCRIPCION");
                datos[2] = resultado.getFloat("PRO_COSTO") + "";
                datos[3] = resultado.getFloat("PRO_PRECIO") + "";
                datos[4] = resultado.getInt("PRO_STOCK") + "";
                datos[5] = resultado.getInt("ID_CATEGORIA") + "";
                datos[6] = resultado.getInt("ID_MARCA") + "";
                datos[7] = resultado.getString("PRO_ESTADO");
                tabla.addRow(datos);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar los Datos\n" + ex);
        }
    }

    public void mostrarProductoporImagen(String kw, JPanel Panel, JLabel lbltest, JLabel lblid, JTextField lblprecio, JLabel lblstock) {

        String sql = "select ID_PRODUCTO,PRO_PRECIO,PRO_STOCK, PRO_DESCRIPCION, PRO_FOTO from tbl_producto WHERE PRO_DESCRIPCION  LIKE'%" + kw + "%'";
        try {
            preparedStatement = cc.prepareStatement(sql);
            ResultSet resultado = preparedStatement.executeQuery();  //Linea que ejecuta la consulta sql y almacena los datos en resultado
            // Panel.setLayout(null);
            int x = 50, y = 50;
            Border border = BorderFactory.createLineBorder(Color.BLUE, 5);
            while (resultado.next()) {

                String id = resultado.getString("ID_PRODUCTO");
                String nombre = resultado.getString("PRO_DESCRIPCION");
                String precio = resultado.getString("PRO_PRECIO");
                String stock = resultado.getString("PRO_STOCK");
                Blob blob = resultado.getBlob("PRO_FOTO");
                byte[] data = blob.getBytes(1, (int) blob.length());
                BufferedImage img = null;
                try {
                    img = ImageIO.read(new ByteArrayInputStream(data));
                } catch (Exception e) {
                }

                ImageIcon icono = new ImageIcon(img);
                JLabel lb = new JLabel();
                lb.setBounds(x, y, 100, 180);
                lb.setSize(100, 180);
                Icon icono2 = new ImageIcon(icono.getImage().getScaledInstance(lb.getWidth(), lb.getHeight() - 15, Image.SCALE_DEFAULT));
                lb.setIcon(icono2);
                lb.setFont(new Font("Century Gothic", Font.BOLD, 18));
                lb.setText(nombre);
                lb.setVerticalTextPosition(1);
                lb.setHorizontalTextPosition(0);
                lb.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        // you can open a new frame here as
                        // i have assumed you have declared "frame" as instance variable
                        ;
                        lbltest.setText(nombre);
                        lblid.setText(id);
                        lblprecio.setText(precio);
                        lblstock.setText(stock);

                    }
                });
                System.out.println(Panel.getWidth());
                if (x < 400) {
                    x += 170;
                } else {
                    x = 50;
                    y += 210;
                }
                System.out.println(x);
                Panel.add(lb);
                Panel.repaint();

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar los Datos\n" + ex);
        }
    }

    public void mostraarProductoporNombre(String kw, JTable tbl_producto) {
        tabla.setColumnCount(0);
        tabla.setRowCount(0);
        tabla.addColumn("ID");
        tabla.addColumn("Descripcion");
        tabla.addColumn("Precio");
        tabla.addColumn("Stock");
        tbl_producto.setModel(tabla);
        String datos[] = new String[4];    //Variable que almacena los datos de la consulta
        String sql = "SELECT ID_PRODUCTO,PRO_DESCRIPCION,PRO_PRECIO,PRo_STOCK FROM tbl_producto WHERE PRO_DESCRIPCION  LIKE '%" + kw + "%'";  //Consulta sql
        try {
            st = cc.createStatement();
            ResultSet resultado = st.executeQuery(sql);  //Linea que ejecuta la consulta sql y almacena los datos en resultado

            while (resultado.next()) {                                    //Bucle que recorre la consulta obtenida
                datos[0] = resultado.getInt("ID_PRODUCTO") + "";
                datos[1] = resultado.getString("PRO_DESCRIPCION");
                datos[2] = resultado.getFloat("PRO_PRECIO") + "";
                datos[3] = resultado.getInt("PRO_STOCK") + "";
                tabla.addRow(datos);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar los Datos\n" + ex);
        }
    }
}
