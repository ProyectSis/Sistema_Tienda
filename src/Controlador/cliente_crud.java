/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelos.conexion;

/**
 *
 * @author Admin
 */
public class cliente_crud {

    conexion conexion = new conexion();
    Connection cc = conexion.conectado();
    PreparedStatement preparedStatement = null;
    Statement st = null;

    public void buscarPorCedula(JTextField cedula, JLabel mach, JLabel machcedula) {
        if (cedula.getText().length() > 1) {

            String sql = "SELECT CLI_NOMBRE,CLI_CI_RUC FROM tbl_cliente where CLI_CI_RUC LIKE '%" + cedula.getText() + "%'";
            try {
                Statement st = cc.createStatement();
                ResultSet rs = st.executeQuery(sql);

                if (rs.next()) {
                    String res = rs.getString(1);
                    String res2 = rs.getString(2);

                    mach.setText(res);
                    mach.setForeground(Color.green);

                    machcedula.setText(res2);
                    machcedula.setForeground(Color.green);
                }

            } catch (SQLException e) {
                // JOptionPane.showMessageDialog(null, "Error: " + e);
                System.out.println(" " + e.getSQLState() + " " + e.getMessage());
            }
        }
    }

    public String[] llenarDatos(String text) {
        String[] registros = new String[6];

        String sql = "SELECT * FROM tbl_cliente where CLI_CI_RUC = '"+text+"'";
        try {
            Statement st = cc.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                registros[0] = rs.getString("ID_CLIENTE");
                registros[1] = rs.getString("CLI_NOMBRE");
                registros[2] = rs.getString("CLI_CI_RUC");
                registros[3] = rs.getString("CLI_DIRECCION");
                registros[4] = rs.getString("CLI_TELEFONO");
                registros[5] = rs.getString("CLI_ESTADO");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
        return registros;
    }
}
