package MCQQuiz;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 * The main class for the GUI version of the quiz
 * Here we initialize the scene showing the start of the quiz
 */

public class GUIMain extends Application{

    //The default colors + colorblind color options for the labels, buttons and textfields

    static Color backgroundcol1 = Color.rgb(195,210,213);
    static Color backgroundcol2 = Color.rgb(193,247,220);
    static Color textcol = Color.BLACK;
    static boolean notInCBmode = true;

    /**
     * The main entry point for the JavaFX application.
     * Sets up the initial GUI layout with terms of service, user name entry,
     * and control buttons.
     * 
     * @param stage The primary stage for this application
     */
    @Override
    public void start(Stage stage) throws Exception {
        
        //Initializing all the required variables

        GridPane gp = new GridPane();
        Scene scene = new Scene(gp);
        QuizFunctions func = new QuizFunctions();

        
        Label userNameFinal = new Label();
        Label timer = new Label("Timer");
        Label termsOfService = new Label("Rules\n"+
                                        "1. NO CHEATINg (trust me its an easy quiz)\n"+
                                        "2. You are given a minute of time for the number of questions you choose to answer\n"+
                                        "3. Once you select an answer, you cannot change it and must move onto the next question\n"+
                                        "4. For each correct answer you get 1 point, and there is no negative marking for inccorect answer\n"+
                                        "5. Your score will be recorded on a leaderboard with other people who attempt the quiz\n"+
                                        "6. If you suffer from any form of color-blindness, click the second button before beginning the quiz.\n"+
                                        "It will change the visibility to a high contrast mode for easier visibility \n"+
                                        "7. The quiz will complete upon the final question being answer or the timer running out.\n"+
                                        "Good Luck!");

        Label scorecard = new Label();
        TextField userNameEntry = new TextField("Enter your name: ");
        Button startButton = new Button("Begin Quiz");
        Button colorButton = new Button("Click here for colour blind mode");

        //Formatting all the created objects so it looks proper

        func.quickFormat(termsOfService, backgroundcol2);
        termsOfService.setTextAlignment(TextAlignment.CENTER);
        func.quickFormat(userNameEntry, backgroundcol2);
        func.quickFormat(startButton, backgroundcol1);
        func.quickFormat(colorButton, Color.rgb(31,68,156));
        colorButton.setTextFill(Color.rgb(240,80,57));

        //Adding the objects to the gridpane

        gp.add(termsOfService, 0,0);
        gp.add(userNameEntry, 0,1);
        gp.add(startButton,0,2);
        gp.add(colorButton,0,3);

        //Loading the labels into an array so less arguments are required by readToS
        Label[] tempArr = {userNameFinal, timer, termsOfService, scorecard};
        startButton.setOnAction(new readToS(tempArr, userNameEntry, gp, startButton, colorButton));
        colorButton.setOnAction(new PressColorBlind(termsOfService, userNameEntry, startButton));
        

        gp.setAlignment(Pos.CENTER);
        stage.setScene(scene);
        stage.setTitle("Quiz");
        stage.show();

    }

    /**
     * Main method to launch the JavaFX application.
     * 
     * @param args the arguments for when we call main
     */
    public static void main(String[] args) {
        
        launch(args);
    }

}
