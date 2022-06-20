/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package authentication;

/**
 *
 * @author yosr barghouthi / maissa dridi l2cs02 
 */
public class User {
    private String cin;
    private String nom;
    private String prenom;
    private String email;
    private String statut;
    private String password;
    
    public User(){super();}
    public User(String c,String name, String namee, String mail, String s,String pwd){
        this.cin=c;
        this.nom=name;
        this.prenom=namee;
        this.email=mail;
        this.statut=s;
        this.password=pwd;
    }
    public User(String c,String pa){
        this.cin=c;
        this.password=pa;
    }
    public String getCin() {
        return cin;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getStatut() {
        return statut;
    }

    public String getPassword() {
        return password;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" + "cin=" + cin + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", statut=" + statut + ", password=" + password + '}';
    }
    
    
}
