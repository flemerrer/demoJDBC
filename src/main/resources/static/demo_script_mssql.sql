--Supprime les tables si elles existent
DROP TABLE FORMATEURS;
DROP TABLE COURS_ENI;

--Crée la table COURS_ENI
CREATE TABLE COURS_ENI
(
	id    int PRIMARY KEY,
	titre NVARCHAR(250) NOT NULL,
	duree int NOT NULL
);

--Crée la table FORMATEURS
CREATE TABLE FORMATEURS
(
	email              NVARCHAR(200)  PRIMARY KEY,
	nom                NVARCHAR(250) NOT NULL,
	prenom             NVARCHAR(250) NOT NULL,
	id_cours_principal int
);

-- ENREGISTREMENTS :

--Insère des enregistrements dans la table FORMATEURS
INSERT INTO FORMATEURS (email, nom, prenom)
VALUES ('abaille@campus-eni.fr', 'BAILLE', 'Anne-Lise');
INSERT INTO FORMATEURS (email, nom, prenom)
VALUES ('jtrillard@campus-eni.fr', 'TRILLARD', 'Julien');
INSERT INTO FORMATEURS (email, nom, prenom)
VALUES ('fdelaschesnais@campus-eni.fr', 'DELACHESNAIS', 'Frédéric');
