package Assignment4.src.MCQQuiz;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class PressWrong implements EventHandler<ActionEvent> {

    private Button wrongbutton;
    private Button cont;
    private QuizFunctions func = new QuizFunctions();
    private Button[] answers;

    /**
     * Button and events for and after selecting the wrong option.
     *
     * @param wrongbutton The button representing the incorrect answer.
     * @param cont        The "Continue" button to move to next question
     * @param answers     Options for the question  
     */

    public PressWrong(Button wrongbutton, Button cont, Button[] answers){

        this.wrongbutton = wrongbutton;
        this.cont = cont;
        this.answers = answers;
    }

    public void handle(ActionEvent event){
        for (Button a : answers){
            a.setDisable(true);
        }
        wrongbutton.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
        func.quickFormat(cont, GUIMain.backgroundcol2);
        cont.setText("Continue!");

    }

}