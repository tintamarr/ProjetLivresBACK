package com.takima.backskeleton.services;

import com.takima.backskeleton.DAO.UtilisateurDao;
import com.takima.backskeleton.exceptions.DaoException;
import com.takima.backskeleton.exceptions.ServiceException;
import com.takima.backskeleton.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService {

    private final UtilisateurDao utilisateurDao;
    @Autowired
    private LivresEnCoursService livresEnCoursService;
    @Autowired
    private LivresLusService livresLusService;
    @Autowired
    private PileALireService pileALireService;
    @Autowired
    @Lazy
    private CommentairesService commentairesService;

    public UtilisateurService(UtilisateurDao utilisateurDao) {
        this.utilisateurDao = utilisateurDao;
    }
    public Utilisateur createUtilisateur(Utilisateur utilisateur) throws DaoException {
        try {
            return utilisateurDao.save(utilisateur);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DaoException();
        }
    }


    public void deleteByIdUtilisateur(Long id) throws DaoException {
        try {
            List<Livresencours> livresencours = livresEnCoursService.findByUtilisateur(id);
            if (livresencours != null){
                livresencours.forEach(livresencours1 -> {
                    try {
                        livresEnCoursService.deleteLivreEnCours(livresencours1.getIdlivresencours());
                    } catch (ServiceException e) {
                        throw new RuntimeException(e);
                    }
                });
            }

            List<Livreslus> livreslus = livresLusService.findByUtilisateur(id);
            if (livreslus != null){
                livreslus.forEach(livreslus1 -> {
                    try {
                        livresLusService.deleteLivresLus(livreslus1.getIdLivresLus());
                    } catch (ServiceException e) {
                        throw new RuntimeException(e);
                    }
                });
            }

            List<Pilealire> pilealires = pileALireService.findByUtilisateur(id);
            if (pilealires != null){
                pilealires.forEach(pilealire1 -> {
                    try {
                        pileALireService.deletePileALire(pilealire1.getIdPileALire());
                    } catch (ServiceException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
            List<Commentaires> commentaires = commentairesService.findByUtilisateurId(id);
            if (commentaires != null){
                commentaires.forEach(commentaires1 -> {
                    try {
                        commentairesService.deleteCommentaire(commentaires1.getIdCommentaire());
                    } catch (DaoException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
            utilisateurDao.deleteById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DaoException();
        }
    }

    public Utilisateur findByIdUtilisateur(long id) throws DaoException {
        try {
            return utilisateurDao.findById(id)
                    .orElseThrow(DaoException::new);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DaoException();
        }
    }


    public List<Utilisateur> findAllUtilisateurs() throws DaoException {
        try {
            return utilisateurDao.findAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DaoException();
        }
    }

    public long countUtilisateurs() throws DaoException {
        try {
            return utilisateurDao.count();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DaoException();
        }
    }

    public List<Utilisateur> findByNomUtilisateur(String name) throws DaoException {
        try {
            return utilisateurDao.findByNom(name);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DaoException();
        }
    }
}