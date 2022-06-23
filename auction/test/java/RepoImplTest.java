import at.htl.auction.entity.Benutzer;
        import at.htl.auction.repo.RepoImpl;
        import org.junit.jupiter.api.Test;
        import at.htl.auction.entity.Anzeige;


        import java.sql.*;

        import static org.junit.jupiter.api.Assertions.assertEquals;

class HelloControllerTest {


    private RepoImpl userRepository;
    Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/db;create=true", "app", "app");

    HelloControllerTest() throws SQLException {
    }


    @org.junit.jupiter.api.Test
    void login() throws SQLException {
        Benutzer user = new Benutzer("julian","app");

        PreparedStatement get = conn.prepareStatement("select * from BENUTZER where BENUTZERNAME = '" + user.getBenutzername() + "'");
        ResultSet rs = get.executeQuery();
        while(rs.next()){


            assertEquals("julian", rs.getString("benutzername"));
            assertEquals("app", rs.getString("passwort"));

        }

    }
    @org.junit.jupiter.api.Test
    void getLastPrice() {
    }

    @org.junit.jupiter.api.Test
    void belongsto() {
    }

    @org.junit.jupiter.api.Test
    void register() throws SQLException {
        Benutzer user = new  Benutzer("David", "skate");
        userRepository.register(user.getBenutzername(), user.getPasswort());

        PreparedStatement get = conn.prepareStatement("select * from BENUTZER where BENUTZERNAME = '" + user.getBenutzername() + "'");
        ResultSet rs = get.executeQuery();
        while(rs.next()){

            assertEquals("david", rs.getString("benutzername"));
            assertEquals("skate", rs.getString("passwort"));

        }

    }
    @Test
    void selltest(Anzeige anzeige) throws SQLException{

        PreparedStatement deletebids = conn.prepareStatement("delete from GEBOT where ANZEIGENR = " + anzeige.getAnzeigeNr());
        deletebids.executeUpdate();

        PreparedStatement pstmt = conn.prepareStatement("delete from anzeige where ANZEIGENR = " + anzeige.getAnzeigeNr());
        pstmt.executeUpdate();



    }



}