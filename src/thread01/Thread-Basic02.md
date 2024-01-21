### 스레드의 이름

작업 스레드는 자동적으로 Thread-n이라는 이름을 가진다.
다른 이름으로 설정하고 싶다면 setName()메서드를 이용한다.
```java
thread.setName("스레드 이름");
```
스레드 이름은 디버깅 시 어떤 스레드가 작업하는지 조사할 목적으로 사용된다.
현재 코드를 어떤 스레드가 실행하고 있는지 호가인하려면 정적메서드인 currentThread()로 스레드 객체의 참조를 얻은 다음 
getName()메서드로 이름을 출력해보면 된다.

```java
Thread thread  = Thread.currentThread();
System.out.println(thread.getName());
```
<br>

### 스레드의 상태

스레드 객체를 생성하고 start()메서드를 호출하면 곧바로 스레드가 실행되는 것이 아니라, 실행 대기 상태로 된다.
실행 대기 상태란, 실행을 기다리고  있는 상태를 말한다.

실행대기하는 스레드는 CPU 스케줄링에 따라 CPU 를 점유하고 run()메서드를 실행한다.
이때를 실행 상태라고 한다. 다른 스레드가 실행 상태가 된다.

이렇게 스레드는 실행대기 상태와 실행상태를 번갈아 가면서 자신의 run()메서드를 조금씩 실행한다.
실행 상태에서 run()메서드가 종료되면 더 이상 실행할 코드가 없기 때문에 스레드의 실행은 멈추게 된돠. 이 상태를 종료 상태라고 한다.

실행 상태에서 일시 정지 상태로 가기도 하는데, 일시 정지 상태는 스레드가 실행할 수 없는 상태를 말한다. 스레드가 다시 실행 상태로 가기 위해서는 
일시 정지 상태에서 실행 대기 상태로 가야만 한다.
![img.png](../resource/img.png)
![img_1.png](../resource/img_1.png)
표에서 wait(), notify(), notifyAll()은 Object클래스의 메서드고 그외는 Thread 클래스의 메서드다.
wait(), notify(), notifyAll(), 메서드의 사용방법은 스레드 동기화에서 알아보기로 하고 , 여기서는 Threrad 클래스의 메서드만 살펴본다.

#### sleep() : 주어진 시간 동안 일시 정리
실행중인 스레드를 일정 시간 멈추게 하고 시파뎜ㄴ Thread 클래스의 정적 메서도인 sleep()을 이용하면 되ㅏ노다.
매개값에서는 얼마동안 일시 정지 상태로 있을 것이니지 밀리세컨드(1/1000)단위로 시간을 주면 된다.
```java
try {
    Thread.sleep(1000);
} catch(InterruptedException e) {
    //interrupt() 메서드가 로출되면 실행
        }
```
일시정지 상태에서는 InterruptedException이 발생할 수 있기 때문에 sleep()은 예외처리가 필요한 메서드다.


#### join() : 다른 스레드의 종료를 기다림
다른 스레드가 종료되어 그 결과값을 받아 처리하는 경우 등의 일에 join()메서드를 제공하낟.
ThreadA()가 ThreadB()의 join()메서드를 호출하면 ThreadA 는 ThreadB가 종료할 때까지 일시정지가 되었다가 
Thread B의 run() 메서드가 종료되고 나서 ThreadA 는 일시정지에서 풀려 다음 코드를 실행한다.
```java
THreadA;
threadB.start();
threadB.join();

ThreadB;
run(){
    
}
```


#### yield() : 다른 스레드에게 실행 양보
스레드를 처리하는 작업은 반복적인 실행을 위해  for문이나 whiile문을 포함하는 경우가 많은데  가끔 반복문이 무의미한 반복을 하는 경우가 있다.
다음 예제를 보면,
```java
public void run() {
    while(true) {
        if(work) {
            System.out.println("Thread  A 작업 내용");
        }
    }
}
```
work값이 false라면 whild문은 어떠한 실행문도 실행하지 않고 무의미한 반복을 한다.
이때 다른 스레드에게 실행을 양보하고 자신은 실행 대기 상태로 가는 것이 프로그램 성능에 도움이 된다.
yield()를 호출한 스레드는 실행 대기 상태로 돌아가고, 다른 스레드가 실행 상태가 된다.
```java

public void run() {
    while(true) {
        if(work) {
            System.out.println("ThreadA의 작업 내용");
        }else{
            Thread.yield();
        }
    }
}

```
