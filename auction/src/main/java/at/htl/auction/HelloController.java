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


    public Button sellbutton;

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

    @FXML
    private TextField desc;


    Scene scene;
    Stage poststage = new Stage();
    public void upload(ActionEvent actionEvent) throws SQLException, IOException {
        scene = new Scene(fxmlLoader.load());
        poststage.setTitle("Create Auction");
        poststage.setScene(scene);
        poststage.show();
    }

    public void post(ActionEvent actionEvent) throws SQLException {
        repo.addauction(name.getText(), preis.getText(), this.login, this.desc.getText());
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
        container.getChildren().clear();
        this.anzeigen = repo.anzeigen();
        for(int i = 0; i < anzeigen.size(); i++){
            System.out.println(anzeigen.get(i));
            Button tempbutton = new Button(anzeigen.get(i).getTitel());
            tempbutton.setPrefSize(300,300);
            tempbutton.setFont(new Font(46));

            if(anzeigen.get(i).getUsername().equals(login.getBenutzername())){
                tempbutton.setStyle("-fx-background-color: rgb(148, 176, 155)");
            }

            final int index = i;
            tempbutton.setOnAction(e -> {
                try {
                    openpost(index);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });

            container.getChildren().add(tempbutton);
        }
        //Button tempbutton = new Button("asdflkjödfsajlökakl");

    }

    static Anzeige currentanzeige;

    Stage anzeigestage = new Stage();
    public EventHandler openpost(int index) throws IOException {
        System.out.println(index);
        this.currentanzeige = anzeigen.get(index);

        FXMLLoader loaderopenpost = new FXMLLoader(HelloApplication.class.getResource("post.fxml"));
        Scene scene = new Scene(loaderopenpost.load());
        anzeigestage.setTitle("Auction");
        anzeigestage.setScene(scene);
        anzeigestage.show();

        return null;
    }




    @FXML
    private Text basispreis;

    @FXML
    private Text beschreibung;

    @FXML
    private TextField gebot;

    @FXML
    private Text letzterpreis;

    @FXML
    private Text titel;

    @FXML
    private Text statuspost;
    @FXML
    void bieten(ActionEvent event) throws SQLException {

            if(repo.getLastPrice(currentanzeige.getAnzeigeNr()) <= Double.valueOf(gebot.getText()) || repo.getLastPrice(currentanzeige.getAnzeigeNr()) == 0){
                repo.bid(Double.valueOf(gebot.getText()), login, currentanzeige.getAnzeigeNr());
                this.letzterpreis.setText(String.valueOf(repo.getLastPrice(currentanzeige.getAnzeigeNr())));
                statuspost.setText("");
            }else{
                statuspost.setText("Angebot ist niedriger als das letzthöchste!");
            }

    }

    @FXML
    void updatepost(ActionEvent event) throws SQLException {
        this.titel.setText(currentanzeige.getTitel());
        this.basispreis.setText(String.valueOf(currentanzeige.getPreis()));
        this.beschreibung.setText(currentanzeige.getBeschreibung());
        if(repo.getLastPrice(currentanzeige.getAnzeigeNr()) == 0){
            this.letzterpreis.setText(String.valueOf(currentanzeige.getPreis()));
        }else{
            this.letzterpreis.setText(String.valueOf(repo.getLastPrice(currentanzeige.getAnzeigeNr())));
        }

        if(repo.belongsto(login, currentanzeige.getAnzeigeNr())){
            sellbutton.setDisable(false);
        }else{
            sellbutton.setDisable(true);
        }
    }

    @FXML
    private Button bid;
    public void sell(ActionEvent actionEvent) throws SQLException {
        if(repo.sell(currentanzeige)){
            statuspost.setText("Sold!!");
            bid.setDisable(true);
        }
    }
}