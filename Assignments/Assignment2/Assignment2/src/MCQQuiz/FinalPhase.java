package MCQQuiz;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class FinalPhase implements EventHandler<ActionEvent> {

    private GridPane gp;
    private int numOfQuestions;
    private Label hiddenscore;
    private QuizFunctions func = new QuizFunctions();
    private double leaderboardScore;
    private String leaderboard;
    
    public FinalPhase(GridPane gp, int numOfQuestions, Label hiddenscore, String leaderboard){

        this.gp = gp;
        this.numOfQuestions = numOfQuestions;
        this.hiddenscore = hiddenscore;
        this.leaderboard = leaderboard;

    }

    public void handle(ActionEvent event){
        leaderboardScore = Double.valueOf(hiddenscore.getText());
        Label scoreboard = new Label(leaderboard);
        func.quickFormat(scoreboard, Color.DARKMAGENTA);
        gp.getChildren().clear();
        gp.add(scoreboard, 0,0);
       

    }

}