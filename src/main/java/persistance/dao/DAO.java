package persistance.dao;

import persistance.DbConnect;

import java.sql.Connection;
import java.util.List;

public abstract class DAO<T> {

    public Connection connect = DbConnect.getInstance();

    /**
     * Permet de récupérer tous les objets de la table
     */
    public abstract List<T> getAll();

    /**
     * Permet de récupérer un objet via son ID
     */
    public abstract T find(int id);

    /**
     * Permet de récupérer un objet avec différent paramétre
     */
    public abstract T findObj(Object... args);

    /**
     * Permet de créer une entrée dans la base de données
     * par rapport à un objet
     */
    public abstract void create(Object... args);

    /**
     * Permet de mettre à jour les données d'une entrée dans la base
     */
    public abstract void update(Object... args);

    /**
     * Permet la suppression d'une entrée de la base
     */
    public abstract void delete(T obj);
}