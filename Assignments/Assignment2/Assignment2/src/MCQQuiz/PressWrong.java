package MCQQuiz;

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


    public PressWrong(Button wrongbutton, Button cont){

        this.wrongbutton = wrongbutton;
        this.cont = cont;
    }

    public void handle(ActionEvent event){

        wrongbutton.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
        func.quickFormat(cont, Color.LIGHTGREY);
        cont.setText("Continue!");

    }

}