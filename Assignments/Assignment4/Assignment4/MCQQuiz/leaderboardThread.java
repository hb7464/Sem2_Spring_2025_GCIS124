package MCQQuiz;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * The leaderboardThread class handles processing of leaderboard update requests
 * from individual client sockets in a separate thread.
 */

public class leaderboardThread implements Runnable{
    
    private Socket quizSocket;
    QuizFunctions func = new QuizFunctions();
    
    /**
     * Creates a leaderboard thread taking the quizClient socket as an argument
     *
     * @param quizSocket The client side socket
     */
    
    public leaderboardThread(Socket quizSocket){
        this.quizSocket = quizSocket;
    }
    
    /**
     * Processes the client's quiz submission by reading the name, score, and time
     * Updates the leaderboard and sends back an updated nested string array of the top 3
     * submissions as well as the user's submission back to the client socket
     */

    @Override
    public synchronized void run(){
        try{

            BufferedReader in = new BufferedReader(new InputStreamReader(quizSocket.getInputStream()));
            PrintWriter out = new PrintWriter(quizSocket.getOutputStream(), true);

            String name = in.readLine();
            String score = in.readLine();
            String time = in.readLine();
            String filename = "Assignment4\\MCQQuiz\\leadboard.txt";

            String[][] leaderboard = func.updateLeaderboard(filename, name, score, time);
            String[][] leaderboardWithRanks = new String[4][4];
            int rank = 0;

            for (String[] entry : leaderboard){

                if (rank < 3){leaderboardWithRanks[rank] = entry;}
                if (entry[1].equals(name) && entry[2].equals(score) && entry[3].equals(time)){
                    leaderboardWithRanks[3] = entry;
                    break;
                }
                rank++;
            }
            for (int i = 0; i < leaderboardWithRanks.length; i++){
                for (int j = 0; j < 4; j++){
                    out.println(leaderboardWithRanks[i][j]);
                }
            }

            System.out.println("Received from client: " + name + ", " + score + ", " + time);
            quizSocket.close();

        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
