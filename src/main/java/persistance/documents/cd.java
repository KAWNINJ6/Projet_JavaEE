package persistance.documents;

public class cd extends DocumentGeneric {
    private static final int TYPE = 2;

    public cd(int id, String nom, Boolean isDispo, String emprunteur) {
        super(id, nom, isDispo, emprunteur);
        super.type = TYPE;
    }
}
