//package com.takima.backskeleton.service;
//
//import java.util.List;
//
//import com.takima.backskeleton.dao.LivresEnCoursDao;
//import com.takima.backskeleton.exeptions.DaoException;
//import com.takima.backskeleton.exeptions.ServiceException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class LivresencoursService {
//
//    private final LivresEnCoursDao livresEnCoursDao;
//
//    @Autowired
//    public LivresencoursService(LivresEnCoursDao livresEnCoursDao) {
//        this.livresEnCoursDao = livresEnCoursDao;
//    }
//
//    public long create(LivresEnCours livreEnCours) throws ServiceException {
//        if (livreEnCours.getTitre() == null || livreEnCours.getTitre().isEmpty()) {
//            throw new ServiceException("Le titre du livre en cours ne peut pas être vide.");
//        }
//
//        if (livreEnCours.getUtilisateurId() <= 0) {
//            throw new ServiceException("L'ID de l'utilisateur est requis.");
//        }
//
//        try {
//            livresEnCoursDao.create(livreEnCours);
//            return livreEnCours.getId();
//        } catch (DaoException e) {
//            throw new ServiceException("Erreur lors de la création du livre en cours: " + e.getMessage(), e);
//        }
//    }
//
//    public long delete(LivresEnCours livreEnCours) throws ServiceException {
//        try {
//            livresEnCoursDao.delete(livreEnCours);
//            return livreEnCours.getId();
//        } catch (DaoException e) {
//            throw new ServiceException("Erreur lors de la suppression du livre en cours: " + e.getMessage(), e);
//        }
//    }
//
//    public LivresEnCours findById(long id) throws ServiceException {
//        try {
//            LivresEnCours livreEnCours = livresEnCoursDao.findById(id);
//            if (livreEnCours != null) {
//                return livreEnCours;
//            }
//            throw new ServiceException("Le livre en cours n°" + id + " n'a pas été trouvé dans la base de données.");
//        } catch (DaoException e) {
//            throw new ServiceException("Erreur lors de la recherche du livre en cours: " + e.getMessage(), e);
//        }
//    }
//
//    public List<LivresEnCours> findAll() throws ServiceException {
//        try {
//            List<LivresEnCours> livresEnCours = livresEnCoursDao.findAll();
//            if (livresEnCours != null && !livresEnCours.isEmpty()) {
//                return livresEnCours;
//            }
//            throw new ServiceException("Aucun livre en cours trouvé dans la base de données.");
//        } catch (DaoException e) {
//            throw new ServiceException("Erreur lors de la récupération des livres en cours: " + e.getMessage(), e);
//        }
//    }
//
//    public long count() throws ServiceException {
//        try {
//            return livresEnCoursDao.count();
//        } catch (DaoException e) {
//            throw new ServiceException("Erreur lors du comptage des livres en cours: " + e.getMessage(), e);
//        }
//    }
//
//    public List<LivresEnCours> findByUtilisateurId(long utilisateurId) throws ServiceException {
//        try {
//            List<LivresEnCours> livresEnCours = livresEnCoursDao.findByUtilisateurId(utilisateurId);
//            if (livresEnCours != null && !livresEnCours.isEmpty()) {
//                return livresEnCours;
//            }
//            throw new ServiceException("Aucun livre en cours trouvé pour l'utilisateur avec l'ID : " + utilisateurId);
//        } catch (DaoException e) {
//            throw new ServiceException("Erreur lors de la recherche des livres en cours par ID d'utilisateur: " + e.getMessage(), e);
//        }
//    }
//
//    // Nouvelle méthode pour trouver des livres en cours par livre ID
//    public List<LivresEnCours> findByLivreId(long livreId) throws ServiceException {
//        try {
//            List<LivresEnCours> livresEnCours = livresEnCoursDao.findByLivreId(livreId);
//            if (livresEnCours != null && !livresEnCours.isEmpty()) {
//                return livresEnCours;
//            }
//            throw new ServiceException("Aucun livre en cours trouvé avec l'ID de livre : " + livreId);
//        } catch (DaoException e) {
//            throw new ServiceException("Erreur lors de la recherche des livres en cours par livre ID: " + e.getMessage(), e);
//        }
//    }
//}
