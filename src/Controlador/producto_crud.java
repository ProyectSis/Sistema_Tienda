package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelos.conexion;

public class producto_crud {

    conexion conexion = new conexion();
    Connection cc = conexion.conectado();
    PreparedStatement preparedStatement = null;
    DefaultTableModel tabla = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int Fila, int Colum) {
            return false;
        }
    };

    public void InsertaNuevoProducto(String descripcion, int stock, float precio, float costo, String estado, int categoria, int marca) {
        String query = "INSERT INTO tbl_producto (ID_PRODUCTO,PRO_DESCRIPCION,PRO_STOCK,PRO_PRECIO,PRO_COSTO,PRO_ESTADO,ID_CATEGORIA,ID_MARCA) values (null, ?, ?, ?, ?, ?, ?, ?)";
        try {
            preparedStatement = cc.prepareStatement(query);

            preparedStatement.setString(1, descripcion);
            preparedStatement.setInt(2, stock);
            preparedStatement.setFloat(3, precio);
            preparedStatement.setFloat(4, costo);
            preparedStatement.setString(5, estado);
            preparedStatement.setInt(6, categoria);
            preparedStatement.setInt(7, marca);

            // execute insert SQL stetement
            preparedStatement.executeUpdate();

            System.out.println("Se añadio correctamente el registro");

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }
    }

    public void mostrarDatosConTableModel(JTable jTable1) {
        tabla.addColumn("ID");
        tabla.addColumn("Descripcion");
        tabla.addColumn("Costo");
        tabla.addColumn("Precio");
        tabla.addColumn("Stck");
        tabla.addColumn("Categoria");
        tabla.addColumn("Marca");
        tabla.addColumn("Estado");
        jTable1.setModel(tabla);
        String datos[] = new String[8];    //Variable que almacena los datos de la consulta
        String sql = "select * from tbl_producto";  //Consulta sql
        try {
            preparedStatement = cc.prepareStatement(sql);
            ResultSet resultado = preparedStatement.executeQuery();  //Linea que ejecuta la consulta sql y almacena los datos en resultado

            while (resultado.next()) {                                    //Bucle que recorre la consulta obtenida
                datos[0] = resultado.getInt("ID_PRODUCTO")+"";
                datos[1] = resultado.getString("PRO_DESCRIPCION");
                datos[2] = resultado.getFloat("PRO_COSTO")+"";
                datos[3] = resultado.getFloat("PRO_PRECIO")+"";
                datos[4] = resultado.getInt("PRO_STOCK")+"";
                datos[5] = resultado.getInt("ID_CATEGORIA")+"";
                datos[6] = resultado.getInt("ID_MARCA")+"";
                datos[7] = resultado.getString("PRO_ESTADO");
                tabla.addRow(datos);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar los Datos\n" + ex);
        }
    }
}
