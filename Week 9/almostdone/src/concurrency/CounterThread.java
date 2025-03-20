package concurrency;

public class CounterThread extends Thread{

    private final String name;
    private final int id;
    public CounterThread(String name, int id){
        this.name = name;
        this.id = id;
    }

    @Override
    public void run(){
        for (int i = 1 ; i < 101 ; i++ ){System.out.println("{"+id+"}"+name+" : "+i);}
    }

    public static void main(String[] args) {
        
            CounterThread nametime1 = new CounterThread("hishaam",1);
            CounterThread nametime2 = new CounterThread("hishaam",2);
            CounterThread nametime3 = new CounterThread("hishaam",3);
            nametime1.start();
            nametime2.start();
            nametime3.start();
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (char ch = 'A'; ch <= 'Z'; ch++){
                System.out.println(ch);
            }

            System.out.println("1 "+nametime1.isAlive()+" 2 "+nametime2.isAlive()+" 3 "+nametime3.isAlive());
            System.out.println("_------------------------");
            
            while (nametime1.isAlive() || nametime2.isAlive() || nametime3.isAlive()){System.out.println("A1 "+nametime1.isAlive()+" 2 "+nametime2.isAlive()+" 3 "+nametime3.isAlive());}
            System.out.println("1 "+nametime1.isAlive()+" 2 "+nametime2.isAlive()+" 3 "+nametime3.isAlive());
            System.out.println("fini");
    }
}
