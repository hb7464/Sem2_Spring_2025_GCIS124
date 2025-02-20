package BST1;
import java.util.Scanner;

public class mmactualthing {

    public static void main(String[] args){

        Scanner inp = new Scanner(System.in);
        mmmbinarytreemmmmm tree = new mmmbinarytreemmmmm();

        try{

            while (true){

                System.out.print("Enter a number to add(or 'exit' to exit): ");
                int val = inp.nextInt();
                inp.nextLine();
                tree.add(val);
            }

        }catch (Exception e){

            inp.close();
            System.out.println("Noice. WE exit");
            tree.dftraverse();

        }
    }



}
