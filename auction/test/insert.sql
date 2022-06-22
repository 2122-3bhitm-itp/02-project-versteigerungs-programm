delete from gebot where true;
delete from anzeige where true;
delete from benutzer where true;


insert into benutzer (benutzernr, benutzername, passwort) values(10 , 'ValentinW', '1234');
insert into benutzer (benutzernr, benutzername, passwort) values(11 , 'JulianJ', '5678');
insert into benutzer (benutzernr, benutzername, passwort) values(12 , 'PascalG', '9101');
insert into benutzer (benutzernr, benutzername, passwort) values(13 , 'TeoM', '1121');



insert into anzeige (anzeigeNr, VERKAEUFERNR, PREIS, TITEL, BESCHREIBUNG)
values (101, 10, 98.99, 'Objektiv', 'Altes Sony Objektiv, stark benutzt');
insert into anzeige (anzeigeNr, VERKAEUFERNR, PREIS, TITEL, BESCHREIBUNG)
values (102, 13, 160, 'Hantelbank', 'Hantelbank vor einem Jahr gekauft, jetzt gehe ich wieder ins Fitnesstudio, weil Corona vorbei ist.');
insert into anzeige (anzeigeNr, VERKAEUFERNR, PREIS, TITEL, BESCHREIBUNG)
values (103, 11, 7.99, 'Kochtopf', 'Alter Kochtopf, wenig verwendet');

insert into gebot (GEBOTNR, ANZEIGENR, BIETERNR, "GebotsPreis")
VALUES (10, 101, 11, 110);
insert into gebot (GEBOTNR, ANZEIGENR, BIETERNR, "GebotsPreis")
VALUES (11, 102, 10, 165);
insert into gebot (GEBOTNR, ANZEIGENR, BIETERNR, "GebotsPreis")
VALUES (12, 101, 12, 120);

/*Beziehungen testen*/