package com.takima.backskeleton.services;

import java.util.List;

import com.takima.backskeleton.dao.LivreDao;
import com.takima.backskeleton.exceptions.DaoException;
import com.takima.backskeleton.exceptions.ServiceException;
import com.takima.backskeleton.models.Livres;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivreService{

    private final LivreDao livreDao;

    public LivreService(LivreDao livreDao) {
        this.livreDao = livreDao;
    }

    // Méthode pour créer un livre
//    public long create(Livres livre) throws ServiceException {
//        if (livre.getTitre() == null || livre.getTitre().isEmpty()) {
//            throw new ServiceException("Le titre du livre ne peut pas être vide.");
//        }
//
//        if (livre.getAuteur() == null || livre.getAuteur().isEmpty()) {
//            throw new ServiceException("L'auteur du livre ne peut pas être vide.");
//        }
//
//        if (livre.getDate_parution() == null) {
//            throw new ServiceException("La date de parution du livre est requise.");
//        }
//
//        livreDao.creerLivre(livre);
//        return livre.getId_livre();
//    }

//
//
//    // Méthode pour supprimer un livre
//    public void delete(Livres livre) {
//        try {
//            livreDao.delete(livre);
//        } catch (DaoException e) {
//            throw new ServiceException("Erreur lors de la suppression du livre: " + e.getMessage(), e);
//        }
//    }
//
//    // Méthode pour trouver un livre par son ID
//    public Livres findById(long id) throws ServiceException {
//        try {
//            Livres livre = livreDao.findById(id);
//            if (livre != null) {
//                return livre;
//            }
//            throw new ServiceException("Le livre n°" + id + " n'a pas été trouvé dans la base de données.");
//        } catch (DaoException e) {
//            throw new ServiceException("Erreur lors de la recherche du livre: " + e.getMessage(), e);
//        }
//    }
//
//    // Méthode pour obtenir tous les livres
    public List<Livres> findAll() throws ServiceException {
        List<Livres> livres = livreDao.findAll();
        if (livres != null && !livres.isEmpty()) {
            return livres;
        }
        throw new ServiceException("Aucun livre trouvé dans la base de données.");
    }
//
//    // Méthode pour compter le nombre de livres
//    public long count() throws ServiceException {
//        try {
//            return livreDao.count();
//        } catch (DaoException e) {
//            throw new ServiceException("Erreur lors du comptage des livres: " + e.getMessage(), e);
//        }
//    }
//
//    // Nouvelle méthode pour trouver des livres par titre
//    public List<Livres> findByTitle(String titre) throws ServiceException {
//        try {
//            List<Livres> livres = livreDao.findByName(titre);
//            if (livres != null && !livres.isEmpty()) {
//                return livres;
//            }
//            throw new ServiceException("Aucun livre trouvé avec le titre : " + titre);
//        } catch (DaoException e) {
//            throw new ServiceException("Erreur lors de la recherche des livres par titre: " + e.getMessage(), e);
//        }
//    }
//
//    // Nouvelle méthode pour trouver des livres par édition
//    public List<Livres> findByEdition(String edition) throws ServiceException {
//        try {
//            List<Livres> livres = livreDao.findByEdition(edition);
//            if (livres != null && !livres.isEmpty()) {
//                return livres;
//            }
//            throw new ServiceException("Aucun livre trouvé avec l'édition : " + edition);
//        } catch (DaoException e) {
//            throw new ServiceException("Erreur lors de la recherche des livres par édition: " + e.getMessage(), e);
//        }
//    }
//
//    // Nouvelle méthode pour trouver des livres par auteur
//    public List<Livres> findByAuteur(String auteur) throws ServiceException {
//        try {
//            List<Livres> livres = livreDao.findByAuteur(auteur);
//            if (livres != null && !livres.isEmpty()) {
//                return livres;
//            }
//            throw new ServiceException("Aucun livre trouvé avec l'auteur : " + auteur);
//        } catch (DaoException e) {
//            throw new ServiceException("Erreur lors de la recherche des livres par auteur: " + e.getMessage(), e);
//        }
//    }
}


