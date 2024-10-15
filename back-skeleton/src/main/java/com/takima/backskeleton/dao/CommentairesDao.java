package com.takima.backskeleton.DAO;

import com.takima.backskeleton.DTO.CommentairesDto;
import com.takima.backskeleton.exceptions.DaoException;
import com.takima.backskeleton.models.Commentaires;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentairesDao extends JpaRepository<Commentaires, Long> {


    List<Commentaires> findByUtilisateurIdUtilisateur(Long id_utilisateur);


    List<Commentaires> findByLivresIdLivre(Long id_livre);


    List<Commentaires> findByNoteUnique(Integer note);

    List<Commentaires> findByStatut(Boolean statut);

    default Commentaires creerCommentaire(Commentaires commentaire) throws DaoException {
        try {
            return save(commentaire);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DaoException();
        }
    }
}




