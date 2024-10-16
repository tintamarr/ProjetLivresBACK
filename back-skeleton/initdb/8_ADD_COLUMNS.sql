ALTER TABLE livres
    ADD COLUMN couverture VARCHAR(250);

ALTER TABLE livres
    ADD COLUMN genre VARCHAR(50);

ALTER TABLE livres
    ADD COLUMN nombre_pages VARCHAR(50);

ALTER TABLE utilisateurs
    ADD COLUMN photo_profil int;

UPDATE livres
SET couverture = 'https://m.media-amazon.com/images/I/71sNGnoZnpL._AC_UF1000,1000_QL80_.jpg',
    genre = 'Roman',
    nombre_pages = '350'
WHERE ctid = (SELECT ctid FROM livres LIMIT 1);

UPDATE utilisateurs
SET photo_profil = 1
WHERE ctid = (SELECT ctid FROM utilisateurs LIMIT 1);