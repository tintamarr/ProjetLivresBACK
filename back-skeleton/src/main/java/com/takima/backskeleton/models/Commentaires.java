package com.takima.backskeleton.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Commentaires {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_commentaire;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_utilisateur", nullable = false)
    private Utilisateur utilisateur;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_livre", nullable = false)
    private Livres livre;

    @Column(columnDefinition = "TEXT")
    private String commentaire;

    @NotNull
    @Min(0)
    @Max(5)
    private Integer note_unique;

    @NotNull
    private Boolean status;

    // Constructeurs
    public Commentaires() {
    }

    public Commentaires(Utilisateur utilisateur, Livres livre, String commentaire, Integer note_unique, Boolean status) {
        this.utilisateur = utilisateur;
        this.livre = livre;
        this.commentaire = commentaire;
        this.note_unique = note_unique;
        this.status = status;
    }

    // Getters et Setters
    public Long getId_commentaire() {
        return id_commentaire;
    }

    public void setId_commentaire(Long id_commentaire) {
        this.id_commentaire = id_commentaire;
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

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Integer getNote_unique() {
        return note_unique;
    }

    public void setNote_unique(Integer note_unique) {
        this.note_unique = note_unique;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}

