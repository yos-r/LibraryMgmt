package livres;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author yosr barghouthi / maissa dridi l2cs02 
 */
public class Livre {
    private String isbn;
    private String titre;
    private String auteur;
    private int dispo; // 0 : réservé 1: prêt 
    
    public Livre(){super();}
    public Livre(String i,String t,String a){
        this.isbn=i;
        this.titre=t;
        this.auteur=a;
        this.dispo=1;
    }

    public Livre(String isbn, String titre, String auteur, int dispo) {
        this.isbn = isbn;
        this.titre = titre;
        this.auteur = auteur;
        this.dispo = dispo;
    }
    

    public String getIsbn() {
        return isbn;
    }

    public String getTitre() {
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public int getDispo() {
        return dispo;
    }
    

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public void setDispo(int statut) {
        this.dispo = statut;
    }

    @Override
    public String toString() {
        return "Livre{" + "isbn=" + isbn + ", titre=" + titre + ", auteur=" + auteur + ", dispo=" + dispo + '}';
    }
    
    
}
