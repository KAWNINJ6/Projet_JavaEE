package persistance;

import mediatek2022.Document;
import mediatek2022.Mediatheque;
import org.junit.jupiter.api.Test;

class MediathequeDataTest {

    @Test
    public void test() {
        try {
            Class.forName("persistance.MediathequeData");

            Mediatheque.getInstance().ajoutDocument(1, "Unlivre");

            System.out.println("Method getDocument() : " + Mediatheque.getInstance().getDocument(4).toString());

            System.out.println("Method tousLesDocumentsDisponibles() : ");
            for (Document d : Mediatheque.getInstance().tousLesDocumentsDisponibles()) {
                System.out.println(d.toString());
            }

            System.out.println("Method getUser() : ");
            System.out.println(Mediatheque.getInstance().getUser("rootB", "rootB").toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}