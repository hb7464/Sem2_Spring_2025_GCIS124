package MCQQuiz;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class leaderboardThread implements Runnable{

    private Socket quizSocket;
    QuizFunctions func = new QuizFunctions();
    
    public leaderboardThread(Socket quizSocket){
        this.quizSocket = quizSocket;
    }

    @Override
    public synchronized void run(){
        try{

             BufferedReader in = new BufferedReader(new InputStreamReader(quizSocket.getInputStream()));
             PrintWriter out = new PrintWriter(quizSocket.getOutputStream(), true);
            // Receive three strings
            String name = in.readLine();
            String score = in.readLine();
            String time = in.readLine();
            String filename = "Assignment4\\MCQQuiz\\leadboard.txt";

            func.updateLeaderboard(filename, name, score, time);

            System.out.println("Received from client: " + name + ", " + score + ", " + time);

            out.println("Data received and saved to leaderboard.");
            quizSocket.close();

        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
