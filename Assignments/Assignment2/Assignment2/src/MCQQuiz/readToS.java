package MCQQuiz;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class readToS implements EventHandler<ActionEvent> {

    private Label username;
    private Label timer;
    private Label tos;
    private Label scorecard;
    private TextField usernameInp;
    private GridPane gp;
    private Button submit;
    private Label noOfQuestions = new Label("How many questions do you want?(0-10)");
    private TextField actualNoOfQuestions = new TextField("Enter num: ");
    private Button startQuiz = new Button("Start Quiz");
    private QuizFunctions func = new QuizFunctions();

    public readToS(Label[] arrOfLabels, TextField usernameInp, GridPane gp, Button submit){
        this.username = arrOfLabels[0];
        this.timer = arrOfLabels[1];
        this.tos = arrOfLabels[2];
        this.scorecard = arrOfLabels[3];
        this.usernameInp = usernameInp;
        this.gp = gp;
        this.submit = submit;
    }

    public void handle(ActionEvent event){

        username.setText(usernameInp.getText());
        scorecard.setText("   0/0   ");
        
        gp.getChildren().remove(usernameInp);
        gp.getChildren().remove(tos);
        gp.getChildren().remove(submit);
        
        func.quickFormat(username, Color.DARKGRAY);
        func.quickFormat(timer, Color.DARKGRAY);
        func.quickFormat(scorecard, Color.DARKGRAY);
        func.quickFormat(noOfQuestions, null);
        func.quickFormat(actualNoOfQuestions, Color.WHITE);
        func.quickFormat(startQuiz, Color.WHITE);
        
        gp.add(username, 0, 0);
        gp.add(scorecard, 1, 0);
        gp.add(timer, 2, 0);
        gp.add(noOfQuestions, 0, 1);
        gp.add(actualNoOfQuestions, 1, 1);
        gp.add(startQuiz, 2, 1);

        Label[] tempArr = {username, timer, scorecard, noOfQuestions};
        startQuiz.setOnAction(new quizbegin(tempArr, actualNoOfQuestions, gp, startQuiz));

    }
}