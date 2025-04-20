package MCQQuiz;

/**
 * The interface we use to define structure of a quiz question.
 * TFQQuestion and MCQQuestion implement this interface
 */

public interface Question {
    
    //Getter functions for the question, answers and correct answer
    public String getQuestion(); 
    public String[] getAllAnswers();
    public String getCorrectAnswer();

    /**
     * Checks if the provided answer is correct.
     * @param userOption The answer provided by the user
     */
    public boolean isCorrectAnswer(String userOption);

}
