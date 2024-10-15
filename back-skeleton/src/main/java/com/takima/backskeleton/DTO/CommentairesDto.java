package com.takima.backskeleton.DTO;

public class CommentairesDto {
    private Long idUtilisateur;
    private Long idLivre;
    private String commentaire;

    private int noteUnique;
    private boolean statut;

    public Long getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Long idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public Long getIdLivre() {
        return idLivre;
    }

    public void setIdLivre(Long idLivre) {
        this.idLivre = idLivre;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public int getNoteUnique() {
        return noteUnique;
    }

    public void setNoteUnique(int noteUnique) {
        this.noteUnique = noteUnique;
    }

    public boolean isStatut() {
        return statut;
    }

    public void setStatut(boolean statut) {
        this.statut = statut;
    }
}