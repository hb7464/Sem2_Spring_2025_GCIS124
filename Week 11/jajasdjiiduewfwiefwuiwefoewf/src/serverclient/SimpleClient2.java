package serverclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SimpleClient2 {

    public static void main(String[] args) {
        try{

            
            Scanner inp = new Scanner(System.in);
            Socket socket = new  Socket("localhost", 16789);
            
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            
            for( String txt : args ){
                System.out.print("Enter your guess (1-10): ");
                int guess = inp.nextInt();
                out.println(guess);
                pw.println( txt ); 
                out.flush();
                pw.flush();
                System.out.println(txt+" is now "+ guess );
            }
            pw.println("STOP");
            pw.flush();
        
            // inp.nextLine();
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter resp = new PrintWriter(socket.getOutputStream(), true);
            
            br.close();
            pw.close();
            in.close();
            out.close();
            inp.close();
            socket.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
