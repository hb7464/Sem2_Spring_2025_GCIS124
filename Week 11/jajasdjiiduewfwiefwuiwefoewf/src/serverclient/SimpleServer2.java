package serverclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class SimpleServer2 {

    public static void main(String[] args) {
        
        try{

            ServerSocket ss = new ServerSocket( 16789 );
            Socket cs = null;
            String clientMsg;
            
            while( true ){
                System.out.println("Waiting for a client connection");
                cs = ss.accept(); // wait here for connections from a client
                System.out.println("Client connected.");
                
                BufferedReader br = new BufferedReader( new InputStreamReader ( cs.getInputStream() ) );
                PrintWriter pw = new PrintWriter( new OutputStreamWriter( cs.getOutputStream()) );
                do{
                    Random random = new Random();
                    int randomNumber = random.nextInt(10) + 1;

                    
                    clientMsg = br.readLine();
                    clientMsg = clientMsg.toUpperCase();

                    boolean digi = false;
                    for (int i = 0; i < clientMsg.length(); i++){
                        if ((Character.isDigit(clientMsg.charAt(i)))){digi = true;}
                        else{digi = false;}
                    }
                    if (digi){

                        int clientGuess = Integer.parseInt(clientMsg);
                        if (randomNumber == clientGuess) {
                            System.out.println("Correct");
                        }
                        else{
                            System.out.println("Incorrect. The correct answer is "+ randomNumber);
                        }
                    }
                    pw.println( clientMsg );
                    pw.flush();
                    System.out.println("Sent to client: "+ clientMsg );
                } while( ! clientMsg.equalsIgnoreCase( "STOP" ) );
               
                br.close();
                pw.close();
                ss.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
