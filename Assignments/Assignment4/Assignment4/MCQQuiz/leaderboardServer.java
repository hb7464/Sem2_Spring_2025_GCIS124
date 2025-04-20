package MCQQuiz;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class leaderboardServer{
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        try{
            ServerSocket leaderboardSocket = new ServerSocket(54123);
            System.out.println("Server launched. Awaiting connection...");
            do{
                Socket quizSocket = leaderboardSocket.accept();
                System.out.println("Connection Established.");
                
                leaderboardThread update = new leaderboardThread(quizSocket);
                new Thread(update).start();

            }while (!(inp.nextLine()).equals("stop"));

            leaderboardSocket.close();
            inp.close();
            
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
