
SELECT * 
FROM Varaukset 
WHERE varausTyyppi = 'harjoitus';

SELECT Työntekijät.nimi, Varaukset.varausTyyppi, Varaukset.varausPäivä 
FROM Työntekijät 
JOIN TyöntekijäVaraus ON Työntekijät.tunnus = TyöntekijäVaraus.työntekijäID 
JOIN Varaukset ON TyöntekijäVaraus.varausID = Varaukset.varaustunnus;

SELECT Kurssi.nimi, Opiskelija.nimi 
FROM Kurssi 
JOIN Harjoitusryhmä ON Kurssi.kurssikoodi = Harjoitusryhmä.harjoituskoodi 
JOIN Opiskelija ON Harjoitusryhmä.opiskelijaNro = Opiskelija.opiskelijanumero;

SELECT SUM(Kurssi.opintopiste) AS totalCredits 
FROM Kurssi 
JOIN Suoritukset ON Kurssi.kurssikoodi = Suoritukset.kurssikoodi 
WHERE Suoritukset.opiskelijanumero = 12345;

SELECT Opiskelija.nimi 
FROM Opiskelija 
JOIN TenttiIlmo ON Opiskelija.opiskelijanumero = TenttiIlmo.opiskelijaNro 
WHERE TenttiIlmo.kurssikoodi = 'ABC123';

SELECT T.kurssiNro, T.opiskelijaNro, T.arvosana, O.nimi, O.aloitusVuosi
FROM TentiLasnaolot T, Opiskelija O
WHERE T.opiskelijaNro = O.opiskelijanumero AND T.arvosana >= 1
ORDER BY T.kurssiNro;

SELECT Kurssi.kurssikoodi, Kurssi.nimi, Kurssi.opintopiste
FROM Kurssi, Luento, Sali
WHERE Luento.luentokoodi = Kurssi.kurssikoodi AND Sali.saliNro = Luento.paikka AND
Sali.saliRakennus = 'Väre';

SELECT Kurssi.kurssikoodi, Kurssi.nimi, Tentti.päivämäärä, Sali.saliNro, Sali.saliRakennus
FROM Kurssi, Tentti, Sali
WHERE Tentti.tenttikoodi = Kurssi.kurssikoodi AND Sali.saliNro = Tentti.paikka AND Sali.saliNro = 'U2';

SELECT * 
FROM Harjoitusryhmä
WHERE harjoituskoodi = 'A123';

SELECT nimi 
FROM Työntekijät 
WHERE tehtävänimike = 'Professori';

SELECT opiskelijaNro, kurssikoodi, pisteet 
FROM HarjoitusPisteet 
WHERE pisteet >= 20;

SELECT kurssikoodi, nimi, opintopiste
FROM Kurssi
WHERE tenttiMahdollisuus LIKE '%29.06.2023%' ;

SELECT nimi FROM Työntekijät
JOIN TyöntekijäVaraus ON Työntekijät.tunnus = TyöntekijäVaraus.työntekijäID
JOIN Varaukset ON TyöntekijäVaraus.varausID = Varaukset.varaustunnus;

SELECT nimi, kurssikoodi
FROM Kurssi
WHERE EXISTS (
    SELECT *
    FROM Harjoitusryhmä
    WHERE Harjoitusryhmä.harjoituskoodi = Kurssi.kurssikoodi
    AND Kurssi.tenttiMahdollisuus LIKE '%05.07.2023%' AND Kurssi.tenttiMahdollisuus LIKE '%19.07.2023%'
);

SELECT Työntekijät.nimi
FROM Työntekijät
JOIN TyöntekijäVaraus ON Työntekijät.tunnus = TyöntekijäVaraus.työntekijäID;

SELECT nimi, tehtävänimike
FROM Työntekijät
WHERE tunnus IN (
    SELECT työntekijäID
    FROM TyöntekijäVaraus
    WHERE varausID = 1
)
UNION
SELECT nimi, tehtävänimike
FROM Työntekijät
WHERE tunnus IN (
    SELECT työntekijäID
    FROM TyöntekijäVaraus
    WHERE varausID = 2
);

UPDATE Opiskelija 
SET nimi = 'Matti Meikäläinen', tutkintoOhjelma = 'Tietojenkäsittelytiede' 
WHERE opiskelijanumero = 54321;