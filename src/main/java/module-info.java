module lessonsQ2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens ru.geekbrains to javafx.fxml;
    exports ru.geekbrains;
}