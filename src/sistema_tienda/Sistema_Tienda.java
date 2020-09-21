/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_tienda;

import Vistas.V_login;
import javax.swing.UIManager;
import modelos.conexion;

/**
 *
 * @author Admin
 */
public class Sistema_Tienda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        V_login v_login = new V_login();
        v_login.setVisible(true);
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
