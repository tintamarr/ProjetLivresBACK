package com.takima.backskeleton.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Livres {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_livre;

    private String edition;
    private String titre;
    private String auteur;
    private String resume;

    private LocalDate date_parution;
    private LocalDate date_ajout;
    private Double note;

    // Constructeurs
    public Livres() {
    }

    public Livres(String edition, String titre, String auteur, String resume, LocalDate date_parution, LocalDate date_ajout, Double note) {
        this.edition = edition;
        this.titre = titre;
        this.auteur = auteur;
        this.resume = resume;
        this.date_parution = date_parution;
        this.date_ajout = date_ajout;
        this.note = note;
    }

    @Override
    public String toString() {
        return "Livres{" +
                "id_livre=" + id_livre +
                ", edition='" + edition + '\'' +
                ", titre='" + titre + '\'' +
                ", auteur='" + auteur + '\'' +
                ", resume='" + resume + '\'' +
                ", date_parution=" + date_parution +
                ", date_ajout=" + date_ajout +
                ", note=" + note +
                '}';
    }

    // Getters et Setters
    public Long getId_livre() {
        return id_livre;
    }

    public void setId_livre(Long id_livre) {
        this.id_livre = id_livre;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public LocalDate getDate_parution() {
        return date_parution;
    }

    public void setDate_parution(LocalDate date_parution) {
        this.date_parution = date_parution;
    }

    public LocalDate getDate_ajout() {
        return date_ajout;
    }

    public void setDate_ajout(LocalDate date_ajout) {
        this.date_ajout = date_ajout;
    }

    public Double getNote() {
        return note;
    }

    public void setNote(Double note) {
        this.note = note;
    }
}
