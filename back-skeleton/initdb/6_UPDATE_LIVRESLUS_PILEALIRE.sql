ALTER TABLE livreslus
    ADD COLUMN id_livres_lus SERIAL;
ALTER TABLE livreslus
    ADD CONSTRAINT pk_livres_lus PRIMARY KEY (id_livres_lus);

ALTER TABLE pilealire
    ADD COLUMN id_pile_a_lire SERIAL;
ALTER TABLE pilealire
    ADD CONSTRAINT pk_pile_a_lire PRIMARY KEY (id_pile_a_lire);