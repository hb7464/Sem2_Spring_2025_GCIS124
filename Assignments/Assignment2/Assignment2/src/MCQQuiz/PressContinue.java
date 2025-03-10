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
    private Label contChecked;
    private Label q1;
    private Button a1;
    private Button a2;
    
    public PressContinue(Button cont, GridPane gp, Label contChecked, Label q1, Button a1, Button a2){

        this.cont = cont;
        this.gp = gp;
        this.contChecked = contChecked;

    }

    public void handle(ActionEvent event){

        cont.setText("");
        quickFormat(cont,null);
        cont.setBorder(null);
        gp.getChildren().remove(a1);
        gp.getChildren().remove(a2);        
        contChecked.setText("Checked");

    }

    public void quickFormat(Button item, Color bgColor){
        item.setMaxWidth(Double.MAX_VALUE);
        item.setMaxHeight(Double.MAX_VALUE);
        item.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,new CornerRadii(0), BorderStroke.DEFAULT_WIDTHS)));
        item.setBackground(new Background(new BackgroundFill(bgColor, CornerRadii.EMPTY, Insets.EMPTY)));
    }
}