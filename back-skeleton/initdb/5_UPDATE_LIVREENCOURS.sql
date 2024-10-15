ALTER TABLE livresencours
    ADD COLUMN idLivresEnCours SERIAL;
ALTER TABLE livresencours
    ADD CONSTRAINT pk_livresencours PRIMARY KEY (idLivresEnCours);