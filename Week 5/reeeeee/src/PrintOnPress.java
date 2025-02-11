import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PrintOnPress implements EventHandler<ActionEvent> {

    private Label label;
    private TextField textField;

    public PrintOnPress(Label label, TextField textField){
        this.label = label;
        this.textField = textField;
    }

    public void handle(ActionEvent event){
        String text = textField.getText();
        label.setText(text);
    }
}