package thread01;

public class YieldExample {
    public static void main(String[] args) {
        WorkThreadExample workThreadA = new WorkThreadExample("workThreadA");
        WorkThreadExample workThreadB = new WorkThreadExample("workThreadB");

        workThreadA.start();
        workThreadB.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {

        }
        workThreadA.work = false;
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e){
            workThreadB.work = true;
        }
    }
}
