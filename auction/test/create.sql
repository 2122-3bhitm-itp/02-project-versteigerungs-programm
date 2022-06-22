create table BENUTZER
(
    BENUTZERNR   INTEGER not null
        primary key,
    BENUTZERNAME VARCHAR(20),
    PASSWORT     VARCHAR(35)
);

create table ANZEIGE
(
    ANZEIGENR    INTEGER not null
        primary key,
    VERKAEUFERNR INTEGER
        references BENUTZER,
    PREIS        DOUBLE,
    TITEL        VARCHAR(20),
    BESCHREIBUNG VARCHAR(100)
);

create table GEBOT
(
    GEBOTNR       INTEGER not null
        primary key,
    ANZEIGENR     INTEGER
        references ANZEIGE,
    BIETERNR      INTEGER
        references BENUTZER,
    "GebotsPreis" DOUBLE
);

