package at.htl.auction.repo;

import at.htl.auction.entity.Benutzer;

import java.sql.SQLException;

public interface Repo {



    void add_auction(String name, String price, Benutzer benutzer) throws SQLException;
}
