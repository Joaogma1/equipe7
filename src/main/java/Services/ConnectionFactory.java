/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    static String url = "jdbc:mysql://35.226.108.150:3306/TADSDISTRIBUIDORA";
    static String login = "aplicacao";
    static String senha = "654321";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c =  DriverManager.getConnection(url, login, senha);
            return c;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
