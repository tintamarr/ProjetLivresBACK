package com.takima.backskeleton.controllers;

import com.takima.backskeleton.exceptions.ServiceException;
import com.takima.backskeleton.models.Livreslus;
import com.takima.backskeleton.DTO.LivresLusDto;
import com.takima.backskeleton.services.LivresLusService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("livreslus")
@RestController
public class LivresLusController {

    private final LivresLusService livresLusService;

    public LivresLusController(LivresLusService livresLusService) {
        this.livresLusService = livresLusService;
    }
    @GetMapping("")
    public List<Livreslus> getAllLivreslus() throws ServiceException {
        return livresLusService.findAllLivresLus();
    }

    @PostMapping("/create")
    public Livreslus createLivreLus(@RequestBody LivresLusDto livresLusDto) throws ServiceException {
        return livresLusService.createLivresLus(livresLusDto);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteLivreLus(@PathVariable("id") Long id) throws ServiceException {
        livresLusService.deleteLivresLus(id);
    }
    @GetMapping("/utilisateur/{idUtilisateur}")
    public List<Livreslus> findByUtilisateur(@PathVariable("idUtilisateur") Long idUtilisateur) throws ServiceException {
        return livresLusService.findByUtilisateur(idUtilisateur);
    }
    @GetMapping("/livre/{idLivre}")
    public List<Livreslus> findByLivre(@PathVariable("idLivre") Long idLivre) throws ServiceException {
        return livresLusService.findByLivre(idLivre);
    }
    @GetMapping("/id/{id}")
    public Livreslus findById(@PathVariable("id") Long id) throws ServiceException {
        return livresLusService.findById(id);
    }
    @GetMapping("/count")
    public long countLivresLus() throws ServiceException {
        return livresLusService.countLivresLus();
    }

}
