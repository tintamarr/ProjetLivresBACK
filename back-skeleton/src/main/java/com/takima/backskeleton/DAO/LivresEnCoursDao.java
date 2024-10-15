package com.takima.backskeleton.DAO;

import com.takima.backskeleton.exceptions.DaoException;
import com.takima.backskeleton.models.Livresencours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivresEnCoursDao extends JpaRepository<Livresencours, Long> {

    default List<Livresencours> findLivresEnCoursParUtilisateur(Long id_utilisateur) throws DaoException {
        try {
            return findByUtilisateurIdUtilisateur(id_utilisateur);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DaoException();
        }
    }

    List<Livresencours> findByUtilisateurIdUtilisateur(Long idUtilisateur);

    default List<Livresencours> findLivresEnCoursParLivre(Long id_livre) throws DaoException {
        try {
            return findByLivreIdLivre(id_livre);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DaoException();
        }
    }

    List<Livresencours> findByLivreIdLivre(Long idLivre);

    default Livresencours findLivreEnCoursParId(Long id) throws DaoException {
        try {
            return findByIdlivresencours(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DaoException();
        }
    }

    Livresencours findByIdlivresencours(Long Idlivresencours);

    default List<Livresencours> findTousLesLivresEnCours() throws DaoException {
        try {
            return findAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DaoException();
        }
    }



    default Livresencours creerLivreEnCours(Livresencours livreEnCours) throws DaoException {
        try {
            return save(livreEnCours);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DaoException();
        }
    }

    default void supprimerLivreEnCours(Long id_livres_encours) throws DaoException {
        try {
            deleteById(id_livres_encours);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DaoException();
        }
    }

    default long compterLivresEnCours() throws DaoException {
        try {
            return count();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DaoException();
        }
    }

}
