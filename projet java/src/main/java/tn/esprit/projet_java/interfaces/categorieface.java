package tn.esprit.projet_java.interfaces;
import tn.esprit.projet_java.models.categorie;

import java.sql.SQLException;
import java.util.List;

public interface categorieface<T> {
    void add(T t) throws SQLException, RuntimeException;
    void update(T t) throws SQLException;
    void delete(T t) throws SQLException;
    List<categorie> recupere ();
    tn.esprit.projet_java.models.categorie getcategoriebyid(int id);
}
