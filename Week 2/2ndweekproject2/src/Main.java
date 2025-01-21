import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try{
        Scanner inp = new Scanner(System.in);
        System.out.print("ENter your nage: ");
        int age = inp.nextInt();
        System.out.print("You are "+age+" years old");
        }catch(InputMismatchException e){
            System.out.print("UH OH "+e);
        }

    }
}