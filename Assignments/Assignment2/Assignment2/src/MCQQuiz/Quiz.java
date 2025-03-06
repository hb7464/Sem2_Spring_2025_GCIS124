package MCQQuiz;
import java.util.Scanner;

public class Quiz {

    private double userScore;
    private double totalScore;

    public String getScore(){return this.userScore+"/"+this.totalScore;}

    public void startQuiz(){

        QuizQuestions quizTime = new QuizQuestions();
        String filename = "src\\MCQQuiz\\questionsBase.txt";
        quizTime.load(filename);
        
        Scanner inp = new Scanner(System.in);
        System.out.print("Enter the number of questions you want: ");
        int numOfQuestions = inp.nextInt();
        inp.nextLine();

        quizTime.select(numOfQuestions);

        for (Question q: quizTime.selectedQuestions){
            // System.out.println(q.getQuestion());        //debugging
            // System.out.println(q.getCorrectAnswer());//debugging
            // for (String ind: q.getAllAnswers()){
            //     System.out.println(ind);
            // }//debugging
            System.out.print(q);
            String ans = inp.nextLine();

            totalScore++;
            if (q.isCorrectAnswer(ans)){
                System.out.println("Good Job!");
                userScore++;
            }
            else{System.out.println("Unfortunate! The correct answer is "+q.getCorrectAnswer());}

        }
        inp.close();

        System.out.println("Quiz over, time to see how you did!");
        System.out.println("You got a score of: "+this.getScore());


    }

}
