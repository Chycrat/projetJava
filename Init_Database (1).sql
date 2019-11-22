#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------


#------------------------------------------------------------
# Table: Reunion
#------------------------------------------------------------

CREATE TABLE Reunion(
        id_reunion   Int  Auto_increment  NOT NULL ,
        Date         Date NOT NULL ,
        Lieu         Varchar (100) NOT NULL ,
        Objectif     Varchar (150) NOT NULL ,
        Compte_rendu Varchar (500) NOT NULL
	,CONSTRAINT Reunion_PK PRIMARY KEY (id_reunion)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Role
#------------------------------------------------------------

CREATE TABLE Role(
        id_role  Int  Auto_increment  NOT NULL ,
        Nom_role Varchar (50) NOT NULL
	,CONSTRAINT Role_PK PRIMARY KEY (id_role)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Collab
#------------------------------------------------------------

CREATE TABLE Collab(
        id_collab Int  Auto_increment  NOT NULL ,
        Nom       Varchar (50) NOT NULL ,
        Prenom    Varchar (50) NOT NULL ,
        Login     Varchar (100) NOT NULL ,
        Password  Varchar (100) NOT NULL ,
        id_role   Int NOT NULL
	,CONSTRAINT Collab_PK PRIMARY KEY (id_collab)

	,CONSTRAINT Collab_Role_FK FOREIGN KEY (id_role) REFERENCES Role(id_role)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Tache
#------------------------------------------------------------

CREATE TABLE Tache(
        id_tache    Int  Auto_increment  NOT NULL ,
        Nom_tache   Varchar (100) NOT NULL ,
        Description Varchar (500) NOT NULL ,
        DeadLine    Date NOT NULL ,
        id_reunion  Int NOT NULL
	,CONSTRAINT Tache_PK PRIMARY KEY (id_tache)

	,CONSTRAINT Tache_Reunion_FK FOREIGN KEY (id_reunion) REFERENCES Reunion(id_reunion)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: TACHE_COLLAB
#------------------------------------------------------------

CREATE TABLE TACHE_COLLAB(
        id_collab Int NOT NULL ,
        id_tache  Int NOT NULL
	,CONSTRAINT TACHE_COLLAB_PK PRIMARY KEY (id_collab,id_tache)

	,CONSTRAINT TACHE_COLLAB_Collab_FK FOREIGN KEY (id_collab) REFERENCES Collab(id_collab)
	,CONSTRAINT TACHE_COLLAB_Tache0_FK FOREIGN KEY (id_tache) REFERENCES Tache(id_tache)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: REUNION_COLLAB
#------------------------------------------------------------

CREATE TABLE REUNION_COLLAB(
        id_reunion Int NOT NULL ,
        id_collab  Int NOT NULL
	,CONSTRAINT REUNION_COLLAB_PK PRIMARY KEY (id_reunion,id_collab)

	,CONSTRAINT REUNION_COLLAB_Reunion_FK FOREIGN KEY (id_reunion) REFERENCES Reunion(id_reunion)
	,CONSTRAINT REUNION_COLLAB_Collab0_FK FOREIGN KEY (id_collab) REFERENCES Collab(id_collab)
)ENGINE=InnoDB;

INSERT INTO Role(Nom_role) VALUES
('Admin'),
('Chef de Projet'),
('Développeur'),
('Comptable'),
('Stagiaire'),
('Kebabier');


INSERT INTO Collab (Nom,Prenom,Login,Password,id_role)VALUES 
('Allan', 'BROCHARD', 'allanb', 'azerty',1),
('Romain', 'CHRETIEN', 'romainc', 'azerty',1),
('Valentin', 'HALLAY', 'valentinh', 'azerty',1),
('Ulrich', 'HASSED', 'ulrichh', 'azerty',1);

INSERT INTO Reunion (Date,Lieu,Objectif,Compte_rendu) VALUES
(CURDATE(),'Salle 21', 'Création d\'un projet java', 'Création d\'un projet java en groupe sur le sujet de la gestion des CR');

INSERT INTO REUNION_COLLAB(id_reunion,id_collab) VALUES
(1,1),
(1,2),
(1,3),
(1,4);

INSERT INTO Tache(Nom_tache, Description, DeadLine, id_reunion) VALUES
('Cadrage', 'Réaliser la phase de cadrage du projet en organisant toutes les tâches','22/11/2019',1);

INSERT INTO TACHE_COLLAB(id_collab, id_tache) VALUES
(1,1),
(2,1),
(3,1),
(4,1);




