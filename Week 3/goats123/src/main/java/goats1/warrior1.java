package goats1;

public class warrior1 extends goat1{

    private final static int  WARRIOR1MAXHP = 150;
    public warrior1(String name) {
        super(name, WARRIOR1MAXHP, WARRIOR1MAXHP);
    }

    @Override
    public Attack1 attack(){

        int[] hits = {25};
        Attack1 a = new Attack1("Cleave", hits, Damage1.Physical);
        return a;

    }
    @Override
    public void takeDamage(Attack1 attack){
        int sumofHits = 0;
        for (int i = 0;i < attack.getHits().length;i++)
            sumofHits+=attack.getHits()[i];
        
        if(attack.getDamageType().equals(Damage1.Physical)){
            sumofHits*= 0.75;
        }
        
        if(attack.getDamageType().equals(Damage1.Magical)){
            sumofHits*= 1.25;
        }
        if(sumofHits>getcurrentHP()){
            setcurrentHP(0);
        }
        else{
            setcurrentHP(getcurrentHP()-sumofHits);
        }
    }
}
