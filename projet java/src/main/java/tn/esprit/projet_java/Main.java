package tn.esprit.projet_java;

import tn.esprit.projet_java.services.EvenementService;
import tn.esprit.projet_java.services.categorieService;


public class Main {
    public static void main(String[] args) {
        EvenementService es=new EvenementService();
       // evenement as=new evenement(1,"es",new Date(System.currentTimeMillis()),18);


        categorieService ca= new categorieService();

        //  ca.add(new categorie("comedy"));
        //es.add(as);
        // es.update(as);

        System.out.println(es.recupere());
    }

}

