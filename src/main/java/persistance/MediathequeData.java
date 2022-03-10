package persistance;

import mediatek2022.Document;
import mediatek2022.Mediatheque;
import mediatek2022.PersistentMediatheque;
import mediatek2022.Utilisateur;
import persistance.dao.DAO;
import persistance.dao.DocumentDAO;
import persistance.dao.UtilisateurDAO;

import java.util.List;

// classe mono-instance  dont l'unique instance est connue de la m�diatheque
// via une auto-d�claration dans son bloc static

public class MediathequeData implements PersistentMediatheque {
// Jean-Fran�ois Brette 01/01/2018
	private static PersistentMediatheque instance;

	static {
		MediathequeData instance = new MediathequeData();
		Mediatheque.getInstance().setData(instance);
	}

	public static PersistentMediatheque getInstance() {
		return instance;
	}

	private MediathequeData() {
	}

	// renvoie la liste de tous les documents disponibles de la m�diath�que
	@Override
	public List<Document> tousLesDocumentsDisponibles() {
		DAO<Document> documentDao = new DocumentDAO();
		synchronized (documentDao) {
			return documentDao.getAll();
		}
	}

	// va r�cup�rer le User dans la BD et le renvoie
	// si pas trouv�, renvoie null
	@Override
	public Utilisateur getUser(String login, String password) {
		DAO<Utilisateur> utilisateurDao = new UtilisateurDAO();
		synchronized (utilisateurDao) {
			return utilisateurDao.findObj(login, password);
		}
	}

	// va r�cup�rer le document de num�ro numDocument dans la BD
	// et le renvoie
	// si pas trouv�, renvoie null
	@Override
	public Document getDocument(int numDocument) {
		DAO<Document> documentDao = new DocumentDAO();
		synchronized (documentDao) {
			return documentDao.find(numDocument);
		}
	}

	@Override
	public void ajoutDocument(int type, Object... args) {
		DAO<Document> documentDao = new DocumentDAO();
		synchronized (documentDao) {
			documentDao.create(args[0], type);
		}
	}

}
