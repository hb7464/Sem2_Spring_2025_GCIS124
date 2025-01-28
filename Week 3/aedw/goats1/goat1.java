public class goat1 {
    private String name;
    private int maxHP;
    private int currentHP;

    public goat1(String name, int maxHP, int currHP){

        this.name = name;
        this.maxHP = maxHP;
        this.currentHP = currHP;
    }

    public String getname(){return this.name;}
    public int getmaxHP(){return this.maxHP;}
    public int getcurrentHP(){return this.currentHP;}

    public void setname(String Newname){this.name = Newname;}
    public void setmaxHP(int newHP){this.maxHP = newHP;}        
    public void setcurrentHP(int newHP){this.currentHP = newHP;}  
    
    @Override
    public String toString(){
        return "Goat " + name + ", maxHP: "+maxHP+", CurrentHP: "+currentHP;
    }

    public boolean isConscious(){
        return this.currentHP > 0;
    }

    public void heal(int healamount) {
        if(currentHP+healamount > maxHP){
            setcurrentHP(maxHP);
        }
        else {
            setcurrentHP(currentHP+healamount);
        }
    }
}   
