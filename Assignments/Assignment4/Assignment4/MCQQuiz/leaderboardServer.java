package MCQQuiz;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class leaderboardServer{
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
