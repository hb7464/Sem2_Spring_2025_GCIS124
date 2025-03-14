package MCQQuiz;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class PressColorBlind implements EventHandler<ActionEvent> {

    QuizFunctions func = new QuizFunctions();

    public void handle(ActionEvent event){
        GUIMain.backgroundcol1 = GUIMain.CBBACK_COLOR;
        GUIMain.backgroundcol2 = GUIMain.CBBACK_COLOR;
        GUIMain.textcol = GUIMain.CBTEXT_COLOR;
    }

}