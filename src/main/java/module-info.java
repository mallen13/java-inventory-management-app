module allen_c482.inventory_app {
    requires javafx.controls;
    requires javafx.fxml;


    opens allen_c482.inventory_app to javafx.fxml;
    exports allen_c482.inventory_app;
}