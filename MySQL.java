
/**
 * Klasse MySQ
 *  
 *  
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MySQL {
    //Neu
    private String username;
    private String password;
    private String url;
    
    private Connection connection;
    private Properties properties;

    public MySQL() {
        this.username = "mysql";
        this.password = "goethe";
        this.url = "jdbc:mysql://10.102.8.70:3306/monopoly";
        connect();
    }
    
    private Properties getProperties() {
        if(properties == null) {
            properties = new Properties();
            properties.setProperty("user", username);
            properties.setProperty("password", password);
        }
        return properties;
    }

    public Connection connect() {
        if(connection == null) {{
                try {
                    connection = DriverManager.getConnection(url, getProperties());
                    System.out.println("Es konnte erfolgreich eine Verbindung zur Datenbank hergestellt werden");
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("Es konnte keine Verbindung zur Datenbank hergestellt werden.");
                }
            }
        }else {
            System.out.println("Es konnte keine Verbindung zur Datenbank hergestellt werden.");
        }
        return connection;
    
    }

    public void close() {
        if(connection != null) {
            try {
                connection.close();
                connection = null;
                System.out.println("Die Verbindung zur Datenbank wurde geschlossen.");
            } catch(SQLException e) {
                e.printStackTrace();
                 System.out.println("Es konnte keine Verbindung zur Datenbank geschlossen werden.");
            }
        }else {
            System.out.println("Es konnte keine Verbindung zur Datenbank geschlossen werden.");
        }
    }
    
    public Connection getConnection() {
        return connection;
    }

}
