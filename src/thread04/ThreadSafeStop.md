### 스레드의 안전 종료

자신의 run() 메서드가 모두 실행되면 자동적으로 종료되지만, 경우에 따라서는 실행 중인 스레드를 즉시 종료할 필요가 있다.
예를 들어 동영상을 끝까지 안보고 사용자가 멈춤을 요구했을 경우 등이 있다.
 스레드의 강제종료를 위해 Thread는 stop() 메서드를 제공하고 있으나 이 메서드는 deprecated 되었다. 스레드를 갑자기 종료하게 되면 사용중이던 리소스들이 불안전한 상태로  남겨지기 때문이다. 여기서 리소스란 파일, 네트워크 환경 등을 말한 다.
 스레드를 안전하게 종료하는방법에는 사용하던 리소스를 정리하고 run()메서드를 빨리 종료하는 것이다. 주로 조건 이용 방법과 interrupt()메서드 이용 방법을 사용한다.

#### 조건이용
while문으로 반복 실행할 경우, 조건을 이용해서 run()메서드의 종료를 유도할 수 있다. 다음 코드는 stop 필드 조건에 따라서  run()메셔드의 종료를 유도한다.
```java
public class xxxThread extends Thread {
    private boolean stop;
    public void run() {
        while(!stop) {
            //스레드가 빈복 실행하는 코드
        }
        // 스레드가 사용한 리소스 정리
    }
}
```


### interrupt)메서드 이용 
스레드가 일시정지 상태에 있을 때 InterruptedException예외를 발생시키는 역할을 하낟. 이것을 이용하면 예외처리를 통해 run()메서드를 정상종료 시킬 수 있다. 
```java
    XThread thread = new Xthread();
    thread.start();
.......
    thread.interrupt();
```
```java
public void run() {
    try {
        while (true) {
         ...
            Thread.sleep(1);
        }
    }catch (InterruptedException e) {
        
    }
    // 스레드가 사용한 리소스 정리
}
```
XThread 를 생성해서 start() 메서드를 실행한 후에 XTread의 interrupt() 메서드를 실행하면 XThread 가 일시 정지 상태가 될 때 InterruptedException이 발생하여 예외처리 블록으로 이동한다. 이것은 결국 while문을 빠져나와 자원을 정리하고 스레드가 종료되는 효과를 가져온다.

스레드가 실행대기 / 실행 상태일 때에는 interrupt()메서드가 호출되어도 InterruptedException이 발생하지 않는다. 그러나 스레드가 어떤 이유로 일시 정지 상태가 되면, InterruptedException 예외가 발생한다. 그래서 짧은 시간이나마 일시 정지를 위해 Thread.sleep(1)을 사용한 것이다.
일시 정지를 만들지 않고도 interrupt()메서드 호출 여부를 알 수 있는 방법이 있다. Thread의 interrupt()와 isInterrupted()메서드는 interrupt()메서드 호출 여부를 리턴한다. interrupted()정적 메서드고 isInterrupted()는 인스턴스 메서드다.
```java
boolean status = Thread.interrupted();
boolean status = objThread.isInterrupted();
```


