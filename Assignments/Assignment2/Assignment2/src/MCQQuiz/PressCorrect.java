package MCQQuiz;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class PressCorrect implements EventHandler<ActionEvent> {

    private Button correctbutton;
    private Label score;
    private int currscore;
    private int numOfQuestions;
    private Button cont;
    private QuizFunctions func = new QuizFunctions();

    public PressCorrect(Button correctbutton, Label score, int currscore, int numOfQuestions, Button cont){

        this.correctbutton = correctbutton;
        this.score = score;
        this.currscore = currscore;
        this.numOfQuestions = numOfQuestions;
        this.cont = cont;

    }

    public void handle(ActionEvent event){

        currscore++;
        correctbutton.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        score.setText("   "+(currscore)+"/"+numOfQuestions+"   ");
        func.quickFormat(cont, Color.LIGHTGREY);
        cont.setText("Correct Continue!");

    }

}