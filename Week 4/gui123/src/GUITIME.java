import java.awt.Color;
import java.awt.Insets;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.stage;

public class GUITIME extends Application{

    @Override
    public void start(Stage stage) throws Exception{
        java.awt.Label label = new Label("New Label1 text ");
        label.setFont((new Font("Arial",32)));
        label.setFill(Color.GOLDENROD);
        label.setBackground(new Background
        (new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        Scene scene = Scene(Label);
        stage.setScene(scene);
        stage.setTitle("New Window");
        stage.show();
    }

    public static void main(String[] args) {
        
        launch(args);

    }
}