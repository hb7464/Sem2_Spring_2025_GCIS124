public class ThreadExample extends Thread{

    private final int id;

    public ThreadExample(int id){
        this.id = id;
    }
    
    @Override
    public void run(){
        System.out.println(id);
    }

    

}