package MCQQuiz;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GUIMain extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        
        GridPane gp = new GridPane();
        Scene scene = new Scene(gp);
        QuizFunctions func = new QuizFunctions();

        
        Label userNameFinal = new Label();
        Label timer = new Label("Timer");
        Label termsOfService = new Label("STUF YOU NEDED TO AGREE TO + \nRULES");
        Label scorecard = new Label();
        TextField userNameEntry = new TextField("Enter your name: ");
        Button startButton = new Button("Begin Quiz");
        func.quickFormat(termsOfService, Color.WHITE);
        func.quickFormat(userNameEntry, Color.WHITE);
        func.quickFormat(startButton, Color.LIGHTGREY);


        gp.add(termsOfService, 0,0);
        gp.add(userNameEntry, 0,1);
        gp.add(startButton,0,2);
        Label[] tempArr = {userNameFinal, timer, termsOfService, scorecard};
        startButton.setOnAction(new readToS(tempArr, userNameEntry, gp, startButton));
        


        gp.setAlignment(Pos.CENTER);
        stage.setScene(scene);
        stage.setTitle("Quiz");
        stage.show();

    }

    public static void main(String[] args) {
        
        launch(args);
    }

}
