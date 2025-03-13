package MCQQuiz;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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

public class QuizFunctions {

    public void quickFormat(Label item, Color bgColor){
        item.setMaxWidth(Double.MAX_VALUE);
        item.setMaxHeight(Double.MAX_VALUE);
        item.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,new CornerRadii(0), BorderStroke.DEFAULT_WIDTHS)));
        item.setBackground(new Background(new BackgroundFill(bgColor, CornerRadii.EMPTY, Insets.EMPTY)));
        item.setPadding(new Insets(15));
        item.setAlignment(Pos.CENTER);
    }
    public void quickFormat(Button item, Color bgColor){
        item.setMaxWidth(Double.MAX_VALUE);
        item.setMaxHeight(Double.MAX_VALUE);
        item.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,new CornerRadii(0), BorderStroke.DEFAULT_WIDTHS)));
        item.setBackground(new Background(new BackgroundFill(bgColor, CornerRadii.EMPTY, Insets.EMPTY)));
        item.setPadding(new Insets(15));
        item.setAlignment(Pos.CENTER);
    }
    public void quickFormat(TextField item, Color bgColor){
        item.setMaxWidth(Double.MAX_VALUE);
        item.setMaxHeight(Double.MAX_VALUE);
        item.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,new CornerRadii(0), BorderStroke.DEFAULT_WIDTHS)));
        item.setBackground(new Background(new BackgroundFill(bgColor, CornerRadii.EMPTY, Insets.EMPTY)));
        item.setPadding(new Insets(15));
        item.setAlignment(Pos.CENTER);
    }

    public void loadQuestion(Label username, int currIndex, QuizQuestions quizTime, Label q1, 
    Button[] answers, int currscore, int numOfQuestions, Button contButton, 
    GridPane gp, Label scorecard, Label hiddenscore){
        try{
            if (currIndex >= quizTime.selectedQuestions.size()){
                Label congratsMessage = new Label("Congrats "+username.getText()+" on finishing the quiz \n You have scored: "
                                                    +hiddenscore.getText()+"/"+numOfQuestions);
                quickFormat(congratsMessage,Color.ORANGERED);
                
                contButton.setText("Click here to see the leaderboard");
                quickFormat(contButton, Color.ALICEBLUE);
                
                gp.add(congratsMessage, 0, 1, 3,1);
                String leaderboard = updateLeaderboard("src\\MCQQuiz\\leadboard.txt", username.getText(), hiddenscore.getText());
                contButton.setOnAction(new FinalPhase(gp, numOfQuestions, hiddenscore, leaderboard));

                gp.getChildren().remove(q1);
                for (Button a: answers){
                    gp.getChildren().remove(a);
                }     

                return;
            }
            
            ArrayList<Question> q = quizTime.selectedQuestions;
            q1.setText(q.get(currIndex).getQuestion());
            quickFormat(q1, Color.LIGHTGREY);
            gp.add(q1, 0, 1, 3,1);
            
            int option = 0;

            for (Button a: answers){
                
                
                if (q.get(currIndex).getAllAnswers().length == 2 && option == 2){break;}

                String ans = q.get(currIndex).getAllAnswers()[option];
                a.setText(ans);
                gp.add(a,0,option+2, 3,1);
                quickFormat(a, Color.BLANCHEDALMOND);

                if (ans.equals(q.get(currIndex).getCorrectAnswer())){a.setOnAction(new PressCorrect(a, scorecard, currscore, numOfQuestions, contButton, hiddenscore));}

                else{a.setOnAction(new PressWrong(a, contButton));}            
                option++;
            }
            contButton.setOnAction(new PressContinue(username, contButton, gp, q1, answers, quizTime, currIndex, currscore, numOfQuestions, scorecard, hiddenscore));
        }catch (Exception e){
            System.out.println("The following error has occured: "+e);
        }   
    }

    public String updateLeaderboard(String filename, String username, String score){
        ArrayList<ArrayList<String>> leaderboard = new ArrayList<>();
        String board = "";
        
        ArrayList<String> temp = new ArrayList<>();
        temp.add(username);
        temp.add(score);
        leaderboard.add(temp);
        
        try{
            
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
            while ((bufferedReader.readLine() != null)){

                String entry = bufferedReader.readLine();

                String tempStr = "";
                ArrayList<String> tempArr = new ArrayList<>();

                for (int i = 0; i< entry.length(); i++){
                    if (entry.charAt(i) == ','){
                        tempArr.add(tempStr);
                        tempStr = "";             
                    }
                    else{
                        tempStr += entry.charAt(i);
                    }
                }
                tempArr.add(tempStr);
                leaderboard.add(tempArr);
            }
            leaderboard.sort((arraylist1, arraylist2) -> compare(arraylist1, arraylist2));
            bufferedReader.close();
            
            
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename));
            
            for (ArrayList<String> entry : leaderboard) {
                bufferedWriter.newLine();
                bufferedWriter.write(entry.get(0)+","+entry.get(1)+"\n");
                board += "["+(leaderboard.indexOf(entry)+1)+"] "+entry.get(0)+" : "+entry.get(1)+"\n";
            }
            bufferedWriter.close();
            
            
        }catch (Exception e) {
            System.out.println("The following error has occured: "+e);
            e.printStackTrace();
        }
        return board;
    }

    public int compare(ArrayList<String> list1, ArrayList<String> list2) {

        int num1 = Integer.parseInt(list1.get(1));
        int num2 = Integer.parseInt(list2.get(1)); 
        return num2-num1;
    }

}
