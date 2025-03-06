package MCQQuiz;

public interface Question {
    
    String getQuestion();
    String[] getAllAnswers();
    String getCorrectAnswer();
    boolean isCorrectAnswer(String userOption);

}
