/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Administrador
 */
public class ConnectionFactory {

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://35.226.108.150:3306/TADSDISTRIBUIDORA", "aplicacao", "senhadificil");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
