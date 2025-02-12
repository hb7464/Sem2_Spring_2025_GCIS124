import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;


public class PressEqual implements EventHandler<ActionEvent> {

    private Label labelTop1;
    private Label labelTop2;
    private Label labelTop3;
    private Label ResultLabel;

    public PressEqual(Label labelTop1,Label labelTop2, Label labelTop3, Label ResultLabel){
        this.labelTop1 = labelTop1;
        this.labelTop2 = labelTop2;
        this.labelTop3 = labelTop3;
        this.ResultLabel = ResultLabel;
    }

    public void handle(ActionEvent event){
        String Op = labelTop2.getText();
        Double num1 = Double.valueOf(labelTop1.getText());
        Double num2 = Double.valueOf(labelTop3.getText());

        if (Op.equals("+"))
            ResultLabel.setText("Result: "+(num1+num2));
        else if (Op.equals("-"))
            ResultLabel.setText("Result: "+(num1-num2));
        else if (Op.equals("X"))
            ResultLabel.setText("Result: "+(num1*num2));
        else if (Op.equals("/"))
            ResultLabel.setText("Result: "+(num1/num2));
        else if (Op.equals("%"))
            ResultLabel.setText("Result: "+((num1/100) *num2));

    }
}