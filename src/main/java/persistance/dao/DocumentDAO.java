package persistance.dao;

import mediatek2022.Document;
import persistance.documents.cd;
import persistance.documents.livre;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DocumentDAO extends DAO<Document> {

    @Override
    public List<Document> getAll() {
        List<Document> listDocs = new ArrayList<>();

        try {
            PreparedStatement prstmt = connect.prepareStatement("SELECT * FROM document");
            ResultSet res = prstmt.executeQuery();

            while (res.next()) {
                switch (res.getInt("type")){
                    case 1:
                        listDocs.add(new livre(res.getInt("id"),
                                res.getString("nom"),
                                res.getBoolean("disponible"),
                                res.getString("emprunteur")));
                        break;
                    case 2:
                        listDocs.add(new cd(res.getInt("id"),
                                res.getString("nom"),
                                res.getBoolean("disponible"),
                                res.getString("emprunteur")));
                        break;
                    default:
                        break;
                }

            }
            prstmt.close();
            return listDocs;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Document find(int id) {
        try {
            PreparedStatement prstmt = connect.prepareStatement("SELECT * FROM document WHERE id = ?");
            prstmt.setInt(1, id);
            ResultSet res = prstmt.executeQuery();
            if (res.next()) {
                switch (res.getInt("type")){
                    case 1:
                        return new livre(res.getInt("id"),
                                res.getString("nom"),
                                res.getBoolean("disponible"),
                                res.getString("emprunteur"));
                    case 2:
                        return new cd(res.getInt("id"),
                                res.getString("nom"),
                                res.getBoolean("disponible"),
                                res.getString("emprunteur"));
                }
            }
            res.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Document findObj(Object... args) {
        // future application
        return null;
    }

    @Override
    public void create(Object... args) {
        try {
            PreparedStatement prstmt = connect.prepareStatement("INSERT INTO document (nom, type) VALUES (?, ?)");
            prstmt.setString(1, (String) args[0]);
            prstmt.setInt(2, (int) args[1]);
            prstmt.executeUpdate();
            prstmt.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Object... args) {
        try {
            PreparedStatement prstmt = connect.prepareStatement("UPDATE document SET disponible = ?, emprunteur = ? WHERE id = ?");
            prstmt.setBoolean(1, (boolean) args[0]);
            prstmt.setString(2, (String) args[1]);
            prstmt.setInt(3, (int) args[2]);
            prstmt.executeUpdate();
            prstmt.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(Document obj) {
        // future application
    }
}
