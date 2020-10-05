package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelos.conexion;

public class categoria_crud {
    DefaultTableModel tabla = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int Fila, int Colum) {
            return false;
        }
    };
    conexion conexion = new conexion();
    Connection cc = conexion.conectado();
    PreparedStatement preparedStatement = null;
    Statement st = null;
    public void llenarComboboxCategoria(JComboBox cbox_categoria) {

//Creamos objeto tipo Connection    
        ResultSet result = null;

//Creamos la Consulta SQL
        String SSQL = "SELECT CAT_DESCRIPCION FROM tbl_categoria ";

//Establecemos bloque try-catch-finally
        try {

            //Establecemos conexión con la BD 
            //Preparamos la consulta SQL
            preparedStatement = cc.prepareStatement(SSQL);
            //Ejecutamos la consulta
            result = preparedStatement.executeQuery();

            //LLenamos nuestro ComboBox
            cbox_categoria.addItem("Seleccione...");

            while (result.next()) {

                cbox_categoria.addItem(result.getString("CAT_DESCRIPCION"));

            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);

        } 

    }

    public void mostrarDatosConTableModel(JTable jTable1) {
        tabla.setColumnCount(0);
        tabla.setRowCount(0);
        tabla.addColumn("ID");
        tabla.addColumn("Descripcion");
        jTable1.setModel(tabla);
        String datos[] = new String[2];    //Variable que almacena los datos de la consulta
            String sql = "select * from tbl_categoria";  //Consulta sql
        try {
            preparedStatement = cc.prepareStatement(sql);
            ResultSet resultado = preparedStatement.executeQuery();  //Linea que ejecuta la consulta sql y almacena los datos en resultado

            while (resultado.next()) {                                    //Bucle que recorre la consulta obtenida
                datos[0] = resultado.getString("ID_CATEGORIA");
                datos[1] = resultado.getString("CAT_DESCRIPCION");
                tabla.addRow(datos);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar los Datos\n" + ex);
        }
    }
    
    public void buscarCategoria(JTable tbl_categoria, String keyword){
        
        tabla.setColumnCount(0);
        tabla.setRowCount(0);
        tabla.addColumn("ID");
        tabla.addColumn("Descripcion");
        tbl_categoria.setModel(tabla);
        String datos[] = new String[2];    //Variable que almacena los datos de la consulta
            String sql = "SELECT * FROM tbl_categoria WHERE cat_descripcion LIKE '%"+keyword+"%'";  //Consulta sql
        try {
            st = cc.createStatement();
            ResultSet resultado = st.executeQuery(sql);  //Linea que ejecuta la consulta sql y almacena los datos en resultado

            while (resultado.next()) {                                    //Bucle que recorre la consulta obtenida
                datos[0] = resultado.getString("ID_CATEGORIA");
                datos[1] = resultado.getString("CAT_DESCRIPCION");
                tabla.addRow(datos);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar los Datos\n" + ex);
        }
    }
    
    public void nuevaCategoria(String descripcion){
    
    String query = "INSERT INTO tbl_categoria (ID_CATEGORIA,CAT_DESCRIPCION) values (null,?)";
        
        try {
            preparedStatement = cc.prepareStatement(query);

            preparedStatement.setString(1, descripcion);

            // execute insert SQL stetement
            preparedStatement.executeUpdate();

            JOptionPane.showMessageDialog(null,"Se añadio correctamente el registro");

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }
    }
}
