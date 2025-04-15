package MCQQuiz;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * A class that changes the default colors to colorblind friendly colors
 */

public class PressColorBlind implements EventHandler<ActionEvent> {

    public void handle(ActionEvent event){ // Setting the default color scheme to a colorblind friendly scheme
        GUIMain.backgroundcol1 = GUIMain.CBBACK_COLOR;
        GUIMain.backgroundcol2 = GUIMain.CBBACK_COLOR;
        GUIMain.textcol = GUIMain.CBTEXT_COLOR;
    }

}