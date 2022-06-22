package at.htl.auction;

import at.htl.auction.entity.Benutzer;
import at.htl.auction.repo.RepoImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class HelloController {
    public Benutzer login;
    public Text registerstatus;
    public Text loginstatus;

    RepoImpl repo = new RepoImpl();

    Stage poststage = new Stage();
    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("create-post.fxml"));

        @FXML
        private PasswordField loginpwd;

        @FXML
        private TextField loginusername;

        @FXML
        private PasswordField registerpwd1;

        @FXML
        private PasswordField registerpwd2;

        @FXML
        private TextField registerusername;

        @FXML
        void login(ActionEvent event) throws SQLException {
            Benutzer temp = repo.login(loginusername.getText(), loginpwd.getText());
            if(temp == null){
                loginstatus.setText("User doesn't exist, or password is false");
            }else{
                this.login = temp;
                System.out.println(temp);
            }
        }

        @FXML
        void register(ActionEvent event) throws SQLException {
            if(registerpwd1.getText().equals(registerpwd2.getText())){
                Benutzer temp = repo.register(registerusername.getText(), registerpwd1.getText());
                if(temp == null){
                    registerstatus.setText("User already exists");
                }else{
                    this.login = temp;
                    System.out.println(this.login);
                }
            }else{
                registerstatus.setText("Passwords don't match");
            }
        }


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