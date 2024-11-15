package com.takima.backskeleton.models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "utilisateurs")
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUtilisateur;

    private String nom;
    private String prenom;
    private String pseudo;
    private String mail;
    private LocalDate datenaissance;

    private int photo_profil;

    public Utilisateur() {
    }

    public Utilisateur(String nom, String prenom, String pseudo, String mail, LocalDate datenaissance, int photo_profil) {
        this.nom = nom;
        this.prenom = prenom;
        this.pseudo = pseudo;
        this.mail = mail;
        this.datenaissance = datenaissance;
        this.photo_profil = photo_profil;
    }

    public Long getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Long id_utilisateur) {
        this.idUtilisateur = id_utilisateur;
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

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public LocalDate getDatenaissance() {
        return datenaissance;
    }

    public void setDatenaissance(LocalDate datenaissance) {
        this.datenaissance = datenaissance;
    }

    public int getPhoto_profil() {
        return photo_profil;
    }

    public void setPhoto_profil(int photo_profil) {
        this.photo_profil = photo_profil;
    }
}