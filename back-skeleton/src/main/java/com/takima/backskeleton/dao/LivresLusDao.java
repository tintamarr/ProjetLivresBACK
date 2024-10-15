package com.takima.backskeleton.dao;

import com.takima.backskeleton.exceptions.DaoException;
import com.takima.backskeleton.models.Livreslus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivresLusDao extends JpaRepository<Livreslus, Long> {

    default List<Livreslus> findTousLesLivresLus() throws DaoException {
        try {
            return findAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DaoException();
        }
    }

    default List<Livreslus> findLivresLusParUtilisateur(Long id_utilisateur) throws DaoException {
        try {
            return findByUtilisateurIdUtilisateur(id_utilisateur);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DaoException();
        }
    }

    List<Livreslus> findByUtilisateurIdUtilisateur(Long idUtilisateur);

    default List<Livreslus> findLivresLusParLivre(Long id_livre) throws DaoException {
        try {
            return findByLivreIdLivre(id_livre);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DaoException();
        }
    }

    List<Livreslus> findByLivreIdLivre(Long idLivre);

    default Livreslus findLivreLusParId(Long id) throws DaoException {
        try {
            return findByIdLivresLus(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DaoException();
        }
    }

    Livreslus findByIdLivresLus(Long id);


    default Livreslus creerLivresLus(Livreslus livreslus) throws DaoException {
        try {
            return save(livreslus);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DaoException();
        }
    }

    default void supprimerLivreLus(Long id_livres_lus) throws DaoException {
        try {
            deleteById(id_livres_lus);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DaoException();
        }
    }

    default long compterLivresLus() throws DaoException {
        try {
            return count();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DaoException();
        }
    }
}
