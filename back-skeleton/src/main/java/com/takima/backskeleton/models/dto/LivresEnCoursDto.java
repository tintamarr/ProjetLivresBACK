package com.takima.backskeleton.models.dto;

public class LivresEnCoursDto {
        private Long idUtilisateur;
        private Long idLivre;
        private Long progression;

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

    public Long getProgression() {
        return progression;
    }

    public void setProgression(Long progression) {
        this.progression = progression;
    }
}
