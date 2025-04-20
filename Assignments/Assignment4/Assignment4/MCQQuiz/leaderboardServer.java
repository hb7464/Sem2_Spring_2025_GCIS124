package MCQQuiz;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * The leaderboardServer class is responsible for the creation of a TCP server
 * which listens for multiple quiz clients and updates the quiz submissions
 * using the leaderboardThread class
 */

public class leaderboardServer{

    /**
     * Main method used to launch the TCP server
     * 
     * @param args the arguments for when we call main
     */
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        try{
            ServerSocket leaderboardSocket = new ServerSocket(54123);
            do{
                System.out.println("Server launched. Awaiting connection...");
                Socket quizSocket = leaderboardSocket.accept();
                System.out.println("Connection Established.");
                
                leaderboardThread update = new leaderboardThread(quizSocket);
                new Thread(update).start();
                
                System.out.println("Enter 'stop' to shutdown the server");
            }while (!(inp.nextLine()).equals("stop"));

            leaderboardSocket.close();
            inp.close();
            
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
