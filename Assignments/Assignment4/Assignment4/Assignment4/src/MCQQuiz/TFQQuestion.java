package Assignment4.src.MCQQuiz;

/**
 * This represents a class for multiple choice questions with possible answers and the correct answer 
 */

public class TFQQuestion implements Question{
// Declaring the private variables of the class
 
     private String question;
     private String correctAnswer;

    /**
     *  The constructor for the question and correct answer
     * @param question The question
     * @param correctAnswer The correct answer
     */
    
     public TFQQuestion(String question, String correctAnswer){

         
         this.question = question;
         this.correctAnswer = correctAnswer;
         
        }
        
     // To get the question
     public String getQuestion(){
         return this.question;
     }
     // To get the possible answers
     public String[] getAllAnswers(){
         return new String[]{"True", "False"};
     }
     // To get the correct answer
     public String getCorrectAnswer(){
         return this.correctAnswer;
     }

     // To display the question with possible answers
     @Override
     public String toString(){
         return this.getQuestion()+"\nTrue"+
         "\nFalse"+"\nEnter your answer (True or False): ";
     }
 
     // To check if the user has entered the correct answer
     public boolean isCorrectAnswer(String UserOption){
         return this.correctAnswer.equals(UserOption);
     }
}