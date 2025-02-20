package BST1;

public class mmmbinarytreemmmmm {

    mmmmbinarynodemmm root;

    public void add(int value){root = addRecursive(root,value);}
    
    private mmmmbinarynodemmm addRecursive(mmmmbinarynodemmm current, int value){

        if (current == null){return new mmmmbinarynodemmm(value);}

        if (value < current.getValue()){current.setLeftValue(addRecursive(current.getLeftValue(), value));}
        
        if (value > current.getValue()){current.setRightValue(addRecursive(current.getRightValue(), value));}
        
        else {return current;}   
        
        return current;
    }

    public void dftraverse(){
        System.out.println("Binary tree Depth First Search: ");
        traverseInOrder(root);
    }

    public void traverseInOrder(mmmmbinarynodemmm node){
        if (node != null){
            traverseInOrder(node.getLeftValue());
            System.out.print(node.getValue()+" ");
            traverseInOrder(node.getRightValue());
        }
    }
    
}
