package Controlador;

import java.awt.Image;
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
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
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
        tabla.addColumn("Stck");
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

                ImageIcon icono = new ImageIcon(img);
                //Icon icono2 = new ImageIcon(icono.getImage().getScaledInstance(jTable1.getWidth(), jTable1.getHeight(), Image.SCALE_DEFAULT));
                datos[8] = new JLabel(icono);
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
        tabla.addColumn("Stck");
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

    public void mostrarProductoporImagen(JPanel Panel) {
        String sql = "select PRO_FOTO from tbl_producto";
        try {
            preparedStatement = cc.prepareStatement(sql);
            ResultSet resultado = preparedStatement.executeQuery();  //Linea que ejecuta la consulta sql y almacena los datos en resultado

            while (resultado.next()) {

                Blob blob = resultado.getBlob("PRO_FOTO");
                byte[] data = blob.getBytes(1, (int) blob.length());
                BufferedImage img = null;
                try {
                    img = ImageIO.read(new ByteArrayInputStream(data));
                } catch (Exception e) {
                }

                ImageIcon icono = new ImageIcon(img);
                Panel.add(new JLabel(icono));
                //Icon icono2 = new ImageIcon(icono.getImage().getScaledInstance(jTable1.getWidth(), jTable1.getHeight(), Image.SCALE_DEFAULT));
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar los Datos\n" + ex);
        }
    }
}
