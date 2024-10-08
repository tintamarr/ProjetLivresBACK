INSERT INTO utilisateurs (id_utilisateur,nom,prenom,pseudo,mail,datenaissance) VALUES (1, 'RICAUD', 'Amélie', 'amé','mail@gmail.com', '2002-07-31');
INSERT INTO livres (id_livre,edition,titre,auteur,resume,date_parution,date_ajout, note) VALUES (1, 'Pocket', 'La mer sans étoile', 'Erin','Homme face à la porte', '2020-01-01', '2022-10-08', 5);
INSERT INTO commentaires (ID_UTILISATEUR, ID_LIVRE, ID_COMMENTAIRE, COMMENTAIRE, NOTE_UNIQUE, STATUT) VALUES (1, 1, 1, 'C est trop bine', 5, false);
INSERT INTO livreslus (id_utilisateur, id_livre) VALUES (1,1);
INSERT INTO pilealire (id_utilisateur, id_livre) VALUES (1,1);
INSERT INTO livresencours (id_utilisateur, id_livre, progression) VALUES (1,1, 50);


