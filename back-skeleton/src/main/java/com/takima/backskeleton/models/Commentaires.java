package com.takima.backskeleton.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "commentaires")
public class Commentaires {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCommentaire;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur", nullable = false)
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "id_livre", nullable = false)
    private Livres livres;

    @Column(columnDefinition = "TEXT")
    private String commentaire;

    @NotNull
    @Min(0)
    @Max(5)
    private Integer noteUnique;

    @NotNull
    private Boolean statut;

    // Constructeurs
    public Commentaires() {
    }

    public Commentaires(Utilisateur utilisateur, Livres livres, String commentaire, Integer note_unique, Boolean statut) {
        this.utilisateur = utilisateur;
        this.livres = livres;
        this.commentaire = commentaire;
        this.noteUnique = note_unique;
        this.statut = statut;
    }

    // Getters et Setters
    public Long getIdCommentaire() {
        return idCommentaire;
    }

    public void setIdCommentaire(Long id_commentaire) {
        this.idCommentaire = id_commentaire;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Integer getNoteUnique() {
        return noteUnique;
    }

    public void setNoteUnique(Integer note_unique) {
        this.noteUnique = note_unique;
    }

    public Boolean getStatut() {
        return statut;
    }

    public void setStatut(Boolean status) {
        this.statut = status;
    }
}

