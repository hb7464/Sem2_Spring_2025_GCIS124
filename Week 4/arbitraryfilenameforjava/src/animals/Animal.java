package animals;
public interface Animal{
    
    private static final String KINGDOM = "Animalia";

    public static String getKingdom(){
        return KINGDOM;    
    }

    public abstract void speak();
}


