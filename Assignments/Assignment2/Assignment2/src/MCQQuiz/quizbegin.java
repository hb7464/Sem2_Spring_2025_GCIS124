package MCQQuiz;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.geometry.Pos;


public class quizbegin implements EventHandler<ActionEvent> {

    private Label username;
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

            else if (numOfQuestions < 0){
                noOfQuestions.setText("This is code made for a quiz???\nWhy do you not want to answer questions? \nAre you hiding something?");
            }

            else{
                scorecard.setText("   0/"+numOfQuestions+"   ");
                int currscore = 0;
                timer.setText(numOfQuestions+":00");

                Button continueButton = new Button("");
                quickFormat(continueButton, null);
                continueButton.setBorder(null);
                gp.add(continueButton, 3, 4);
                
                Label contChecked = new Label("NotChecked");
                quickFormat(contChecked, null);
                contChecked.setBorder(null);
                contChecked.setTextFill(null);
                gp.add(contChecked, 3,3);
                
                QuizQuestions quizTime = new QuizQuestions();
                String filename = "src\\MCQQuiz\\questionsBase.txt";
                    quizTime.load(filename);
                
                gp.getChildren().remove(noOfQuestions);
                gp.getChildren().remove(actualNoOfQuestions);
                gp.getChildren().remove(startQuiz);

                quizTime.select(numOfQuestions);
                int currIndex = 0;
                //Add the load question function here

                // System.out.print("HAKP#"); //debug
            }
        }
        catch (Exception e){
            System.out.println("The following exception has occured: "+e);
            System.out.println(e.getStackTrace()[0]);
        }
        
    }

    public void loadQuestion(int currIndex, QuizQuestions quizTime, Label q1, Button[] answers, boolean cleared){
        if (currIndex >= quizTime.selectedQuestions.size()){
            //Put code to complete quiz
            return;
        }
        if (!cleared){
            gp.getChildren().remove(q1);
        }
        ArrayList<Question> q = quizTime.selectedQuestions;
        q1.setText(q.get(currIndex).getQuestion());
        quickFormat(q1, Color.LIGHTGREY);
        gp.add(q1, 0, 1, 3,1);
        int option = 0;
        for (Button a: answers){

            if (quizTime.selectedQuestions.size() == 2 && option == 2){break;}
            String ans = q.get(currIndex).getAllAnswers()[option];
            a.setText(ans);
            gp.add(a,0,currIndex+2, 3,1);
            quickFormat(a, Color.BLANCHEDALMOND);
            if (ans == q.get(currIndex).getCorrectAnswer()){a.setOnAction(new PressCorrect(a2, q1, currIndex, option, a1, q1));} 
            //fix  presscorrrect and presswrong
            else{a.setOnAction(new PressWrong(a, a, a, q1));}
        }
        
    }

    public void quickFormat(Label item, Color bgColor){
        item.setMaxWidth(Double.MAX_VALUE);
        item.setMaxHeight(Double.MAX_VALUE);
        item.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,new CornerRadii(0), BorderStroke.DEFAULT_WIDTHS)));
        item.setBackground(new Background(new BackgroundFill(bgColor, CornerRadii.EMPTY, Insets.EMPTY)));
        item.setPadding(new Insets(15));
        item.setAlignment(Pos.CENTER);
    }

    public void quickFormat(Button item, Color bgColor){
        item.setMaxWidth(Double.MAX_VALUE);
        item.setMaxHeight(Double.MAX_VALUE);
        item.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,new CornerRadii(0), BorderStroke.DEFAULT_WIDTHS)));
        item.setBackground(new Background(new BackgroundFill(bgColor, CornerRadii.EMPTY, Insets.EMPTY)));
        item.setPadding(new Insets(15));
        item.setAlignment(Pos.CENTER);
    }
}