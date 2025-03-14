package MCQQuiz;

/**
 * This represents a class for multiple choice questions with possible answers and the correct answer
 * 
 * @param question
 * @param answers
 * @param correctAnswer 
 * 
 */

 public class MCQQuestion implements Question{
     
     // Declaring the private variables of the class
 
     private String question;
     private String[] answers;
     private String correctAnswer;
 
     // The constructor for the question, answers and correct answer
 
     public MCQQuestion(String question, String[] answers, String correctAnswer){
 
         this.question = question;
         this.answers = answers;
         this.correctAnswer = correctAnswer;
 
     }
 
     // To get the question
     public String getQuestion(){
         return question;
     }
     // To get the possible answers
     public String[] getAllAnswers(){
         return answers;
     }
     // To get the correct answer
     public String getCorrectAnswer(){
         return correctAnswer;
     }
 
     // To display the question with possible answers
     @Override
     public String toString(){
         return this.getQuestion()+"\n"+this.answers[0]+
         "\n"+this.answers[1]+"\n"+this.answers[2]+
         "\n"+this.answers[3]+"\nEnter your answer (Type it out the same as listed): ";
     }
 
     // To check if the user has entered the correct answer
     public boolean isCorrectAnswer(String userOption){
         return this.correctAnswer.equals(userOption);
     }
}
 