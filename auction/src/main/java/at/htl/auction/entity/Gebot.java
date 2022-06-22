package at.htl.auction.entity;

public class Gebot {
    int GebotNr;
    double GebotPreis;
    Anzeige anzeige;

    public Gebot(int gebotNr, double gebotPreis, Anzeige anzeige) {
        GebotNr = gebotNr;
        GebotPreis = gebotPreis;
        this.anzeige = anzeige;
    }

    public int getGebotNr() {
        return GebotNr;
    }

    public double getGebotPreis() {
        return GebotPreis;
    }

    public Anzeige getAnzeige() {
        return anzeige;
    }
}
