package thread03;

public class WaitNotifyExample {
    public static void main(String[] args) {
        WorkObject workObject = new WorkObject();


        ThreadA a = new ThreadA(workObject);
        ThreadB b = new ThreadB(workObject);

        a.start();
        b.start();
    }

}
