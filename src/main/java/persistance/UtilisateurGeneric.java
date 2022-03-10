package persistance;

/*
 * Future class abstract ou Interface (mais pas necessaire pour ce projet)
 */
public class UtilisateurGeneric implements mediatek2022.Utilisateur {
    private String login;
    private boolean isBiblio;

    public UtilisateurGeneric(String login, boolean isBiblio) {
        this.login = login;
        this.isBiblio = isBiblio;
    }

    @Override
    public String name() {
        return this.login;
    }

    @Override
    public boolean isBibliothecaire() {
        return this.isBiblio;
    }

    @Override
    public Object[] data() {
        return new Object[0];
    }

    @Override
    public String toString() {
        return login + "/" + isBiblio;
    }
}
