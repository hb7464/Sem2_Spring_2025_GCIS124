public class mage1 extends goat1{

    private final static int  MAGEMAXHP = 100;
    public mage1(String name, int maxHP, int currHP) {
        super(name, MAGEMAXHP, MAGEMAXHP);
    }

    public Attack1 attack(){

        int[] hits = {9,9,9,9};
        Attack1 a = new Attack1("Magic Missiles", hits, Damage1.Magical);
        return a;

    }
    public void takeDamage(Attack1 attack){
        int sumofHits = 0;
        for (int i = 0;i < attack.getHits().length;i++)
            sumofHits+=attack.getHits()[i];
        
        if(attack.getDamageType().equals(Damage1.Magical)){
            sumofHits*= 0.75;
        }
        
        if(attack.getDamageType().equals(Damage1.Physical)){
            sumofHits*= 1.25;
        }

    }


}
