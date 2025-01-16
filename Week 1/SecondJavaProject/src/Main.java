import org.junit.Test;

import java.util.Scanner;

public class Main {

    public static int summArr(int[] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static double calculate(double a, double b){
        return a+b;
    }
    public static String reversestring(String s){
        String rs = "";
        for (int i = s.length()-1; i >= 0; i--){
            rs += s.charAt(i);
        }
        return rs;
    }

    public static String calcyear(String name, int age){

        return name+ " is born in "+ (2024-age);
    }

    public static String allinsidemethod(){

        Scanner inp = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = inp.nextLine();

        System.out.print("Enter your age: ");
        int age = inp.nextInt();
        inp.nextLine();

        return name+ " is born in "+ (2024-age);
    }

    public static void main(String[] args) {

//        String str = "Hello world";
//        System.out.println(str);
//        System.out.println(str.length());
//        System.out.println(str.charAt(3));
//        System.out.println(str.toUpperCase());
//        System.out.println(str.substring(0,4));
//        System.out.println(str.indexOf("old"));
//        return;
//        int age = 19;
//        if (age > 18 && age < 20) {
//            System.out.println("COLLEGE");
//        }
//        else if (age < 18) {
//            System.out.println("YOUNG");
//        }
//        else {
//            System.out.println("Goodbye World");
//        }

//        int i = 15;
//        while (i!=0){
//            System.out.println(i);
//            i--;
//        }
//
//        int i = 1048576;
//        int temp = i;
//        int c = 1;
//        while (i!=2){
//            System.out.println(i);
//            i = i/2;
//            c++;
//        }
//        System.out.println(temp+" is 2 to the power of "+c);

//        for (int i = 100; i >=0; i-=5)

//        Create a method that asks user for main and age
//        and returns user is born in (YEAR) Which you have to calculate

//        System.out.println(allinsidemethod());
//
//        Scanner inp = new Scanner(System.in);
//
//        System.out.print("Enter your name: ");
//        String name = inp.nextLine();
//
//        System.out.print("Enter your age: ");
//        int age = inp.nextInt();
//        inp.nextLine();
//
//        System.out.println(calcyear(name, age));
//        inp.close();

//        Scanner inp = new Scanner(System.in);
//        System.out.print("Enter a string: ");
//        String s = inp.nextLine();
//        System.out.println(reversestring(s));
//        inp.close();

        int[] x = {1,2,3,4,5,6,78,9};
        x[3] = 44;
        System.out.println(x[3]);
        System.out.print(summArr(x));
    }
}

