package MCQQuiz;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class FinalPhase implements EventHandler<ActionEvent> {

    private GridPane gp;
    private QuizFunctions func = new QuizFunctions();
    private String leaderboard;
    
    public FinalPhase(GridPane gp, int numOfQuestions, Label hiddenscore, String leaderboard){

        this.gp = gp;
        this.leaderboard = leaderboard;

    }

    public void handle(ActionEvent event){

        Label header = new Label("Leaderboard");
        header.setPadding(new Insets(60));
        Label scoreboard = new Label(leaderboard);
        func.quickFormat(scoreboard, Color.DARKMAGENTA);
        func.quickFormat(header, Color.DARKMAGENTA);
        gp.getChildren().clear();
        gp.add(header, 0,0);
        gp.add(scoreboard, 0,1);
       
    }

}