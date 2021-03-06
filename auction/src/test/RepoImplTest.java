import at.htl.auction.entity.Benutzer;
        import at.htl.auction.repo.RepoImpl;
        import org.junit.jupiter.api.Test;
        import at.htl.auction.entity.Anzeige;


        import java.sql.*;

        import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HelloControllerTest {


    RepoImpl userRepository = new RepoImpl();
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
    void getLastPricetest() throws SQLException {

        assertEquals(12, userRepository.getLastPrice(12));
    }

    @org.junit.jupiter.api.Test
    void belongstotest() throws SQLException {
        Benutzer user = new Benutzer("julian","app");
        assertTrue(userRepository.belongsto(user, 4));

    }

    @org.junit.jupiter.api.Test
    void registertest() throws SQLException {
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