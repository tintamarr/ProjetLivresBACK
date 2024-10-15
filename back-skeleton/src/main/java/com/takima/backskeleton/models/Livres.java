package com.takima.backskeleton.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Livres {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLivre;

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
                "id_livre=" + idLivre +
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
    public Long getIdLivre() {
        return idLivre;
    }

    public void setIdLivre(Long id_livre) {
        this.idLivre = id_livre;
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
