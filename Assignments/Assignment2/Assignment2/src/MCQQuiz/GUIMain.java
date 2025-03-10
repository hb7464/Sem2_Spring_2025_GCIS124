package MCQQuiz;

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
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GUIMain extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        
        GridPane gp = new GridPane();
        Scene scene = new Scene(gp);
        
        Label userNameFinal = new Label();
        Label timer = new Label("Timer");
        Label termsOfService = new Label("STUF YOU NEDED TO AGREE TO + \nRULES");
        Label scorecard = new Label();
        TextField userNameEntry = new TextField("Enter your name: ");
        Button startButton = new Button("Begin Quiz");
        quickFormat(termsOfService, Color.WHITE);
        quickFormat(userNameEntry, Color.WHITE);
        quickFormat(startButton, Color.LIGHTGREY);
        
        gp.add(termsOfService, 0,0);
        gp.add(userNameEntry, 0,1);
        gp.add(startButton,0,2);
    
        Label[] tempArr = {userNameFinal, timer, termsOfService, scorecard};
        startButton.setOnAction(new readToS(tempArr, userNameEntry, gp, startButton));
        



        stage.setScene(scene);
        stage.setTitle("Quiz");
        stage.show();

    }

    public void quickFormat(Label item, Color bgColor){
        item.setMaxWidth(Double.MAX_VALUE);
        item.setMaxHeight(Double.MAX_VALUE);
        item.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,new CornerRadii(0), BorderStroke.DEFAULT_WIDTHS)));
        item.setBackground(new Background(new BackgroundFill(bgColor, CornerRadii.EMPTY, Insets.EMPTY)));
        item.setPadding(new Insets(15));
        item.setAlignment(Pos.CENTER);
    }
    public void quickFormat(Button item, Color bgColor){
        item.setMaxWidth(Double.MAX_VALUE);
        item.setMaxHeight(Double.MAX_VALUE);
        item.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,new CornerRadii(0), BorderStroke.DEFAULT_WIDTHS)));
        item.setBackground(new Background(new BackgroundFill(bgColor, CornerRadii.EMPTY, Insets.EMPTY)));
        item.setPadding(new Insets(15));
        item.setAlignment(Pos.CENTER);
    }
    public void quickFormat(TextField item, Color bgColor){
        item.setMaxWidth(Double.MAX_VALUE);
        item.setMaxHeight(Double.MAX_VALUE);
        item.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,new CornerRadii(0), BorderStroke.DEFAULT_WIDTHS)));
        item.setBackground(new Background(new BackgroundFill(bgColor, CornerRadii.EMPTY, Insets.EMPTY)));
        item.setPadding(new Insets(15));
        item.setAlignment(Pos.CENTER);
    }

    public static void main(String[] args) {
        
        launch(args);
    }

}
