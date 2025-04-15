package MCQQuiz;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 * Handles the final phase of the quiz, displaying the leaderboard.
 * Clears the GridPane and shows the leaderboard.
 */

public class FinalPhase implements EventHandler<ActionEvent> {

    private GridPane gp;
    private QuizFunctions func = new QuizFunctions();
    private String leaderboard;
    
    /**
     * 
     * @param gp the gridpane
     * @param numOfQuestions How many questions in total
     * @param hiddenscore //A label that ensures the user's score is not lost
     * @param leaderboard //The leaderboard that is loaded from the leaderboard text file
     */

    public FinalPhase(GridPane gp, int numOfQuestions, Label hiddenscore, String leaderboard){

        this.gp = gp;
        this.leaderboard = leaderboard;

    }

    public void handle(ActionEvent event){ //The void handle event, here it is displaying the leaderboard

        Label header = new Label("Leaderboard");
        header.setPadding(new Insets(60));
        Label scoreboard = new Label(leaderboard);
        func.quickFormat(scoreboard, GUIMain.backgroundcol2);
        func.quickFormat(header, GUIMain.backgroundcol1);
        gp.getChildren().clear();
        gp.add(header, 0,0);
        gp.add(scoreboard, 0,1);
       
    }

}