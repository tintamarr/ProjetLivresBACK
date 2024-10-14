package com.takima.backskeleton.models;

import jakarta.persistence.*;

@Entity
public class Livresencours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLivresEnCours;

    @ManyToOne
    @JoinColumn(name = "idUtilisateur", nullable = false)
    private Utilisateur utilisateur; // Vous devez avoir une classe Utilisateur

    @ManyToOne
    @JoinColumn(name = "idLivre", nullable = false)
    private Livres livre;

    private Long progression;

    // Constructeurs
    public Livresencours() {
    }

    public Livresencours(Livres livre, Utilisateur utilisateur, Long progression) {
        this.livre = livre;
        this.utilisateur = utilisateur;
        this.progression = progression;
    }

    public Long getIdLivresEnCours() {
        return idLivresEnCours;
    }

    public void setIdLivresEnCours(Long idLivresEnCours) {
        this.idLivresEnCours = idLivresEnCours;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Livres getLivre() {
        return livre;
    }

    public void setLivre(Livres livre) {
        this.livre = livre;
    }

    public Long getProgression() {
        return progression;
    }

    public void setProgression(Long progression) {
        this.progression = progression;
    }
}
