package MCQQuiz;

import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 * Handles the start of the quiz.
 * Initializes the timer, loads questions, and officially starts the quiz
 */

public class quizbegin implements EventHandler<ActionEvent> {

    private Label username;
    private Label hiddenscore = new Label("0");
    private Label timerLabel;
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

    /**
     * Intializing all the objects required to start the quiz
     * @param arrOfLabels An array of all the labels from readToS
     * @param actualNoOfQuestions The input from the user about the required number of questions
     * @param gp The gridpane instance
     * @param startQuiz The button used to start the quiz
     */

    public quizbegin(Label[] arrOfLabels, TextField actualNoOfQuestions, GridPane gp, Button startQuiz){
        this.username = arrOfLabels[0];
        this.timerLabel = arrOfLabels[1];
        this.scorecard = arrOfLabels[2];
        this.noOfQuestions = arrOfLabels[3];
        this.actualNoOfQuestions = actualNoOfQuestions;
        this.gp = gp;
        this.startQuiz = startQuiz;
    }

    public void handle(ActionEvent event){ //Getting the number of questions from the user to see how
                                            //many questions are required

        try{ //Using try-with resources to catch any non-numeric inputs inside the textfield
        
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
                
                Timer timer = new Timer();
                
                TimerTask countdown = new TimerTask() {
                    int time = numOfQuestions*60;
                    @Override 
                    public void run(){

                        
                        if (time > 0){
                            Platform.runLater(() -> {timerLabel.setText((time/60)+":"+(time%60));});
                            time--;
                        }
                        else if (time <= 0){
                            timerLabel.setText("Times Up!");
                            func.loadEndCard(username, q1, answers, currIndex, cont, gp, hiddenscore);
                            timer.cancel();
                        }
                    }
                };
                timer.scheduleAtFixedRate(countdown, 0, 1000);
                func.loadQuestion(username, currIndex, quizTime, q1, answers, currscore, numOfQuestions, cont, gp, scorecard, hiddenscore);
            }
        }
        catch (Exception e){
            System.out.println("The following exception has occured: "+e);
            noOfQuestions.setText("Can you just enter a regular integer?");
        }
        
    }


}