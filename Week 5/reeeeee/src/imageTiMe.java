import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
// import javafx.scene.control.Button;
// import javafx.scene.control.TextField;
// import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class imageTiMe extends Application{

    @Override
    public void start(Stage stage) throws Exception{
        
        Label label1 = labelFactory("Result: ", Color.BLACK, Color.WHITE, Color.BLACK);
        
        Image sunflowers = new Image("file:download.jpeg");
        ImageView iView = new ImageView(sunflowers);
        
        VBox vb = new VBox();
        Button add = new Button("+");
        add.setFont(new Font("Arial",32));
        add.setMaxWidth(Double.MAX_VALUE);
        TextField tf1 = new TextField("Enter num1");
        TextField tf2 = new TextField("Enter num2");
        vb.getChildren().addAll(label1, tf1,tf2,add,iView);
        
        VBox.setVgrow(iView, Priority.ALWAYS);
        Scene scene = new Scene(vb);

        add.setOnAction(new PressAdd(label1,tf1,tf2));
        stage.setScene(scene);
        stage.setTitle("Addition");
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
