

package modelos;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class conexion {
    private final String hostname ="tienda-db.cftnpf71qyzx.us-east-1.rds.amazonaws.com"; //Direccion de la base de datos
    //private final String url = "jdbc:mysql://"+hostname+":3306/tienda?user=root&password=12345678"; //Direccion de la  coneccion
    private final String url ="jdbc:mysql://tienda.mysql.database.azure.com:3306/tienda?useSSL=true&requireSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"; 
    //myDbConn = DriverManager.getConnection(url, "admin123@tienda", {Tango2000.});
    PreparedStatement prepareStatement;
    Connection conn = null;
    
     public conexion() {
     try{   //Inicio del try
         
         Class.forName("com.mysql.cj.jdbc.Driver");     //Con el metodo de la clase forName, le pasamos el driver de MySQL para que lo cargue    
         conn = DriverManager.getConnection(url, "admin123@tienda","Tango2000.");    //Apuntamos nuestro objeto con a el intento de conectarse con los parametros o las credenciales que tenemos en MYSQL
        //Aqui mandamos la url donde viene la direccion de la BD, nuestro nombre de usuario y la contraseña, que por defecto al instalar viene vacia
        if (conn!=null){                         //Si logramos conectarnos, con deja de apuntar a null y obtenemos conexion
                          //Sin funciona imprimimos en consola un mensaje
         }
      }//cerramos el try
         catch(SQLException | ClassNotFoundException e)        //Agarramos excepciones de tipo SQL
         {
         System.out.println(e);          //las mostramos en consola
         }
        //las mostramos en consola
        //agarramos excepciones de tipo clase en java
        

    }
     public Connection conectado(){  //Este metodo de tipo Connection nos devuelve el estado del objeto
      return conn;
}

    public void desconectar(){     //Por seguridad, cuando terminemos sentencias, cerramos la conexion o si la necesitamos cerrar por otro caso
      conn = null;                  //Ahora de nuevo con sera null
      System.out.println("La conexion la BD se ha cerrado");

    } 
    
}
