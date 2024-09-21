package tn.esprit.projet_java.services;

import tn.esprit.projet_java.interfaces.CRUD;
import tn.esprit.projet_java.models.evenement;
import tn.esprit.projet_java.utils.MyDatabase;
import tn.esprit.projet_java.interfaces.categorieface;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class EvenementService implements CRUD<evenement> {
    Connection cnx= MyDatabase.getInstance().getCnx();
    @Override
    public void add(evenement e) throws SQLException, RuntimeException {

            String req = "INSERT INTO `evenement`( `nom`, `date`,`categorie`) VALUES ('" + e.getNom() + "','" + e.getDate() + "'," + e.getcategorie()+")";
        try (Statement st = cnx.createStatement()) {
            try {
                st.executeUpdate(req);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        System.out.println("Player Added successfully!");

    }

    @Override
    public void update(evenement e) throws SQLException {
        String req = "update evenement set nom=? , date=?,categorie=?  where id_even=?";
        PreparedStatement pre = cnx.prepareStatement(req);

        pre.setString(1,e.getNom());
        pre.setDate(2,e.getDate());
        pre.setInt(3,e.getcategorie());
        pre.setInt(4,e.getId_event());

        pre.executeUpdate();
    }

    @Override
    public void delete(evenement evenement) throws SQLException {
        String req = " delete from evenement where id_even=?";
        PreparedStatement pre = cnx.prepareStatement(req);
        pre.setInt(1,evenement.getId_event());
        pre.executeUpdate();
    }

    @Override
    public List<evenement> recupere() {
        List<evenement> evenement = new ArrayList<>();
        categorieface face= new categorieService() ;

        try {

            String req = "SELECT * FROM evenement";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                evenement e = new evenement();
                e.setId_event(rs.getInt(1));
                e.setNom(rs.getString(2));
                e.setDate(rs.getDate(3));
                e.setCategorie(rs.getInt(4));
                e.setCate(face.getcategoriebyid(e.getcategorie()));

                evenement.add(e);
            }

        } catch (SQLException ex) {

            ex.printStackTrace();
        }

        return evenement;

    }

}
