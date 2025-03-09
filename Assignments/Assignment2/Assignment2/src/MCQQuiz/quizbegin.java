package MCQQuiz;

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
    private String ca = "";


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
                timer.setText(numOfQuestions+":00");
                
                QuizQuestions quizTime = new QuizQuestions();
                String filename = "src\\MCQQuiz\\questionsBase.txt";
                    quizTime.load(filename);
                
                gp.getChildren().remove(noOfQuestions);
                gp.getChildren().remove(actualNoOfQuestions);
                gp.getChildren().remove(startQuiz);
                // System.out.println("HALP"); //debug


                quizTime.select(numOfQuestions);
                for (Question q: quizTime.selectedQuestions){
                    // System.out.println("HALP2"); //debug
                    ca = q.getCorrectAnswer();
                    // System.out.println("sds"); //debug

                    q1.setText(q.getQuestion());
                    String[] ans = q.getAllAnswers();
                    
                    if (ans.length == 2){
                        
                        if (ans[0] == ca){
                            a1.setOnAction(new PressCorrect(a1,gp));
                            a2.setOnAction(new PressWrong(a2,a1,gp));
                        }
                        else{
                            a1.setOnAction(new PressWrong(a1,a2,gp));
                            a2.setOnAction(new PressCorrect(a2,gp));
                        }
                        
                        a1.setText(ans[0]);
                        a2.setText(ans[1]);
                        
                        quickFormat(a1, Color.BLANCHEDALMOND);
                        quickFormat(a2, Color.BLANCHEDALMOND);
                        
                        gp.add(a1, 0, 2, 3,1);
                        gp.add(a2, 0, 3, 3,1);
                        
                    }
                    
                    else{
                        
                        if (ans[0] == ca){
                            a1.setOnAction(new PressCorrect(a1,gp));
                            a2.setOnAction(new PressWrong(a2,a1,gp));
                            a3.setOnAction(new PressWrong(a3,a1,gp));
                            a4.setOnAction(new PressWrong(a4,a1,gp));
                        }
                        else if (ans[1] == ca){
                            a1.setOnAction(new PressWrong(a1,a2,gp));
                            a2.setOnAction(new PressCorrect(a2,gp));
                            a3.setOnAction(new PressWrong(a3,a2,gp));
                            a4.setOnAction(new PressWrong(a4,a2,gp));
                        }
                        else if (ans[2] == ca){
                            a1.setOnAction(new PressWrong(a1,a3,gp));
                            a2.setOnAction(new PressWrong(a2,a3,gp));
                            a3.setOnAction(new PressCorrect(a3,gp));
                            a4.setOnAction(new PressWrong(a4,a3,gp));
                        }
                        else{
                            a1.setOnAction(new PressWrong(a1,a4,gp));
                            a2.setOnAction(new PressWrong(a2,a4,gp));
                            a3.setOnAction(new PressWrong(a3,a4,gp));
                            a4.setOnAction(new PressCorrect(a4,gp));
                        }

                        a1.setText(ans[0]);
                        a2.setText(ans[1]);
                        a3.setText(ans[2]);
                        a4.setText(ans[3]);
                        
                        quickFormat(a1, Color.BLANCHEDALMOND);
                        quickFormat(a2, Color.BLANCHEDALMOND);
                        quickFormat(a3, Color.BLANCHEDALMOND);
                        quickFormat(a4, Color.BLANCHEDALMOND);
                        
                        gp.add(a1, 0, 2, 3,1);
                        gp.add(a2, 0, 3, 3,1);
                        gp.add(a3, 0, 4, 3,1);
                        gp.add(a4, 0, 5, 3,1);
                        
                    }
                    quickFormat(q1, Color.LIGHTGREY);
    
                    gp.add(q1, 0, 1, 3,1);
                }
                // System.out.print("HAKP#");
            }
        }
        catch (Exception e){
            System.out.println("The following exception has occured: "+e);
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
    public void quickFormat(TextField item, Color bgColor){
        item.setMaxWidth(Double.MAX_VALUE);
        item.setMaxHeight(Double.MAX_VALUE);
        item.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,new CornerRadii(0), BorderStroke.DEFAULT_WIDTHS)));
        item.setBackground(new Background(new BackgroundFill(bgColor, CornerRadii.EMPTY, Insets.EMPTY)));
        item.setPadding(new Insets(15));
        item.setAlignment(Pos.CENTER);
    }
}