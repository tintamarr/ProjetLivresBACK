package com.takima.backskeleton.controllers;

import com.takima.backskeleton.exceptions.ServiceException;
import com.takima.backskeleton.models.Pilealire;
import com.takima.backskeleton.DTO.PileALireDto;
import com.takima.backskeleton.services.PileALireService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("pilealire")
@RestController
public class PileALireController {

    private final PileALireService pileALireService;

    public PileALireController(PileALireService pileALireService) {
        this.pileALireService = pileALireService;
    }

    @GetMapping("")
    public List<Pilealire> getAllPileALire() throws ServiceException {
        return pileALireService.findAllPileALire();
    }

    @PostMapping("/create")
    public Pilealire createPileALire(@RequestBody PileALireDto pileALireDto) throws ServiceException {
        return pileALireService.createPileALire(pileALireDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePileALire(@PathVariable("id") Long id) throws ServiceException {
        pileALireService.deletePileALire(id);
    }

    @GetMapping("/utilisateur/{idUtilisateur}")
    public List<Pilealire> findByUtilisateur(@PathVariable("idUtilisateur") Long idUtilisateur) throws ServiceException {
        return pileALireService.findByUtilisateur(idUtilisateur);
    }

    @GetMapping("/livre/{idLivre}")
    public List<Pilealire> findByLivre(@PathVariable("idLivre") Long idLivre) throws ServiceException {
        return pileALireService.findByLivre(idLivre);
    }

    @GetMapping("/id/{id}")
    public Pilealire findById(@PathVariable("id") Long id) throws ServiceException {
        return pileALireService.findById(id);
    }

    @GetMapping("/count")
    public long countPileALire() throws ServiceException {
        return pileALireService.countPileALire();
    }

}
