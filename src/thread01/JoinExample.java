package thread01;

public class JoinExample {
    public static void main(String[] args) {
        SumThreadExample sumThread  = new SumThreadExample();
        sumThread.start();
        try{
            sumThread.join();
        }catch (InterruptedException e) {

        }
        System.out.println("1 ~ 100 의 합:" + sumThread.getSum());
    }
}
