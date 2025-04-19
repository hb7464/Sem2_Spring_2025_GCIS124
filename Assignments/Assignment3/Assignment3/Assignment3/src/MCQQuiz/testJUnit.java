package MCQQuiz;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

public class testJUnit {

    @Test
    void testLeaderboardSorting() {
        // Create QuizFunctions object (assuming it's the class where updateLeaderboard is located)
        QuizFunctions func = new QuizFunctions();
        
        // Mock inputs
        String filename = "src\\MCQQuiz\\leadboard.txt";
        String username = "Alice";
        String score = "8";
        String timeTaken = "120";

        // The method will update the leaderboard in the text file and return a formatted leaderboard
        String result = func.updateLeaderboard(filename, username, score);

        // We now validate the leaderboard content (you'll have to manually inspect the leaderboard file or use assertions on the returned string)
        assertTrue(result.contains("Alice"), "Leaderboard should contain Alice");
        assertTrue(result.contains("8"), "Leaderboard should have score 8");
    }

    @Test
    public void timerTest() throws InterruptedException {
        // Assuming the timer is handled in a method within your code like "startTimer()"
        DummyQuiz quiz = new DummyQuiz();
        quiz.startTimer(1);  // Set a 1-second timer

        Thread.sleep(1500);  // Wait for 1.5 seconds (ensuring timer has expired)

        // After the timer expires, it should trigger the "isTimeUp" flag
        assertTrue(quiz.isTimeUp, "Timer should set isTimeUp to true when expired");
    }

    @Test
    void testCorrectAnswerScoring() {
        // Assuming your scoring logic is handled inside a method like "calculateScore()"
        QuizFunctions func = new QuizFunctions();
        
        String userAnswer = "A";
        String correctAnswer = "A";

        // This is a sample of how scoring would work:
        int score = func.calculateScore(userAnswer, correctAnswer);  // This method should return a score based on the answer
        assertEquals(1, score, "Correct answer should increase score");
    }

    @Test
    void testEmptyAnswer() {
        // Checking empty answers
        QuizFunctions func = new QuizFunctions();

        String userAnswer = "";
        String correctAnswer = "A";

        int score = func.calculateScore(userAnswer, correctAnswer);  
        assertEquals(0, score, "Empty answer should not increase score");
    }

    @Test
    void testIdenticalAnswersMultipleChoice() {
        // If your system handles multiple choices, we should verify that as well
        QuizFunctions func = new QuizFunctions();
        
        String[] options = {"A", "B", "A", "C"};
        long count = func.countIdenticalAnswers(options, "A");  // Assuming you have such a method
        
        assertEquals(2, count, "There should be 2 identical 'A' answers in the options");
    }

    @Test
    void testColorBlindToggle() {
        // Assuming the color toggling logic is contained within "pressColorBlind.toggleColorBlindMode()"
        GUIMain.textcol = GUIMain.DEFAULT_TEXT_COLOR;  // Set to default color
        pressColorBlind.toggleColorBlindMode();  // Toggle to colorblind mode

        assertEquals(GUIMain.CBTEXT_COLOR, GUIMain.textcol, "Text color should change to colorblind mode");

        pressColorBlind.toggleColorBlindMode();  // Toggle back to default
        assertEquals(GUIMain.DEFAULT_TEXT_COLOR, GUIMain.textcol, "Text color should revert to default mode");
    }


}

