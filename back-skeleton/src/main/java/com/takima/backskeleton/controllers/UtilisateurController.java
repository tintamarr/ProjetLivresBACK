package com.takima.backskeleton.controllers;

import com.takima.backskeleton.exceptions.DaoException;
import com.takima.backskeleton.models.Utilisateur;
import com.takima.backskeleton.services.UtilisateurService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("utilisateurs")
@RestController
public class UtilisateurController {

    private final UtilisateurService utilisateurService;

    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @PostMapping("/create")
    public Utilisateur createUtilisateur(@RequestBody Utilisateur utilisateur) throws DaoException {
        return utilisateurService.createUtilisateur(utilisateur);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUtilisateur(@PathVariable("id") Long id) throws DaoException {
        utilisateurService.deleteByIdUtilisateur(id);
    }

    @GetMapping("/count")
    public long countUtilisateurs() throws DaoException {
        return utilisateurService.countUtilisateurs();
    }

    @GetMapping("")
    public List<Utilisateur> getAllUtilisateurs() throws DaoException {
        return utilisateurService.findAllUtilisateurs();
    }


    @GetMapping("/{id}")
    public Utilisateur getUtilisateurById(@PathVariable("id") Long id) throws DaoException {
        return utilisateurService.findByIdUtilisateur(id);
    }

    @GetMapping("/nom/{nom}")
    public List<Utilisateur> getUtilisateurByNom(@PathVariable("nom") String nom) throws DaoException {
        return utilisateurService.findByNomUtilisateur(nom);
    }
}
