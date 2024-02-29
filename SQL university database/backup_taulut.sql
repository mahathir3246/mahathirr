--
-- File generated with SQLiteStudio v3.4.3 on Wed May 10 19:55:18 2023
--
-- Text encoding used: System
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- Table: HarjoitusPisteet
CREATE TABLE IF NOT EXISTS HarjoitusPisteet(
    opiskelijaNro INTEGER,
    kurssikoodi CHAR(10),
    p�iv�m��r� CHAR(10),
    pisteet INTEGER,
    PRIMARY KEY (opiskelijaNro, kurssikoodi),
    FOREIGN KEY (opiskelijaNro) REFERENCES Opiskelija(opiskelijanumero),
    FOREIGN KEY (kurssikoodi) REFERENCES Kurssi(kurssikoodi)
);
INSERT INTO HarjoitusPisteet (opiskelijaNro, kurssikoodi, p�iv�m��r�, pisteet) VALUES (12345, 'ABC123', '01.03.2023', 20);
INSERT INTO HarjoitusPisteet (opiskelijaNro, kurssikoodi, p�iv�m��r�, pisteet) VALUES (54321, 'A123', '15.04.2023', 15);

-- Table: Harjoitusryhm�
CREATE TABLE IF NOT EXISTS Harjoitusryhm�(
    harjoituskoodi CHAR(10) PRIMARY KEY,
    opiskelijaNro INT,
    p�iv�m��r� TEXT, 
    paikka TEXT, 
    paikkam��r� INTEGER,
    ryhm�Nro CHAR(5),
    FOREIGN KEY (harjoituskoodi) REFERENCES Kurssi(kurssikoodi),
    FOREIGN KEY (opiskelijaNro) REFERENCES Opiskelija(opiskelijanumero)
);
INSERT INTO Harjoitusryhm� (harjoituskoodi, opiskelijaNro, p�iv�m��r�, paikka, paikkam��r�, ryhm�Nro) VALUES ('ABC123', 12345, '15.05.2023', 'U503', 25, 'H01');
INSERT INTO Harjoitusryhm� (harjoituskoodi, opiskelijaNro, p�iv�m��r�, paikka, paikkam��r�, ryhm�Nro) VALUES ('A123', 54321, '20.05.2023', 'U2', 30, 'H02');

-- Table: Kurssi
CREATE TABLE IF NOT EXISTS Kurssi(
    kurssikoodi CHAR(10) PRIMARY KEY,
    nimi TEXT,
    opintopiste INTEGER,
    tenttiMahdollisuus TEXT,
    kurssiP�iv�m��r� TEXT
);
INSERT INTO Kurssi (kurssikoodi, nimi, opintopiste, tenttiMahdollisuus, kurssiP�iv�m��r�) VALUES ('ABC123', 'Ohjelmoinnin perusteet', 5, '01.06.2023, 15.06.2023, 29.06.2023', '01.05.2023 - 31.07.2023');
INSERT INTO Kurssi (kurssikoodi, nimi, opintopiste, tenttiMahdollisuus, kurssiP�iv�m��r�) VALUES ('A123', 'Tietorakenteet ja algoritmit', 6, '05.07.2023, 19.07.2023, 02.08.2023', '01.06.2023 - 31.08.2023');

-- Table: Luento
CREATE TABLE IF NOT EXISTS Luento(
    luentokoodi CHAR(10), 
    p�iv�m��r� TEXT,
    paikka TEXT,
    paikkam��r� INTEGER,
    PRIMARY KEY(luentokoodi, p�iv�m��r�),
    FOREIGN KEY (luentokoodi) REFERENCES Kurssi(kurssikoodi)            
);
INSERT INTO Luento (luentokoodi, p�iv�m��r�, paikka, paikkam��r�) VALUES ('ABC123', '2023-05-15', 'U503', 100);
INSERT INTO Luento (luentokoodi, p�iv�m��r�, paikka, paikkam��r�) VALUES ('A123', '2023-05-20', 'U2', 50);

-- Table: Opiskelija
CREATE TABLE IF NOT EXISTS Opiskelija(
    opiskelijanumero INTEGER PRIMARY KEY,
    nimi TEXT,
    syntym�aika CHAR(10),
    tutkintoOhjelma TEXT,
    aloitusVuosi CHAR(4),
    lopetusVUOSI CHAR(4)
);
INSERT INTO Opiskelija (opiskelijanumero, nimi, syntym�aika, tutkintoOhjelma, aloitusVuosi, lopetusVUOSI) VALUES (12345, 'Maija Meik�l�inen', '01.01.2000', 'Tietojenk�sittelytiede', '2019', '2023');
INSERT INTO Opiskelija (opiskelijanumero, nimi, syntym�aika, tutkintoOhjelma, aloitusVuosi, lopetusVUOSI) VALUES (54321, 'Matti Meik�l�inen', '12.05.1999', 'Tietojenk�sittelytiede', '2018', NULL);

-- Table: Rakennus
CREATE TABLE IF NOT EXISTS Rakennus(
    nimi TEXT PRIMARY KEY,
    katuosoite TEXT,
    FOREIGN KEY (nimi) REFERENCES Sali(saliRakennus) 
);
INSERT INTO Rakennus (nimi, katuosoite) VALUES ('Kandidaattikeskus', 'Betoni 2');
INSERT INTO Rakennus (nimi, katuosoite) VALUES ('V�re', 'Konemiehentie 2');

-- Table: Sali
CREATE TABLE IF NOT EXISTS Sali(
    saliNro CHAR(10) PRIMARY KEY,
    paikatOpiskelijoille INTEGER, 
    paikatTenttij�ille INTEGER, 
    varaustunnus INTEGER,
    saliRakennus TEXT UNIQUE
);
INSERT INTO Sali (saliNro, paikatOpiskelijoille, paikatTenttij�ille, varaustunnus, saliRakennus) VALUES ('U503', 50, 30, 1, 'Kandidaattikeskus');
INSERT INTO Sali (saliNro, paikatOpiskelijoille, paikatTenttij�ille, varaustunnus, saliRakennus) VALUES ('U2', 70, 40, 2, 'V�re');

-- Table: SaliVarusteet
CREATE TABLE IF NOT EXISTS SaliVarusteet(
    nimi TEXT,
    saliNro CHAR(10),
    PRIMARY KEY(nimi, saliNro),
    FOREIGN KEY (saliNro) REFERENCES Sali(saliNro)
);
INSERT INTO SaliVarusteet (nimi, saliNro) VALUES ('Taulu', 'U503');
INSERT INTO SaliVarusteet (nimi, saliNro) VALUES ('smartboard', 'U2');
INSERT INTO SaliVarusteet (nimi, saliNro) VALUES ('��nentoistoj�rjestelm�', 'U503');
INSERT INTO SaliVarusteet (nimi, saliNro) VALUES ('Tietokone', 'U2');
INSERT INTO SaliVarusteet (nimi, saliNro) VALUES ('Projektori', 'U503');
INSERT INTO SaliVarusteet (nimi, saliNro) VALUES ('Piirtoheitin', 'U2');
INSERT INTO SaliVarusteet (nimi, saliNro) VALUES ('Lasertulostin', 'U2');

-- Table: Suoritukset
CREATE TABLE IF NOT EXISTS Suoritukset(
    opiskelijanumero INTEGER PRIMARY KEY,
    kurssikoodi CHAR(10),
    p�iv�m��r� CHAR(10),
    kurssiarvosana INTEGER CHECK(kurssiarvosana >= 0 AND kurssiarvosana <= 5),
    FOREIGN KEY (kurssikoodi) REFERENCES Kurssi(kurssikoodi),
    FOREIGN KEY (opiskelijanumero) REFERENCES Opiskelija(opiskelijanumero) 
);
INSERT INTO Suoritukset (opiskelijanumero, kurssikoodi, p�iv�m��r�, kurssiarvosana) VALUES (12345, 'A123', '12.05.2022', 3);
INSERT INTO Suoritukset (opiskelijanumero, kurssikoodi, p�iv�m��r�, kurssiarvosana) VALUES (54321, 'ABC123', '12.05.2022', 5);

-- Table: TentiLasnaolot
CREATE TABLE IF NOT EXISTS TentiLasnaolot(
    opiskelijaNro INTEGER,
    kurssiNro CHAR(10),
    arvosana INTEGER CHECK(arvosana >= 0 AND arvosana <= 5),
    PRIMARY KEY(opiskelijaNro, kurssiNro),
    FOREIGN KEY (kurssiNro) REFERENCES Kurssi(kurssikoodi),
    FOREIGN KEY (opiskelijaNro) REFERENCES Opiskelija(opiskelijanumero) 
);
INSERT INTO TentiLasnaolot (opiskelijaNro, kurssiNro, arvosana) VALUES (54321, 'ABC123', 3);
INSERT INTO TentiLasnaolot (opiskelijaNro, kurssiNro, arvosana) VALUES (12345, 'A123', 4);

-- Table: Tentti
CREATE TABLE IF NOT EXISTS Tentti(
    tenttikoodi CHAR(10) PRIMARY KEY,    
    opiskelijaNro INT,    
    p�iv�m��r� TEXT,
    paikka TEXT,
    paikkam��r� INTEGER,
    FOREIGN KEY (tenttikoodi) REFERENCES Kurssi(kurssikoodi),
    FOREIGN KEY (paikka) REFERENCES Sali(saliNro),    
    FOREIGN KEY (opiskelijaNro) REFERENCES Opiskelija(opiskelijanumero)   
);
INSERT INTO Tentti (tenttikoodi, opiskelijaNro, p�iv�m��r�, paikka, paikkam��r�) VALUES ('ABC123', 12345, '2023-05-30', 'U503', 50);
INSERT INTO Tentti (tenttikoodi, opiskelijaNro, p�iv�m��r�, paikka, paikkam��r�) VALUES ('A123', 54321, '2023-06-15', 'U2', 40);

-- Table: TenttiIlmo
CREATE TABLE IF NOT EXISTS TenttiIlmo(
    ilmoittautumisPaiva CHAR(10) PRIMARY KEY,
    kurssikoodi CHAR(10) NOT NULL,
    opiskelijaNro INTEGER,
    kielivalinta TEXT,
    FOREIGN KEY (kurssikoodi) REFERENCES Kurssi(kurssikoodi),
    FOREIGN KEY (opiskelijaNro) REFERENCES Opiskelija(opiskelijanumero) 
);
INSERT INTO TenttiIlmo (ilmoittautumisPaiva, kurssikoodi, opiskelijaNro, kielivalinta) VALUES ('09.05.2023', 'A123', 12345, 'suomi');
INSERT INTO TenttiIlmo (ilmoittautumisPaiva, kurssikoodi, opiskelijaNro, kielivalinta) VALUES ('22.05.2023', 'ABC123', 54321, 'ruotsi');

-- Table: Ty�ntekij�t
CREATE TABLE IF NOT EXISTS Ty�ntekij�t(
    tunnus INTEGER PRIMARY KEY, 
    nimi CHAR(100) NOT NULL,
    teht�v�nimike TEXT,
    osoite TEXT,
    puhelinnumero INTEGER,
    ty�suhdeAlku CHAR(10),
    ty�suhdeLoppu CHAR(10)
);
INSERT INTO Ty�ntekij�t (tunnus, nimi, teht�v�nimike, osoite, puhelinnumero, ty�suhdeAlku, ty�suhdeLoppu) VALUES (1, 'Matti Meik�l�inen', 'Professori', 'Esimerkkikatu 1, Helsinki', 123456789, '01.01.2022', '31.12.2023');
INSERT INTO Ty�ntekij�t (tunnus, nimi, teht�v�nimike, osoite, puhelinnumero, ty�suhdeAlku, ty�suhdeLoppu) VALUES (2, 'Maija Mallikas', 'Assistentti', 'Esimerkkikatu 2, Espoo', 987654321, '01.02.2022', '31.12.2022');

-- Table: Ty�ntekij�Varaus
CREATE TABLE IF NOT EXISTS Ty�ntekij�Varaus(
    id INTEGER PRIMARY KEY,
    ty�ntekij�ID INTEGER,
    varausID INTEGER,
    FOREIGN KEY (ty�ntekij�ID) REFERENCES Ty�ntekij�t(tunnus),
    FOREIGN KEY (varausID) REFERENCES Varaukset(varaustunnus)  
);
INSERT INTO Ty�ntekij�Varaus (id, ty�ntekij�ID, varausID) VALUES (1, 1, 1);
INSERT INTO Ty�ntekij�Varaus (id, ty�ntekij�ID, varausID) VALUES (2, 2, 2);

-- Table: Varaukset
CREATE TABLE IF NOT EXISTS Varaukset(
    varaustunnus INTEGER PRIMARY KEY, 
    varausTyyppi CHAR(10),
    varausP�iv� CHAR(10)
);
INSERT INTO Varaukset (varaustunnus, varausTyyppi, varausP�iv�) VALUES (1, 'harjoitus', '06.01.2023');
INSERT INTO Varaukset (varaustunnus, varausTyyppi, varausP�iv�) VALUES (2, 'tentti', '15.06.2023');
INSERT INTO Varaukset (varaustunnus, varausTyyppi, varausP�iv�) VALUES (3, 'luento', '30.06.2022');

-- View: KurssitJaOpiskelijat
CREATE VIEW IF NOT EXISTS KurssitJaOpiskelijat AS
SELECT Kurssi.nimi AS kurssi_nimi, Kurssi.opintopiste AS opintopisteet, Opiskelija.nimi AS opiskelijan_nimi, Harjoitusryhm�.p�iv�m��r� AS harjoitus_p�iv�m��r�
FROM Kurssi 
JOIN Harjoitusryhm� ON Kurssi.kurssikoodi = Harjoitusryhm�.harjoituskoodi
JOIN Opiskelija ON Harjoitusryhm�.opiskelijaNro = Opiskelija.opiskelijanumero;

COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
