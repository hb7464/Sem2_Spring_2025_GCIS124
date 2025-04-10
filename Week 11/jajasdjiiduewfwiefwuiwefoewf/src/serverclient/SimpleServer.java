package serverclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class SimpleServer {

    public static void main(String[] args) {
        
        try{

            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Server started. Waiting for client to connect...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected.");

            Random random = new Random();
            int randomNumber = random.nextInt(10) + 1;

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String guess = in.readLine();
            int clientGuess = Integer.parseInt(guess);

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            
            if (randomNumber == clientGuess) {
                System.out.println("Correct");
            }
            else{
                System.out.println("Incorrect. The correct answer is "+ randomNumber);
            }

            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
