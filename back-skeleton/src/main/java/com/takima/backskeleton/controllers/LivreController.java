package com.takima.backskeleton.controllers;

import com.takima.backskeleton.exceptions.ServiceException;
import com.takima.backskeleton.models.Livres;
import com.takima.backskeleton.services.LivreService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}


