/**
 * This represents a class for multiple choice questions with possible answers and the correct answer
 * 
 * @param question
 * @param answers
 * @param correctAnswer 
 * 
 */

import java.util.Scanner; //To take user input for the answer

public class MCQQuestion {
    
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
        return this.question;
    }
    // To get the possible answers
    public String[] getAnswers(){
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
        "\n2."+this.answers[1]+"\n3."+this.answers[2]+
        "\n4."+this.answers[3]+"\nEnter your answer (1-4): ";
    }

    // To check if two MCQQuestion object instances are equal
    public boolean equals(MCQQuestion Q2){
        if (Q2 instanceof MCQQuestion){
            return this.question.equals(Q2.getQuestion()) 
            && this.correctAnswer.equals(Q2.getCorrectAnswer()) 
            && this.answers == Q2.getAnswers();
        }
        return false;
    }

    // To check if the user has entered the correct answer
    public boolean isCorrectAnswer(String UserOption){
        return this.correctAnswer.equals(UserOption);
    }

    // The main class in which we create an MCQQuestion object
    public static void main(String[] args) {

        // Initializing the variables for an object
      
        String question = "What is GCIS124?";
        String[] answers = {
            "Snake",
            "Global Climate Impact Studies",
            "I don't know",
            "Cake"
        };

        String correctAnswer = "2";

        MCQQuestion Quiz = new MCQQuestion(question, answers, correctAnswer); //Creating the object instance

        Scanner input = new Scanner(System.in); //Intializing the scanner
        System.out.print(Quiz); //Displaying the question and possible answers

        String userAnswer = input.nextLine(); //Taking the user's answer

        //Checking the user's answer is correct
        if (Quiz.isCorrectAnswer(userAnswer)) {
            System.out.println("Correct!");
        } else {
            System.out.println("Incorrect. The correct answer is 2. Global Climate Impact Studies");
        }

        input.close(); //To close the scanner
    }
}

