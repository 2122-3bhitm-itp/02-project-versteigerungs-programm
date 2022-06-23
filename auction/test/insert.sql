delete from gebot where true;
delete from anzeige where true;
delete from benutzer where true;


insert into benutzer (benutzername, passwort) values('ValentinW', '1234');
insert into benutzer (benutzername, passwort) values('JulianJ', '5678');
insert into benutzer (benutzername, passwort) values('PascalG', '9101');
insert into benutzer (benutzername, passwort) values('TeoM', '1121');



insert into anzeige (BENUTZERNAME, PREIS, TITEL, BESCHREIBUNG)
values ('ValentinW', 98.99, 'Objektiv', 'Altes Sony Objektiv, stark benutzt');
insert into anzeige (BENUTZERNAME, PREIS, TITEL, BESCHREIBUNG)
values ('TeoM', 160, 'Hantelbank', 'Hantelbank vor einem Jahr gekauft, jetzt gehe ich wieder ins Fitnesstudio, weil Corona vorbei ist.');
insert into anzeige (BENUTZERNAME, PREIS, TITEL, BESCHREIBUNG)
values ('JulianJ', 7.99, 'Kochtopf', 'Alter Kochtopf, wenig verwendet');


/*Beziehungen testen*/