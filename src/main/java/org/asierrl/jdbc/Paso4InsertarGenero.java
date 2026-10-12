package org.asierrl.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;


public class Paso4InsertarGenero {

    public static void main(String[] args){
        String url = "jdbc:mariadb://localhost:3306/chinook";
        String usuario = "root";
        String clave = "";

        String sql = "INSERT INTO Genre (GenreId, Name) VALUES (?, ?)";

        try {
            Connection conexion = DriverManager.getConnection(url, usuario, clave);

            // Inic. Select Max Genre Id
            String sqlMax = "SELECT MAX(GenreId) FROM Genre";
            PreparedStatement consulta = conexion.prepareStatement(sqlMax);
            ResultSet resultado = consulta.executeQuery();

            int nuevoId = 1;
            if (resultado.next()) {
                nuevoId = resultado.getInt(1) + 1;
            }
            // Fin. Select Max Genre Id

            PreparedStatement sentencia = conexion.prepareStatement(sql);
            sentencia.setInt(1, nuevoId);
            sentencia.setString(2, "Synthwave");

            int filas = sentencia.executeUpdate();
            System.out.println(filas + " fila(s) insertada(s)");

        }catch (SQLException e){
            System.err.println("Error: " + e.getMessage());
        }
    }

}
