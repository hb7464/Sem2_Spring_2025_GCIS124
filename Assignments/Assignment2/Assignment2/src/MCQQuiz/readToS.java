package MCQQuiz;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

public class readToS implements EventHandler<ActionEvent> {

    private Label username;
    private Label timer;
    private Label tos;
    private Label scorecard;
    private TextField usernameInp;
    private GridPane gp;
    private Button submit;
    private Label noOfQuestions = new Label("How many questions do you want?(0-10)");
    private TextField actualNoOfQuestions = new TextField("Enter num: ");
    private Button startQuiz = new Button("Start Quiz");

    public readToS(Label[] arrOfLabels, TextField usernameInp, GridPane gp, Button submit){
        this.username = arrOfLabels[0];
        this.timer = arrOfLabels[1];
        this.tos = arrOfLabels[2];
        this.scorecard = arrOfLabels[3];
        this.usernameInp = usernameInp;
        this.gp = gp;
        this.submit = submit;
    }

    public void handle(ActionEvent event){

        username.setText(usernameInp.getText());
        scorecard.setText("   0/0   ");
        
        gp.getChildren().remove(usernameInp);
        gp.getChildren().remove(tos);
        gp.getChildren().remove(submit);
        
        quickFormat(username, Color.DARKGRAY);
        quickFormat(timer, Color.DARKGRAY);
        quickFormat(scorecard, Color.DARKGRAY);
        quickFormat(noOfQuestions, null);
        quickFormat(actualNoOfQuestions, Color.WHITE);
        quickFormat(startQuiz, Color.WHITE);
        
        gp.add(username, 0, 0);
        gp.add(scorecard, 1, 0);
        gp.add(timer, 2, 0);
        gp.add(noOfQuestions, 0, 1);
        gp.add(actualNoOfQuestions, 1, 1);
        gp.add(startQuiz, 2, 1);

        Label[] tempArr = {username, timer, scorecard, noOfQuestions};
        startQuiz.setOnAction(new quizbegin(tempArr, actualNoOfQuestions, gp, startQuiz));

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