package MCQQuiz;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * A class designed to load questions from a file
 * and then select a inputed number of random questions 
 * from the loaded questions
 */

public class QuizQuestions {

    ArrayList<Question> allQuestions = new ArrayList<>(); //The array list of all questions from the file
    public ArrayList<Question> selectedQuestions = new ArrayList<>(); //The array list of questions designated for the user to answer


    /**
     * Loads questions from the specified file.
     * @param filename The filepath of the file with the questions
     */

    public void load(String filename){ //The function that loads all questions, answers and correct answers from the desired file
        
        FileReader reader;

        //Using try with resources to ensure the file exists
        try {
            reader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(reader);
            
            while ((bufferedReader.readLine() != null)){
            
                String question = bufferedReader.readLine();
                String possibleAnswers = bufferedReader.readLine();
                
                // Counting number of answers by counting the number of commas
                int c = 1;
                for (int i = 0; i< possibleAnswers.length(); i++){
                    
                    if (possibleAnswers.charAt(i) == ','){
                        c++;
                    }
                }
                //Splitting the possible answers into an array using "," as a delimiter
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

                //Checking the array length to see if it is a True/False type or a MCQ type
                if (tempArr.length == 2){
                    TFQQuestion questionData = new TFQQuestion(question, correctAnswer);
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
            e.printStackTrace();
        }    
    }

    /**
     * @param numOfQuestions The number of questions the user wants to select
     */

    public void select(int numOfQuestions){
        
        if (allQuestions.size() == 0) { //Checking if any questions have been loaded
            System.out.println("No questions loaded!");
            return;
        }

        for (int i = 0; i<numOfQuestions;){
            boolean is_repeated = false;
            int ind = (int) (Math.random()*allQuestions.size());

            for (Question j : selectedQuestions){ //Checking to make sure no duplicates are loaded
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

