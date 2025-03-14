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

    static Color backgroundcol1 = Color.rgb(195,210,213);
    static Color backgroundcol2 = Color.rgb(193,247,220);
    static Color textcol = Color.BLACK;
    final static Color CBbackgroundcol = Color.rgb(31,68,156);
    final static Color CBtextcol = Color.rgb(240,80,57);

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
        Button colorButton = new Button("Click here for colour blind mode");
        func.quickFormat(termsOfService, backgroundcol2);
        func.quickFormat(userNameEntry, backgroundcol2);
        func.quickFormat(startButton, backgroundcol1);
        func.quickFormat(colorButton, CBbackgroundcol);
        colorButton.setTextFill(CBtextcol);


        gp.add(termsOfService, 0,0);
        gp.add(userNameEntry, 0,1);
        gp.add(startButton,0,2);
        gp.add(colorButton,0,3);

        Label[] tempArr = {userNameFinal, timer, termsOfService, scorecard};
        startButton.setOnAction(new readToS(tempArr, userNameEntry, gp, startButton, colorButton));
        colorButton.setOnAction(new PressColorBlind());
        

        gp.setAlignment(Pos.CENTER);
        stage.setScene(scene);
        stage.setTitle("Quiz");
        stage.show();

    }

    public static void main(String[] args) {
        
        launch(args);
    }

}
