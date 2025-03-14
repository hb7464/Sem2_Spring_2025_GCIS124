package MCQQuiz;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class PressCorrect implements EventHandler<ActionEvent> {

    private Button correctbutton;
    private Label score;
    private int currscore;
    private int numOfQuestions;
    private Button cont;
    private QuizFunctions func = new QuizFunctions();
    private Label hiddenscore;
    private Button[] answers;

    public PressCorrect(Button correctbutton, Label score, int currscore, int numOfQuestions, Button cont, Label hiddenscore, Button[] answers){

        this.correctbutton = correctbutton;
        this.score = score;
        this.currscore = currscore;
        this.numOfQuestions = numOfQuestions;
        this.cont = cont;
        this.hiddenscore = hiddenscore;
        this.answers = answers;

    }

    public void handle(ActionEvent event){

        for (Button a : answers){
            a.setDisable(true);
        }

        currscore++;
        hiddenscore.setText(""+currscore);
        correctbutton.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        score.setText("   "+(currscore)+"/"+numOfQuestions+"   ");
        func.quickFormat(cont, GUIMain.backgroundcol2);
        cont.setText("Correct Continue!");

    }

}