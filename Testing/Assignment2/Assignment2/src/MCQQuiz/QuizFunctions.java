package MCQQuiz;

import java.io.BufferedReader;
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

/**A collection of all the methods repeatedly used within the GUI code */

public class QuizFunctions {

    /**
     * The 3 quickFormat methods are for different data types of object but work the same
     * It speeds up the process of formatting the objects on the scene
     * @param item the instance of the object
     * @param bgColor the desired color of the background for the object
     */

    public void quickFormat(Label item, Color bgColor){
        item.setMaxWidth(Double.MAX_VALUE);
        item.setMaxHeight(Double.MAX_VALUE);
        item.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,new CornerRadii(0), BorderStroke.DEFAULT_WIDTHS)));
        item.setBackground(new Background(new BackgroundFill(bgColor, CornerRadii.EMPTY, Insets.EMPTY)));
        item.setPadding(new Insets(15));
        item.setAlignment(Pos.CENTER);
        item.setTextFill(GUIMain.textcol);
    }
    public void quickFormat(Button item, Color bgColor){
        item.setMaxWidth(Double.MAX_VALUE);
        item.setMaxHeight(Double.MAX_VALUE);
        item.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,new CornerRadii(0), BorderStroke.DEFAULT_WIDTHS)));
        item.setBackground(new Background(new BackgroundFill(bgColor, CornerRadii.EMPTY, Insets.EMPTY)));
        item.setPadding(new Insets(15));
        item.setAlignment(Pos.CENTER);
        item.setTextFill(GUIMain.textcol);
    }
    public void quickFormat(TextField item, Color bgColor){
        item.setMaxWidth(Double.MAX_VALUE);
        item.setMaxHeight(Double.MAX_VALUE);
        item.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,new CornerRadii(0), BorderStroke.DEFAULT_WIDTHS)));
        item.setBackground(new Background(new BackgroundFill(bgColor, CornerRadii.EMPTY, Insets.EMPTY)));
        item.setPadding(new Insets(15));
        item.setAlignment(Pos.CENTER);
        if ((GUIMain.textcol).equals(GUIMain.CBTEXT_COLOR)){item.setStyle("-fx-text-fill: #f05039");}

    }

    /**
     * A method used to load the next instance of a 
     * question onto the scene for the user to answer
     * @param username The username the user entered at the start of the quiz
     * @param currIndex The question number the user is on
     * @param quizTime The instance of QuizQuestions
     * @param q1 The question label that was displayed
     * @param answers An array of the answer buttons
     * @param currscore The user's current score
     * @param numOfQuestions The total number of questions
     * @param contButton The continue button
     * @param gp the gridpane instance
     * @param scorecard The label displaying the score of the user
     * @param hiddenscore The label containing the user's score
     */

    public void loadQuestion(Label username, int currIndex, QuizQuestions quizTime, Label q1, 
    Button[] answers, int currscore, int numOfQuestions, Button contButton, 
    GridPane gp, Label scorecard, Label hiddenscore, Label timerLabel){
        try{
            if (currIndex >= quizTime.selectedQuestions.size()){
                
                loadEndCard(username, q1, answers, numOfQuestions, contButton, gp, hiddenscore, timerLabel);

                return;
            }
            
            ArrayList<Question> q = quizTime.selectedQuestions;
            q1.setText(q.get(currIndex).getQuestion());
            quickFormat(q1, GUIMain.backgroundcol2);
            gp.add(q1, 0, 1, 3,1);
            q1.setDisable(false);
            
            int option = 0;

            for (Button a: answers){
                
                
                if (q.get(currIndex).getAllAnswers().length == 2 && option == 2){break;}

                String ans = q.get(currIndex).getAllAnswers()[option];
                a.setText(ans);
                a.setDisable(false);
                gp.add(a,0,option+2, 3,1);
                quickFormat(a, GUIMain.backgroundcol1);

                if (ans.equals(q.get(currIndex).getCorrectAnswer())){a.setOnAction(new PressCorrect(a, scorecard, currscore, numOfQuestions, contButton, hiddenscore,answers));}

                else{a.setOnAction(new PressWrong(a, contButton, answers));}            
                option++;
            }
            contButton.setOnAction(new PressContinue(username, contButton, gp, q1, answers, quizTime, currIndex, currscore, numOfQuestions, scorecard, hiddenscore, timerLabel));
        }catch (Exception e){
            e.printStackTrace();
        }   
    }

    /**
     * A method to load the congratulations screen of the quiz 
     * when the user answers all questions or time runs out
     * @param username The username the user entered at the start of the quiz
     * @param q1 The question label that was displayed
     * @param answers An array of the answer buttons
     * @param numOfQuestions The total number of questions
     * @param contButton The continue button
     * @param gp The gridpane instance
     * @param hiddenscore The label containing the user's score
     */

    public void loadEndCard(Label username, Label q1, 
    Button[] answers, int numOfQuestions, Button contButton, 
    GridPane gp, Label hiddenscore, Label timerLabel){
        Label congratsMessage = new Label("Congrats "+username.getText()+" on finishing the quiz \n You have scored: "
                                                    +hiddenscore.getText()+"/"+numOfQuestions);
                quickFormat(congratsMessage,GUIMain.backgroundcol1);
                
                contButton.setText("Click here to see the leaderboard");
                quickFormat(contButton, GUIMain.backgroundcol2);
                
                gp.add(congratsMessage, 0, 1, 3,1);
                String[][] leaderboard = updateLeaderboard("Assignment2\\Assignment2\\src\\MCQQuiz\\leadboard.txt", username.getText(), hiddenscore.getText(), timerLabel.getText());
                contButton.setOnAction(new FinalPhase(gp, numOfQuestions, hiddenscore, leaderboard));

                gp.getChildren().remove(q1);
                for (Button a: answers){
                    gp.getChildren().remove(a);
                }

    }

    /**
     * A method to update the leaderboard text file whenever 
     * someone finishes the quiz and the ranks as well as 
     * returning a string that can be used to display the 
     * leaderboard to a user who has just finished the quiz     
     * 
     * @param filename the filepath for the leaderboard
     * @param username The username the user entered at the start of the quiz
     * @param score The user's final score
     * @return //It returns a string to be displayed in a label
     */

    public String[][] updateLeaderboard(String filename, String username, String score, String timetaken){
        ArrayList<ArrayList<String>> leaderboard = new ArrayList<>();
        
        ArrayList<String> temp = new ArrayList<>();
        temp.add(username);
        temp.add(score);
        temp.add(timetaken);
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
            
            
            FileWriter bufferedWriter = new FileWriter(filename);
            int rank = 1;
            String[][] board = new String[leaderboard.size()][4];
            for (ArrayList<String> entry : leaderboard) {
                bufferedWriter.write("\n"+entry.get(0)+","+entry.get(1)+","+entry.get(2)+"\n");
                board[rank-1][0] = "["+rank+"]";
                for  (int i = 0; i < 3; i++){
                    board[rank-1][i+1] = entry.get(i);
                }
                rank++;
            }
            bufferedWriter.flush();
            bufferedWriter.close();
            return board;
            
        }catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }


    /**
     * A comparator used sort through the entries on the leaderboard
     * and make the sure the highest rank has the highest score
     * @param list1 The first entry
     * @param list2 The second entry
     * @return //returns the arraylist
     */
    
    public int compare(ArrayList<String> list1, ArrayList<String> list2) {
        int num1 = Integer.parseInt(list1.get(1));
        int num2 = Integer.parseInt(list2.get(1)); 
        return num2-num1;
    }

    // public class countdownTimer extends Thread{

    //     private String currtime;
    //     private final Integer numOfQuestions;
    //     private int remainingtime;
    //     private Label timerLabel;

    //     public countdownTimer(Integer numOfQuestions, Label timerLabel){
    //         this.numOfQuestions = numOfQuestions;
    //         this.timerLabel = timerLabel;
    //     }
    
    //     @Override
    //     public void run(){
    //         try {
    //         for (int i = numOfQuestions*60 ; i > 0 ; i-- ){
    //             remainingtime--;
    //             Thread.sleep(1000);
    //             currtime = (remainingtime/60)+":"+(remainingtime%60);
    //             timerLabel.setText(currtime);
    //             }
    //         }catch (Exception e) {
    //         e.printStackTrace();
    //         }
    //     }
    
    // }

}
