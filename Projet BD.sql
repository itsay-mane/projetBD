CREATE TABLE Producteur(
    idProducteur INT,
    nomProducteur VARCHAR(255),
    adresseProducteur VARCHAR(255),
    contactProducteur VARCHAR(255),
    CONSTRAINT producteur_pk Primary Key(idProducteur)
);

CREATE TABLE ActiviteProducteur(
    actiProducteur VARCHAR(255),
    CONSTRAINT activiteProducteur_pk PRIMARY KEY(actiProducteur)
);

CREATE TABLE Exerce(
    idProducteur INT,
    actiProducteur VARCHAR(255),
    CONSTRAINT exerce_pk PRIMARY KEY(idProducteur, actiProducteur),
    CONSTRAINT activte_fk FOREIGN KEY(actiProducteur) REFERENCES ActiviteProducteur(actiProducteur),
    CONSTRAINT idProducteur_fk FOREIGN KEY(idProducteur) REFERENCES Producteur(idProducteur)
);

CREATE TABLE Produit(
    idProduit INT,
    idProducteur INT,
    nomProduit VARCHAR(255),
    descriptionProduit VARCHAR(255),
    CONSTRAINT produit_pk PRIMARY KEY(idProduit),
    CONSTRAINT idProducteur_fk_Produit FOREIGN KEY(idProducteur) REFERENCES Producteur(idProducteur)
);

CREATE TABLE Contenant(
    idProduit INT,
    typeContenant VARCHAR(255),
    capaciteContenant FLOAT,
    triContenant VARCHAR(255),
    CONSTRAINT idProduit_pk PRIMARY KEY(idProduit),
    CONSTRAINT idProduit_fk FOREIGN KEY(idProduit) REFERENCES Produit(idProduit),
    CONSTRAINT capaciteContenant_val CHECK (capaciteContenant >= 0),
    CONSTRAINT triContenant_val CHECK (triContenant IN ('jetable', 'reutilisable'))
);

CREATE TABLE ProduitAlimentaire(
    idProduit INT,
    categorieProduit VARCHAR(255),
    CONSTRAINT idProduit_pk_alimentaire PRIMARY KEY(idProduit),
    CONSTRAINT idProduit_fk_alimentaire FOREIGN KEY(idProduit) REFERENCES produit(idProduit)
);

CREATE TABLE CaraProduit(
    caracteristiqueProduit VARCHAR(255),
    CONSTRAINT Cara_Produit Primary key(caracteristiqueProduit)
);

CREATE TABLE PossedeCaract(
    idProduit INT,
    caracteristiqueProduit VARCHAR(255),
    CONSTRAINT possede_pk_PossedeCaract PRIMARY KEY(idProduit, caracteristiqueProduit),
    CONSTRAINT idProduit_fk_PossedeCaract FOREIGN KEY (idProduit) REFERENCES ProduitAlimentaire(idProduit),
    CONSTRAINT caraProduit_fk_PossedeCaract FOREIGN KEY (caracteristiqueProduit) REFERENCES CaraProduit(caracteristiqueProduit)
);

CREATE TABLE SaisonnaliteProduit(
    dateDebut VARCHAR(32),
    dateFin VARCHAR(32),
    CONSTRAINT saisonnalite_pk PRIMARY KEY(dateDebut, datefin)
);

CREATE TABLE ProduitEstDispo(
    idProduit INT,
    dateDebut VARCHAR(32),
    datefin VARCHAR(32),
    CONSTRAINT produitEstDispo_pk PRIMARY KEY(dateDebut, datefin, idProduit),
    CONSTRAINT idProduit_fk_produitEstDispo FOREIGN KEY (idProduit) REFERENCES ProduitAlimentaire(idProduit)
);

CREATE TABLE Lot(
    idProduit INT,
    conditionnement VARCHAR(32),
    dateReceptionLot VARCHAR(32),
    quantiteLot FLOAT,
    prixAchat FLOAT,
    prixVente FLOAT,
    CONSTRAINT lot_pk PRIMARY KEY(dateReceptionLot, conditionnement, idProduit),
    CONSTRAINT lot_fk FOREIGN KEY (idProduit) REFERENCES Produit(idProduit),
    CONSTRAINT prixAchat_val CHECK(prixAchat >= 0),
    CONSTRAINT prixVente_val CHECK(prixVente >= 0),
    CONSTRAINT quantiteLot_val CHECK(quantiteLot >= 0),
    CONSTRAINT conditionnement_value CHECK (conditionnement IN ('vrac','preconditionne', 'contenant'))
);

CREATE TABLE Perte(
    idProduit INT,
    conditionnement VARCHAR(32),
    dateReceptionLot VARCHAR(32),
    datePerte VARCHAR(32),
    naturePerte VARCHAR(255),
    quantitePerte FLOAT,
    CONSTRAINT perte_pk PRIMARY KEY(idProduit, dateReceptionLot, conditionnement, datePerte),
    CONSTRAINT lot_idProduit_fk FOREIGN KEY (idProduit, conditionnement, dateReceptionLot) REFERENCES Lot(idProduit, conditionnement, dateReceptionLot),
    CONSTRAINT quantitePerte_value CHECK(quantitePerte >= 0)
);

CREATE TABLE PeremptionLot(
    datePeremptionLot VARCHAR(32),
    CONSTRAINT peremptionLot_pk PRIMARY KEY(datePeremptionLot)
);

CREATE TABLE Perime(
     idProduit INT,
     conditionnement VARCHAR(32),
     dateReceptionLot VARCHAR(32),
     datePeremptionLot VARCHAR(32),    
     CONSTRAINT perime_pk PRIMARY KEY(idProduit, conditionnement, dateReceptionLot),
     CONSTRAINT lot_id_fk FOREIGN KEY (dateReceptionLot, conditionnement, idProduit) REFERENCES Lot(dateReceptionLot, conditionnement, idProduit)
);

CREATE TABLE IdClient(
    idClient int,
    CONSTRAINT idClient_pk PRIMARY KEY(idClient)
);

CREATE TABLE Clients(
    idClient INT,
    mailClient VARCHAR(320),
    nomClient VARCHAR(255),
    prenomClient VARCHAR(255),
    telClient VARCHAR(255),
    CONSTRAINT client_pk PRIMARY KEY(mailClient),
    CONSTRAINT clients_fk FOREIGN KEY (idClient) REFERENCES idClient(idClient)
);

CREATE TABLE AdresseLivraison(
    adLivraison VARCHAR(255),
    mailClient VARCHAR(320),
    CONSTRAINT adresseLivraison_pk PRIMARY KEY(adLivraison, mailClient),
    CONSTRAINT adLivr_fk FOREIGN KEY (mailClient) REFERENCES Clients(mailClient)
);

CREATE TABLE Commande(
    idClient INT,
    dateCommande VARCHAR(32),
    statutCommande VARCHAR(32),
    modePaiement VARCHAR(32),
    modeRecuperation VARCHAR(32),
    CONSTRAINT commande_pk PRIMARY KEY(idClient,dateCommande),
    CONSTRAINT commande_fk FOREIGN KEY (idClient) REFERENCES IdClient(idClient),
    CONSTRAINT statutCommande_value CHECK (statutCommande IN ('En preparation', 'Prete', 'En Livraison', 'Recuperee/Livree', 'Annulee')),
    CONSTRAINT modePaiement CHECK (modePaiement IN ('en ligne', 'boutique')),
    CONSTRAINT modeRecuperation CHECK (modeRecuperation IN ('boutique', 'livraison à domicile'))
);

CREATE TABLE CaracLivraison(
    fraisLivraison FLOAT,
    dateEstimeeLivraison VARCHAR(32),
    CONSTRAINT caracKivraison_pk PRIMARY KEY(fraisLivraison, dateEstimeeLivraison),
    CONSTRAINT fraislivraison_value CHECK(fraisLivraison >= 0)
);

CREATE TABLE PossedeCaracLivr(
    idClient INT,
    dateCommande VARCHAR(32),
    fraisLivraison FLOAT,
    dateEstimeeLivraison VARCHAR(32),
    CONSTRAINT possedeCaracLivr_pk PRIMARY KEY(idClient, dateCommande),
    CONSTRAINT commande_idclient_fk FOREIGN KEY (idCLient, dateCommande) REFERENCES commande(idCLient, dateCommande)
);


CREATE TABLE LigneDeCommande(
    idClient INT,
    dateCommande VARCHAR(32),
    numLigne INT,
    quantiteCommandee FLOAT,
    sousTotalLigne FLOAT,
    idProduit INT,
    dateReceptionLot VARCHAR(32),
    conditionnement VARCHAR(32),
    CONSTRAINT lignedeCommande_pk PRIMARY KEY(idClient, dateCommande, numLigne),
    CONSTRAINT ligneDeCommande_fk FOREIGN KEY (idClient, dateCommande) REFERENCES Commande(idClient, dateCommande),
    CONSTRAINT lot_id_fk_LigneDeCommande FOREIGN KEY (dateReceptionLot, conditionnement, idProduit) REFERENCES Lot(dateReceptionLot, conditionnement, idProduit), 
    CONSTRAINT numLigne_val CHECK (numLigne >= 0),
    CONSTRAINT quantiteCommande_val CHECK (quantiteCommandee >= 0),
    CONSTRAINT sousTotalLigne_val CHECK (sousTotalLigne >= 0)
);

INSERT INTO Producteur values (0, 'Peyre Noëlle', '77 Avenue de la rue, 0°, 0°', 'a.b@protonmail.com');
INSERT INTO Producteur values (1, 'Lutin', '78 Avenue de la rue, 5°, 1°', 'c.d@gmail.com');

INSERT INTO ActiviteProducteur values ('Receleur');
INSERT INTO ActiviteProducteur values ('Apiculteur');
INSERT INTO ActiviteProducteur values ('Marchand de tapis');

INSERT INTO Exerce values (0, 'Receleur');
INSERT INTO Exerce values (0, 'Apiculteur');
INSERT INTO Exerce values (1, 'Marchand de tapis');

-- Produit - sang de centaure
INSERT INTO Produit values (0, 0, 'Sang de centaure', 'Groupe sanguin AB.');
INSERT INTO ProduitAlimentaire values (0, 'Boisson');
INSERT INTO CaraProduit values ('Olympe, AB');
INSERT INTO PossedeCaract values (0, 'Olympe, AB');
INSERT INTO SaisonnaliteProduit values ('2004-05-13', '2025-05-13');
INSERT INTO ProduitEstDispo values (0, '2004-05-13', '2025-05-13');

-- Sang de centaure en vrac
INSERT INTO Lot values (0, 'vrac', '2025-11-13', 13.5, 42, 52);
INSERT INTO Perte values (0, 'vrac', '2025-11-13', '2025-11-14', 'Combustion spontanée', 2.0);
INSERT INTO PeremptionLot values ('2025-05-13');
INSERT INTO Perime values (0, 'vrac', '2025-11-13', '2025-05-13');

-- Sang de centaure pré-conditionné (flacons de 500 g)
INSERT INTO Lot values (0, 'preconditionne', '2025-11-11', 18, 44, 57);
INSERT INTO Perte values (0, 'preconditionne', '2025-11-11', '2025-11-12', 'Flacons volés', 4);

-- Quelques contenants
INSERT INTO Produit values (1, 0, 'Hotte 3000', 'En cuir de dragon');
INSERT INTO Contenant values (1, 'Hotte', 35, 'reutilisable');
INSERT INTO Lot values (1, 'contenant', '1912-05-05', 42, 900, 9000);

INSERT INTO Produit values(2, 1, 'Fiole de Merlin', 'Incassable');
INSERT INTO Contenant values (2, 'Fiole de verre', 12, 'jetable');
INSERT INTO Lot values (2, 'contenant', '2025-01-05', 64, 999.99, 10);
INSERT INTO Perte values (2, 'contenant', '2025-01-05', '2025-10-10', 'Fiole cassée (chute)', 1);

-- Produit - orteil de géant
INSERT INTO Produit values (3, 1, 'Orteil de géant', 'Parfait avec des échalottes');
INSERT INTO ProduitAlimentaire values (3, 'Condiment');
INSERT INTO CaraProduit values ('Extrait frais');
INSERT INTO PossedeCaract values (3, 'Extrait frais');
INSERT INTO SaisonnaliteProduit values ('11-14', '11-25');
INSERT INTO ProduitEstDispo values (3, '11-14', '11-25');

INSERT INTO Lot values (3, 'preconditionne', '2025-11-13', 25, 500, 500);

SELECT * FROM produit;
SELECT * FROM produit, peremptionlot;
-- TODO : commandes dans différents états


-- DROP TABLE LigneDeCommande;
-- DROP TABLE PossedeCaracLivr;
-- DROP TABLE CaracLivraison;
-- DROP TABLE Commande;
-- DROP TABLE AdresseLivraison;
-- DROP TABLE Clients;
-- DROP TABLE IdClient;
-- DROP TABLE Perime;
-- DROP TABLE PeremptionLot;
-- DROP TABLE Perte;
--  DROP TABLE lot;
-- DROP TABLE produitEstDispo;
--DROP TABLE SaisonnaliteProduit;
--DROP TABLE PossedeCaract;
--DROP TABLE CaraProduit;
--DROP TABLE ProduitAlimentaire;
--DROP TABLE Contenant;
--DROP TABLE Produit;
--DROP TABLE Exerce;
--DROP TABLE ActiviteProducteur;
--DROP TABLE Producteur;


