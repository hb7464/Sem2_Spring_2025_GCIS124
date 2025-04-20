package MCQQuiz;

import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.GridPane;

public class leaderboardClientThread extends Thread {

    private GridPane gp;
    private Label username;
    private String score;
    private int numOfQuestions;
    private Label timerLabel;
    private Label hiddenscore;
    private Button contButton;
    private ProgressIndicator loading;

    public leaderboardClientThread(GridPane gp, Label username, String score, int numOfQuestions,
                                             Label timerLabel, Label hiddenscore, Button contButton, ProgressIndicator loading) {
        this.gp = gp;
        this.username = username;
        this.score = score;
        this.numOfQuestions = numOfQuestions;
        this.timerLabel = timerLabel;
        this.hiddenscore = hiddenscore;
        this.contButton = contButton;
        this.loading = loading;
    }

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
