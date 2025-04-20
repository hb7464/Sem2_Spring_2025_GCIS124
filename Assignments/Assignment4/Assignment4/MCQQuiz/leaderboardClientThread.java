package MCQQuiz;

import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.GridPane;

/**
 * The leaderboardClientThread class is responsible for defining a thread 
 * that updates the gridpane once the leaderboard is ready to be displayed 
 * and removes the loading screen
 */

public class leaderboardClientThread extends Thread {

    private GridPane gp;
    private Label username;
    private String score;
    private int numOfQuestions;
    private Label timerLabel;
    private Button contButton;
    private ProgressIndicator loading;

    /**
     * The constructor for the client thread
     *
     * @param gp The GridPane 
     * @param username The username as a label
     * @param score The user's score as a string
     * @param numOfQuestions The number of questions the user selected
     * @param timerLabel The label with user's submission time
     * @param contButton The continue button that will be used to show the leaderboard
     * @param loading The circular loading object to show the user the quiz is loading
     */

    public leaderboardClientThread(GridPane gp, Label username, String score, int numOfQuestions,
                                             Label timerLabel, Button contButton, ProgressIndicator loading) {
        this.gp = gp;
        this.username = username;
        this.score = score;
        this.numOfQuestions = numOfQuestions;
        this.timerLabel = timerLabel;
        this.contButton = contButton;
        this.loading = loading;
    }

    /**
     * A thread that sends the user data to the server and then updates the 
     * end screen once the leaderboard is ready
     */

    @Override
    public void run() {
        leaderboardClient client = new leaderboardClient();
        QuizFunctions func = new QuizFunctions();
        String[][] leaderboard = client.sendScores(username.getText(), score, func.calculateTimeTaken(timerLabel, numOfQuestions));

        Platform.runLater(() -> {
            contButton.setText("Click here to see the leaderboard");
            func.quickFormat(contButton, GUIMain.backgroundcol2);
            contButton.setOnAction(new FinalPhase(gp, leaderboard));
            gp.getChildren().remove(loading);
        });
    }
}
