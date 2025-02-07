
import javafx.application.Application;
import javafx.geometry.Insets;
// import javafx.geometry.Pos;
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

        Label label1 = labelFactory("First Label",Color.BLACK,Color.BLUE);

        Label label2 = labelFactory("Second Label",Color.BLACK,Color.BLUE);

        HBox hb = new HBox();
        hb.getChildren().addAll(label1,label2);

        BorderPane pane = new BorderPane();

        pane.setTop(labelFactory("dwdad", Color.BLUE, Color.BLACK));
        pane.setBottom(labelFactory("dwd", Color.BLUE, Color.GREEN));
        pane.setLeft(labelFactory("dd", Color.BLUE, Color.GRAY));
        pane.setRight(labelFactory("dwwwdad", Color.BLUE, Color.RED));
        pane.setCenter(labelFactory("deewdad", Color.BLUE, Color.YELLOW));

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setTitle("New Window");
        stage.show();
    }

    public Label labelFactory(String text, Color color, Color BgColor){
        Label label = new Label(text);
        label.setFont((new Font("Arial",32)));
        label.setTextFill(color);
        label.setBackground(new Background
        (new BackgroundFill(BgColor, CornerRadii.EMPTY, Insets.EMPTY)));
        label.setMaxWidth(Double.MAX_VALUE);
        label.setPadding(new Insets(15));
        label.setBorder(new Border
        (new BorderStroke(Color.DARKSLATEGRAY, BorderStrokeStyle.DOTTED, 
        new CornerRadii(10), BorderStroke.THICK)));

        return label;
    }

    public static void main(String[] args) {
        
        launch(args);

    }
}