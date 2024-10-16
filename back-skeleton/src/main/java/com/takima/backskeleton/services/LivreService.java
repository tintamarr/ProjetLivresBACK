package com.takima.backskeleton.services;

import java.util.List;

import com.takima.backskeleton.DAO.LivreDao;
import com.takima.backskeleton.exceptions.DaoException;
import com.takima.backskeleton.exceptions.ServiceException;
import com.takima.backskeleton.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class LivreService{

    private final LivreDao livreDao;

    @Autowired
    private LivresEnCoursService livresEnCoursService;
    @Autowired
    private LivresLusService livresLusService;
    @Autowired
    private PileALireService pileALireService;
    @Autowired
    @Lazy
    private CommentairesService commentairesService;

    public LivreService(LivreDao livreDao) {
        this.livreDao = livreDao;
    }

    public List<Livres> findAll() throws ServiceException {
        List<Livres> livres = livreDao.findAll();
        if (livres != null && !livres.isEmpty()) {
            return livres;
        }
        throw new ServiceException("Aucun livre trouvé dans la base de données.");
    }

    public Livres createLivre(Livres livre) throws ServiceException {
        if (livre.getTitre() == null || livre.getTitre().isEmpty()) {
            throw new ServiceException("Le titre du livre ne peut pas être vide.");
        }

        if (livre.getAuteur() == null || livre.getAuteur().isEmpty()) {
            throw new ServiceException("L'auteur du livre ne peut pas être vide.");
        }

        if (livre.getDate_parution() == null) {
            throw new ServiceException("La date de parution du livre est requise.");
        }

        try {
            livreDao.creerLivre(livre);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
        return livre;
    }
    public long countLivre() throws ServiceException {
        try {
            return livreDao.compterLivres();
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }


    public void deleteLivre(Long id_livre) throws ServiceException {
        try {

            //TODO : faire pareil pour utilisateur
            List<Livresencours> livresencours = livresEnCoursService.findByLivre(id_livre);
            if (livresencours != null){
                livresencours.forEach(livresencours1 -> {
                    try {
                        livresEnCoursService.deleteLivreEnCours(livresencours1.getIdlivresencours());
                    } catch (ServiceException e) {
                        throw new RuntimeException(e);
                    }
                });
            }

            List<Livreslus> livreslus = livresLusService.findByLivre(id_livre);
            if (livreslus != null){
                livreslus.forEach(livreslus1 -> {
                    try {
                        livresLusService.deleteLivresLus(livreslus1.getIdLivresLus());
                    } catch (ServiceException e) {
                        throw new RuntimeException(e);
                    }
                });
            }

            List<Pilealire> pilealires = pileALireService.findByLivre(id_livre);
            if (pilealires != null){
                pilealires.forEach(pilealire1 -> {
                    try {
                        pileALireService.deletePileALire(pilealire1.getIdPileALire());
                    } catch (ServiceException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
            List<Commentaires> commentaires = commentairesService.findByLivreId(id_livre);
            if (commentaires != null){
                commentaires.forEach(commentaires1 -> {
                    try {
                        commentairesService.deleteCommentaire(commentaires1.getIdCommentaire());
                    } catch (DaoException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
            livreDao.supprimerLivre(id_livre);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public Livres findById(long id) throws ServiceException {
        try {
            Livres livre = livreDao.findLivreParId(id);
            if (livre != null) {
                return livre;
            }
            throw new ServiceException("Le livre n°" + id + " n'a pas été trouvé dans la base de données.");
        } catch (DaoException e) {
            throw new ServiceException("Erreur lors de la recherche du livre: " + e.getMessage());
        }
    }

    public List<Livres> findByTitre(String titre) throws ServiceException {
        try {
            List<Livres> livres = livreDao.findLivreParTitre(titre);
            if (livres != null && !livres.isEmpty()) {
                return livres;
            }
            throw new ServiceException("Aucun livre trouvé avec le titre : " + titre);
        } catch (DaoException e) {
            throw new ServiceException("Erreur lors de la recherche des livres par titre: " + e.getMessage());
        }
    }
    public List<Livres> findByAuteur(String auteur) throws ServiceException {
        try {
            List<Livres> livres = livreDao.findLivreParAuteur(auteur);
            if (livres != null && !livres.isEmpty()) {
                return livres;
            }
            throw new ServiceException("Aucun livre trouvé avec l'auteur' : " + auteur);
        } catch (DaoException e) {
            throw new ServiceException("Erreur lors de la recherche des livres par auteur: " + e.getMessage());
        }
    }
    public List<Livres> findByEdition(String edition) throws ServiceException {
        try {
            List<Livres> livres = livreDao.findLivreParEdition(edition);
            if (livres != null && !livres.isEmpty()) {
                return livres;
            }
            throw new ServiceException("Aucun livre trouvé avec l'edition : " + edition);
        } catch (DaoException e) {
            throw new ServiceException("Erreur lors de la recherche des livres par edition: " + e.getMessage());
        }
    }

    public List<Livres> findByGenre(String genre) throws ServiceException {
        try {
            List<Livres> livres = livreDao.findLivreParGenre(genre);
            if (livres != null && !livres.isEmpty()) {
                return livres;
            }
            throw new ServiceException("Aucun livre trouvé avec le genre : " + genre);
        } catch (DaoException e) {
            throw new ServiceException("Erreur lors de la recherche des livres par genre: " + e.getMessage());
        }
    }
}


