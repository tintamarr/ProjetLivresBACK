package com.takima.backskeleton.services;

import com.takima.backskeleton.DAO.CommentairesDao;
import com.takima.backskeleton.exceptions.DaoException;
import com.takima.backskeleton.models.Commentaires;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentairesService {

    private final CommentairesDao commentairesDao;

    public CommentairesService(CommentairesDao commentairesDao) {
        this.commentairesDao = commentairesDao;
    }


    public Commentaires createCommentaire(Commentaires commentaire) throws DaoException {
        try {
            return commentairesDao.save(commentaire);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DaoException();
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
