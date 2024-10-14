//package com.takima.backskeleton.service;
//
//import com.takima.backskeleton.dao.UtilisateurDao;
//import com.takima.backskeleton.exeptions.DaoException;
//import com.takima.backskeleton.exeptions.ServiceException;
//import com.takima.backskeleton.models.Utilisateur;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class UtilisateurService {
//
//    private final UtilisateurDao utilisateurDao;
//
//    public UtilisateurService(UtilisateurDao utilisateurDao) {
//        this.utilisateurDao = utilisateurDao;
//    }
//
//    public long create(Utilisateur utilisateur) throws ServiceException {
//        try {
//            // Ici tu peux ajouter des validations, si nécessaire
//            utilisateurDao.create(utilisateur);
//            return utilisateur.getId();  // Supposons que la méthode getId() retourne l'identifiant
//        } catch (DaoException e) {
//            throw new ServiceException("Erreur lors de la création de l'utilisateur: " + e.getMessage(), e);
//        }
//    }
//
//    public long delete(Utilisateur utilisateur) throws ServiceException {
//        try {
//            utilisateurDao.delete(utilisateur);
//            return utilisateur.getId();  // Retourne l'ID de l'utilisateur supprimé
//        } catch (DaoException e) {
//            throw new ServiceException("Erreur lors de la suppression de l'utilisateur: " + e.getMessage(), e);
//        }
//    }
//
//    public Utilisateur findById(long id) throws ServiceException {
//        try {
//            Utilisateur utilisateur = utilisateurDao.findById(id);
//            if (utilisateur != null) {
//                return utilisateur;
//            }
//            throw new ServiceException("L'utilisateur avec l'ID " + id + " n'a pas été trouvé.");
//        } catch (DaoException e) {
//            throw new ServiceException("Erreur lors de la recherche de l'utilisateur: " + e.getMessage(), e);
//        }
//    }
//
//    public List<Utilisateur> findAll() throws ServiceException {
//        try {
//            return utilisateurDao.findAll();
//        } catch (DaoException e) {
//            throw new ServiceException("Erreur lors de la récupération des utilisateurs: " + e.getMessage(), e);
//        }
//    }
//
//    public long count() throws ServiceException {
//        try {
//            return utilisateurDao.count();
//        } catch (DaoException e) {
//            throw new ServiceException("Erreur lors du comptage des utilisateurs: " + e.getMessage(), e);
//        }
//    }
//
//    public List<Utilisateur> findByName(String name) throws ServiceException {
//        try {
//            return utilisateurDao.findByName(name);
//        } catch (DaoException e) {
//            throw new ServiceException("Erreur lors de la recherche des utilisateurs par nom: " + e.getMessage(), e);
//        }
//    }
//}
