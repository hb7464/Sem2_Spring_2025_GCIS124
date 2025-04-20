package Assignment4.src.MCQQuiz;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;


public class testJUnit {

    @Test
    public void testMCQ() {

        String[] answers = {"A", "B", "C", "D"};
        MCQQuestion mcq = new MCQQuestion("Random question", answers, "B");
        
        assertTrue("Correct answer", mcq.isCorrectAnswer("B"));
        
        assertFalse("Incorrect answer", mcq.isCorrectAnswer("A"));
        
    }

    @Test
    public void testTFQ() {

        TFQQuestion tfq = new TFQQuestion("Testing True/False question", "True");
        
        assertTrue("Correct answer", tfq.isCorrectAnswer("True"));
        
        assertFalse("Incorrect answer", tfq.isCorrectAnswer("False"));
        
    }


    @Test
    public void testLeaderboardSorting() {
        QuizFunctions functions = new QuizFunctions();
        
        ArrayList<String> highScore = new ArrayList<>();
        highScore.add("P1");
        highScore.add("5");
        highScore.add("2:30");
        
        ArrayList<String> lowScore = new ArrayList<>();
        lowScore.add("P2");
        lowScore.add("3");
        lowScore.add("3:00");
        
        int result = functions.compare(highScore, lowScore);
        assertTrue("Higher score", result < 0);
        
        result = functions.compare(lowScore, highScore);
        assertTrue("Lower score", result > 0);
    }
    @Test
    public void testMCQEdgeCases() {
        String[] answers1 = {"", "B", "C", "D"};
        MCQQuestion mcq1 = new MCQQuestion("Empty correct answer", answers1, "");
        assertTrue("Should accept empty correct answer", mcq1.isCorrectAnswer(""));
        assertFalse("Non-empty should fail", mcq1.isCorrectAnswer("B"));

        String[] answers2 = {"Same", "Same", "Same", "Same"};
        MCQQuestion mcq2 = new MCQQuestion("All identical answers", answers2, "Same");
        assertTrue("Should accept identical answer", mcq2.isCorrectAnswer("Same"));

        String[] answers3 = {"A", "B", "C", null};
        MCQQuestion mcq3 = new MCQQuestion("Null in answers", answers3, "B");
        assertFalse("Null input should fail", mcq3.isCorrectAnswer(null));
        assertTrue("Valid answer should pass", mcq3.isCorrectAnswer("B"));

        String[] answers4 = {"Python", "Java", "C++", "JavaScript"};
        MCQQuestion mcq4 = new MCQQuestion("Case sensitive", answers4, "Java");
        assertFalse("Different case should fail", mcq4.isCorrectAnswer("java"));
        assertTrue("Exact case should pass", mcq4.isCorrectAnswer("Java"));

        String[] answers5 = {"True", "False", "Maybe?", "Don't know"};
        MCQQuestion mcq5 = new MCQQuestion("Special chars", answers5, "Maybe?");
        assertTrue("Special chars should work", mcq5.isCorrectAnswer("Maybe?"));
        assertFalse("Incorrect special chars should fail", mcq5.isCorrectAnswer("Don't know"));
    }

    @Test
    public void testQuestionLoading() {
        QuizQuestions quiz = new QuizQuestions();
        quiz.load("Assignment3\\Assignment3\\src\\MCQQuiz\\leadboard.txt");
        
        assertFalse("Questions should be loaded", quiz.allQuestions.isEmpty());
    }
}