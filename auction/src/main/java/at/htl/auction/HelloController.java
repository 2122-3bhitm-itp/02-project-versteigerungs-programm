package at.htl.auction;

import at.htl.auction.repo.RepoImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.sql.SQLException;

public class HelloController {
    RepoImpl repo = new RepoImpl();

    public HelloController() throws SQLException {
    }

    public void find(ActionEvent actionEvent) {
    }

    public void upload(ActionEvent actionEvent) throws SQLException {
        repo.addauction();
    }
}