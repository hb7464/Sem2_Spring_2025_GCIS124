import java.util.Comparator;

public class FruitCompareName implements Comparator<DaFruit>{

    public int compare(DaFruit f1, DaFruit f2){
        String name1 = f1.getName();
        String name2 = f2.getName();
        return name1.toLowerCase().compareTo(name2.toLowerCase());
    }

}
