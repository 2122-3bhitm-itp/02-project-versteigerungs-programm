delete from gebot where true;
delete from anzeige where true;
delete from benutzer where true;


insert into benutzer (benutzername, passwort) values('ValentinW', '1234');
insert into benutzer (benutzername, passwort) values('JulianJ', '5678');
insert into benutzer (benutzername, passwort) values('PascalG', '9101');
insert into benutzer (benutzername, passwort) values('TeoM', '1121');


insert into anzeige (anzeigeNr, BENUTZERNAME, PREIS, TITEL, BESCHREIBUNG)
values (101, 'ValentinW', 98.99, 'Objektiv', 'Altes Sony Objektiv, stark benutzt');
insert into anzeige (anzeigeNr, BENUTZERNAME, PREIS, TITEL, BESCHREIBUNG)
values (102, 'TeoM', 160, 'Hantelbank', 'Hantelbank vor einem Jahr gekauft, jetzt gehe ich wieder ins Fitnessstudio, weil Corona vorbei ist.');
insert into anzeige (anzeigeNr, BENUTZERNAME, PREIS, TITEL, BESCHREIBUNG)
values (103, 'JulianJ', 7.99, 'Kochtopf', 'Alter Kochtopf, wenig verwendet');

insert into gebot (GEBOTNR, ANZEIGENR, BIETER, "GebotsPreis")
VALUES (10, 101, 'JulianJ', 110);
insert into gebot (GEBOTNR, ANZEIGENR, BIETER, "GebotsPreis")
VALUES (11, 102, 'JulianJ', 165);
insert into gebot (GEBOTNR, ANZEIGENR, BIETER, "GebotsPreis")
VALUES (12, 101, 'PascalG', 120);

/*Beziehungen testen*/