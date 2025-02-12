import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.Button;


public class PressNum implements EventHandler<ActionEvent> {

    private Label labelTop1;
    private Label labelTop2;
    private Button labelNo;

    public PressNum(Label labelTop1,Label labelTop2, Button labelNo){
        this.labelTop1 = labelTop1;
        this.labelTop2 = labelTop2;
        this.labelNo = labelNo;
    }

    public void handle(ActionEvent event){
        String num = labelNo.getText();
        if (labelTop1.getText().equals(" "))
            labelTop1.setText(num);
        else
            labelTop2.setText(num);

    }
}