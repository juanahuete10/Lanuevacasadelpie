/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author personal
 */
public class Conexion {
  private final String
url="jdbc:sqlserver://localhost:1433;databaseName=CasaDelPie2;"
+ "integratedSecurity=true;" +
"encrypt=true;trustServerCertificate=true; user=ge; password=123";

Connection cn;
public Connection conectar(){
try {
     cn = (Connection) DriverManager.getConnection(url);
     System.out.println("Conexion establecida");
     return cn;
} catch (SQLException e) {
     System.out.println("Error en la conexión: "+e);
}
return null;
}  
}
