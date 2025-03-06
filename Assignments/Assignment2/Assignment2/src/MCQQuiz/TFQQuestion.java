package MCQQuiz;

public class TFQQuestion implements Question{
// Declaring the private variables of the class
 
     private String question;
     private String[] answers;
     private String correctAnswer;
 
     // The constructor for the question, answers and correct answer
 
     public TFQQuestion(String question, String[] answers, String correctAnswer){
 
         this.question = question;
         this.answers = answers;
         this.correctAnswer = correctAnswer;
 
     }
 
     // To get the question
     public String getQuestion(){
         return this.question;
     }
     // To get the possible answers
     public String[] getAllAnswers(){
         return this.answers;
     }
     // To get the correct answer
     public String getCorrectAnswer(){
         return this.correctAnswer;
     }
 
     // To change the question
     public void setQuestion(String Newquestion){
         this.question = Newquestion;
     }
     
     // To change the possible answers
     public void setAnswers(String[] Newanswers){
         this.answers = Newanswers;
     }
     
     // To change the correct answer
     public void setCorrectAnswer(String NewcorrectAnswer){
         this.correctAnswer = NewcorrectAnswer;
     }
 
     // To display the question with possible answers
     @Override
     public String toString(){
         return this.getQuestion()+"\n1."+this.answers[0]+
         "\n2."+this.answers[1]+"\nEnter your answer (True or False): ";
     }
 
     // To check if two MCQQuestion object instances are equal
     public boolean equals(MCQQuestion Q2){
         if (Q2 instanceof MCQQuestion){
             return this.question.equals(Q2.getQuestion()) 
             && this.correctAnswer.equals(Q2.getCorrectAnswer()) 
             && this.answers == Q2.getAllAnswers();
         }
         return false;
     }
 
     // To check if the user has entered the correct answer
     public boolean isCorrectAnswer(String UserOption){
         return this.correctAnswer.equals(UserOption);
     }
}