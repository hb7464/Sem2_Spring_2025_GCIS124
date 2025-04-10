package serverclient;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPEchoServer {

    public static void main(String[] args) throws IOException{
        
        DatagramSocket server = new DatagramSocket(54321);
        byte[] buffer = new byte[1024];
        DatagramPacket incoming = new DatagramPacket(buffer, buffer.length);

        server.receive(incoming);
        String message = new String(incoming.getData(),0,incoming.getLength());
        System.out.println(message);

        //Activity 11.2.7
        DatagramPacket outgoing = new DatagramPacket(message.getBytes(), 
        message.length(), incoming.getAddress(), incoming.getPort());
        
        server.send(outgoing);
        server.close();

    }

}
