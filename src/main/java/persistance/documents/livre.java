package persistance.documents;

public class livre extends DocumentGeneric {
    private static final int TYPE = 1;

    public livre(int id, String nom, Boolean isDispo, String emprunteur) {
        super(id, nom, isDispo, emprunteur);
        super.type = TYPE;
    }
}
