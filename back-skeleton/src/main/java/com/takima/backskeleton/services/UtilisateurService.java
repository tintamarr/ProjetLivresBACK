package com.takima.backskeleton.services;

import com.takima.backskeleton.DAO.UtilisateurDao;
import com.takima.backskeleton.exceptions.DaoException;
import com.takima.backskeleton.models.Utilisateur;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService {

    private final UtilisateurDao utilisateurDao;

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
