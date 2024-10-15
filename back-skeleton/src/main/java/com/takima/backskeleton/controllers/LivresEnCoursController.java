package com.takima.backskeleton.controllers;

import com.takima.backskeleton.exceptions.ServiceException;
import com.takima.backskeleton.models.Livresencours;
import com.takima.backskeleton.DTO.LivresEnCoursDto;
import com.takima.backskeleton.services.LivresEnCoursService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("livresencours")
@RestController
public class LivresEnCoursController {

    private final LivresEnCoursService livresEnCoursService;

    public LivresEnCoursController(LivresEnCoursService livresEnCoursService) {
        this.livresEnCoursService = livresEnCoursService;
    }
    @GetMapping("")
    public List<Livresencours> getAllLivresEnCours() throws ServiceException {
        return livresEnCoursService.findAll();
    }
    @PostMapping("/create")
    public Livresencours createLivreEnCours(@RequestBody LivresEnCoursDto livresEnCoursDto) throws ServiceException {
        return livresEnCoursService.createLivreEnCours(livresEnCoursDto);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteLivreEnCours(@PathVariable("id") Long id) throws ServiceException {
        livresEnCoursService.deleteLivreEnCours(id);
    }
    @GetMapping("/utilisateur/{idUtilisateur}")
    public List<Livresencours> findByUtilisateur(@PathVariable("idUtilisateur") Long idUtilisateur) throws ServiceException {
        return livresEnCoursService.findByUtilisateur(idUtilisateur);
    }
    @GetMapping("/livre/{idLivre}")
    public List<Livresencours> findByLivre(@PathVariable("idLivre") Long idLivre) throws ServiceException {
        return livresEnCoursService.findByLivre(idLivre);
    }
    @GetMapping("/id/{id}")
    public Livresencours findById(@PathVariable("id") Long id) throws ServiceException {
        return livresEnCoursService.findById(id);
    }
    @GetMapping("/count")
    public long countLivresEnCours() throws ServiceException {
        return livresEnCoursService.countLivresEnCours();
    }
}
