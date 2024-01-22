package thread04;

public class InterruptExample03 {
    public static void main(String[] args) {
        Thread thread  = new PrintThread03();
        thread.start();

        try{
            Thread.sleep(1000);
        }catch(InterruptedException e) {

        }
        thread.interrupt();
    }
}
