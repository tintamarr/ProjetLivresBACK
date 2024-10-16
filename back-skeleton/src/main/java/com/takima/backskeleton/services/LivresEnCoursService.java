package com.takima.backskeleton.services;

import com.takima.backskeleton.DAO.LivreDao;
import com.takima.backskeleton.DAO.LivresEnCoursDao;
import com.takima.backskeleton.DAO.UtilisateurDao;
import com.takima.backskeleton.exceptions.DaoException;
import com.takima.backskeleton.exceptions.ServiceException;
import com.takima.backskeleton.models.Livres;
import com.takima.backskeleton.models.Livresencours;
import com.takima.backskeleton.models.Utilisateur;
import com.takima.backskeleton.DTO.LivresEnCoursDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LivresEnCoursService {

    private final LivresEnCoursDao livresEnCoursDao;

    @Autowired
    private UtilisateurDao utilisateurDao;

    @Autowired
    private LivreDao livreDao;

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

    public Livresencours createLivreEnCours(LivresEnCoursDto livresEnCoursDto) throws ServiceException {
        try {
            
            Utilisateur utilisateur = utilisateurDao.findById(livresEnCoursDto.getIdUtilisateur())
                    .orElseThrow(() -> new ServiceException("Utilisateur non trouvé avec l'ID : " + livresEnCoursDto.getIdUtilisateur()));

            Livres livre = livreDao.findById(livresEnCoursDto.getIdLivre())
                    .orElseThrow(() -> new ServiceException("Livre non trouvé avec l'ID : " + livresEnCoursDto.getIdLivre()));


            Livresencours livreEnCours = new Livresencours();
            livreEnCours.setUtilisateur(utilisateur);
            livreEnCours.setLivre(livre);
            livreEnCours.setProgression(livresEnCoursDto.getProgression());
            return livresEnCoursDao.creerLivreEnCours(livreEnCours);

        } catch (DaoException e) {
            throw new ServiceException("Erreur lors de la création du livre en cours : " + e.getMessage());
        }
    }

    public long countLivresEnCours() throws ServiceException {
        try {
            return livresEnCoursDao.compterLivresEnCours();
        } catch (DaoException e) {
            throw new ServiceException("Erreur lors du comptage des livres en cours : " + e.getMessage());
        }
    }

    public void deleteLivreEnCours(Long idLivresEnCours) throws ServiceException {
        try {
            livresEnCoursDao.supprimerLivreEnCours(idLivresEnCours);
        } catch (DaoException e) {
            throw new ServiceException("Erreur lors de la suppression du livre en cours : " + e.getMessage());
        }
    }

    public Livresencours findById(Long id) throws ServiceException {
        try {
            Livresencours livreEnCours = livresEnCoursDao.findLivreEnCoursParId(id);
            if (livreEnCours != null) {
                return livreEnCours;
            }
            throw new ServiceException("Aucun livre en cours trouvé avec l'ID : " + id);
        } catch (DaoException e) {
            throw new ServiceException("Erreur lors de la recherche du livre en cours : " + e.getMessage());
        }
    }

    public List<Livresencours> findByUtilisateur(Long idUtilisateur) throws ServiceException {
        try {
            List<Livresencours> livresEnCours = livresEnCoursDao.findLivresEnCoursParUtilisateur(idUtilisateur);
            return (livresEnCours != null) ? livresEnCours : new ArrayList<>();
        } catch (DaoException e) {
            throw new ServiceException("Erreur lors de la recherche des livres en cours par utilisateur : " + e.getMessage());
        }
    }

    public List<Livresencours> findByLivre(Long idLivre) throws ServiceException {
        try {
            List<Livresencours> livresEnCours = livresEnCoursDao.findLivresEnCoursParLivre(idLivre);
            return (livresEnCours != null) ? livresEnCours : new ArrayList<>();
        } catch (DaoException e) {
            throw new ServiceException("Erreur lors de la recherche des livres en cours par livre : " + e.getMessage());
        }
    }
}