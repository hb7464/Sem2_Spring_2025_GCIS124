import java.net.*;
import java.io.*;

public class nottestingtestingtime {
    public static void main(String[] args) throws Exception {
        try {
            System.out.println("getLocalHost: "+InetAddress.getLocalHost());
            System.out.println("getByName: "+InetAddress.getByName("localhost"));
            System.out.println("getByName: "+InetAddress.getByName("rit.edu"));
            System.out.println("getByName: "+InetAddress.getByName("google.com"));
        } catch (UnknownHostException e) {
            System.out.println("Error with read and write");
            e.printStackTrace();
        }
    }
}
