package at.htl.auction;

import at.htl.auction.entity.Anzeige;
import at.htl.auction.entity.Benutzer;
import at.htl.auction.repo.RepoImpl;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;

public class HelloController {


    public HelloController() throws SQLException {
    }

    public static Benutzer login;
    public Text registerstatus;
    public Text loginstatus;

    RepoImpl repo = new RepoImpl();


        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("create-post.fxml"));

    @FXML
    private FlowPane container;
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

  /*  @FXML
    public void initialize(){
        this.container = new FlowPane();
    }*/

        @FXML
        void login(ActionEvent event) throws SQLException, IOException {
            Benutzer temp = repo.login(loginusername.getText(), loginpwd.getText());
            if(temp == null){
                loginstatus.setText("User doesn't exist, or password is false");
            }else{
                this.login = temp;
                showmain();
                System.out.println(temp);
            }
        }

        @FXML
        void register(ActionEvent event) throws SQLException, IOException {
            if(registerpwd1.getText().equals(registerpwd2.getText())){
                Benutzer temp = repo.register(registerusername.getText(), registerpwd1.getText());
                if(temp == null){
                    registerstatus.setText("User already exists");
                }else{
                    this.login = temp;
                    showmain();
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

    Scene scene;
    Stage poststage = new Stage();
    public void upload(ActionEvent actionEvent) throws SQLException, IOException {
        scene = new Scene(fxmlLoader.load());
        poststage.setTitle("Create Auction");
        poststage.setScene(scene);
        poststage.show();
    }

    public void post(ActionEvent actionEvent) throws SQLException {
        repo.addauction(name.getText(), preis.getText(), this.login);
        System.out.println("upload");
        poststage.close();
        //
    }


    //SHOW
    Stage mainstage = new Stage();
    public void showmain() throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        mainstage.setTitle("Auction");
        mainstage.setScene(scene);
        mainstage.show();


    }

    LinkedList<Anzeige> anzeigen;
    public void update(ActionEvent actionEvent) throws SQLException {
        this.anzeigen = repo.anzeigen();
        for(int i = 0; i < anzeigen.size(); i++){
            System.out.println(anzeigen.get(i));
            Button tempbutton = new Button(anzeigen.get(i).getTitel());
            tempbutton.setPrefSize(300,300);
            tempbutton.setFont(new Font(46));
            tempbutton.setOnAction(openpost(i));

            container.getChildren().add(tempbutton);
        }
        //Button tempbutton = new Button("asdflkjödfsajlökakl");

    }

    public EventHandler openpost(int index){
        System.out.println(index);
        return null;
    }
}