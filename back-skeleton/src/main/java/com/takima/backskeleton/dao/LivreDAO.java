package com.takima.backskeleton.dao;

import com.takima.backskeleton.exceptions.DaoException;
import com.takima.backskeleton.model.Livre;
import com.takima.backskeleton.persistence.ConnectionManager;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LivreDAO {
    // Constructeur privé pour suivre le pattern singleton
    private LivreDAO() {}

    // Requêtes SQL
    private static final String CREATE_LIVRE_QUERY = "INSERT INTO livres(edition, titre, auteur, resume, date_parution, date_ajout, note) VALUES($1, $2, $3, $4, $5, $6, $7);";
    private static final String DELETE_LIVRE_QUERY = "DELETE FROM livres WHERE id_livre=$1;";
    private static final String FIND_LIVRE_QUERY = "SELECT * FROM livres WHERE id_livre=$1;";
    private static final String FIND_LIVRES_QUERY = "SELECT * FROM livres;";
    private static final String COUNT_LIVRES_QUERY = "SELECT COUNT(id_livre) AS count FROM livres;";

    // Méthode pour créer un livre
    public long create(Livre livre) throws DaoException {
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement ps = connection.prepareStatement(CREATE_LIVRE_QUERY)) {
            ps.setString(1, livre.getEdition());
            ps.setString(2, livre.getTitre());
            ps.setString(3, livre.getAuteur());
            ps.setString(4, livre.getResume());
            ps.setDate(5, Date.valueOf(livre.getDateParution()));
            ps.setDate(6, Date.valueOf(livre.getDateAjout()));
            ps.setFloat(7, livre.getNote());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new DaoException("Erreur lors de la création du livre : " + e.getMessage());
        }
        return livre.getIdLivre();
    }

    // Méthode pour supprimer un livre par ID
    public long delete(Livre livre) throws DaoException {
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement ps = connection.prepareStatement(DELETE_LIVRE_QUERY)) {
            ps.setLong(1, livre.getIdLivre());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Erreur lors de la suppression du livre : " + e.getMessage());
        }
        return livre.getIdLivre();
    }

    // Méthode pour trouver un livre par ID
    public Livre findById(long idLivre) throws DaoException {
        Livre livre = new Livre();
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement ps = connection.prepareStatement(FIND_LIVRE_QUERY)) {
            ps.setLong(1, idLivre);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                livre.setIdLivre(rs.getLong("id_livre"));
                livre.setEdition(rs.getString("edition"));
                livre.setTitre(rs.getString("titre"));
                livre.setAuteur(rs.getString("auteur"));
                livre.setResume(rs.getString("resume"));
                livre.setDateParution(rs.getDate("date_parution").toLocalDate());
                livre.setDateAjout(rs.getDate("date_ajout").toLocalDate());
                livre.setNote(rs.getFloat("note"));
            }
        } catch (SQLException e) {
            throw new DaoException("Erreur lors de la recherche du livre : " + e.getMessage());
        }
        return livre;
    }

    // Méthode pour récupérer tous les livres
    public List<Livre> findAll() throws DaoException {
        List<Livre> livres = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement ps = connection.prepareStatement(FIND_LIVRES_QUERY)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Livre livre = new Livre();
                livre.setIdLivre(rs.getLong("id_livre"));
                livre.setEdition(rs.getString("edition"));
                livre.setTitre(rs.getString("titre"));
                livre.setAuteur(rs.getString("auteur"));
                livre.setResume(rs.getString("resume"));
                livre.setDateParution(rs.getDate("date_parution").toLocalDate());
                livre.setDateAjout(rs.getDate("date_ajout").toLocalDate());
                livre.setNote(rs.getFloat("note"));
                livres.add(livre);
            }
        } catch (SQLException e) {
            throw new DaoException("Erreur lors de la récupération de la liste des livres : " + e.getMessage());
        }
        return livres;
    }

    // Méthode pour compter le nombre de livres
    public long count() throws DaoException {
        long nbrLivres = 0;
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement ps = connection.prepareStatement(COUNT_LIVRES_QUERY)) {
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                nbrLivres = rs.getLong("count");
            }
        } catch (SQLException e) {
            throw new DaoException("Erreur lors du comptage des livres : " + e.getMessage());
        }
        return nbrLivres;
    }
}
