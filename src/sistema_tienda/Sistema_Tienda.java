/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_tienda;

import Vistas.V_login;
import Vistas.V_principal;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.UIManager;
import modelos.conexion;

/**
 *
 * @author Admin
 */
public class Sistema_Tienda extends Observable{

    /**
     * @param args the command line arguments
     */
    public Sistema_Tienda()
     {
         Timer timer = new Timer();
         timer.scheduleAtFixedRate(timerTask, 0, 1000);
     }
    public static void main(String[] args) {
        Sistema_Tienda modelo = new Sistema_Tienda();
         modelo.addObserver (new Observer()
         {
             public void update (Observable unObservable, Object dato)
             {
                 
                 System.out.println (dato);
             }
         });
        V_login v_login = new V_login();
        v_login.setVisible(true);
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     TimerTask timerTask = new TimerTask()
     {
         /**
          * Método al que Timer llamará cada segundo. Se encarga de avisar
          * a los observadores de este modelo.
          */
         public void run() 
         {
             setChanged();
             notifyObservers(new Date());
         }
     };
     
    
}
