package at.htl.auction.entity;

import java.util.ArrayList;

public class Benutzer {
    private String benutzername;
    private String passwort;

    ArrayList<Gebot> gebote = new ArrayList<Gebot>();
    ArrayList<Anzeige> anzeigen = new ArrayList<>();

    public Benutzer(String benutzername, String passwort) {
        this.benutzername = benutzername;
        this.passwort = passwort;
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

    @Override
    public String toString() {
        return "Benutzer{" +
                "benutzername='" + benutzername + '\'' +
                ", passwort='" + passwort + '\'' +
                '}';
    }
}
