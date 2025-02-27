import java.util.Scanner;
import java.util.ArrayList;

public class GimmeMaChange {

    public static ArrayList<Bills> getChange(double price, double payment){
        ArrayList<Bills> change_ = new ArrayList<Bills>();
        double change = price - payment;
        System.out.println("Change is "+change);
        while (change>0){
            if (change >= Bills.Twenty.getamount()){
                change_.add(Bills.Twenty);
                change =  Bills.Twenty.getamount() - change;
            }
            else if (change >= Bills.Tenner.getamount()){
                change_.add(Bills.Tenner);
                change =  Bills.Tenner.getamount() - change;
            }
            else if (change >= Bills.Fiver.getamount()){
                change_.add(Bills.Fiver);
                change =  Bills.Fiver.getamount() - change;
            }
            else if (change >= Bills.Dollar.getamount()){
                change_.add(Bills.Dollar);
                change =  Bills.Dollar.getamount() - change;
            }
            else if (change >= Bills.Quarter.getamount()){
                change_.add(Bills.Quarter);
                change =  Bills.Quarter.getamount() - change;
            }
            else if (change >= Bills.Penny.getamount()){
                change_.add(Bills.Penny);
                change =  Bills.Penny.getamount() - change;
            }
        }
        return change_;

    }
    public static void main(String[] args) throws Exception {
        
        Scanner inp = new Scanner(System.in);

        System.out.print("Enter item price: ");
        double price = inp.nextDouble();
        inp.nextLine();
        System.out.print("Enter how much you paid: ");
        double paid = inp.nextDouble();
        inp.close();
        ArrayList<Bills> change = getChange(price, paid);

        System.out.println("Your change is "+change);


        
    }
}
