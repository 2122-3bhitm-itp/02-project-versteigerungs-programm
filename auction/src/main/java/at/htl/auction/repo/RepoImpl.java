package at.htl.auction.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RepoImpl implements Repo{
    //Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/db;create=true", "app", "app");

    public RepoImpl() throws SQLException {
    }

    @Override
    public void addauction() throws SQLException {
        //PreparedStatement pstmt = conn.prepareStatement("create table temp(id varchar(12) primary key)");
        //pstmt.executeQuery();
    }
}
