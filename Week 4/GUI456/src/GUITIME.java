import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
// import javafx.scene.layout.VBox;


public class GUITIME extends Application{

    @Override
    public void start(Stage stage) throws Exception{

        Label label1 = labelFactory("First Label",Color.BLACK,Color.BLUE,Color.AQUA);

        Label label2 = labelFactory("Second Label",Color.BLACK,Color.BLUE,Color.AQUA);

        HBox hb = new HBox();
        hb.getChildren().addAll(label1,label2);

        BorderPane pane = new BorderPane();

        pane.setTop(labelFactory("label 1", Color.WHITE, Color.BLACK, Color.AQUA));
        pane.setBottom(labelFactory("label 2", Color.WHITE, Color.GREEN, Color.AQUA));
        pane.setLeft(labelFactory("label 3", Color.WHITE, Color.GRAY, Color.AQUA));
        pane.setRight(labelFactory("label 4", Color.WHITE, Color.RED, Color.AQUA));
        pane.setCenter(labelFactory("label 5", Color.WHITE, Color.PURPLE, Color.AQUA));

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setTitle("New Window");
        stage.show();
    }

    public Label labelFactory(String text, Color color, Color BgColor, Color BorderColor){
        Label label = new Label(text);
        label.setFont((new Font("Arial",32)));
        label.setTextFill(color);

        label.setBackground(new Background
        (new BackgroundFill(BgColor, CornerRadii.EMPTY, Insets.EMPTY)));

        label.setMaxWidth(Double.MAX_VALUE);
        label.setPadding(new Insets(15));

        label.setBorder(new Border
        (new BorderStroke(BorderColor, BorderStrokeStyle.SOLID, 
        new CornerRadii(0), BorderStroke.DEFAULT_WIDTHS)));
        
        label.setAlignment(Pos.CENTER);

        return label;
    }

    public static void main(String[] args) {
        
        launch(args);

    }
}