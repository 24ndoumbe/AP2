module fr.hugobaras {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens fr.hugobaras to javafx.fxml;
    exports fr.hugobaras;
}
