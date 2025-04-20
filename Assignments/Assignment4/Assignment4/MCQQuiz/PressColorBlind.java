package MCQQuiz;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;

/**
 * A class that changes the default colors to colorblind friendly colors
 */

public class PressColorBlind implements EventHandler<ActionEvent> {

    QuizFunctions func = new QuizFunctions();
    
    private Label termsOfService;
    private TextField userNameEntry;
    private Button startButton;

    /**
     * Constructs a PressColorBlind event handler with references to UI elements.
     * 
     * @param termsOfService The label containing terms of service text
     * @param userNameEntry The text field for user name entry
     * @param startButton The main start quiz button
     */

    public PressColorBlind(Label termsOfService, TextField userNameEntry, Button startButton){
        this.termsOfService = termsOfService;
        this.userNameEntry = userNameEntry;
        this.startButton = startButton;
    }

    /**
     * Handles the color mode toggle action.
     * Switches between normal and colorblind-friendly color schemes when the button is clicked.
     * 
     * @param event The action event triggered by button click
     */
    
    public void handle(ActionEvent event){ // Setting the default color scheme to a colorblind friendly 
                                           //scheme or to default
        if (GUIMain.notInCBmode){
            GUIMain.backgroundcol1 = Color.rgb(31,68,156);
            GUIMain.backgroundcol2 = Color.rgb(31,68,156);
            GUIMain.textcol = Color.rgb(240,80,57);
            GUIMain.notInCBmode = false;
        }
        else{
            GUIMain.backgroundcol1 = Color.rgb(195,210,213);;
            GUIMain.backgroundcol2 = Color.rgb(193,247,220);
            GUIMain.textcol = Color.BLACK;
            GUIMain.notInCBmode = true;
        }
        func.quickFormat(termsOfService, GUIMain.backgroundcol2);
        func.quickFormat(userNameEntry, GUIMain.backgroundcol2);
        func.quickFormat(startButton, GUIMain.backgroundcol1);
    }

}