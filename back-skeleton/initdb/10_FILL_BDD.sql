TRUNCATE TABLE commentaires, livresencours, livreslus, pilealire, livres, utilisateurs RESTART IDENTITY CASCADE;

INSERT INTO livres (edition, titre, auteur, resume, date_parution, date_ajout, note, couverture, genre, nombre_pages)
VALUES
    ('Pocket', 'La mer sans étoiles', 'Erin Morgenstern', 'Une hisoire de mondes parallèles.', '2019-11-05', '2023-01-15', 5, 'https://static.fnac-static.com/multimedia/Images/FR/NR/d7/cd/b1/11652567/1507-1/tsp20230308075437/La-Mer-sans-etoiles.jpg', 'Roman', 300),
    ('Gallimard', 'La Vie devant soi', 'Romain Gary', 'Une histoire d''amitié entre un garçon et une vieille dame à Belleville.', '2021-05-10', '2023-01-15', 5, 'https://m.media-amazon.com/images/I/81ZcBwoEwoL._SL1500_.jpg', 'Roman', 300),
    ('Actes Sud', 'Les Gratitudes', 'Delphine de Vigan', 'Un hommage émouvant à la reconnaissance et aux liens humains.', '2019-08-22', '2023-01-20', 4, 'https://m.media-amazon.com/images/I/71WrSQMY2WL._AC_UF1000,1000_QL80_.jpg', 'Drame', 240),
    ('Albin Michel', 'L''Anomalie', 'Hervé Le Tellier', 'Un avion rencontre une étrange anomalie temporelle.', '2020-09-01', '2023-02-05', 5, 'https://m.media-amazon.com/images/I/81vimU4GY3L._AC_UF1000,1000_QL80_.jpg', 'Science-fiction', 336),
    ('Grasset', 'Chanson douce', 'Leïla Slimani', 'Un thriller captivant autour de la relation d''une nounou et des enfants.', '2016-10-18', '2023-02-12', 4, 'https://static.fnac-static.com/multimedia/PE/Images/FR/NR/88/ef/8e/9367432/1507-1/tsp20240103071824/Chanson-douce.jpg', 'Thriller', 228),
    ('Robert Laffont', 'Les Déracinés', 'Catherine Bardon', 'Un roman historique sur l''exil et la résilience.', '2018-05-03', '2023-02-22', 5, 'https://servimg.eyrolles.com/static/media/8382/9782365698382_internet_h1400.jpg', 'Historique', 512),
    ('Seuil', 'Le Lambeau', 'Philippe Lançon', 'Une reconstruction physique et psychique après une tragédie.', '2018-04-12', '2023-03-10', 4, 'https://www.gallimard.fr/system/files/migrations/ouvrages/couvertures/G03679.jpg', 'Autobiographie', 496),
    ('L''Iconoclaste', 'Changer : méthode', 'Édouard Louis', 'Un récit de transformation personnelle.', '2021-01-07', '2023-03-15', 3, 'https://static.fnac-static.com/multimedia/PE/Images/FR/NR/40/8f/cd/13471552/1507-1/tsp20240809092432/Changer-methode.jpg', 'Essai', 208),
    ('Stock', 'L''Amie prodigieuse', 'Elena Ferrante', 'Une histoire d''amitié féminine dans l''Italie des années 1950.', '2011-08-29', '2023-03-18', 5, 'https://m.media-amazon.com/images/I/81BUhH+sgHL._AC_UF1000,1000_QL80_.jpg', 'Roman', 400),
    ('Actes Sud', 'L''Art de perdre', 'Alice Zeniter', 'Un roman qui explore l''héritage de la guerre d''Algérie.', '2017-08-23', '2023-03-20', 4, 'https://m.media-amazon.com/images/I/71X5Dc6BUAL._AC_UF1000,1000_QL80_.jpg', 'Historique', 504),
    ('Gallimard', 'En attendant Bojangles', 'Olivier Bourdeaut', 'Un amour fou raconté à travers le regard d''un enfant.', '2016-01-07', '2023-03-25', 5, 'https://static.fnac-static.com/multimedia/PE/Images/FR/NR/72/e2/83/8643186/1507-1/tsp20240730072900/En-attendant-Bojangles.jpg', 'Roman', 160),
    ('Flammarion', 'La panthère des neiges', 'Sylvain Tesson', 'Une quête de beauté et de contemplation au Tibet.', '2019-10-10', '2023-03-30', 4, 'https://m.media-amazon.com/images/I/71Ye1jmlUZL._AC_UF1000,1000_QL80_.jpg', 'Essai', 288),
    ('Grasset', 'La familia grande', 'Camille Kouchner', 'Un témoignage poignant sur les secrets de famille.', '2021-01-07', '2023-04-01', 4, 'https://m.media-amazon.com/images/I/513FP2h+aAL._AC_UF1000,1000_QL80_.jpg', 'Autobiographie', 240),
    ('Gallimard', 'Un dimanche', 'Claire Keegan', 'Un court récit sur la solitude et l''intensité des sentiments.', '2022-10-06', '2023-04-04', 3, 'https://m.media-amazon.com/images/I/813Nw9y2ReL._AC_UF1000,1000_QL80_.jpg', 'Roman', 112),
    ('Lattès', 'Le Cerf-volant', 'Laetitia Colombani', 'Une histoire de renaissance et de sororité en Inde.', '2021-06-02', '2023-04-08', 4, 'https://www.livredepoche.com/sites/default/files/images/livres/couv/9782253262848-001-T.jpeg', 'Roman', 288),
    ('Le livre de poche', 'Les femmes du bout du monde', 'Mélissa Da Costa', 'Une femme fuit ses problèmes en partant en Nouvelle-Zélande.', '2023-11-03', '2024-04-12', 4, 'https://www.livredepoche.com/sites/default/files/styles/manual_crop_269_435/public/images/livres/couv/9782253249016-001-T.jpeg', 'Roman', 208),
    ('Actes Sud', 'Avant que j''oublie', 'Anne Pauly', 'Un hommage bouleversant d''une fille à son père disparu.', '2019-08-21', '2023-04-15', 4, 'https://editions-verdier.fr/wp-content/uploads/2022/11/avant_que_j_oublie_prix-667x1024.jpg', 'Roman', 160),
    ('Flammarion', 'Leurs enfants après eux', 'Nicolas Mathieu', 'Chronique sociale des désillusions de la jeunesse française.', '2018-08-22', '2023-04-18', 5, 'https://www.actes-sud.fr/sites/default/files/couvertures/9782330108717.jpg', 'Roman', 430),
    ('Gallimard', 'À son image', 'Jérôme Ferrari', 'Réflexion sur la photographie et la guerre.', '2018-08-16', '2023-04-20', 3, 'https://static.fnac-static.com/multimedia/PE/Images/FR/NR/f2/2e/bc/12332786/1507-1/tsp20241010081458/A-son-image.jpg', 'Roman', 208),
    ('Albin Michel', 'La Tresse', 'Laetitia Colombani', 'Trois femmes dans le monde, unies par leur résilience.', '2017-05-10', '2023-04-22', 5, 'https://www.livredepoche.com/sites/default/files/images/livres/couv/9782253906568-001-T.jpeg', 'Roman', 224),
    ('Gallimard', 'Le consentement', 'Vanessa Springora', 'Un récit autobiographique sur l''emprise et le pouvoir.', '2020-01-02', '2023-04-25', 4, 'https://esprit.presse.fr/prod/file/esprit_presse/article/img_resize/42993_large.jpg', 'Autobiographie', 216),
    ('Actes Sud', 'Rien où poser sa tête', 'Françoise Frenkel', 'Une libraire en fuite pendant la Seconde Guerre mondiale.', '2015-03-01', '2023-04-28', 4, 'https://www.folio-lesite.fr/system/files/migrations/ouvrages/couvertures/G01330.jpg', 'Historique', 320),
    ('Seuil', 'Petit pays', 'Gaël Faye', 'Un jeune garçon fait face à la guerre au Burundi.', '2016-08-24', '2023-05-01', 5, 'https://www.livredepoche.com/sites/default/files/images/livres/couv/9782253070443-001-T.jpeg', 'Roman', 224),
    ('Folio', 'La Nuit des temps', 'René Barjavel', 'Science-fiction et romance autour d''une civilisation perdue.', '2017-09-10', '2023-05-03', 5, 'https://m.media-amazon.com/images/I/51agfIYIv3L._AC_UF1000,1000_QL80_.jpg', 'Science-fiction', 380),
    ('Lattès', 'La servante écarlate', 'Margaret Atwood', 'Dystopie dans un monde où les femmes n''ont plus de droits.', '2017-04-26', '2023-05-05', 5, 'https://m.media-amazon.com/images/I/510Px5VM8ML._AC_UF1000,1000_QL80_.jpg', 'Dystopie', 528),
    ('Gallimard', 'Des hommes justes', 'Ivan Jablonka', 'Une réflexion sur la masculinité et l''égalité.', '2019-09-05', '2023-05-07', 4, 'https://m.media-amazon.com/images/I/617w5QbZUAL._AC_UF894,1000_QL80_.jpg', 'Essai', 496),
    ('Lattès', 'Le Mur invisible', 'Marlen Haushofer', 'Une femme se retrouve isolée dans un monde hostile.', '2019-01-02', '2023-05-09', 4, 'https://actes-sud.fr/sites/default/files/couvertures/9782868698322.jpg', 'Dystopie', 350),
    ('Robert Laffont', 'L''Énigme de la chambre 622', 'Joël Dicker', 'Un meurtre non résolu dans un hôtel suisse.', '2020-06-03', '2023-05-10', 4, 'https://products-images.di-static.com/image/joel-dicker-l-enigme-de-la-chambre-622/9782889730025-475x500-1.jpg', 'Thriller', 560),
    ('Le Livre de Poche', 'Le Parfum', 'Patrick Süskind', 'Un homme avec un odorat exceptionnel devient tueur en série.', '2020-02-10', '2023-05-12', 5, 'https://m.media-amazon.com/images/I/71jeGu2g82L._AC_UF1000,1000_QL80_.jpg', 'Thriller', 272),
    ('Actes Sud', 'La salle de bal', 'Anna Hope', 'Une histoire d''amour et de tragédie dans un asile psychiatrique.', '2018-01-03', '2023-05-16', 4, 'https://m.media-amazon.com/images/I/71BpU5w5oLL._AC_UF1000,1000_QL80_.jpg', 'Roman', 400);

INSERT INTO utilisateurs (nom, prenom, pseudo, mail, datenaissance, photo_profil)
VALUES
    ('Martin', 'Léa', 'lea_mrt', 'lea.martin@example.com', '1998-04-12', 1),
    ('Dubois', 'Noah', 'noah_dbs', 'noah.dubois@example.com', '1995-06-23', 2),
    ('Garcia', 'Emma', 'emma_grc', 'emma.garcia@example.com', '2000-11-09', 3),
    ('Lefevre', 'Lucas', 'lucas_lfr', 'lucas.lefevre@example.com', '1997-03-15', 1),
    ('Moreau', 'Chloé', 'chloe_mr', 'chloe.moreau@example.com', '2001-09-27', 2),
    ('Simon', 'Enzo', 'enzo_smn', 'enzo.simon@example.com', '1999-02-17', 3),
    ('Roux', 'Camille', 'camille_rx', 'camille.roux@example.com', '1996-12-05', 1),
    ('Dupont', 'Léo', 'leo_dp', 'leo.dupont@example.com', '2003-07-19', 2),
    ('Fontaine', 'Inès', 'ines_ftn', 'ines.fontaine@example.com', '2002-10-11', 3),
    ('Blanc', 'Tom', 'tom_blc', 'tom.blanc@example.com', '1994-01-28', 1);

INSERT INTO pilealire (id_utilisateur, id_livre)
VALUES
    (1, 1), (1, 2), (1, 5), (1, 7), (1, 10),
    (2, 3), (2, 4),
    (3, 5), (3, 6),
    (4, 7), (4, 8),
    (5, 9), (5, 10),
    (6, 11), (6, 12),
    (7, 13), (7, 14),
    (8, 15), (8, 16),
    (9, 17), (9, 18),
    (10, 19), (10, 20);

INSERT INTO livreslus (id_utilisateur, id_livre)
VALUES
    (1, 3),
    (1, 4), (1, 6), (1, 9), (1, 12),
    (2, 6),
    (2, 8),
    (3, 10),
    (3, 11),
    (4, 13),
    (4, 14),
    (5, 16),
    (5, 17),
    (6, 19),
    (6, 20),
    (7, 22),
    (7, 23),
    (8, 25),
    (8, 26),
    (9, 28),
    (9, 29),
    (10, 30),
    (10, 1);

INSERT INTO livresencours (id_utilisateur, id_livre, progression)
VALUES
    (1, 3, 25), (1, 11, 40), (1, 13, 55), (1, 15, 70), (1, 18, 20),
    (2, 6, 40),
    (3, 12, 75),
    (4, 15, 50),
    (5, 18, 20),
    (6, 21, 10),
    (7, 24, 60),
    (8, 1, 45),
    (9, 9, 30),
    (10, 4, 80);

INSERT INTO commentaires (id_utilisateur, id_livre, commentaire, note_unique, statut)
VALUES
    (1, 3, 'Un chef-d''œuvre moderne.', 5, False),
    (1, 5, 'Un peu difficile à suivre mais fascinant.',  4, True),
    (2, 6, 'Un vrai plaisir de lecture, je recommande.',  5, False),
    (2, 8, 'Pas à mon goût, mais bien écrit.',  5, False),
    (3, 10, 'Une belle découverte littéraire.', 4, True),
    (3, 12, 'Une histoire prenante et bien rythmée.',  5, False),
    (4, 13, 'Simple mais poignant.', 4, True),
    (4, 15, 'Beaucoup d''émotion dans cette lecture.', 5, False),
    (5, 16, 'Vraiment inspirant, à lire.', 4, True),
    (5, 17, 'Une histoire qui marque.',  5, False),
    (6, 19, 'Passionnant du début à la fin.', 4, True),
    (6, 21, 'Des personnages attachants.',  5, False),
    (7, 22, 'Un véritable voyage littéraire.',4, True),
    (7, 23, 'Pas convaincu par la fin.',  5, False),
    (8, 25, 'Mon coup de cœur de l''année.', 4, True),
    (8, 27, 'Intéressant mais un peu confus.',  5, False),
    (9, 28, 'Très bien écrit, à découvrir.', 4, True),
    (9, 1, 'Je recommande vivement.',  5, False),
    (10, 2, 'Magnifique et bouleversant.',4, True),
    (10, 2, 'À lire absolument.',  5, False);