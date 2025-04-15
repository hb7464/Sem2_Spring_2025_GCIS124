package MCQQuiz;

/**
 * The main file for the command line interface version of the quiz
 */

public class CLIMain {
    
    /**
     * @param args the arguments for when we call main
     * In this file, we are just initiating an instance of the Quiz
     * and then starting it
     */
    public static void main(String[] args) {
        Quiz quizTime = new Quiz();
        quizTime.startQuiz();
    }

}
