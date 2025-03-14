package MCQQuiz;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class PressColorBlind implements EventHandler<ActionEvent> {

    QuizFunctions func = new QuizFunctions();

    public void handle(ActionEvent event){
        GUIMain.backgroundcol1 = GUIMain.CBbackgroundcol;
        GUIMain.backgroundcol2 = GUIMain.CBbackgroundcol;
        GUIMain.textcol = GUIMain.CBtextcol;
    }

}