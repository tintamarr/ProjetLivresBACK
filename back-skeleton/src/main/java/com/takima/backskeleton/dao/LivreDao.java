package com.takima.backskeleton.dao;

import com.takima.backskeleton.models.Livres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivreDao extends JpaRepository<Livres, Long> {

    List<Livres> findByTitre(String titre);
    List<Livres> findByAuteur(String auteur);
    List<Livres> findByEdition(String edition);
    List<Livres> findAll();

    Livres findByIdLivre(long id);

    default Livres creerLivre(Livres livre) {
        return save(livre);
    }

//     Méthode pour supprimer un livre par ID
    default void supprimerLivre(Long idLivre) {
        deleteById(idLivre);
    }
}