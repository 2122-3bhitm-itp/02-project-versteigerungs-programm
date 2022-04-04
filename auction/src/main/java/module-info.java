module at.htl.auction {
    requires javafx.controls;
    requires javafx.fxml;


    opens at.htl.auction to javafx.fxml;
    exports at.htl.auction;
    exports at.htl.auction.entity;
    opens at.htl.auction.entity to javafx.fxml;
}