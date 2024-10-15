package com.takima.backskeleton.controllers;

import com.takima.backskeleton.DTO.CommentairesDto;
import com.takima.backskeleton.exceptions.DaoException;
import com.takima.backskeleton.exceptions.ServiceException;
import com.takima.backskeleton.models.Commentaires;
import com.takima.backskeleton.services.CommentairesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("commentaires")
@RestController
public class CommentairesController {

    private final CommentairesService commentairesService;

    public CommentairesController(CommentairesService commentairesService) {
        this.commentairesService = commentairesService;
    }

    @PostMapping("/create")
    public Commentaires createCommentaire(@RequestBody CommentairesDto commentaireDto) throws DaoException, ServiceException {
        return commentairesService.createCommentaire(commentaireDto);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteCommentaire(@PathVariable("id") Long id) throws DaoException {
        commentairesService.deleteCommentaire(id);
    }

    @GetMapping("/findCommentaireById/{id}")
    public Commentaires getCommentaireById(@PathVariable("id") Long id) throws DaoException {
        return commentairesService.findById(id);
    }

    @GetMapping("/findAllCommentaires")
    public List<Commentaires> getAllCommentaires() throws DaoException {
        return commentairesService.findAll();
    }

    @GetMapping("/utilisateur/{id_utilisateur}")
    public List<Commentaires> getCommentairesByUtilisateurId(@PathVariable("id_utilisateur") Long utilisateurId) throws DaoException {
        return commentairesService.findByUtilisateurId(utilisateurId);
    }


    @GetMapping("/livre/{id_livre}")
    public List<Commentaires> getCommentairesByLivreId(@PathVariable("id_livre") Long livreId) throws DaoException {
        return commentairesService.findByLivreId(livreId);
    }

    @GetMapping("/note/{note}")
    public List<Commentaires> getCommentairesByNote(@PathVariable("note") Integer note) throws DaoException {
        return commentairesService.findByNote(note);
    }
}
