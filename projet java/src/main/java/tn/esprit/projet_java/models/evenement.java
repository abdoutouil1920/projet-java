package tn.esprit.projet_java.models;

import java.sql.Date;

public class evenement {
    private int id_event;
    private String nom;
    private Date date;
    private categorie cate;
    private  int ID_cat;

    public categorie getCate() {
        return cate;
    }

    public void setCate(categorie cate) {
        this.cate = cate;
    }

    public evenement(int id_event, String nom, Date date) {
        this.id_event = id_event;
        this.nom = nom;
        this.date = date;

    }

    public evenement(String nom, Date date) {
        this.nom = nom;
        this.date = date;
    }

    public evenement(int id_event, String nom, Date date,int ID_cat) {
        this.id_event = id_event;
        this.nom = nom;
        this.date = date;
        this.ID_cat=ID_cat;
    }

    public evenement(String nom, Date date, int ID_cat) {
        this.nom = nom;
        this.date = date;
        this.ID_cat=ID_cat;
    }

    public evenement() {
    }

    public int getId_event() {
        return id_event;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public int getcategorie() {
        return ID_cat;
    }

    public void setCategorie(int ID_cat) {
        this.ID_cat = ID_cat;
    }

    @Override
    public String toString() {
        return "evenement{" +
                "id_event=" + id_event +
                ", nom='" + nom + '\'' +
                ", date=" + date +'\'' +
                ", categorie=" + ID_cat +
                '}';
    }
}
