package MCQQuiz;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class QuizQuestions {

    private ArrayList<Question> allQuestions = new ArrayList<>();
    public ArrayList<Question> selectedQuestions = new ArrayList<>();

    public void load(String filename){
        
        FileReader reader;
        try {
            reader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(reader);
            
            while ((bufferedReader.readLine() != null)){
            
                String question = bufferedReader.readLine();
                // System.out.println(question); //Debugging
                String possibleAnswers = bufferedReader.readLine();
                // System.out.println(possibleAnswers); //Debugging
                
                // Counting number of answers
                int c = 0;
                for (int i = 0; i< possibleAnswers.length(); i++){
                    
                    if (possibleAnswers.charAt(i) == ','){
                        c++;
                    }
                }
                //Splitting the possible answers into an array
                String tempStr = "";
                String[] tempArr = new String[c];
                int k = 0;
                for (int i = 0; i< possibleAnswers.length(); i++){
                    // System.out.println(tempStr); //debugging 
                    if (possibleAnswers.charAt(i) == ','){
                        tempArr[k] = tempStr;
                        k++;
                        tempStr = "";             
                    }
                    else{
                        tempStr += possibleAnswers.charAt(i);
                    }
                }

                String correctAnswer = bufferedReader.readLine();
                if (tempArr.length == 2){
                    TFQQuestion questionData = new TFQQuestion(question, tempArr, correctAnswer);
                    allQuestions.add(questionData);
                }
                else{
                    MCQQuestion questionData = new MCQQuestion(question, tempArr, correctAnswer);
                    allQuestions.add(questionData);
                }
            }

            bufferedReader.close();
        } 
        catch (Exception e) {
            System.out.println("The following error has occured: "+e);
        }    
    }
    public void select(int numOfQuestions){
        for (int i = 0; i<numOfQuestions; i++){
            selectedQuestions.add(allQuestions.get((int) (Math.random()*allQuestions.size())));
        }
    }

}
