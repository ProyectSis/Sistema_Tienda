/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_tienda;

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
        System.out.println("Hola xdxd");
        System.out.println("Hola Mundo");
        
        conexion con = new conexion();         //Creamos un objeto de tipo conexion
        con.conectado();                    //Mandamos a llamar el metodo conectado
        
    }
    
}
