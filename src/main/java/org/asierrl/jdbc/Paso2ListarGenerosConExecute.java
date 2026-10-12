package org.asierrl.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Paso2ListarGenerosConExecute {

    public static void main(String[] args){
        String url = "jdbc:mariadb://localhost:3306/chinook";
        String usuario = "root";
        String clave = "";

        String sql = "SELECT GenreId, Name FROM Genre ORDER BY Name";

        try {
            Connection conexion = DriverManager.getConnection(url, usuario, clave);

            Statement sentencia = conexion.createStatement();

            boolean hayResultado = sentencia.execute(sql);
            System.out.println("¿execute() devuelve un ResultSet? " + hayResultado);

            if(hayResultado){
                ResultSet resultado = sentencia.getResultSet();
                while (resultado.next()){
                    System.out.println(resultado.getInt("GenreId") + " - " +
                            resultado.getString("Name"));
                }
            }
        }catch (SQLException e){
            System.err.println("Error: " + e.getMessage());
        }
    }

}
