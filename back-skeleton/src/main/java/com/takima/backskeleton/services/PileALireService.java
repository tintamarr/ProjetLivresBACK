package com.takima.backskeleton.services;

import com.takima.backskeleton.dao.LivreDao;
import com.takima.backskeleton.dao.PileALireDao;
import com.takima.backskeleton.dao.UtilisateurDao;
import com.takima.backskeleton.exceptions.DaoException;
import com.takima.backskeleton.exceptions.ServiceException;
import com.takima.backskeleton.models.Livres;
import com.takima.backskeleton.models.Pilealire;
import com.takima.backskeleton.models.Utilisateur;
import com.takima.backskeleton.models.dto.PileALireDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PileALireService {
    private final PileALireDao pileALireDao;

    @Autowired
    private UtilisateurDao utilisateurDao;

    @Autowired
    private LivreDao livreDao;

    public PileALireService(PileALireDao pileALireDao) {
        this.pileALireDao = pileALireDao;
    }

    public List<Pilealire> findAllPileALire() throws ServiceException {
        try {
            List<Pilealire> pilealire = pileALireDao.findTousLesPileALire();
            if (pilealire != null && !pilealire.isEmpty()) {
                return pilealire;
            }
            throw new ServiceException("Aucun livre en cours trouvé.");
        } catch (DaoException e) {
            throw new ServiceException("Erreur lors de la récupération des livres en cours : " + e.getMessage());
        }
    }

    public Pilealire createPileALire(PileALireDto pileALireDto) throws ServiceException {
        try {

            Utilisateur utilisateur = utilisateurDao.findById(pileALireDto.getIdUtilisateur())
                    .orElseThrow(() -> new ServiceException("Utilisateur non trouvé avec l'ID : " + pileALireDto.getIdUtilisateur()));

            Livres livre = livreDao.findById(pileALireDto.getIdLivre())
                    .orElseThrow(() -> new ServiceException("Livre non trouvé avec l'ID : " + pileALireDto.getIdLivre()));


            Pilealire pileALire = new Pilealire();
            pileALire.setUtilisateur(utilisateur);
            pileALire.setLivre(livre);
            return pileALireDao.creerPileALire(pileALire);

        } catch (DaoException e) {
            throw new ServiceException("Erreur lors de la création du livre en cours : " + e.getMessage());
        }
    }

    public long countPileALire() throws ServiceException {
        try {
            return pileALireDao.compterPileALire();
        } catch (DaoException e) {
            throw new ServiceException("Erreur lors du comptage des livres en cours : " + e.getMessage());
        }
    }

    public void deletePileALire(Long idPileALire) throws ServiceException {
        try {
            pileALireDao.supprimerPileALire(idPileALire);
        } catch (DaoException e) {
            throw new ServiceException("Erreur lors de la suppression du livre en cours : " + e.getMessage());
        }
    }

    public Pilealire findById(Long id) throws ServiceException {
        try {
            Pilealire pileALire = pileALireDao.findPileALireParId(id);
            if (pileALire != null) {
                return pileALire;
            }
            throw new ServiceException("Aucun livre en cours trouvé avec l'ID : " + id);
        } catch (DaoException e) {
            throw new ServiceException("Erreur lors de la recherche du livre en cours : " + e.getMessage());
        }
    }

    public List<Pilealire> findByUtilisateur(Long idUtilisateur) throws ServiceException {
        try {
            List<Pilealire> pileALire = pileALireDao.findPileALireParUtilisateur(idUtilisateur);
            if (pileALire != null && !pileALire.isEmpty()) {
                return pileALire;
            }
            throw new ServiceException("Aucun livre en cours trouvé pour l'utilisateur avec l'ID : " + idUtilisateur);
        } catch (DaoException e) {
            throw new ServiceException("Erreur lors de la recherche des livres en cours par utilisateur : " + e.getMessage());
        }
    }

    public List<Pilealire> findByLivre(Long idLivre) throws ServiceException {
        try {
            List<Pilealire> pileALire = pileALireDao.findPileALireParLivre(idLivre);
            if (pileALire != null && !pileALire.isEmpty()) {
                return pileALire;
            }
            throw new ServiceException("Aucun livre en cours trouvé pour le livre avec l'ID : " + idLivre);
        } catch (DaoException e) {
            throw new ServiceException("Erreur lors de la recherche des livres en cours par livre : " + e.getMessage());
        }
    }
}
