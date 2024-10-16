package com.takima.backskeleton.DAO;

import com.takima.backskeleton.exceptions.DaoException;
import com.takima.backskeleton.models.Livres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivreDao extends JpaRepository<Livres, Long> {

    default List<Livres> findLivreParTitre(String titre) throws DaoException {
        try {
            return findByTitre(titre);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DaoException();
        }
    }

    List<Livres> findByTitre(String titre);

    default List<Livres> findLivreParAuteur(String auteur) throws DaoException {
        try {
            return findByAuteur(auteur);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DaoException();
        }
    }
    List<Livres> findByAuteur(String auteur);
    default List<Livres> findLivreParEdition(String edition) throws DaoException {
        try {
            return findByEdition(edition);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DaoException();
        }
    }
    List<Livres> findByEdition(String edition);
    default List<Livres> findLivreParGenre(String genre) throws DaoException {
        try {
            return findByGenre(genre);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DaoException();
        }
    }
    List<Livres> findByGenre(String edition);

    List<Livres> findAll();

    default Livres findLivreParId(Long id_livre) throws DaoException {
        try {
            return findByIdLivre(id_livre);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DaoException();
        }
    }

    Livres findByIdLivre(long idLivre);

    default Livres creerLivre(Livres livre) throws DaoException {
        try {
            return save(livre);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DaoException();
        }
    }
    default void supprimerLivre(Long id_livre) throws DaoException {
        try{
            deleteById(id_livre);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DaoException();
        }
    }

    default long compterLivres() throws DaoException {
        try {
            return count();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DaoException();
        }
    }


}