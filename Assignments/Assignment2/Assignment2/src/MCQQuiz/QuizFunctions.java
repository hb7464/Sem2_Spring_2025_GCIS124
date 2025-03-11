package MCQQuiz;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
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

public class QuizFunctions {

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

    public void loadQuestion(int currIndex, QuizQuestions quizTime, Label q1, Button[] answers, int currscore, int numOfQuestions, Button contButton, GridPane gp, Label scorecard){
        if (currIndex >= quizTime.selectedQuestions.size()){
            //Put code to complete quiz
            return;
        }
        
        ArrayList<Question> q = quizTime.selectedQuestions;
        q1.setText(q.get(currIndex).getQuestion());
        quickFormat(q1, Color.LIGHTGREY);
        gp.add(q1, 0, 1, 3,1);
        
        int option = 0;
        System.out.println("Currscore1"+currscore);
        for (Button a: answers){
            
            
            if (q.get(currIndex).getAllAnswers().length == 2 && option == 2){break;}

            String ans = q.get(currIndex).getAllAnswers()[option];
            a.setText(ans);
            gp.add(a,0,option+2, 3,1);
            quickFormat(a, Color.BLANCHEDALMOND);

            if (ans.equals(q.get(currIndex).getCorrectAnswer())){a.setOnAction(new PressCorrect(a, scorecard, currscore, numOfQuestions, contButton));}

            else{a.setOnAction(new PressWrong(a, contButton));}            
            option++;
        }
        contButton.setOnAction(new PressContinue(contButton, gp, q1, answers, quizTime, currIndex, currscore, numOfQuestions, scorecard));
        
    }

}
