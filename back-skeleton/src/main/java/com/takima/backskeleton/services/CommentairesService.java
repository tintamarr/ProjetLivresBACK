package com.takima.backskeleton.services;

import com.takima.backskeleton.DAO.CommentairesDao;
import com.takima.backskeleton.DAO.UtilisateurDao;
import com.takima.backskeleton.DTO.CommentairesDto;
import com.takima.backskeleton.exceptions.DaoException;
import com.takima.backskeleton.exceptions.ServiceException;
import com.takima.backskeleton.models.Commentaires;
import com.takima.backskeleton.models.Livres;
import com.takima.backskeleton.models.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.takima.backskeleton.dao.LivreDao;

import java.util.List;

@Service
public class CommentairesService {

    private final CommentairesDao commentairesDao;

    public CommentairesService(CommentairesDao commentairesDao) {
        this.commentairesDao = commentairesDao;
    }

    @Autowired
    private UtilisateurService utilisateurService;

    @Autowired
    private LivreDao livreDao;


    public Commentaires createCommentaire(CommentairesDto commentairesDto) throws ServiceException {
        try {

            Utilisateur utilisateur = utilisateurService.findByIdUtilisateur(commentairesDto.getIdUtilisateur());

            Livres livre = livreDao.findByIdLivre(commentairesDto.getIdLivre());


            Commentaires commentaire = new Commentaires();
            commentaire.setUtilisateur(utilisateur);
            commentaire.setLivres(livre);
            commentaire.setStatut(commentairesDto.isStatut());
            commentaire.setNoteUnique(commentairesDto.getNoteUnique());
            commentaire.setCommentaire(commentairesDto.getCommentaire());
            return commentairesDao.creerCommentaire(commentaire);

        } catch (DaoException e) {
            throw new ServiceException("Erreur lors de la création du livre en cours : " + e.getMessage());
        }
    }

    public void deleteCommentaire(Long id) throws DaoException {
        try {
            commentairesDao.deleteById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DaoException();
        }
    }

    public Commentaires findById(Long id) throws DaoException {
        try {
            return commentairesDao.findById(id)
                    .orElseThrow(() -> new DaoException());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DaoException();
        }
    }

    public List<Commentaires> findAll() throws DaoException {
        try {
            return commentairesDao.findAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DaoException();
        }
    }

    public List<Commentaires> findByUtilisateurId(Long utilisateurId) throws DaoException {
        try {
            return commentairesDao.findByUtilisateurIdUtilisateur(utilisateurId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DaoException();
        }
    }

    public List<Commentaires> findByLivreId(Long livreId) throws DaoException {
        try {
            return commentairesDao.findByLivresIdLivre(livreId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DaoException();
        }
    }

    public List<Commentaires> findByNote(Integer note) throws DaoException {
        try {
            return commentairesDao.findByNoteUnique(note);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DaoException();
        }
    }
}
