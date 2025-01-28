package goats1;

public class Attack1 {

    private String name;
    private int[] hits;
    private String Damagetype;

    public attack1(String name, int[] hits, Damage1 damagetype){
        this.name = name;
        this.hits = hits;
        this.Damagetype = damagetype;
    }

    public int getHits(){
        return this.hits;
    }


}
