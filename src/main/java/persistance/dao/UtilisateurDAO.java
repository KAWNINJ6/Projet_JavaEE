package persistance.dao;

import mediatek2022.Utilisateur;
import persistance.UtilisateurGeneric;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UtilisateurDAO extends DAO<Utilisateur> {
    @Override
    public List<Utilisateur> getAll() {
        // future application
        return null;
    }

    @Override
    public Utilisateur find(int id) {
        // future application
        return null;
    }

    @Override
    public Utilisateur findObj(Object... args) {
        try {
            PreparedStatement prstmt = connect.prepareStatement("SELECT * FROM utilisateur WHERE login = ? AND mdp = ?");
            prstmt.setString(1, (String) args[0]);
            prstmt.setString(2, (String) args[1]);
            ResultSet res = prstmt.executeQuery();

            if (res.next()) {
                return new UtilisateurGeneric(res.getString("login"), res.getBoolean("bibliothecaire"));
            }
            prstmt.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void create(Object... args) {
        // future application
    }

    @Override
    public void update(Object... args) {
        // future application
    }

    @Override
    public void delete(Utilisateur obj) {
        // future application
    }
}
