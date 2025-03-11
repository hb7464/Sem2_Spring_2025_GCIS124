package MCQQuiz;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

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
    
    public PressContinue(Button cont, GridPane gp, 
    Label q1, Button[] answers, QuizQuestions quizTime, 
    int currIndex, int currscore, int numOfQuestions, Label scorecard){

        this.cont = cont;
        this.gp = gp;
        this.q1 = q1;
        this.answers = answers;
        this.quizTime = quizTime;
        this.currIndex = currIndex+1;
        this.currscore = currscore;
        this.numOfQuestions = numOfQuestions;
        this.scorecard = scorecard;

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

        Button cont = new Button("PlaceHolder");
        func.quickFormat(cont, null);
        cont.setBorder(null);
        gp.add(cont, 3, 4);
        if (cont.getText().equals("Correct Continue!")){currscore++;}
        System.out.println("Currscore2"+currscore);

        func.loadQuestion(currIndex, quizTime, q1, answers, currscore, numOfQuestions, cont, gp, scorecard);


    }

}