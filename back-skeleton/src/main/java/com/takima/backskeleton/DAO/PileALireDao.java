package com.takima.backskeleton.DAO;

import com.takima.backskeleton.exceptions.DaoException;
import com.takima.backskeleton.models.Pilealire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PileALireDao extends JpaRepository<Pilealire, Long> {

    default List<Pilealire> findTousLesPileALire() throws DaoException {
        try {
            return findAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DaoException();
        }
    }

    default List<Pilealire> findPileALireParUtilisateur(Long id_utilisateur) throws DaoException {
        try {
            return findByUtilisateurIdUtilisateur(id_utilisateur);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DaoException();
        }
    }

    List<Pilealire> findByUtilisateurIdUtilisateur(Long idUtilisateur);

    default List<Pilealire> findPileALireParLivre(Long id_livre) throws DaoException {
        try {
            return findByLivreIdLivre(id_livre);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DaoException();
        }
    }

    List<Pilealire> findByLivreIdLivre(Long idLivre);

    default Pilealire findPileALireParId(Long id) throws DaoException {
        try {
            return findByIdPileALire(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DaoException();
        }
    }

    Pilealire findByIdPileALire(Long id);


    default Pilealire creerPileALire(Pilealire pilealire) throws DaoException {
        try {
            return save(pilealire);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DaoException();
        }
    }

    default void supprimerPileALire(Long id_pile_alire) throws DaoException {
        try {
            deleteById(id_pile_alire);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DaoException();
        }
    }

    default long compterPileALire() throws DaoException {
        try {
            return count();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DaoException();
        }
    }
}

