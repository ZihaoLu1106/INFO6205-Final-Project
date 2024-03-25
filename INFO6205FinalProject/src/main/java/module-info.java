module com.info6205.info6205finalproject {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.info6205.info6205finalproject to javafx.fxml;
    exports com.info6205.info6205finalproject;
}