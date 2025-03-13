package MCQQuiz;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class quizbegin implements EventHandler<ActionEvent> {

    private Label username;
    private Label hiddenscore = new Label("0");
    private Label timer;
    private Label scorecard;
    private GridPane gp;
    private Button startQuiz;
    private Label noOfQuestions;
    private TextField actualNoOfQuestions;
    private Label q1 = new Label();
    private Button a1 = new Button();
    private Button a2 = new Button();
    private Button a3 = new Button();
    private Button a4 = new Button();
    private Button[] answers = {a1,a2,a3,a4};
    private QuizFunctions func = new QuizFunctions();

    public quizbegin(Label[] arrOfLabels, TextField actualNoOfQuestions, GridPane gp, Button startQuiz){
        this.username = arrOfLabels[0];
        this.timer = arrOfLabels[1];
        this.scorecard = arrOfLabels[2];
        this.noOfQuestions = arrOfLabels[3];
        this.actualNoOfQuestions = actualNoOfQuestions;
        this.gp = gp;
        this.startQuiz = startQuiz;
    }

    public void handle(ActionEvent event){

        try{
        
            Integer numOfQuestions = Integer.valueOf(actualNoOfQuestions.getText());
            if (numOfQuestions > 10){
                noOfQuestions.setText("WOAH! Slow down there, we don't have that many questions.");
            }

            else if (numOfQuestions <= 0){
                noOfQuestions.setText("This is code made for a quiz???\nWhy do you not want to answer questions? \nAre you hiding something?");
            }

            else{
                scorecard.setText("   0/"+numOfQuestions+"   ");
                int currscore = 0;
                timer.setText(numOfQuestions+":00");

                Button cont = new Button("");
                func.quickFormat(cont, null);
                cont.setBorder(null);
                gp.add(cont, 0, 10, 3,1);
                
                QuizQuestions quizTime = new QuizQuestions();
                String filename = "src\\MCQQuiz\\questionsBase.txt";
                quizTime.load(filename);
                
                gp.getChildren().remove(noOfQuestions);
                gp.getChildren().remove(actualNoOfQuestions);
                gp.getChildren().remove(startQuiz);

                quizTime.select(numOfQuestions);
                int currIndex = 0;
                func.loadQuestion(username, currIndex, quizTime, q1, answers, currscore, numOfQuestions, cont, gp, scorecard, hiddenscore);
            }
        }
        catch (Exception e){
            System.out.println("The following exception has occured: "+e);
            System.out.println(e.getStackTrace()[0]);
            noOfQuestions.setText("Can you just enter a regular integer?");
        }
        
    }


}