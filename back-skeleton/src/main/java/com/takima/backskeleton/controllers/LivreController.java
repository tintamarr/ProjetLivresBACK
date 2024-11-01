package com.takima.backskeleton.controllers;

import com.takima.backskeleton.exceptions.ServiceException;
import com.takima.backskeleton.models.Livres;
import com.takima.backskeleton.services.LivreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RequestMapping("livres")
@RestController
public class LivreController {
    private final LivreService livreService;

    public LivreController(LivreService livreService) {
        this.livreService = livreService;
    }

    @GetMapping("")
    public List<Livres> getAllLivres() throws ServiceException {
        return livreService.findAll();
    }
    @PostMapping("/create")
    public Livres createLivre(@RequestBody Livres livre) throws ServiceException {
        return livreService.createLivre(livre);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteLivre(@PathVariable("id") Long id) throws ServiceException {
        livreService.deleteLivre(id);
    }
    @GetMapping("/titre/{titre}")
    public List<Livres> findByTitre(@PathVariable("titre") String titre) throws ServiceException {
        return livreService.findByTitre(titre);
    }
    @GetMapping("/auteur/{auteur}")
    public List<Livres> findByAuteur(@PathVariable("auteur") String auteur) throws ServiceException {
        return livreService.findByAuteur(auteur);
    }
    @GetMapping("/edition/{edition}")
    public List<Livres> findByEdition(@PathVariable("edition") String edition) throws ServiceException {
        return livreService.findByEdition(edition);
    }

    @GetMapping("/genre/{genre}")
    public List<Livres> findByGenre(@PathVariable("genre") String genre) throws ServiceException {
        return livreService.findByGenre(genre);
    }
    @GetMapping("/id/{id}")
    public Livres findById(@PathVariable("id") Long id) throws ServiceException {
        return livreService.findById(id);
    }
    @GetMapping("/count")
    public long countLivres() throws ServiceException {
        return livreService.countLivre();
    }

    @GetMapping("/recents")
    public List<Livres> getDerniersLivres() throws ServiceException {
        return livreService.findDerniersLivres();
    }
}


