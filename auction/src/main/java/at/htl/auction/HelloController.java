package at.htl.auction;

import at.htl.auction.repo.RepoImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class HelloController {
    RepoImpl repo = new RepoImpl();

    Stage poststage = new Stage();
    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("create-post.fxml"));

    @FXML
    private TextField name;

    @FXML
    private TextField preis;

    public HelloController() throws SQLException {
    }

    public void find(ActionEvent actionEvent) {
    }

    public void upload(ActionEvent actionEvent) throws SQLException, IOException {
        Scene scene = new Scene(fxmlLoader.load());
        poststage.setTitle("Create Auction");
        poststage.setScene(scene);
        poststage.show();
    }

    public void post(ActionEvent actionEvent) throws SQLException {
        repo.addauction(name.getText(), preis.getText());
        //
    }
}