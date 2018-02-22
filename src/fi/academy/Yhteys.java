package fi.academy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Yhteys {
    public static Connection avaaYhteys() throws SQLException, ClassNotFoundException {
        String connstr = String.format("jdbc:mysql://localhost:3306/tentti?useSSL=false");
        tarkistaAjuriluokka();
        return DriverManager.getConnection(connstr, "root" ,"salananaas");
    }
    private static void tarkistaAjuriluokka() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
    }
}
