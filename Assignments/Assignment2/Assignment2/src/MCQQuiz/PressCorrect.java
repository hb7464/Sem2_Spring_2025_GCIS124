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

public class PressCorrect implements EventHandler<ActionEvent> {

    private Button correctbutton;
    private Button continuebutton = new Button("Continue!");
    private GridPane gp;

    public PressCorrect(Button correctbutton, GridPane gp){

        this.correctbutton = correctbutton;
        this.gp = gp;

    }

    public void handle(ActionEvent event){

        correctbutton.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        quickFormat(continuebutton, Color.LIGHTGREY);
        gp.add(continuebutton, 3, 4);

    }

    public void quickFormat(Label item, Color bgColor){
        item.setMaxWidth(Double.MAX_VALUE);
        item.setMaxHeight(Double.MAX_VALUE);
        item.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,new CornerRadii(0), BorderStroke.DEFAULT_WIDTHS)));
        item.setBackground(new Background(new BackgroundFill(bgColor, CornerRadii.EMPTY, Insets.EMPTY)));
    }
    public void quickFormat(Button item, Color bgColor){
        item.setMaxWidth(Double.MAX_VALUE);
        item.setMaxHeight(Double.MAX_VALUE);
        item.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,new CornerRadii(0), BorderStroke.DEFAULT_WIDTHS)));
        item.setBackground(new Background(new BackgroundFill(bgColor, CornerRadii.EMPTY, Insets.EMPTY)));
    }
    public void quickFormat(TextField item, Color bgColor){
        item.setMaxWidth(Double.MAX_VALUE);
        item.setMaxHeight(Double.MAX_VALUE);
        item.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,new CornerRadii(0), BorderStroke.DEFAULT_WIDTHS)));
        item.setBackground(new Background(new BackgroundFill(bgColor, CornerRadii.EMPTY, Insets.EMPTY)));
    }
}