package tn.esprit.projet_java.models;

public class categorie {
    private int id_cate;
    private String type;

    public categorie(int id_cate, String type) {
        this.id_cate = id_cate;
        this.type = type;
    }

    public categorie(String type) {
        this.type = type;
    }

    public categorie() {
    }

    public int getId_cate() {
        return id_cate;
    }

    public void setId_cate(int id_cate) {
        this.id_cate = id_cate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "categorie{" +
                " type='" + type + '\'' +
                '}';
    }
}
