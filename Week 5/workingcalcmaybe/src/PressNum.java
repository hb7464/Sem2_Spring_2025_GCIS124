import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.Button;


public class PressNum implements EventHandler<ActionEvent> {

    private Label labelTop1;
    private Label labelTop2;
    private Button labelNo;
    private int[] swit;

    public PressNum(Label labelTop1,Label labelTop2, Button labelNo, int[] swit){
        this.labelTop1 = labelTop1;
        this.labelTop2 = labelTop2;
        this.labelNo = labelNo;
        this.swit = swit;
    }

    public void handle(ActionEvent event){
        String num = labelNo.getText();
        if (swit[0] == 0)
            labelTop1.setText(labelTop1.getText()+num);
        else if (swit[0] == 1)
            labelTop2.setText(labelTop2.getText()+num);

    }
}