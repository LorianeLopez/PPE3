/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gsbperso;

/**
 *
 * @author Loriane
 */

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.IBlockElement;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.ListItem;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.test.annotations.WrapToTest;
//import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import javax.imageio.ImageIO;

import java.io.File;
import java.io.IOException;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;


public class CV {

    public static final String DEST = "results/chapter01/cv.pdf";

    /**
     * Créée un pdf avec les informations de la bdd telle que les formations, les compétences, les langues parlées, les stages effectuée et l'expérience professionnelle de l'emploté
     * @param dest
     * @param laPersonne
     * @throws IOException
     * @throws SQLException 
     */
    public void createPdf(String dest, Personne laPersonne) throws IOException, SQLException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        //Initialize PDF writer
        PdfWriter writer = new PdfWriter(dest);

        //Initialize PDF document
        PdfDocument pdf = new PdfDocument(writer);

        // Create a PdfFont
        try ( // Initialize document
            Document document = new Document(pdf)) {
            // Create a PdfFont
            PdfFont font = PdfFontFactory.createFont(FontConstants.COURIER_BOLD);
            PdfFont font2 = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
            ResultSet images = Singleton.requeteSelection("select url from cv_photo where id_utilisateur = " + laPersonne.getId());
            if(images.next()){
                Blob blob = images.getBlob("url");
                int bloblength = (int) blob.length();
                byte[] data = images.getBlob("url").getBytes(1, bloblength);
                ImageData img = ImageDataFactory.create(data);
                Image image = new Image(img);
                image.setWidth(130);
                image.setHeight(160);
                document.add(image);
            }else{
                document.add(new Paragraph("Aucune image sélectionnée."));
            }
            document.add(new Paragraph("\n"));
            document.add(new Paragraph(laPersonne.getPrenom() + " " + laPersonne.getNom()+"\n \n").setFont(font).setFontSize(20));
            document.add(new Paragraph(laPersonne.getAdresse_rue() + " \n" + laPersonne.getAdresse_CP() + " " + laPersonne.getAdresse_ville()+ " \n").setFont(font));
            if(laPersonne.getPermis() == 1){
                document.add(new Paragraph("\n Permis B \n \n").setFont(font));
            }else{
                document.add(new Paragraph("\n Permis B non acquis \n \n").setFont(font));
            }
            document.add(new Paragraph("Tel : " + laPersonne.getTelPro()+ " \n").setFont(font));
            document.add(new Paragraph("Port : " + laPersonne.getTelPerso()+ " \n \n").setFont(font));
            
            document.add(new Paragraph("Email : ").setFont(font2).setFontSize(14).setUnderline());
            List emails = new List()
                    .setSymbolIndent(12)
                    .setListSymbol("\u2022")
                    .setFont(font);
            ResultSet email = Singleton.requeteSelection("select libelle_email from cv_email where id_utilisateur = " + laPersonne.getId());
            if(email.next()){
                email.last();
                int longueur2 = email.getRow();
                email.first();
                for (int i = 1; i <= longueur2; i++) {
                    emails.add(new ListItem(email.getString("libelle_email")));
                    if (i < longueur2) {
                        email.next();
                    }
                }
            }else{
                document.add(new Paragraph("Aucun email").setFont(font));
            }
            document.add(emails);
            document.add(new Paragraph("\n Formations : \n").setFont(font2).setFontSize(14).setUnderline());
            List formation = new List()
                    .setSymbolIndent(12)
                    .setListSymbol("\u2022")
                    .setFont(font);
            ResultSet formations = Singleton.requeteSelection("select libelle_formation from cv_formation where id_utilisateur = " + laPersonne.getId());
            if(formations.next()){
                formations.last();
                int longueur = formations.getRow();
                formations.first();
                for (int i = 1; i <= longueur; i++) {
                    formation.add(new ListItem(formations.getString("libelle_formation")));
                    if (i < longueur) {
                        formations.next();
                    }
                }
            }else{
                document.add(new Paragraph("Aucune formation."));
            }
            document.add(formation);
            
            document.add(new Paragraph("\n Experience Professionnelle : \n").setFont(font2).setFontSize(14).setUnderline());
            List experience = new List()
                    .setSymbolIndent(12)
                    .setListSymbol("\u2022")
                    .setFont(font);
            ResultSet experiences = Singleton.requeteSelection("select libelle_experience_prof from cv_experience_prof where id_utilisateur = " + laPersonne.getId());
            if(experiences.next()){
                experiences.last();
                int longueur2 = experiences.getRow();
                experiences.first();
                for (int i = 1; i <= longueur2; i++) {
                    experience.add(new ListItem(experiences.getString("libelle_experience_prof")));
                    if (i < longueur2) {
                        experiences.next();
                    }
                }
            }else{
                document.add(new Paragraph("Aucune expérience").setFont(font));
            }
            document.add(experience);
            
            document.add(new Paragraph("\n Stages : \n").setFont(font2).setFontSize(14).setUnderline());
            List stages = new List()
                    .setSymbolIndent(12)
                    .setListSymbol("\u2022")
                    .setFont(font);
            ResultSet stage = Singleton.requeteSelection("select libelle_stage from cv_stages where id_utilisateur = " + laPersonne.getId());
            if(stage.next()){
                stage.last();
                int longueur2 = stage.getRow();
                stage.first();
                for (int i = 1; i <= longueur2; i++) {
                    stages.add(new ListItem(stage.getString("libelle_stage")));
                    if (i < longueur2) {
                        stage.next();
                    }
                }
            }else{
                document.add(new Paragraph("Aucun stage").setFont(font));
            }
            document.add(stages);
            
            document.add(new Paragraph("\n Compétences Informatique : \n").setFont(font2).setFontSize(14).setUnderline());
            List competences = new List()
                    .setSymbolIndent(12)
                    .setListSymbol("\u2022")
                    .setFont(font);
            ResultSet informatique = Singleton.requeteSelection("select libelle_informatique from cv_informatique where id_utilisateur = " + laPersonne.getId());
            if(informatique.next()){
                informatique.last();
                int longueur2 = informatique.getRow();
                informatique.first();
                for (int i = 1; i <= longueur2; i++) {
                    competences.add(new ListItem(informatique.getString("libelle_informatique")));
                    if (i < longueur2) {
                        informatique.next();
                    }
                }
            }else{
                document.add(new Paragraph("Aucune compétence").setFont(font));
            }
            document.add(competences);
            
            document.add(new Paragraph("\n Langues : \n").setFont(font2).setFontSize(14).setUnderline());
            List langue = new List()
                    .setSymbolIndent(12)
                    .setListSymbol("\u2022")
                    .setFont(font);
            ResultSet langues = Singleton.requeteSelection("select libelle_langue from cv_langue where id_utilisateur = " + laPersonne.getId());
            if(langues.next()){
                langues.last();
                int longueur2 = langues.getRow();
                langues.first();
                for (int i = 1; i <= longueur2; i++) {
                    langue.add(new ListItem(langues.getString("libelle_langue")));
                    if (i < longueur2) {
                        langues.next();
                    }
                }
            }else{
                document.add(new Paragraph("Aucune langue parlée").setFont(font));
            }
            document.add(langue);
            
            document.add(new Paragraph("\n Centre d'intéret : \n").setFont(font2).setFontSize(14).setUnderline());
            List centre = new List()
                    .setSymbolIndent(12)
                    .setListSymbol("\u2022")
                    .setFont(font);
            ResultSet interet = Singleton.requeteSelection("select libelle_centre_interet from cv_centre_interet where id_utilisateur = " + laPersonne.getId());
            if(interet.next()){
                interet.last();
                int longueur2 = interet.getRow();
                interet.first();
                for (int i = 1; i <= longueur2; i++) {
                    centre.add(new ListItem(interet.getString("libelle_centre_interet")));
                    if (i < longueur2) {
                        interet.next();
                    }
                }
            }else{
                document.add(new Paragraph("Aucune centre d'intéret").setFont(font));
            }
            document.add(centre);
            
            //Close document
        }
    }

}