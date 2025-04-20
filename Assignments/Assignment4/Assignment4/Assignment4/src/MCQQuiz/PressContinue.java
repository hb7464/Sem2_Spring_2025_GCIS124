package Assignment4.src.MCQQuiz;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 * The method that moves the user to the next Question
 */

public class PressContinue implements EventHandler<ActionEvent> {

    private Label username;
    private GridPane gp;
    private Button cont;
    private Label q1;
    private Button[] answers;
    private QuizQuestions quizTime;
    private QuizFunctions func = new QuizFunctions();
    private int currIndex;
    private int currscore;
    private int numOfQuestions;
    private Label scorecard;
    private Label hiddenscore;
    private Label timerLabel;
    
    /**
     * Button and events for and after pressing continue button.
     *
     * @param username       Label to display username.
     * @param cont           The "Continue" button to move to next question
     * @param gp             The GridPane for the GUI.
     * @param q1             Label to show the current question.
     * @param answers        Options for the question
     * @param quizTime       he object containing the selected questions for the quiz
     * @param currIndex      The index for the current question.
     * @param currscore      Current score of the player.
     * @param numOfQuestions The total number of questions.
     * @param scorecard      Label which shows the player's scorecard.
     * @param hiddenscore    The label for storing the hidden score value.
     * @param timerLabel     The label with the timer
     */

    public PressContinue(Label username, Button cont, GridPane gp, 
    Label q1, Button[] answers, QuizQuestions quizTime, 
    int currIndex, int currscore, int numOfQuestions, Label scorecard, Label hiddenscore, Label timerLabel){

        this.username = username;
        this.cont = cont;
        this.gp = gp;
        this.q1 = q1;
        this.answers = answers;
        this.quizTime = quizTime;
        this.currIndex = currIndex+1;
        this.currscore = currscore;
        this.numOfQuestions = numOfQuestions;
        this.scorecard = scorecard;
        this.hiddenscore = hiddenscore;
        this.timerLabel = timerLabel;

    }

    public void handle(ActionEvent event){

        cont.setText("");
        func.quickFormat(cont,null);
        cont.setBorder(null);
        gp.getChildren().remove(q1);
        for (Button a: answers){
            gp.getChildren().remove(a);
        }     

        currscore = Integer.valueOf(hiddenscore.getText());
        
        func.loadQuestion(username, currIndex, quizTime, q1, answers, currscore, numOfQuestions, cont, gp, scorecard, hiddenscore, timerLabel);


    }

}