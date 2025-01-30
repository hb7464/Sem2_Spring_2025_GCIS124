package goats1;

public class Actiontime {

    public static void goatarena(goat1 m, goat1 w){

        while (m.isConscious() && w.isConscious()){
            
            System.out.println(m);
            System.out.println(w);  

            m.takeDamage(w.attack());
            w.takeDamage(m.attack());

            System.out.println();
        }

        System.out.println(m);
        System.out.println(w);  
        
        if (m.isConscious()){
            System.out.println(m.getname()+" IS THE WINNER!");
        }
        else if (w.isConscious()){
            System.out.println(w.getname()+" IS THE WINNER!");
        }
        else {
            System.out.print("IT IS A TIE!");
        }
        
    }

    public static void main(String[] args) {
        
        mage1 Gandalf = new mage1("Gandalf");
        warrior1 NOT_GANDALF = new warrior1("NOT_GANDALF");

        goatarena(Gandalf, NOT_GANDALF);
        
        // System.out.println(Gandalf);
        // System.out.println(NOT_GANDALF);
        
        // Attack1 a = Gandalf.attack();
        // NOT_GANDALF.takeDamage(a);
        
        // Gandalf.takeDamage(NOT_GANDALF.attack());
        
        // System.out.println(Gandalf);
        // System.out.println(NOT_GANDALF);
        // System.out.println(NOT_GANDALF.isConscious());
        // System.out.println("LET US HEAL NOT_GANDALF");
        // NOT_GANDALF.heal(4);
        // System.out.println(NOT_GANDALF);

        // goat1 Gandalf_Junior = Gandalf;
        // goat1 Not_Gandalf_Junior = NOT_GANDALF;

    }

}
