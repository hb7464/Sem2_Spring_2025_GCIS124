package MCQQuiz;

public interface Question {
    
    //Getter functions for the question, answers and correct answer
    public String getQuestion(); 
    public String[] getAllAnswers();
    public String getCorrectAnswer();

    //A method to check if the answer is correct
    public boolean isCorrectAnswer(String userOption);

}
