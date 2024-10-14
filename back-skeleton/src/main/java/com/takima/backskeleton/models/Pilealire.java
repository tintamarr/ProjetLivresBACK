package com.takima.backskeleton.models;

import jakarta.persistence.*;

@Entity
public class Pilealire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_pile_a_lire;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_livre", nullable = false)
    private Livres livre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_utilisateur", nullable = false)
    private Utilisateur utilisateur;

    // Constructeurs
    public Pilealire() {
    }

    public Pilealire(Livres livre, Utilisateur utilisateur) {
        this.livre = livre;
        this.utilisateur = utilisateur;
    }

    // Getters et Setters
    public Long getId_pile_a_lire() {
        return id_pile_a_lire;
    }

    public void setId_pile_a_lire(Long id_pile_a_lire) {
        this.id_pile_a_lire = id_pile_a_lire;
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
