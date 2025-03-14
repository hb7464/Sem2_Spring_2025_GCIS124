import java.util.TimerTask;
import java.util.Timer;

public class exrctbyuni {

    public static void main(String[] args) {
        
        Timer timer = new Timer();
        TimerTask countdown = new TimerTask() {

        int count = 5;
        @Override 
        public void run(){
            System.out.println(count);
            count--;
            if (count < 0){
                System.out.println("sds");
                timer.cancel();
            }
            }
        };
        timer.scheduleAtFixedRate(countdown,0,1000);
    
    }
}
