create table BENUTZER
(
    BENUTZERNAME VARCHAR(20) not null
        primary key,
    PASSWORT     VARCHAR(35)
);

create table ANZEIGE
(
    ANZEIGENR    INTEGER not null
        primary key,
    Benutzername varchar(20)
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
    BIETER      varchar(20)
        references BENUTZER,
    "GebotsPreis" DOUBLE
);

