import java.util.Scanner;

public class anotherfile {

    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {

        Scanner inp = new Scanner(System.in);

        student[] arr = new student[3];

        for (int i = 0; i < 3; i++) {
        
            System.out.print("Enter name for student "+(i+1)+": ");
            String tempname = inp.nextLine();    
            System.out.print("Enter last name for student "+(i+1)+": ");
            String templastname = inp.nextLine();
            System.out.print("Enter ID for student "+(i+1)+": ");
            int tempid = inp.nextInt();
            inp.nextLine();
            Grading tempgrade = Grading.A;
            student tempobj = new student(tempname, templastname, tempid, tempgrade);
            arr[i] = tempobj;
        }
        inp.close();

        for (int i = 0; i < arr.length; i++)        
            System.out.println("Student "+(i+1)+": "+arr[i]);
    }
    
}
