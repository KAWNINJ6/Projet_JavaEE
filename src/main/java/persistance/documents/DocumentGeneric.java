package persistance.documents;

import mediatek2022.Utilisateur;
import persistance.dao.DocumentDAO;

public abstract class DocumentGeneric implements mediatek2022.Document {
    private int id;
    private String nom;
    protected int type;
    private boolean isDispo;
    private String emprunteur;

    public DocumentGeneric(int id, String nom, Boolean isDispo, String emprunteur) {
        this.id = id;
        this.nom = nom;
        this.isDispo = isDispo;
        this.emprunteur = emprunteur;
    }

    @Override
    public boolean disponible() {
        return isDispo;
    }

    @Override
    public void emprunt(Utilisateur u) {
        if ((emprunteur != null || !disponible())) {
            throw new AssertionError("Ce livre est déjà emprunté");
        }
        synchronized (this) {
            this.emprunteur = u.name();
            this.isDispo = false;
            new DocumentDAO().update(this.isDispo, this.emprunteur, this.id);
        }
    }

    @Override
    public void retour() {
        synchronized (this) {
            this.emprunteur = null;
            this.isDispo = true;
            new DocumentDAO().update(this.isDispo, this.emprunteur, this.id);
        }
    }

    @Override
    public String toString() {
        return id + "/" + nom + "/" + type + "/" + isDispo + "/" + emprunteur;
    }
}
