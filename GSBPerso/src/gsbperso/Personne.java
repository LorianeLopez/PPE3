/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gsbperso;

/**
 *
 * @author nc
 */
public class Personne {
    private Integer id;
    private String nom;
    private String prenom;
    private String adresse_rue;
    private String adresse_CP;
    private String adresse_ville;
    private Float salaire;
    private String telPerso;
    private String telPro;
    private String site;
    private String position;
    private Integer permis;
    private Integer cadre;
    private Integer anciennete;
   
    /**
     * Constructeur vide
     */
    public Personne(){
        
    }
    
    /**
     * Constructeur avec paramètres
     * @param id
     * @param nom
     * @param prenom
     * @param adresse_rue
     * @param adresse_CP
     * @param adresse_ville
     * @param salaire
     * @param telPerso
     * @param telPro
     * @param site
     * @param position
     * @param permis
     * @param cadre 
     * @param ancien
     */
    public Personne(Integer id, String nom, String prenom, String adresse_rue, String adresse_CP, String adresse_ville, Float salaire, String telPerso, String telPro, String site, String position, Integer permis, Integer cadre, Integer ancien){
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse_rue = adresse_rue;
        this.adresse_CP = adresse_CP;
        this.adresse_ville = adresse_ville;
        this.salaire = salaire;
        this.telPerso = telPerso;
        this.telPro = telPro;
        this.site = site;
        this.position = position;
        this.permis = permis;
        this.cadre = cadre;
        this.anciennete = ancien;
    }
    
    public Integer getPermis() {
        return permis;
    }

    public void setPermis(Integer permis) {
        this.permis = permis;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdresse_rue() {
        return adresse_rue;
    }

    public void setAdresse_rue(String adresse_rue) {
        this.adresse_rue = adresse_rue;
    }

    public String getAdresse_CP() {
        return adresse_CP;
    }

    public void setAdresse_CP(String adresse_CP) {
        this.adresse_CP = adresse_CP;
    }

    public String getAdresse_ville() {
        return adresse_ville;
    }

    public void setAdresse_ville(String adresse_ville) {
        this.adresse_ville = adresse_ville;
    }

    public Float getSalaire() {
        return salaire;
    }

    public void setSalaire(Float salaire) {
        this.salaire = salaire;
    }

    public String getTelPerso() {
        return telPerso;
    }

    public void setTelPerso(String telPerso) {
        this.telPerso = telPerso;
    }

    public String getTelPro() {
        return telPro;
    }

    public void setTelPro(String telPro) {
        this.telPro = telPro;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getCadre() {
        return cadre;
    }

    public void setCadre(Integer cadre) {
        this.cadre = cadre;
    }

    public Integer getAnciennete() {
        return anciennete;
    }

    public void setAnciennete(Integer anciennete) {
        this.anciennete = anciennete;
    }
    
    
    

}
