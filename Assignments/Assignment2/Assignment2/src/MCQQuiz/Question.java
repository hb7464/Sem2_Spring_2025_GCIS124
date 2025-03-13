package MCQQuiz;

public interface Question {
    
    public String getQuestion();
    public String[] getAllAnswers();
    public String getCorrectAnswer();
    public boolean isCorrectAnswer(String userOption);

}
