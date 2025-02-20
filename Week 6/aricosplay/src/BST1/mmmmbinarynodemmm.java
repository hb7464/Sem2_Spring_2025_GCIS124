package BST1;

public class mmmmbinarynodemmm {

    private mmmmbinarynodemmm LeftValue;
    private mmmmbinarynodemmm RightValue;
    private  int value;

    public mmmmbinarynodemmm(int value){
        this.value = value;
        this.LeftValue = this.RightValue = null;
    }

    public mmmmbinarynodemmm getLeftValue(){return LeftValue;}
    public void setLeftValue(mmmmbinarynodemmm NewLeftValue){this.LeftValue = NewLeftValue;}

    public mmmmbinarynodemmm getRightValue(){return RightValue;}
    public void setRightValue(mmmmbinarynodemmm NewRightValue){this.RightValue = NewRightValue;}
    
    public int getValue(){return value;}
    public void setValue(int NewValue){this.value = NewValue;}
    
    @Override
    public String toString(){
        return "BinaryNode{Value = <"+value+
                ">, left =<"+LeftValue+
                ">, right =<"+RightValue+">}";
    }

}
