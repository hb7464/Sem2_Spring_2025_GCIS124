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
    private String[][] leaderboard;
    
    /**
     * Constructs a FinalPhase handler to display the quiz leaderboard.
     * @param gp the gridpane
     * @param leaderboard //The leaderboard that is loaded from the leaderboard text file
     */

    public FinalPhase(GridPane gp, String[][] leaderboard){

        this.gp = gp;
        this.leaderboard = leaderboard;

    }

    public void handle(ActionEvent event){ //The void handle event, here it is displaying the leaderboard

        Label header = new Label("Leaderboard");
        header.setPadding(new Insets(60));

        func.quickFormat(header, GUIMain.backgroundcol1);
        gp.getChildren().clear();
        gp.add(header, 0,0, 4,1); 

        for (int entry = 0; entry < leaderboard.length; entry++){

            for (int i = 0; i < 4; i++){
                Label temp = new Label(leaderboard[entry][i]);
                func.quickFormat(temp, GUIMain.backgroundcol2);
                gp.add(temp,i, entry+1);
            }
        }
       
    }

}