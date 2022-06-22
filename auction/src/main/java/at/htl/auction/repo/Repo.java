package at.htl.auction.repo;

import at.htl.auction.entity.Benutzer;

import java.sql.SQLException;

public interface Repo {



    void addauction(String name, String price, Benutzer benutzer) throws SQLException;
}
