

/*

// import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // System.out.println("Try some pizza");
        // System.out. println("Text below");
        
        // int x;
        // x = 123;
        // long y;
        // y = 123000000003423432L;
        // byte z = 124;
        // float a = 123.4343f;
        // double b = 23.43;
        // boolean c = true;
        // char d = 's';
        // String e = "aatasds";
        
        // System.out.println("Trying this "+x);
        // System.out.println("Trying this as well "+y);
        // System.out.println("Trying this too "+z);
        // System.out.println("Float too "+a);
        // System.out.println("Float too "+b);
        // System.out.println("bool too "+c);
        // System.out.println("char too "+d);
        // System.out.println("str too "+e);

        // String x = "abc";
        // String y = "def";
        
        // System.out.println("Before");    
        // System.out.println("x: "+x);
        // System.out.println("y: "+y);
        
        // String temp;
        // temp = x;
        // x = y;
        // y = temp;
        
        // System.out.println("After");
        // System.out.println("x: "+x);
        // System.out.println("y: "+y);

        // Scanner scanner = new Scanner(System.in);

        // System.out.print("Enter input: ");
        // String input = scanner.nextLine();
        // System.out.println("sd: "+input);
        
        // System.out.println("Enter int input2");
        // int input2 = scanner.nextInt();
        // scanner.nextLine();
        // System.out.println("ed: "+input2);
        
        // System.out.println("Enter input3");
        // String input3 = scanner.nextLine();
        // System.out.println("de: "+input3);

        // scanner.close();


        int x = 10;
        System.out.println("Before Operations: "+x);
        
        x++;
        System.out.println("After increment: "+x); //Alternatively to increment more than one, we do += (number)
        x--;
        System.out.println("After decrement: "+x); //Alternatively to decrement more than one, we do -= (number)
        x = x / 2;
        System.out.println("After division by 2: "+x);
        x = x / 3;
        System.out.println("After division by 3: "+x);
        x = x % 3;
        System.out.println("After Modulus by 3: "+x);
        
        double y = 10;
        y =  y / 3;
        System.out.println("After division by 3 and changing to double data type: "+y);
    }
}

*/

// GUI application

/*
import javax.swing.JOptionPane;

public class Main{

    public static void main(String[] args) {
        
        String name = JOptionPane.showInputDialog("Enter your name: ");
        JOptionPane.showMessageDialog(null, "Hello " +name);
        
        int age = Integer.parseInt(JOptionPane.showInputDialog("Enter your age: "));
        JOptionPane.showMessageDialog(null, "You are "+age+" years old.");
        
        double height = Double.parseDouble(JOptionPane.showInputDialog("Enter your height: "));
        JOptionPane.showMessageDialog(null, "You are "+height+"cm tall.");

    }
}
*/
/* Math Functions

public class Main {

     public static void main(String[] args) {
        
        double x = 3.14;
        double y = -10;

        double z = Math.max(x, y);
        double w = Math.min(x, y);
        double v = Math.abs(y);

        System.out.println("The bigger number is "+z);
        System.out.println("The smaller number is "+w);
        System.out.println("The absolute value of the min number is "+v);

        double a = 100;
        double b = 2.43;

        System.out.println("The square root of "+a+" is "+ Math.sqrt(a));
        System.out.println("The rounded of "+b+" is "+Math.round(b));
        System.out.println("Rounding up "+b+" is "+Math.ceil(b));
        System.out.println("Rounding down "+b+" is "+Math.floor(b));

     }
}
*/

/* Hypotenuse calculator
import java.util.Scanner;

public class Main{

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        
        System.out.println("This is a program to get the length of the hypotenuse");
        
        System.out.print("Enter the length of your First side: ");
        double side1 = scanner.nextDouble();
        System.out.print("Enter the length of your Second side: ");
        double side2 = scanner.nextDouble();

        System.out.println("Your sides are " +side1+" and "+side2);

        double hyp = Math.sqrt((side1*side1)+(side2*side2));
        System.out.println("The hypotenuse is "+hyp);

        scanner.close();

    }
}
*/

/* With gui hypotenuse calculator

import javax.swing.JOptionPane;

public class Main{

    public static void main(String[] args) {
        
        JOptionPane.showMessageDialog(null,"This is a program to get the length of the hypotenuse");
        
        double side1 = Double.parseDouble(JOptionPane.showInputDialog("Enter the length of your First side: "));
        double side2 = Double.parseDouble(JOptionPane.showInputDialog("Enter the length of your Second side: "));

        double hyp = Math.sqrt((side1*side1)+(side2*side2));
        JOptionPane.showMessageDialog(null, "Your sides are " +side1+" and "+side2+ "\n Making the hypotenuse "+hyp);

    }
}
*/
/* Using random in Java
import java.util.Random;

public class Main{

    public static void main(String[] args){

        Random random = new Random();

        int x = random.nextInt(6)+1;
        double y = random.nextDouble();
        boolean z = random.nextBoolean();
        
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);

    }
}
*/
/* if else statements
public class Main{

    public static void main(String[] args){

        int a = 18;

        if (a > 18) {
            System.out.println("Age is over 18");
        }

        else if (a < 18) {
            System.out.println("Age is under 18");
        }

        else {
            System.out.println("Age is 18");
        }

    }

}
*/

// Switches in java

/*
public class Main{

    public static void main(String[] args) {
        
        String day = "International Men's Day";
        switch(day) {

            case "Sunday": System.out.println("It is "+ day);
            break;
            case "Monday": System.out.println("It is "+ day);
            break;
            case "Tuesday": System.out.println("It is "+ day);
            break;
            case "Wednesday": System.out.println("It is "+ day);
            break;
            case "Thursday": System.out.println("It is "+ day);
            break;
            case "Friday": System.out.println("It is "+ day);
            break;
            case "Saturday": System.out.println("It is "+ day);
            break;
            default: System.out.println("Not a real day");

        }

    }
}
*/



// HOW TO USE SWITCHES

import javax.swing.JOptionPane;

public class Main{

    public static void main(String[] args){

        String day = JOptionPane.showInputDialog("Enter a Holiday");
        switch(day) {

            case "Sunday": JOptionPane.showMessageDialog(null,"It is "+ day);
            break;
            case "Monday": JOptionPane.showMessageDialog(null,"It is "+ day);
            break;
            case "Tuesday": JOptionPane.showMessageDialog(null,"It is "+ day);
            break;
            case "Wednesday": JOptionPane.showMessageDialog(null,"It is "+ day);
            break;
            case "Thursday": JOptionPane.showMessageDialog(null,"It is "+ day);
            break;
            case "Friday": JOptionPane.showMessageDialog(null,"It is "+ day);
            break;
            case "Saturday": JOptionPane.showMessageDialog(null,"It is "+ day);
            break;
            default: JOptionPane.showMessageDialog(null,day+" is not a real day");

        }

    }
}


/* Using AND OPERATOR &&
public class Main{

    public static void main(String[] args){

        int temp = 15;
        
        if (temp > 35) {
            System.out.println("ITS HOT AF");
        }

        else if (temp >= 20 && temp <=35) {
            System.out.println("It is p avg outside");
        }

        else {
            System.out.println("Its cold af");
        }

    }
}
*/

/* OR OPERATOR ||
import java.util.Scanner;

public class Main{

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Press q or Q to quit out of the program.");
        String response = scanner.next();

        if (response.equals("q") || response.equals( "Q")) { //We use .equals to check equality of a string instead of ==, idk == doesn't work for some reason
            System.out.println("You have exited. Why.");
        }
        else {
            System.out.println("You didn't exit. Why.");
        }


    }
}
*/

/*USING NOT ! operator, we use it to do the opposite of the boolean condition
 (If you want to use it with == or comparison operators like >= instead of using 
 != directly in the expression, u need to enclose the entire boolean expression 
 in brackets and then put ! outside that)
 Eg: !(x = 300) 
 
import java.util.Scanner;

public class Main{

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Press q or Q to quit out of the program.");
        String response = scanner.next();

        if (!response.equals("q") && !response.equals( "Q")) { //We use .equals to check equality of a string instead of ==, idk == doesn't work for some reason
            System.out.println("You didn't exit. Why.");
        }
        else {
            System.out.println("You have exited. Why.");
        }


    }
}
*/

/* WHILE LOOPS
import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        String name = "";
        
        while (name.isBlank()) { 
            System.out.print("Enter your name: ");
            name = scanner.nextLine();
        }

        System.out.println("Hello "+name);

    }

}
*/

/*import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        String name = "";
        
        do{ //do will execute the block of code atleast once and then check the condition as opposed to b4
            // where the condition is checked and then the block of code is executed
            System.out.print("Enter your name: ");
            name = scanner.nextLine();
        }while (name.isBlank());
        
        System.out.println("Hello "+name);

    }

}
*/

/*FOR LOOPS

public class Main{

    public static void main(String[] args){

        for (int index = 10; index>0; index--) { //You can also put the increment/decrement in the executed block of code
            System.out.println(index);
            // index--; //Like over here instead of in the for loop ()
        }
        System.out.println("HAPPY NEW YEAR!!!");
    }
}
*/

/* NESTED LOOPS
import java.util.Scanner;

public class Main{

    public  static void main(String[] args){
        
        Scanner scn = new Scanner(System.in);
        int rows;
        int cols;
        String symb = "";

        System.out.print("Enter number of rows: ");
        rows = scn.nextInt();
        System.out.print("Enter number of columns: ");
        cols = scn.nextInt();
        System.out.print("Enter the symbol to use: ");
        symb = scn.next();

        for(int i = 1; i<=rows;i++){
            for(int j = 1; j<=cols;j++){
                System.out.print(symb); 
            }
            System.out.println();
        }
        
        
    }
}
*/

/* ARRAYS
public class Main{

    public static void main(String[] args) {
        
        // String[] cars = {"Camaro","Corvete","Tesla","BMW"};

        // System.out.println(cars[0]);
        // cars[0] = "Mustang";
        // System.out.println(cars[0]);

        // Alternative way to make an array

        String[] cars = new String[3];
        
        cars[0] = "Mustang";        
        cars[1] = "Corvette";    
        cars[2] = "Tesla";
                
        for(int i = 0; i<cars.length; i++){
            System.out.println(cars[i]);
        }

    }
}
*/

/*
public class Main{

    public static void main(String[] args) {
     
        String[][] cars = new String[3][3];

        cars[0][0] = "Camaro";
        cars[0][1] = "Corvette";    
        cars[0][2] = "Tesla";
        cars[1][0] = "ABC";
        cars[1][1] = "EFG";    
        cars[1][2] = "HIJ";
        cars[2][0] = "KLM";
        cars[2][1] = "NOP";    
        cars[2][2] = "QRS";
        
        //Alternative way to make a 2d ARRAY

        // String[][] cars = {
        //                     {"Camaro","Corvette","Tesla"},
        //                     {"ABC","EFG","HIJ"},
        //                     {"KLM","NOP","QRS"}
        //                 };
                        
        for (int i = 0; i<cars.length; i++) {
            for (int j = 0; j<cars[i].length; j++) {
                System.out.print(cars[i][j]+" ");
            }
            System.out.println();
        }

    }
}
*/
/* DUMB SHI I DID IN CLASS THAT I FOUND FUNNY
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;

public class Main {

    private static void displayImage() {
        // Create the frame
        JFrame frame = new JFrame("Display Image Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        
        // Load the image
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\hisha\\Downloads\\stock-vector-uh-oh-92290096.jpg");  // Replace with your image path
        JLabel label = new JLabel(imageIcon);

        // Add the label to the frame
        frame.getContentPane().add(label, BorderLayout.CENTER);
        
        // Set the frame visible
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {

        try{
        Scanner inp = new Scanner(System.in);
        System.out.print("ENter your nage: ");
        int age = inp.nextInt();
        System.out.print("You are "+age+" years old");
        }catch(InputMismatchException e){
            System.out.print("UH OH "+e);
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    displayImage();
                }
            });
        }

    }
}
*/