package thread01;

public class WorkThreadExample extends Thread{
    public boolean work = true;
    public WorkThreadExample(String name) {
        setName(name);
    }

    //메서드
    @Override
    public void run() {
        while(true) {
            if(work) {
                System.out.println(getName() + ": 작업 처리");
            }else{
                Thread.yield();
            }
        }
    }

}
