drop table courses;
drop table majors;
drop table student_course;
drop table students;

create table livres
(
    id_livre SERIAL PRIMARY KEY,
    edition TEXT not null,
    titre TEXT not null,
    auteur TEXT not null,
    resume TEXT not null,
    date_parution DATE not null,
    date_ajout DATE not null,
    note int null
);

create table Utilisateurs
(
    ID_utilisateur SERIAL PRIMARY KEY,
    Nom VARCHAR (50) not null,
    Prenom VARCHAR (50) not null,
    Pseudo VARCHAR (50) not null,
    Mail VARCHAR(50) not null,
    DateNaissance DATE not null
);

create table PileALire
(
    ID_utilisateur int not null,
    CONSTRAINT fk_utilisateur
        FOREIGN KEY (ID_utilisateur)
            REFERENCES Utilisateurs(ID_utilisateur),

    id_livre int not null,
    CONSTRAINT fk_livre
        FOREIGN KEY (id_livre)
            REFERENCES Livres(id_livre)
);

create table LivresEnCours
(
    Progression int,
    ID_utilisateur int not null,
    CONSTRAINT fk_utilisateur
        FOREIGN KEY (ID_utilisateur)
            REFERENCES Utilisateurs(ID_utilisateur),

    id_livre int not null,
    CONSTRAINT fk_livre
        FOREIGN KEY (id_livre)
            REFERENCES Livres(id_livre)
);

create table LivresLus
(
    ID_utilisateur int not null,
    CONSTRAINT fk_utilisateur
        FOREIGN KEY (ID_utilisateur)
            REFERENCES Utilisateurs(ID_utilisateur),

    id_livre int not null,
    CONSTRAINT fk_livre
        FOREIGN KEY (id_livre)
            REFERENCES Livres(id_livre)
);

create table Commentaires
(
    ID_utilisateur int not null,
    CONSTRAINT fk_utilisateur
        FOREIGN KEY (ID_utilisateur)
            REFERENCES Utilisateurs(ID_utilisateur),

    id_livre int not null,
    CONSTRAINT fk_livre
        FOREIGN KEY (id_livre)
            REFERENCES Livres(id_livre),

    ID_commentaire SERIAL PRIMARY KEY,
    Commentaire TEXT,
    Note_unique int,
    Statut BOOLEAN

)