package at.htl.auction;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException, SQLException {



        Stage loginstage = new Stage();
        FXMLLoader loginloader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
        Scene loginscene = new Scene(loginloader.load());
        loginstage.setTitle("Login/Register");
        loginstage.setScene(loginscene);
        loginstage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}