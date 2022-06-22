package at.htl.auction.repo;

import at.htl.auction.entity.Benutzer;

import java.sql.*;

public class RepoImpl implements Repo{
    Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/db;create=true", "app", "app");

    public RepoImpl() throws SQLException {
    }

    @Override
    public void addauction(String name, String price) throws SQLException {
        //PreparedStatement pstmt = conn.prepareStatement("create table temp(id varchar(12) primary key)");
        //pstmt.executeQuery();
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
}
