package Controlador;

import Vistas.V_principal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import modelos.conexion;
import modelos.ingreso;

public class factura_crud {

    ingreso i = new ingreso();
    conexion conexion = new conexion();
    Connection cc = conexion.conectado();
    PreparedStatement preparedStatement = null;
    Statement st = null;

    public void insertarFactura(int formaPago, int idCliente, float subTotal, float iva, float total, String estado) {
        System.out.println(i.getId());
        String test = "INSERT INTO `tienda`.`tbl_factura` (`ID_FACTURA`, `ID_FORMA_PAGO`, `ID_CLIENTE`, `FACT_FECHA`, `FACT_SUB_TOTAL`, `FACT_IVA`, `FACT_TOTAL`, `ID_VENDEDOR`, `FACT_ESTADO`)";
        String query = "INSERT INTO `tienda`.`tbl_factura` "
                + "(`ID_FACTURA`, `ID_FORMA_PAGO`, `ID_CLIENTE`, `FACT_FECHA`, "
                + "`FACT_SUB_TOTAL`, `FACT_IVA`, `FACT_TOTAL`, `ID_VENDEDOR`, `FACT_ESTADO`) values "
                + "(null,? , ?, ?, ?, ?, ?, ?, ?);";

        try {
            preparedStatement = cc.prepareStatement(query);

            preparedStatement.setInt(1, formaPago);
            preparedStatement.setInt(2, idCliente);
            preparedStatement.setString(3, getFechaActual());
            preparedStatement.setFloat(4, subTotal);
            preparedStatement.setFloat(5, iva);
            preparedStatement.setFloat(6, total);
            preparedStatement.setInt(7, Integer.parseInt(V_principal.lblID.getText()));
            preparedStatement.setString(8, estado);

            // execute insert SQL stetement
            preparedStatement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Se añadio correctamente la factura");

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, (e.getMessage()));

        }
    }

    public void InsertarDetalle(int idProducto,int cantidad) {
        String query = "INSERT INTO tbl_factura_producto (ID_FACTURA,ID_PRODUCTO,DET_CANTIDAD) values ('"+getIdFactura()+"','"+idProducto+"','"+cantidad+"')";

        try {
            
            preparedStatement = cc.prepareStatement(query);


            // execute insert SQL stetement
            preparedStatement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Se añadio correctamente el detalle");

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null,"error al detalle"+ (e.getMessage()));

        }
    }

    public int getIdFactura() {
        int id = 0;
        String sql = "SELECT ID_FACTURA FROM tbl_factura ORDER by ID_FACTURA DESC LIMIT 1";
        try {
            preparedStatement = cc.prepareStatement(sql);
            ResultSet resultado = preparedStatement.executeQuery();  //Linea que ejecuta la consulta sql y almacena los datos en resultado

            while (resultado.next()) {
                id = resultado.getInt(1);
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return id;
    }

    public static String getFechaActual() {
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
        return formateador.format(ahora);
    }

}
