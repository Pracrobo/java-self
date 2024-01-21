package thread02;

public class Calculator {
    private int memory;

    public int getMemory(){
        return memory;
    }

    public synchronized void setMemory1(int memory) {
        this.memory = memory;
        try {
            Thread.sleep(1000);
        }catch(InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + ":" + memory);
        }
    }

    public void setMemory2(int memory) {
        synchronized (this) {
            this.memory= memory;

            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                System.out.println(Thread.currentThread().getName()+":"+memory);
            }
        }
    }
}
