package persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {
    /**
     * URL de connexion
     */
    private static String url = "jdbc:mysql://localhost:3306/mediatheque";

    /**
     * Nom du user
     */
    private static String user = "root";

    /**
     * Mot de passe du user
     */
    private static String passwd = "";

    /**
     * Objet Connexion
     */
    private static Connection connect;

    /**
     * Méthode qui va retourner une instance
     * ou la créer si elle n'existe pas...
     * @return  connect
     */
    public static Connection getInstance(){
        if(connect == null){
            try {
                connect = DriverManager.getConnection(url, user, passwd);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connect;
    }
}
