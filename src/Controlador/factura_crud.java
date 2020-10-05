package Controlador;

import Vistas.V_principal;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelos.conexion;
import modelos.ingreso;

public class factura_crud {

    ingreso i = new ingreso();
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

    public void insertarFactura(int formaPago, String idCliente, float subTotal, float iva, float total, String estado) {
        System.out.println(i.getId());
        if (idCliente == "null") {
            String test = "INSERT INTO `tienda`.`tbl_factura` (`ID_FACTURA`, `ID_FORMA_PAGO`,  `FACT_FECHA`, `FACT_SUB_TOTAL`, `FACT_IVA`, `FACT_TOTAL`, `ID_VENDEDOR`, `FACT_ESTADO`)";
            String query = "INSERT INTO `tienda`.`tbl_factura` "
                    + "(`ID_FACTURA`, `ID_FORMA_PAGO`, `FACT_FECHA`, "
                    + "`FACT_SUB_TOTAL`, `FACT_IVA`, `FACT_TOTAL`, `ID_VENDEDOR`, `FACT_ESTADO`) values "
                    + "(null,? , ?, ?, ?, ?, ?, ?);";

            try {
                preparedStatement = cc.prepareStatement(query);

                preparedStatement.setInt(1, formaPago);
                preparedStatement.setString(2, getFechaActual());
                preparedStatement.setFloat(3, subTotal);
                preparedStatement.setFloat(4, iva);
                preparedStatement.setFloat(5, total);
                preparedStatement.setInt(6, Integer.parseInt(V_principal.lblID.getText()));
                preparedStatement.setString(7, estado);

                // execute insert SQL stetement
                preparedStatement.executeUpdate();

                JOptionPane.showMessageDialog(null, "Se añadio correctamente la factura");

            } catch (SQLException e) {

                JOptionPane.showMessageDialog(null, (e.getMessage()));

            }
        } else {
            String query = "INSERT INTO `tienda`.`tbl_factura` "
                    + "(`ID_FACTURA`, `ID_FORMA_PAGO`, `ID_CLIENTE`, `FACT_FECHA`, "
                    + "`FACT_SUB_TOTAL`, `FACT_IVA`, `FACT_TOTAL`, `ID_VENDEDOR`, `FACT_ESTADO`) values "
                    + "(null,? , ?, ?, ?, ?, ?, ?, ?);";

            try {
                preparedStatement = cc.prepareStatement(query);

                preparedStatement.setInt(1, formaPago);
                preparedStatement.setString(2, idCliente);
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
    }

    public void InsertarDetalle(int idProducto, int cantidad) {
        String query = "INSERT INTO tbl_factura_producto (ID_FACTURA,ID_PRODUCTO,DET_CANTIDAD) values ('" + getIdFactura() + "','" + idProducto + "','" + cantidad + "')";

        try {

            preparedStatement = cc.prepareStatement(query);

            // execute insert SQL stetement
            preparedStatement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Se añadio correctamente el detalle");

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "error al detalle" + (e.getMessage()));

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

    public void mostrarFacturas(JTable tbl_facturas, String filtro) {
        tabla.setColumnCount(0);
        tabla.setRowCount(0);
        tabla.addColumn("ID");
        tabla.addColumn("Cliente");
        tabla.addColumn("Fecha");
        tabla.addColumn("Subtotal");
        tabla.addColumn("Iva");
        tabla.addColumn("Total");
        tabla.addColumn("Estado");
        tabla.addColumn("Forma de Pago");
        tabla.addColumn("Vendedor");
        tbl_facturas.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tbl_facturas.getTableHeader().setOpaque(false);
        tbl_facturas.getTableHeader().setBackground(new Color(32, 136, 203));
        tbl_facturas.getTableHeader().setForeground(new Color(255, 255, 255));
        tbl_facturas.setRowHeight(25);
        tbl_facturas.setModel(tabla);
        String datos[] = new String[9];    //Variable que almacena los datos de la consulta

        String sql = null;
        if (filtro == "") {
            sql = "SELECT\n"
                    + "     tbl_factura.`FACT_FECHA` AS FECHA,\n"
                    + "     tbl_factura.`FACT_SUB_TOTAL` AS SUBTOTAL,\n"
                    + "     tbl_factura.`FACT_IVA` AS IVA,\n"
                    + "     tbl_factura.`FACT_TOTAL` AS TOTAL,\n"
                    + "     tbl_factura.`FACT_ESTADO` AS ESTADO,\n"
                    + "     tbl_forma_pago.`FP_DESCRIPCION` AS DESCRIPCION,\n"
                    + "     tbl_cliente.`CLI_NOMBRE` AS CLIENTE,\n"
                    + "     tbl_vendedor.`VEN_NOMBRE` AS VENDEDOR,\n"
                    + "     tbl_factura.`ID_FACTURA` AS ID\n"
                    + "FROM\n"
                    + "     `tbl_forma_pago` tbl_forma_pago INNER JOIN `tbl_factura` tbl_factura ON tbl_forma_pago.`ID_FORMA_PAGO` = tbl_factura.`ID_FORMA_PAGO`\n"
                    + "     LEFT JOIN `tbl_cliente` tbl_cliente ON tbl_factura.`ID_CLIENTE` = tbl_cliente.`ID_CLIENTE`\n"
                    + "     INNER JOIN `tbl_vendedor` tbl_vendedor ON tbl_factura.`ID_VENDEDOR` = tbl_vendedor.`ID_VENDEDOR`";  //Consulta sql
        } else if (filtro == "Por dia") {
            sql = "SELECT\n"
                    + "     tbl_factura.`FACT_FECHA` AS FECHA,\n"
                    + "     tbl_factura.`FACT_SUB_TOTAL` AS SUBTOTAL,\n"
                    + "     tbl_factura.`FACT_IVA` AS IVA,\n"
                    + "     tbl_factura.`FACT_TOTAL` AS TOTAL,\n"
                    + "     tbl_factura.`FACT_ESTADO` AS ESTADO,\n"
                    + "     tbl_forma_pago.`FP_DESCRIPCION` AS DESCRIPCION,\n"
                    + "     tbl_cliente.`CLI_NOMBRE` AS CLIENTE,\n"
                    + "     tbl_vendedor.`VEN_NOMBRE` AS VENDEDOR,\n"
                    + "     tbl_factura.`ID_FACTURA` AS ID\n"
                    + "FROM\n"
                    + "     `tbl_forma_pago` tbl_forma_pago INNER JOIN `tbl_factura` tbl_factura ON tbl_forma_pago.`ID_FORMA_PAGO` = tbl_factura.`ID_FORMA_PAGO`\n"
                    + "     LEFT JOIN `tbl_cliente` tbl_cliente ON tbl_factura.`ID_CLIENTE` = tbl_cliente.`ID_CLIENTE`\n"
                    + "     INNER JOIN `tbl_vendedor` tbl_vendedor ON tbl_factura.`ID_VENDEDOR` = tbl_vendedor.`ID_VENDEDOR`\n"
                    + "WHERE\n"
                    + "	FACT_FECHA BETWEEN CURDATE() AND DATE_ADD(CURDATE(),INTERVAL 1 DAY)";
        } else if (filtro == "Por mes") {
            sql = "SELECT\n"
                    + "     tbl_factura.`FACT_FECHA` AS FECHA,\n"
                    + "     tbl_factura.`FACT_SUB_TOTAL` AS SUBTOTAL,\n"
                    + "     tbl_factura.`FACT_IVA` AS IVA,\n"
                    + "     tbl_factura.`FACT_TOTAL` AS TOTAL,\n"
                    + "     tbl_factura.`FACT_ESTADO` AS ESTADO,\n"
                    + "     tbl_forma_pago.`FP_DESCRIPCION` AS DESCRIPCION,\n"
                    + "     tbl_cliente.`CLI_NOMBRE` AS CLIENTE,\n"
                    + "     tbl_vendedor.`VEN_NOMBRE` AS VENDEDOR,\n"
                    + "     tbl_factura.`ID_FACTURA` AS ID\n"
                    + "FROM\n"
                    + "     `tbl_forma_pago` tbl_forma_pago INNER JOIN `tbl_factura` tbl_factura ON tbl_forma_pago.`ID_FORMA_PAGO` = tbl_factura.`ID_FORMA_PAGO`\n"
                    + "     LEFT JOIN `tbl_cliente` tbl_cliente ON tbl_factura.`ID_CLIENTE` = tbl_cliente.`ID_CLIENTE`\n"
                    + "     INNER JOIN `tbl_vendedor` tbl_vendedor ON tbl_factura.`ID_VENDEDOR` = tbl_vendedor.`ID_VENDEDOR`\n"
                    + "WHERE\n"
                    + "    FACT_FECHA BETWEEN  LAST_DAY(DATE_SUB(NOW(),INTERVAL 1 MONTH)) AND CURDATE()";
        } else if (filtro == "Por año") {
            sql = "SELECT\n"
                    + "     tbl_factura.`FACT_FECHA` AS FECHA,\n"
                    + "     tbl_factura.`FACT_SUB_TOTAL` AS SUBTOTAL,\n"
                    + "     tbl_factura.`FACT_IVA` AS IVA,\n"
                    + "     tbl_factura.`FACT_TOTAL` AS TOTAL,\n"
                    + "     tbl_factura.`FACT_ESTADO` AS ESTADO,\n"
                    + "     tbl_forma_pago.`FP_DESCRIPCION` AS DESCRIPCION,\n"
                    + "     tbl_cliente.`CLI_NOMBRE` AS CLIENTE,\n"
                    + "     tbl_vendedor.`VEN_NOMBRE` AS VENDEDOR,\n"
                    + "     tbl_factura.`ID_FACTURA` AS ID\n"
                    + "FROM\n"
                    + "     `tbl_forma_pago` tbl_forma_pago INNER JOIN `tbl_factura` tbl_factura ON tbl_forma_pago.`ID_FORMA_PAGO` = tbl_factura.`ID_FORMA_PAGO`\n"
                    + "     LEFT JOIN `tbl_cliente` tbl_cliente ON tbl_factura.`ID_CLIENTE` = tbl_cliente.`ID_CLIENTE`\n"
                    + "     INNER JOIN `tbl_vendedor` tbl_vendedor ON tbl_factura.`ID_VENDEDOR` = tbl_vendedor.`ID_VENDEDOR`\n"
                    + "WHERE\n"
                    + "      FACT_FECHA BETWEEN LAST_DAY(DATE_SUB(NOW(),INTERVAL 1 YEAR))  AND CURDATE();";
        }

        try {
            st = cc.createStatement();
            ResultSet resultado = st.executeQuery(sql);  //Linea que ejecuta la consulta sql y almacena los datos en resultado

            while (resultado.next()) {                                    //Bucle que recorre la consulta obtenida
                datos[0] = resultado.getInt("ID") + "";
                datos[1] = resultado.getString("CLIENTE") + "";
                datos[2] = resultado.getString("FECHA");
                datos[3] = resultado.getString("SUBTOTAL") + "";
                datos[4] = resultado.getString("IVA") + "";
                datos[5] = resultado.getString("TOTAL") + "";
                datos[6] = resultado.getString("ESTADO") + "";
                datos[7] = resultado.getString("DESCRIPCION") + "";
                datos[8] = resultado.getString("VENDEDOR");
                tabla.addRow(datos);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar los Datos\n" + ex);
        }
    }

    public void mostrarDetaalle(JTable tbl_Detalle, JTextField Nombre, JTextField Correo, JTextField ruc, JTextField telefono,
            JTextField cuidad, JTextField formaPago, JTextField estado, JTextField Vendedor, JTextField fecha, JTextField subtotal, JTextField iva, JTextField totall, JTextField CFactura) {
        tabla.setColumnCount(0);
        tabla.setRowCount(0);
        tabla.addColumn("ID");
        tabla.addColumn("Descripcion");
        tabla.addColumn("Cantidad");
        tabla.addColumn("ppu");
        tabla.addColumn("pvp");
        tbl_Detalle.setModel(tabla);

        String datos[] = new String[5];

        String sql = "SELECT\n"
                + "     tbl_factura_producto.`DET_CANTIDAD` AS CANTIDAD,\n"
                + "     tbl_producto.`PRO_DESCRIPCION` AS DESCRIPCION,\n"
                + "     tbl_producto.`PRO_PRECIO` AS PRECIO,\n"
                + "     tbl_factura_producto.`ID_FACTURA` AS ID_FACTURA,\n"
                + "     tbl_factura.`FACT_FECHA` AS FECHA,\n"
                + "     tbl_factura.`FACT_SUB_TOTAL` AS SUB_TOTAL,\n"
                + "     tbl_factura.`FACT_IVA` AS IVA,\n"
                + "     tbl_factura.`FACT_TOTAL` AS TOTAL,\n"
                + "     tbl_factura.`FACT_ESTADO` AS ESTADO,\n"
                + "     tbl_forma_pago.`FP_DESCRIPCION` AS FORMA_PAGO,\n"
                + "     tbl_vendedor.`VEN_NOMBRE` AS NVENDEDOR,\n"
                + "     tbl_cliente.`CLI_NOMBRE` AS NOMBRE,\n"
                + "     tbl_cliente.`CLI_CI_RUC` AS RUC,\n"
                + "     tbl_cliente.`CLI_DIRECCION` AS DIRECCION,\n"
                + "     tbl_cliente.`CLI_TELEFONO` AS TELEFONO,\n"
                + "     tbl_cliente.`CLI_CORREO` AS CORREO,\n"
                + "     tbl_factura_producto.`ID_PRODUCTO` AS ID_PRODUCTO\n"
                + "FROM\n"
                + "     `tbl_factura_producto` tbl_factura_producto INNER JOIN `tbl_producto` tbl_producto ON tbl_factura_producto.`ID_PRODUCTO` = tbl_producto.`ID_PRODUCTO`\n"
                + "     INNER JOIN `tbl_factura` tbl_factura ON tbl_factura_producto.`ID_FACTURA` = tbl_factura.`ID_FACTURA`\n"
                + "     INNER JOIN `tbl_forma_pago` tbl_forma_pago ON tbl_factura.`ID_FORMA_PAGO` = tbl_forma_pago.`ID_FORMA_PAGO`\n"
                + "     INNER JOIN `tbl_vendedor` tbl_vendedor ON tbl_factura.`ID_VENDEDOR` = tbl_vendedor.`ID_VENDEDOR`\n"
                + "     LEFT JOIN `tbl_cliente` tbl_cliente ON tbl_factura.`ID_CLIENTE` = tbl_cliente.`ID_CLIENTE`\n"
                + "WHERE\n"
                + "     tbl_factura_producto.`ID_FACTURA` = '" + CFactura.getText() + "'";
        try {
            System.out.println(CFactura.getText());
            st = cc.createStatement();
            ResultSet resultado = st.executeQuery(sql);  //Linea que ejecuta la consulta sql y almacena los datos en resultado

            while (resultado.next()) {                                    //Bucle que recorre la consulta obtenida
                datos[0] = resultado.getInt("ID_PRODUCTO") + "";
                datos[1] = resultado.getString("DESCRIPCION") + "";
                datos[2] = resultado.getString("CANTIDAD");
                datos[3] = resultado.getString("PRECIO") + "";
                float total = Float.parseFloat(datos[3]) * Float.parseFloat(datos[2]);
                datos[4] = total + "";
                tabla.addRow(datos);

                Nombre.setText(resultado.getString("NOMBRE"));
                ruc.setText(resultado.getString("RUC"));
                telefono.setText(resultado.getString("TELEFONO"));
                cuidad.setText(resultado.getString("DIRECCION"));
                formaPago.setText(resultado.getString("FORMA_PAGO"));
                estado.setText(resultado.getString("ESTADO"));
                Vendedor.setText(resultado.getString("NVENDEDOR"));
                fecha.setText(resultado.getString("FECHA"));
                subtotal.setText(resultado.getString("SUB_TOTAL"));
                iva.setText(resultado.getString("IVA"));
                totall.setText(resultado.getString("TOTAL"));
                Correo.setText(resultado.getString("CORREO"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar los Datos\n" + ex);
        }

    }

    public void actualizarCantidad(String id_producto, int menos) {
        int cantidadA = getCantidad(id_producto) - menos;
        String sql = "UPDATE tbl_producto SET PRO_STOCK= " + cantidadA + " WHERE ID_PRODUCTO=" + id_producto;
        try {
            PreparedStatement ps = cc.prepareStatement(sql);
            ps.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
        }

    }

    public int getCantidad(String idP) {
        int cantidad = 0;
        String sql = "SELECT PRO_STOCK FROM tbl_producto WHERE ID_PRODUCTO = " + idP;
        try {
            preparedStatement = cc.prepareStatement(sql);
            ResultSet resultado = preparedStatement.executeQuery();  //Linea que ejecuta la consulta sql y almacena los datos en resultado

            while (resultado.next()) {
                cantidad = resultado.getInt(1);
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return cantidad;
    }
}
