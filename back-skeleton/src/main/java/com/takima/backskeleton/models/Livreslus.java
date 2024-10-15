package com.takima.backskeleton.models;

import jakarta.persistence.*;

@Entity
public class Livreslus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLivresLus;

    @ManyToOne
    @JoinColumn(name = "id_livre", nullable = false)
    private Livres livre;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur", nullable = false)
    private Utilisateur utilisateur;

    // Constructeurs
    public Livreslus() {
    }

    public Livreslus(Livres livre, Utilisateur utilisateur) {
        this.livre = livre;
        this.utilisateur = utilisateur;
    }

    // Getters et Setters
    public Long getIdLivresLus() {
        return idLivresLus;
    }

    public void setIdLivresLus(Long id_livres_lus) {
        this.idLivresLus = id_livres_lus;
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
