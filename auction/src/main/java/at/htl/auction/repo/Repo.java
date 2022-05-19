package at.htl.auction.repo;

import java.sql.SQLException;

public interface Repo {


    void addauction(String name, String price) throws SQLException;
}
