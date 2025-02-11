//create a new gui where you only have 2 text fields and one button and one label, 
//num1 and num2 and then a button which is +
//you can use vbox

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
// import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class activityforgui1 extends Application{

    @Override
    public void start(Stage stage) throws Exception{
        
        Label label1 = labelFactory("123.456", Color.BLACK, Color.WHITE, Color.BLACK);
        
        VBox vb = new VBox();
        Button press = new Button("+");
        press.setFont(new Font("Arial",32));
        press.setMaxWidth(Double.MAX_VALUE);
        TextField tf1 = new TextField("Enter num1");
        TextField tf2 = new TextField("Enter num2");
        
        
        vb.getChildren().addAll(label1,tf1,tf2,press);
        Scene scene = new Scene(vb);
            
        press.setOnAction(new PrintOnPress2(label1,tf1,tf2));
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