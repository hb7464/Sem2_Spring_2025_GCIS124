
public class Attack1 {

    private String name;
    private int[] hits;
    private Damage1 Damagetype;

    public Attack1(String name, int[] hits, Damage1 damagetype){
        this.name = name;
        this.hits = hits;
        this.Damagetype = damagetype;
    }

    public int[] getHits(){return this.hits;}
    public Damage1 getDamageType(){return this.Damagetype;}
    public String getName(){return this.name;}
    


}
