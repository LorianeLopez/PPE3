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
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.ListItem;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.test.annotations.WrapToTest;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CV {

    public static final String DEST = "results/chapter01/cv.pdf";

    public static void main(String args[]) throws IOException, SQLException {
//        File file = new File(DEST);
//        file.getParentFile().mkdirs();
//        new CV().createPdf(DEST,1);
    }
    
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
            document.add(new Paragraph(laPersonne.getPrenom() + " " + laPersonne.getPrenom()+"\n \n").setFont(font));
            document.add(new Paragraph(laPersonne.getAdresse_rue() + " \n" + laPersonne.getAdresse_CP() + " " + laPersonne.getAdresse_ville()+ " \n \n").setFont(font));
            document.add(new Paragraph("Tel : " + laPersonne.getTelPro()+ " \n").setFont(font));
            document.add(new Paragraph("Port : " + laPersonne.getTelPerso()+ " \n \n").setFont(font));
            
            document.add(new Paragraph("Email : ").setFont(font2));
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
                document.add(new Paragraph("Aucun email"));
            }
            document.add(emails);
            
            if(laPersonne.getPermis() == 1){
                document.add(new Paragraph("\n Permis B \n \n").setFont(font));
            }
            document.add(new Paragraph("Formations : \n").setFont(font2));
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
            }
            document.add(formation);
            
            document.add(new Paragraph("\n Experience Professionnelle : \n").setFont(font2));
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
            }
            document.add(experience);
            //Close document
        }
    }

}