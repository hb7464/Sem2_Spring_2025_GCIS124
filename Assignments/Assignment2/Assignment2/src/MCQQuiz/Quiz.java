package MCQQuiz;
import java.util.Scanner;

public class Quiz {

    private double userScore;
    private double totalScore;

    public String getScore(){return this.userScore+"/"+this.totalScore;}

    public void startQuiz(){

        QuizQuestions quizTime = new QuizQuestions();
        try{
            String filename = "src\\MCQQuiz\\questionsBase.txt";
            quizTime.load(filename);
            
            Scanner inp = new Scanner(System.in);
            boolean notValidNoOfQuestions = true;
            int numOfQuestions = 0;
            
            while (notValidNoOfQuestions){
                
                System.out.print("Enter the number of questions you want(1-10): ");
                numOfQuestions = inp.nextInt();
                inp.nextLine();
                System.out.println();
                if (numOfQuestions <= 0){
                    System.out.println("This is code made for a quiz???\nWhy do you not want to answer questions?"
                    +"\nAre you hiding something?\n");
                }
                else if (numOfQuestions > 10){
                    System.out.println("WOAH!\nSlow down there, we don't have that many questions.\n");
                }
                
                else{notValidNoOfQuestions = false;}
            }
            
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
        catch (Exception e){
            System.out.println("The following Exception has occured: "+e);
        }


    }

}
