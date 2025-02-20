

public class callingthecomparing {

    
    public static void main(String[] args) {
        
        DaFruit f1 = new DaFruit(10.5, "oragne");
        DaFruit f2 = new DaFruit(15, "pizza");
        FruitCompareName c = new FruitCompareName();
        System.out.println(f2.compareTo(f1));
        System.out.println(c.compare(f2,f1));
        
    }

}
