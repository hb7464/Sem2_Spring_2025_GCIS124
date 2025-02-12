import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
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
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class interestingworking extends Application{

    @Override
    public void start(Stage stage) throws Exception{
        
        GridPane gp = new GridPane();

        Label label1 = labelFactory("Result: ", Color.BLACK, Color.WHITE, Color.BLACK);
        Label label12 = labelFactory(" ", Color.BLACK, Color.LIGHTGREY, Color.BLACK);
        Label label13 = labelFactory("OP", Color.BLACK, Color.LIGHTGREY, Color.BLACK);
        Label label14 = labelFactory(" ", Color.BLACK, Color.LIGHTGREY, Color.BLACK);
        

        Button AC = new Button("AC");
        Button Modu = new Button("%");
        Button Divi = new Button("/");
        Button seven = new Button("7");
        Button eight = new Button("8");
        Button nine = new Button("9");
        Button multi = new Button("X");
        Button four = new Button("4");
        Button five = new Button("5");
        Button six = new Button("6");
        Button subt = new Button("-");
        Button one = new Button("1");
        Button two = new Button("2");
        Button three = new Button("3");
        Button add = new Button("+");
        Button zero = new Button("0");
        Button equa = new Button("=");
        
        Button[] arr = {AC, Modu, Divi,
            seven, eight, nine, multi,
            four, five, six, subt,
            one, two, three, add,
            zero, equa};
        for (Button i : arr){   
            i.setFont(new Font("Arial",32));
            i.setMaxWidth(Double.MAX_VALUE);
            i.setMaxHeight(Double.MAX_VALUE);
        }
        
        Scene scene = new Scene(gp);
        gp.add(label1,0,0,4,1);
        gp.add(label12,0,1);
        gp.add(label13,1,1,2,1);
        gp.add(label14,3,1);
        gp.add(AC,0,2,2,1);
        gp.add(Modu,2,2);
        gp.add(Divi,3,2);
        gp.add(seven,0,3);
        gp.add(eight,1,3);
        gp.add(nine,2,3);
        gp.add(multi,3,3);
        gp.add(four,0,4);
        gp.add(five,1,4);
        gp.add(six,2,4);
        gp.add(subt,3,4);
        gp.add(one,0,5);
        gp.add(two,1,5);
        gp.add(three,2,5);
        gp.add(add,3,5);
        gp.add(zero,0,6,2,1);
        gp.add(equa,2,6,2,1);

        one.setOnAction(new PressNum(label12, label14, one));
        two.setOnAction(new PressNum(label12, label14, two));
        three.setOnAction(new PressNum(label12, label14, three));
        four.setOnAction(new PressNum(label12, label14, four));
        five.setOnAction(new PressNum(label12, label14, five));
        six.setOnAction(new PressNum(label12, label14, six));
        seven.setOnAction(new PressNum(label12, label14, seven));
        eight.setOnAction(new PressNum(label12, label14, eight));
        nine.setOnAction(new PressNum(label12, label14, nine));

        Modu.setOnAction(new PressOp(label13, Modu));
        Divi.setOnAction(new PressOp(label13, Divi));
        multi.setOnAction(new PressOp(label13, multi));
        subt.setOnAction(new PressOp(label13, subt));
        add.setOnAction(new PressOp(label13, add));

        equa.setOnAction(new PressEqual(label12, label13, label14, label1));
        AC.setOnAction(new PressClear(label12, label13,label14,label1));
    
        stage.setScene(scene);
        stage.setTitle("Calculator");
        stage.show();

      
    }

    public Label labelFactory(String text, Color color, Color BgColor, Color BorderColor){
        Label label = new Label(text);
        label.setFont((new Font("Arial",32)));
        label.setTextFill(color);

        label.setBackground(new Background
        (new BackgroundFill(BgColor, CornerRadii.EMPTY, Insets.EMPTY)));

        label.setMaxWidth(Double.MAX_VALUE);
        label.setPadding(new Insets(15));

        label.setBorder(new Border
        (new BorderStroke(BorderColor, BorderStrokeStyle.SOLID, 
        new CornerRadii(0), BorderStroke.DEFAULT_WIDTHS)));
        
        label.setAlignment(Pos.CENTER);

        return label;
    }

    public static void main(String[] args) {
        
        launch(args);

    }
}

//create a new gui where you only have 2 text fields and one button and one label, 
//num1 and num2 and then a button which is +
//you can use vbox