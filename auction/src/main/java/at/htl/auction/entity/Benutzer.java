package at.htl.auction.entity;

import java.util.ArrayList;

public class Benutzer {
    private int BenutzerNr;
    private String benutzername;
    private String passwort;

    ArrayList<Gebot> gebote = new ArrayList<Gebot>();
    ArrayList<Anzeige> anzeigen = new ArrayList<>();

    public Benutzer(int benutzerNr, String benutzername, String passwort) {
        BenutzerNr = benutzerNr;
        this.benutzername = benutzername;
        this.passwort = passwort;
    }

    public int getBenutzerNr() {
        return BenutzerNr;
    }

    public String getBenutzername() {
        return benutzername;
    }

    public String getPasswort() {
        return passwort;
    }

    public ArrayList<Gebot> getGebote() {
        return gebote;
    }

    public ArrayList<Anzeige> getAnzeigen() {
        return anzeigen;
    }
}
