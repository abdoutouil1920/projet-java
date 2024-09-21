package tn.esprit.projet_java.services;

import tn.esprit.projet_java.interfaces.categorieface;

import tn.esprit.projet_java.models.categorie;
import tn.esprit.projet_java.utils.MyDatabase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class categorieService implements categorieface<categorie> {
    Connection cnx = MyDatabase.getInstance().getCnx();

    @Override
    public void add(categorie c) throws SQLException {
        String req = "INSERT INTO `categorie`( `type`) VALUES ('" + c.getType() + "')";
        try (Statement st = cnx.createStatement()) {
            try {
                st.executeUpdate(req);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        System.out.println("categorie Added successfully!");

    }

    @Override
    public void update(categorie c) throws SQLException {
        String req = "update categorie set type=?   where id_cate=?";
        PreparedStatement pre = cnx.prepareStatement(req);
        pre.setString(1, c.getType());
        pre.setInt(2,c.getId_cate());


        pre.executeUpdate();

    }

    @Override
    public void delete(categorie c) throws SQLException {
        String req = " delete from categorie where id_cate=?";
        PreparedStatement pre = cnx.prepareStatement(req);
        pre.setInt(1, c.getId_cate());
        pre.executeUpdate();

    }

    @Override
    public List<categorie> recupere() {
        List<categorie> categorie = new ArrayList<>();
        try {

            String req = "SELECT * FROM categorie";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                categorie e = new categorie();
                e.setId_cate(rs.getInt(1));
                e.setType(rs.getString(2));



                categorie.add(e);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return categorie;

    }




@Override
    public categorie getcategoriebyid(int id_cate) {

        categorie categorie = new categorie();
            try {
                String req = "SELECT * FROM categorie WHERE id_cate = ?";
                PreparedStatement preparedStatement = cnx.prepareStatement(req);
                preparedStatement.setInt(1, id_cate);
                ResultSet rs = preparedStatement.executeQuery();

                if (rs.next()) {

                    categorie.setType(rs.getString(2));
                }

            } catch (Exception e) {
                System.out.println("Failed to get user by id");
                e.printStackTrace();
            }
            return categorie;
        }



}

