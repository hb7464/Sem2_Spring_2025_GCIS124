import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws IOException {

//        try{
//        Scanner inp = new Scanner(System.in);
//        System.out.print("ENter your nage: ");
//        int age = inp.nextInt();
//        System.out.print("You are "+age+" years old");
//        }catch(InputMismatchException e){
//            System.out.print("UH OH "+e);
//        }
//        System.out.println();

        // FileReader reader = new FileReader("awsd.txt");
        // BufferedReader bufferedReader = new BufferedReader(reader);
        // String s = bufferedReader.readLine();
        // System.out.println(s);
        // bufferedReader.close();
        
        FileWriter writer = new FileWriter("awsd.txt");
        PrintWriter printWriter = new PrintWriter(writer);
        printWriter.print("Hello");
        printWriter.print("wdwd");

        
    }
}