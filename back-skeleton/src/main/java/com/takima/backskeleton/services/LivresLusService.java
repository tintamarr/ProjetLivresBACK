package com.takima.backskeleton.services;

import com.takima.backskeleton.DAO.LivreDao;
import com.takima.backskeleton.DAO.LivresLusDao;
import com.takima.backskeleton.DAO.UtilisateurDao;
import com.takima.backskeleton.exceptions.DaoException;
import com.takima.backskeleton.exceptions.ServiceException;
import com.takima.backskeleton.models.Livres;
import com.takima.backskeleton.models.Livreslus;
import com.takima.backskeleton.models.Utilisateur;
import com.takima.backskeleton.DTO.LivresLusDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivresLusService {
    private final LivresLusDao livresLusDao;

    @Autowired
    private UtilisateurDao utilisateurDao;

    @Autowired
    private LivreDao livreDao;

    public LivresLusService(LivresLusDao livresLusDao) {
        this.livresLusDao = livresLusDao;
    }

    public List<Livreslus> findAllLivresLus() throws ServiceException {
        try {
            List<Livreslus> livreslus = livresLusDao.findTousLesLivresLus();
            if (livreslus != null && !livreslus.isEmpty()) {
                return livreslus;
            }
            throw new ServiceException("Aucun livre en cours trouvé.");
        } catch (DaoException e) {
            throw new ServiceException("Erreur lors de la récupération des livres en cours : " + e.getMessage());
        }
    }

    public Livreslus createLivresLus(LivresLusDto livresLusDto) throws ServiceException {
        try {

            Utilisateur utilisateur = utilisateurDao.findById(livresLusDto.getIdUtilisateur())
                    .orElseThrow(() -> new ServiceException("Utilisateur non trouvé avec l'ID : " + livresLusDto.getIdUtilisateur()));

            Livres livre = livreDao.findById(livresLusDto.getIdLivre())
                    .orElseThrow(() -> new ServiceException("Livre non trouvé avec l'ID : " + livresLusDto.getIdLivre()));


            Livreslus livreLus = new Livreslus();
            livreLus.setUtilisateur(utilisateur);
            livreLus.setLivre(livre);
            return livresLusDao.creerLivresLus(livreLus);

        } catch (DaoException e) {
            throw new ServiceException("Erreur lors de la création du livre en cours : " + e.getMessage());
        }
    }

    public long countLivresLus() throws ServiceException {
        try {
            return livresLusDao.compterLivresLus();
        } catch (DaoException e) {
            throw new ServiceException("Erreur lors du comptage des livres en cours : " + e.getMessage());
        }
    }

    public void deleteLivresLus(Long idLivresLus) throws ServiceException {
        try {
            livresLusDao.supprimerLivreLus(idLivresLus);
        } catch (DaoException e) {
            throw new ServiceException("Erreur lors de la suppression du livre en cours : " + e.getMessage());
        }
    }

    public Livreslus findById(Long id) throws ServiceException {
        try {
            Livreslus livreLus = livresLusDao.findLivreLusParId(id);
            if (livreLus != null) {
                return livreLus;
            }
            throw new ServiceException("Aucun livre en cours trouvé avec l'ID : " + id);
        } catch (DaoException e) {
            throw new ServiceException("Erreur lors de la recherche du livre en cours : " + e.getMessage());
        }
    }

    public List<Livreslus> findByUtilisateur(Long idUtilisateur) throws ServiceException {
        try {
            List<Livreslus> livresLus = livresLusDao.findLivresLusParUtilisateur(idUtilisateur);
            if (livresLus != null && !livresLus.isEmpty()) {
                return livresLus;
            }
            throw new ServiceException("Aucun livre en cours trouvé pour l'utilisateur avec l'ID : " + idUtilisateur);
        } catch (DaoException e) {
            throw new ServiceException("Erreur lors de la recherche des livres en cours par utilisateur : " + e.getMessage());
        }
    }

    public List<Livreslus> findByLivre(Long idLivre) throws ServiceException {
        try {
            List<Livreslus> livresLus = livresLusDao.findLivresLusParLivre(idLivre);
            if (livresLus != null && !livresLus.isEmpty()) {
                return livresLus;
            }
            throw new ServiceException("Aucun livre en cours trouvé pour le livre avec l'ID : " + idLivre);
        } catch (DaoException e) {
            throw new ServiceException("Erreur lors de la recherche des livres en cours par livre : " + e.getMessage());
        }
    }
}
