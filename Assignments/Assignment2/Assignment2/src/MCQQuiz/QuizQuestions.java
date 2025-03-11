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
                String possibleAnswers = bufferedReader.readLine();
                
                // Counting number of answers
                int c = 1;
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
                    if (possibleAnswers.charAt(i) == ','){
                        tempArr[k] = tempStr;
                        k++;
                        tempStr = "";             
                    }
                    else{
                        tempStr += possibleAnswers.charAt(i);
                    }
                }
                tempArr[k] = tempStr;

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
        
        if (allQuestions.size() == 0) {
            System.out.println("No questions loaded!");
            return;
        }

        for (int i = 0; i<numOfQuestions;){
            boolean is_repeated = false;
            int ind = (int) (Math.random()*allQuestions.size());
            for (Question j : selectedQuestions){
                if (j == allQuestions.get(ind)){
                    is_repeated = true;
                    break;
                }
            }
            if (is_repeated){
                continue;
            }
            i++;
            selectedQuestions.add(allQuestions.get(ind));
        }

    }
}

