package com.takima.backskeleton.models;

import jakarta.persistence.*;

@Entity
public class Pilealire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPileALire;

    @ManyToOne
    @JoinColumn(name = "id_livre", nullable = false)
    private Livres livre;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur", nullable = false)
    private Utilisateur utilisateur;


    public Pilealire() {
    }

    public Pilealire(Livres livre, Utilisateur utilisateur) {
        this.livre = livre;
        this.utilisateur = utilisateur;
    }


    public Long getIdPileALire() {
        return idPileALire;
    }

    public void setIdPileALire(Long id_pile_a_lire) {
        this.idPileALire = id_pile_a_lire;
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
