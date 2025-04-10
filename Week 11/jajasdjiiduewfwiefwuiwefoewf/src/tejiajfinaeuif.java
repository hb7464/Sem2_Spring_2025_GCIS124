import java.net.*;
import java.util.Scanner;
import java.io.*;

public class tejiajfinaeuif {

    public static void main(String[] args) throws IOException {
        
        URL url = new URL("https://www.nasa.gov");
        URLConnection urlConnection = url.openConnection();
        urlConnection.connect();
        InputStream inputStream = urlConnection.getInputStream();
        Scanner inp = new Scanner(inputStream);

        FileWriter writer = new FileWriter("src\\dsds.html");
        BufferedWriter writre = new BufferedWriter(writer);

        while (inp.hasNext()){
            writre.write(inp.nextLine());
        }
        inp.close();
        writre.close();
    }
}

