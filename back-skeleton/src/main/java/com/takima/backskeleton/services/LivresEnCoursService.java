package com.takima.backskeleton.services;

import com.takima.backskeleton.dao.LivresEnCoursDao;
import com.takima.backskeleton.exceptions.DaoException;
import com.takima.backskeleton.exceptions.ServiceException;
import com.takima.backskeleton.models.Livresencours;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivresEnCoursService {

    private final LivresEnCoursDao livresEnCoursDao;

    public LivresEnCoursService(LivresEnCoursDao livresEnCoursDao) {
        this.livresEnCoursDao = livresEnCoursDao;
    }

    public List<Livresencours> findAll() throws ServiceException {
        try {
            List<Livresencours> livresEnCours = livresEnCoursDao.findTousLesLivresEnCours();
            if (livresEnCours != null && !livresEnCours.isEmpty()) {
                return livresEnCours;
            }
            throw new ServiceException("Aucun livre en cours trouvé.");
        } catch (DaoException e) {
            throw new ServiceException("Erreur lors de la récupération des livres en cours : " + e.getMessage());
        }
    }

//    public Livresencours createLivreEnCours(Livresencours livreEnCours) throws ServiceException {
//        if (livreEnCours.getLivre() == null) {
//            throw new ServiceException("Le livre ne peut pas être nul.");
//        }
//        if (livreEnCours.getUtilisateur() == null) {
//            throw new ServiceException("L'utilisateur ne peut pas être nul.");
//        }
//
//        try {
//            return livresEnCoursDao.creerLivreEnCours(livreEnCours);
//        } catch (DaoException e) {
//            throw new ServiceException("Erreur lors de la création du livre en cours : " + e.getMessage());
//        }
//    }
//
//    public long countLivresEnCours() throws ServiceException {
//        try {
//            return livresEnCoursDao.compterLivresEnCours();
//        } catch (DaoException e) {
//            throw new ServiceException("Erreur lors du comptage des livres en cours : " + e.getMessage());
//        }
//    }
//
//    public void deleteLivreEnCours(Long idLivresEnCours) throws ServiceException {
//        try {
//            livresEnCoursDao.supprimerLivreEnCours(idLivresEnCours);
//        } catch (DaoException e) {
//            throw new ServiceException("Erreur lors de la suppression du livre en cours : " + e.getMessage());
//        }
//    }
//
//    public List<Livresencours> findById(Long id) throws ServiceException {
//        try {
//            List<Livresencours> livreEnCours = livresEnCoursDao.findLivresEnCoursParLivre(id);
//            if (livreEnCours != null) {
//                return livreEnCours;
//            }
//            throw new ServiceException("Aucun livre en cours trouvé avec l'ID : " + id);
//        } catch (DaoException e) {
//            throw new ServiceException("Erreur lors de la recherche du livre en cours : " + e.getMessage());
//        }
//    }
//
//    public List<Livresencours> findByUtilisateur(Long idUtilisateur) throws ServiceException {
//        try {
//            List<Livresencours> livresEnCours = livresEnCoursDao.findLivresEnCoursParUtilisateur(idUtilisateur);
//            if (livresEnCours != null && !livresEnCours.isEmpty()) {
//                return livresEnCours;
//            }
//            throw new ServiceException("Aucun livre en cours trouvé pour l'utilisateur avec l'ID : " + idUtilisateur);
//        } catch (DaoException e) {
//            throw new ServiceException("Erreur lors de la recherche des livres en cours par utilisateur : " + e.getMessage());
//        }
//    }
//
//    public List<Livresencours> findByLivre(Long idLivre) throws ServiceException {
//        try {
//            List<Livresencours> livresEnCours = livresEnCoursDao.findLivresEnCoursParLivre(idLivre);
//            if (livresEnCours != null && !livresEnCours.isEmpty()) {
//                return livresEnCours;
//            }
//            throw new ServiceException("Aucun livre en cours trouvé pour le livre avec l'ID : " + idLivre);
//        } catch (DaoException e) {
//            throw new ServiceException("Erreur lors de la recherche des livres en cours par livre : " + e.getMessage());
//        }
//    }
}