import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;


public class PressClear implements EventHandler<ActionEvent> {

    private Label labelTop1;
    private Label labelTop2;
    private Label labelTop3;
    private Label ResultLabel;
    private int[] swi;

    public PressClear(Label labelTop1,Label labelTop2, Label labelTop3, Label ResultLabel, int[] swi){
        this.labelTop1 = labelTop1;
        this.labelTop2 = labelTop2;
        this.labelTop3 = labelTop3;
        this.ResultLabel = ResultLabel;
        this.swi = swi;
    }

    public void handle(ActionEvent event){
        labelTop1.setText(" ");
        labelTop2.setText("OP");
        labelTop3.setText(" ");
        ResultLabel.setText("Result: ");
        swi[0] = 0;

    }
}