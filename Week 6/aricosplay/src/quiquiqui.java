import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class quiquiqui {
    public static void main(String[] args) throws Exception {
    
    List<String> list = new LinkedList<>();
    list.add("My");
    list.add("Name");
    list.add("Is");
    list.add("Khaleel");
    list.add("And");
    list.add("I");
    list.add("Am");
    list.add("Like");
    list.add("A");
    list.add("Happy");
    list.add("Meal");
    
    for (int i = 0; i<list.size(); i++){
        System.out.print(list.get(i)+" ");
    }
    System.out.println();
    list.removeLast();
    list.removeLast();
    list.removeLast();
    list.add("An");
    list.add("Unhappy");
    list.add("Meal");
    
    for (String i:list){
        System.out.print(i+" ");
    }
    System.out.println();

    Iterator<String> i = list.iterator();
    while(i.hasNext()){
        System.out.print(i.next()+" ");
    }    
    
    }
}
