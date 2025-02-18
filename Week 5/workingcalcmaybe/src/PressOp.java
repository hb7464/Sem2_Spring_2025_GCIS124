import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.Button;


public class PressOp implements EventHandler<ActionEvent> {

    private Label labelTop;
    private Button labelOp;
    private int[] swi;

    public PressOp(Label labelTop, Button labelOp, int[] swi){
        this.labelTop = labelTop;
        this.labelOp = labelOp;
        this.swi = swi;
    }

    public void handle(ActionEvent event){
        String Op = labelOp.getText();
        labelTop.setText(Op);

        if (swi[0] == 0){
            swi[0] = 1;
            System.out.println("switch to 1");}
        else if (swi[0] == 1){
            swi[0] = 0;
            System.out.println("switch to 0");}
    }
}