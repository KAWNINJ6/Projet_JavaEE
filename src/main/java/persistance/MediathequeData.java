package persistance;

import mediatek2022.Document;
import mediatek2022.Mediatheque;
import mediatek2022.PersistentMediatheque;
import mediatek2022.Utilisateur;
import persistance.dao.DAO;
import persistance.dao.DocumentDAO;
import persistance.dao.UtilisateurDAO;

import java.util.List;

// classe mono-instance  dont l'unique instance est connue de la médiatheque
// via une auto-déclaration dans son bloc static

public class MediathequeData implements PersistentMediatheque {
// Jean-François Brette 01/01/2018
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

	// renvoie la liste de tous les documents disponibles de la médiathèque
	@Override
	public List<Document> tousLesDocumentsDisponibles() {
		DAO<Document> documentDao = new DocumentDAO();
		synchronized (documentDao) {
			return documentDao.getAll();
		}
	}

	// va récupérer le User dans la BD et le renvoie
	// si pas trouvé, renvoie null
	@Override
	public Utilisateur getUser(String login, String password) {
		DAO<Utilisateur> utilisateurDao = new UtilisateurDAO();
		synchronized (utilisateurDao) {
			return utilisateurDao.findObj(login, password);
		}
	}

	// va récupérer le document de numéro numDocument dans la BD
	// et le renvoie
	// si pas trouvé, renvoie null
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
