module Core {
    requires javafx.graphics;
    exports dk.sdu.cbse.gameapp;
    opens dk.sdu.cbse.gameapp to javafx.graphics;
}