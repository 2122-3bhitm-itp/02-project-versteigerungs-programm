create sequence usernumbers
    start with 10
    increment by 10;


/*leider nicht herausgefunden, wie sequences in derby funktionieren*/
insert into benutzer (benutzernr, benutzername, passwort) values(10 , 'ValentinW', '1234');

insert into anzeige (anzeigeNr, VERKAEUFERNR, PREIS, TITEL, BESCHREIBUNG)
values (101, 10, 98.99, 'Objektiv', 'Altes Sony Objektiv, stark benutzt');

insert into gebot (GEBOTNR, ANZEIGENR, BIETERNR, "GebotPreis")
VALUES (10, 101, 10, 110);

/*Beziehungen testen*/
select benutzername, "GebotPreis", titel from benutzer b join GEBOT g on b.BENUTZERNR = g.BIETERNR join ANZEIGE a on g.ANZEIGENR = a.ANZEIGENR;