package at.htl.auction.entity;

public class Anzeige {
    private int AnzeigeNr;
    private double preis;
    private String titel;
    private String Beschreibung;

    public Anzeige(int anzeigeNr, double preis, String titel, String beschreibung) {
        AnzeigeNr = anzeigeNr;
        this.preis = preis;
        this.titel = titel;
        Beschreibung = beschreibung;
    }

    public int getAnzeigeNr() {
        return AnzeigeNr;
    }

    public double getPreis() {
        return preis;
    }

    public String getTitel() {
        return titel;
    }

    public String getBeschreibung() {
        return Beschreibung;
    }

    @Override
    public String toString() {
        return "Anzeige{" +
                "AnzeigeNr=" + AnzeigeNr +
                ", preis=" + preis +
                ", titel='" + titel + '\'' +
                ", Beschreibung='" + Beschreibung + '\'' +
                '}';
    }
}
