package MCQQuiz;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class PressContinue implements EventHandler<ActionEvent> {

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
    
    public PressContinue(Button cont, GridPane gp, 
    Label q1, Button[] answers, QuizQuestions quizTime, 
    int currIndex, int currscore, int numOfQuestions, Label scorecard, Label hiddenscore){

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

    }

    public void handle(ActionEvent event){

        cont.setText("");
        func.quickFormat(cont,null);
        cont.setBorder(null);
        gp.getChildren().remove(q1);
        for (Button a: answers){
            gp.getChildren().remove(a);
        }     
        gp.getChildren().remove(cont);

        Button cont = new Button("");
        func.quickFormat(cont, null);
        cont.setBorder(null);
        gp.add(cont, 3, 4);
        currscore = Integer.valueOf(hiddenscore.getText());
        
        func.loadQuestion(currIndex, quizTime, q1, answers, currscore, numOfQuestions, cont, gp, scorecard, hiddenscore);


    }

}