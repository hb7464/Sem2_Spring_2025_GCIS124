import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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


public class interesting extends Application{

    // @Override
    // public void start(Stage stage) throws Exception{

    //     Label label1 = labelFactory("label 1", Color.WHITE, Color.BLACK, Color.AQUA);
    //     Label label2 = labelFactory("label 2", Color.WHITE, Color.GREEN, Color.AQUA);
    //     Label label3 = labelFactory("label 3", Color.WHITE, Color.GRAY, Color.AQUA);
    //     Label label4 = labelFactory("label 4", Color.WHITE, Color.RED, Color.AQUA);
    //     Label label5 = labelFactory("label 5", Color.WHITE, Color.PURPLE, Color.AQUA);
    //     Label label6 = labelFactory("label 6", Color.WHITE, Color.PINK, Color.AQUA);

    //     GridPane gp = new GridPane();
    //     Label[] arr = {label1,label2,label3,label4,label5,label6};

    //     String[] arr1 = {"label 1","label 2","label 3","label 4","label 5","label 6"};
    //     Color[][] arr2 = {{Color.WHITE, Color.BLACK, Color.AQUA},{Color.WHITE, Color.GREEN, Color.AQUA},
    //                     {Color.WHITE, Color.GRAY, Color.AQUA},{Color.WHITE, Color.RED, Color.AQUA},
    //                     {Color.WHITE, Color.PURPLE, Color.AQUA},{Color.WHITE, Color.PINK, Color.AQUA}};

    //     for(int i = 0; i < 3; i++){
    //         for (int j = 0; j < 2;j++){
    //             gp.add(labelFactory(arr1[i+j],arr2[i+j][0],arr2[i+j][1],arr2[i+j][2]),i,j);
    //         }
    //     }


    //     Scene scene = new Scene(gp);
    //     stage.setScene(scene);
    //     stage.setTitle("New Window");
    //     stage.show();
    // }

    @Override
    public void start(Stage stage) throws Exception{
        
        GridPane gp = new GridPane();

        Label label1 = labelFactory("123.456", Color.BLACK, Color.WHITE, Color.BLACK);
        Label label20 = labelFactory("AC", Color.BLACK, Color.GREY, Color.BLACK);
        Label label21 = labelFactory("%", Color.BLACK, Color.GREY, Color.BLACK);
        Label label22 = labelFactory("/", Color.BLACK, Color.GREY, Color.BLACK);
        Label label30 = labelFactory("7", Color.BLACK, Color.GREY, Color.BLACK);
        Label label31 = labelFactory("8", Color.BLACK, Color.GREY, Color.BLACK);
        Label label32 = labelFactory("9", Color.BLACK, Color.GREY, Color.BLACK);
        Label label33 = labelFactory("X", Color.BLACK, Color.GREY, Color.BLACK);
        Label label40 = labelFactory("4", Color.BLACK, Color.GREY, Color.BLACK);
        Label label41 = labelFactory("5", Color.BLACK, Color.GREY, Color.BLACK);
        Label label42 = labelFactory("6", Color.BLACK, Color.GREY, Color.BLACK);
        Label label43 = labelFactory("-", Color.BLACK, Color.GREY, Color.BLACK);
        Label label50 = labelFactory("1", Color.BLACK, Color.GREY, Color.BLACK);
        Label label51 = labelFactory("2", Color.BLACK, Color.GREY, Color.BLACK);
        Label label52 = labelFactory("3", Color.BLACK, Color.GREY, Color.BLACK);
        Label label53 = labelFactory("+", Color.BLACK, Color.GREY, Color.BLACK);
        Label label60 = labelFactory("0", Color.BLACK, Color.GREY, Color.BLACK);
        Label label61 = labelFactory(".", Color.BLACK, Color.GREY, Color.BLACK);
        Label label62 = labelFactory("=", Color.BLACK, Color.GREY, Color.BLACK);
        
        Scene scene = new Scene(gp);
        gp.add(label1,0,0,4,1);
        gp.add(label20,0,1,2,1);
        gp.add(label21,2,1);
        gp.add(label22,3,1);
        gp.add(label30,0,2);
        gp.add(label31,1,2);
        gp.add(label32,2,2);
        gp.add(label33,3,2);
        gp.add(label40,0,3);
        gp.add(label41,1,3);
        gp.add(label42,2,3);
        gp.add(label43,3,3);
        gp.add(label50,0,4);
        gp.add(label51,1,4);
        gp.add(label52,2,4);
        gp.add(label53,3,4);
        gp.add(label60,0,5,2,1);
        gp.add(label61,2,5);
        gp.add(label62,3,5);

        Button press = new Button("Click");
        press.setFont(new Font("Arial",32));
        press.setMaxWidth(Double.MAX_VALUE);
        TextField tf = new TextField("Enter name");
        
        press.setOnAction(new PrintOnPress(label21,tf));
        stage.setScene(scene);
        stage.setTitle("New Window");
        stage.show();
        gp.add(press,0,7,4,1);
        gp.add(tf,0,6,4,1);        
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