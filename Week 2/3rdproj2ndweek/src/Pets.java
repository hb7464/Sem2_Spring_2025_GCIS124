import java.util.InputMismatchException;
import java.util.Scanner;

public class Pets{
    public int getAge(){
        return this.age;
    }

    public void changeAge(int newage){
        this.age = newage;
    }

    public String getName(){
        return this.name;
    }

    public void changeName(String newName){
        this.name = newName;
    }

    public String getSpecies(){
        return this.species;
    }

    public void dispall(){
        System.out.println(this.getAge()+" "+this.getName()+" "+this.getSpecies());
    }
    public void changespecies(String newspecies){
        this.species = newspecies;
    }


    private int age;
    private String name;
    private String species;

    public Pets(int age, String name, String species){
        this.age = age;
        this.name = name;
        this.species = species;

    }
    public static void main(String[] args){

        Pets  a =  new Pets(12,"sd","dog");

        a.dispall();

        a.changeAge(14);
        a.changeName("Khaleel");
        a.changespecies("Human? Probably");
        
        a.dispall();
        
        Scanner inp = new Scanner(System.in);

        try {
            System.out.print("Enter your age: ");
            int age = inp.nextInt();
            inp.nextLine();
            System.out.print("Enter your name: ");
            String name = inp.nextLine();
            System.out.print("Enter your species: ");
            String species = inp.nextLine();
            Pets inputtime = new Pets(age, name, species);
            inputtime.dispall();
            inp.close();

        } catch (InputMismatchException e) {
            System.out.println("STOP TRYING TO BREAK MY COPDE WITH "+e);
        }

    }
}