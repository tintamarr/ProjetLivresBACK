package com.takima.backskeleton.models;

import jakarta.persistence.*;

@Entity
public class Livresencours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_livres_encours;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_livre", nullable = false)
    private Livres livre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_utilisateur", nullable = false)
    private Utilisateur utilisateur;

    // Constructeurs
    public Livresencours() {
    }

    public Livresencours(Livres livre, Utilisateur utilisateur) {
        this.livre = livre;
        this.utilisateur = utilisateur;
    }

    // Getters et Setters
    public Long getId_livres_encours() {
        return id_livres_encours;
    }

    public void setId_livres_encours(Long id_livres_encours) {
        this.id_livres_encours = id_livres_encours;
    }

    public Livres getLivre() {
        return livre;
    }

    public void setLivre(Livres livre) {
        this.livre = livre;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
}
