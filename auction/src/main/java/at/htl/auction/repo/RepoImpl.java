package at.htl.auction.repo;

import at.htl.auction.entity.Anzeige;
import at.htl.auction.entity.Benutzer;

import java.sql.*;
import java.util.LinkedList;

public class RepoImpl implements Repo{
    Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/db;create=true", "app", "app");

    public RepoImpl() throws SQLException {
    }

    @Override
    public void addauction(String name, String price, Benutzer benutzer, String desc) throws SQLException {
        PreparedStatement insert = conn.prepareStatement("insert into ANZEIGE(BENUTZERNAME, PREIS, TITEL, BESCHREIBUNG) values('"+benutzer.getBenutzername()+"', "+price+", '"+name+"', '"+desc+"')");
        insert.executeUpdate();
    }

    public Benutzer login(String username, String password) throws SQLException {
        PreparedStatement get = conn.prepareStatement("select * from BENUTZER where BENUTZERNAME = '" + username + "'");
        ResultSet rs = get.executeQuery();
        while(rs.next()){
            if(rs.getString("passwort").equals(password)){
                return new Benutzer(username, password);
            }
            return null;
        }
        return null;
    }

    public Benutzer register(String username, String password) throws SQLException {
        //
        PreparedStatement get = conn.prepareStatement("select * from BENUTZER where BENUTZERNAME = '" + username + "'");
        ResultSet rs = get.executeQuery();
        while(rs.next()){
            return null;
        }
        PreparedStatement insert = conn.prepareStatement("insert into benutzer (BENUTZERNAME, PASSWORT) values ('"+ username +"','"+password+"')");
        insert.executeUpdate();

        return new Benutzer(username, password);
    }

    public LinkedList<Anzeige> anzeigen () throws SQLException {
        LinkedList<Anzeige> temp = new LinkedList<>();

        PreparedStatement pstmt = conn.prepareStatement("select * from ANZEIGE");
        ResultSet rs = pstmt.executeQuery();

        while(rs.next()){
            Anzeige tempanz = new Anzeige(rs.getInt("Anzeigenr"), rs.getDouble("preis"), rs.getString("titel"), rs.getString("beschreibung"), rs.getString("benutzername"));
            temp.add(tempanz);
        }

        return temp;

    }

    public double getLastPrice(double anzeigenr) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement("select max(g.menge) as Menge from gebot g inner join ANZEIGE A on A.ANZEIGENR = g.ANZEIGENR where g.ANZEIGENR = " + anzeigenr);
        ResultSet rs = pstmt.executeQuery();
        while(rs.next()){
            return rs.getDouble("Menge");
        }
        return 0;
    }

    public void bid(double amount, Benutzer user, int postnr) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement("insert into gebot (anzeigeNr, bieter, menge) values ("+postnr+", '"+user.getBenutzername()+"', "+amount+")");
        pstmt.executeUpdate();
    }

    public boolean belongsto(Benutzer user, int postNr) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement("select * from ANZEIGE where ANZEIGENR = " + postNr + " and BENUTZERNAME = '" + user.getBenutzername() + "'");
        ResultSet rs = pstmt.executeQuery();
        while(rs.next()){
            return true;
        }
        return false;
    }

    public boolean sell(Anzeige anzeige) throws SQLException {
        PreparedStatement deletebids = conn.prepareStatement("delete from GEBOT where ANZEIGENR = " + anzeige.getAnzeigeNr());
        deletebids.executeUpdate();

        PreparedStatement pstmt = conn.prepareStatement("delete from anzeige where ANZEIGENR = " + anzeige.getAnzeigeNr());
        pstmt.executeUpdate();
        return true;
    }
}
