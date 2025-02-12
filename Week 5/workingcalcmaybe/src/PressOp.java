import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.Button;


public class PressOp implements EventHandler<ActionEvent> {

    private Label labelTop;
    private Button labelOp;

    public PressOp(Label labelTop, Button labelOp){
        this.labelTop = labelTop;
        this.labelOp = labelOp;
    }

    public void handle(ActionEvent event){
        String Op = labelOp.getText();
        labelTop.setText(Op);
    }
}