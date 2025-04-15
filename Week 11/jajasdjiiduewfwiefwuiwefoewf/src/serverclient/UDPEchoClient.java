package serverclient;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPEchoClient {
    public static void main(String[] args) throws IOException{
        // You normally won't specify a port for clients, Java will pick an available port for you.
        DatagramSocket sock = new DatagramSocket();
        String message = "One more time!";
        System.out.println("Sending message: " + message);
        DatagramPacket outgoing = new DatagramPacket(message.getBytes(), message.length(), InetAddress.getByName("localhost"), 54321);
        sock.send(outgoing);

        byte[] buffer = new byte[1024];
        DatagramPacket incoming = new DatagramPacket(buffer, buffer.length);
        sock.receive(incoming);
        message = new String(incoming.getData(), 0, incoming.getLength());
        System.out.println("Received message: " + message);

        sock.close();


    }
}
