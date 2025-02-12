import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PressSubtract implements EventHandler<ActionEvent> {

    private Label label;
    private TextField textField1;
    private TextField textField2;

    public PressSubtract(Label label, TextField textField1,TextField textField2){
        this.label = label;
        this.textField1 = textField1;
        this.textField2 = textField2;
    }

    public void handle(ActionEvent event){
        Double text1 = Double.valueOf(textField1.getText());
        Double text2 = Double.valueOf(textField2.getText());
        label.setText("Result: "+(text1-text2));
    }
}