package com.takima.backskeleton.models;

import javax.persistence.*;

@Entity
public class Livreslus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_livres_lus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_livre", nullable = false)
    private Livres livre;

    @ManyToOne(fetch = FetchType.LAZY)
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
    public Long getId_livres_lus() {
        return id_livres_lus;
    }

    public void setId_livres_lus(Long id_livres_lus) {
        this.id_livres_lus = id_livres_lus;
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
