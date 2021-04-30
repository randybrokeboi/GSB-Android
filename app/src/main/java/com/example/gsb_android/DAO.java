package com.example.gsb_android;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class DAO {
    private static final String urlmed = "http://gaemedecins.appspot.com/Controleur/medParDep/listeMed/";
    private static final String urldep = "http://denis.brodard.free.fr/dep.php";
    private static String[] LesInfos;

    /**
     *
     * @param numdep
     * @return LesInfos
     */

    public static ArrayList<Medecin> getLesInfos(String numdep){
        ArrayList<Medecin> LesInfos = new ArrayList<Medecin>();
        try{
            System.out.println("passe1");

            System.out.println("passe2");
            URL myURL = new URL(urlmed + numdep);
            System.out.println("passe3");
            Document doc;
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            System.out.println("passe4");
            DocumentBuilder db = dbf.newDocumentBuilder();
            System.out.println("passe5");
            doc = db.parse(myURL.openStream());
            System.out.println(myURL);
            System.out.println("passe6 med");
            Element racine = doc.getDocumentElement();
            NodeList listeMed = racine.getElementsByTagName("Medecin");
            // récup des médecins
            System.out.println("listemed: "+ listeMed.getLength());
            for (int i = 0; i < 5; i++) {
                Node medecin = listeMed.item(i);
                NodeList lesProprietes = medecin.getChildNodes();
                System.out.println("propp: "+ lesProprietes.toString());
                // recherche du nom
                Medecin unmed = new Medecin();
                System.out.println("propro: "+ lesProprietes.getLength());
                for (int j = 0; j < lesProprietes.getLength(); j++) {
                    switch (lesProprietes.item(j).getNodeName()){
                        case "nom":unmed.setmNom(lesProprietes.item(j).getTextContent().trim());
                        break;
                        case "prenom":unmed.setmPrenom(lesProprietes.item(j).getTextContent().trim());
                        break;
                        case "adresse":unmed.setmAdresse(lesProprietes.item(j).getTextContent().trim());
                        break;
                        case "specialite":unmed.setmSpecialite(lesProprietes.item(j).getTextContent().trim());
                        break;
                        case "tel":unmed.setmTel(lesProprietes.item(j).getTextContent().trim());
                        break;
                    }
                }
                LesInfos.add(unmed);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return LesInfos;
    }



    /**
     *
     * @return LesDeps
     */
    public static ArrayList<String> getLesDeps(){
        ArrayList<String> LesDeps = new ArrayList<String>();
        try{
            System.out.println("passe1");

            System.out.println("passe2");
            URL myURL = new URL(urldep);
            System.out.println("passe3");
            Document doc;
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            System.out.println("passe4");
            DocumentBuilder db = dbf.newDocumentBuilder();
            System.out.println("passe5");
            doc = db.parse(myURL.openStream());
            System.out.println("passe6 dep");
            Element racine = doc.getDocumentElement();
            NodeList listeDep = racine.getElementsByTagName("Departement");
            // récup des dep
            for (int i = 0; i < listeDep.getLength(); i++) {
                Node departement = listeDep.item(i);
                NodeList lesProprietes = departement.getChildNodes();
                // recherche du nom
                for (int j = 0; j < lesProprietes.getLength(); j++) {
                    if (lesProprietes.item(j).getNodeName().equals("num")) {
                        LesDeps.add(lesProprietes.item(j).getTextContent().trim());
                        System.out.println("eeeeeee");
                        System.out.println(lesProprietes.item(j).getTextContent().trim());
                        break;
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return LesDeps;
    }
}