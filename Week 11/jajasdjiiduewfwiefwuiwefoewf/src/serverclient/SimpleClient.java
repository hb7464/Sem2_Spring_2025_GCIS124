package serverclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SimpleClient {

    public static void main(String[] args) {
        try{
            Scanner inp = new Scanner(System.in);
            System.out.print("Enter your guess (1-10): ");
            int guess = inp.nextInt();
            Socket socket = new  Socket("localhost", 12345);
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            out.println(guess);
            out.flush();
            // inp.nextLine();
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter resp = new PrintWriter(socket.getOutputStream(), true);
            
            System.out.println(resp);

            in.close();
            out.close();
            inp.close();
            socket.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
