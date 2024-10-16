ALTER TABLE livres
    ALTER COLUMN nombre_pages
        SET DATA TYPE INTEGER USING nombre_pages::integer;