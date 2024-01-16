<h1>Thread 개념</h1>

### 프로세스 vs  스레드의 개념 차이
- 프로세스 : 하나 이상의 스레드를 가지는 연산 등의 작업, OS의 관리의 단위
  - 흐름: 하나의 flow , context라고 한다.
  - 스레드가 N개 존재하는 것은 각자 작동할 수도, 동시에 작동할 수도 있다.
  - 멀티 프로세스 : 프로그램  단위의 멀티 태스킹,  싱글 스레드 N개 , 멀티 스레드 M개가 존재할 수 있다.
- 스레드 : 코드의 실행 흐름
    - 멀티 스레드 : 코드의 실행 흐름이 여러 개인 것

### 멀티 프로세스
- 서로 독립적이다.
- 하나의 프로세스에서 오류가 발생해도 다른 프로세스에게 영향을 미치지 않는다.
- ex) 워드와 엑셀
- vs) 멀티 스레드 : 메신저에서 채팅기능이 먹통이면 파일 기능도 먹통이다.


### 멀티 스레드
- 데이터를 분할해서 병렬로 처리하는 곳에서 사용하기도 하고
- 안드로이드 앱에서 네트워크 통신을 하기위해 사용하기도 한다
- 다수의 클라이언트 요청을 처리하는 서버를 개발할때도 사용한다.
- 예외처리에 조심해야한다.
- 실행중인 스레드가 하나라도 있다면 프로세스는 종료되지 않는다.
- 메인 스레드가 작업 스레드보다 먼저 종료되더라도 작업스레드가 실행중이면 프로세스는 종료되지 않는다.


1. 작업 스레드 생성과 실행
: 멀티 스레드로 실행하는 프로그램을 개발하려면 몇개의 작업을 병렬로 실행할지 경정하고 각 작업별로 스레드를 생성해야 한다.

ex) 메인스레드에서 메인작업과 프로그램 시작 / 작업1에서 스레드1을 생성하고 네트워킹을 함 / 작업 2에서 스레드 2를 생성하고 드로잉을 함

<br>

1-1. Thread 클래스로 직접 생성
java.lang 패키지에 있는 Thread 클래스로부터 작업 스레드 객체를 직접 생성하려면 Runnable 구현 객체를 매개값으로 갖는 생성자를 호출하면 된다.
```java
Thread  thread = new Thread(Runnable target);
```
Runnable은 스레드가 작업을 실행할때 사용하는 인터페이스다.
Runnable에서 run()메서드가 정의되어 있는데 구현 클래스는 run()을 재정의해서 스레드가 실행할 코드르 가지고 있어야한다.
```java
class Task implements  Runnable{
    @Override
    public void run() {
        
    }
}
```


Runnable구현 클래스는 작업내용을 정의한 것으로 스레드에게 전달해야 한다.
Runnable 구현 객체를 생성한 후 Thread 생성자 매개값으로 Runnable 객체를 다음 같이 전달하면 된다.
```java
Runnable task = new Task();
Thread thread = new Thread(task);
```

명시적인 Runnable 구현 클래스를 작성하지 않고 Thread 생성자를 호출할 때 Runnable 익명 구현 객체를 매개값으로 사용할 수 있다. <br>이 방법이 많이 쓰인다.

```java
Thread thread = new Thread(new Runnable) {
    @Override
    public void run(){
        
    }
}
```

작업 스레드를 실행하려면 스레드 객체의 start()메서드를 호출해야 한다.
start() 메서드가 호출되면, 작업 스레드는 매개값으로 받은 Runnable 의 run() 메서드를 실행하면서 작업한다. 

예제로 BeepPrint.java 클래스를 보자.
<br>

1-2. Thread 자식 클래스로 생성
작업스레드 객체를 생성하는 또다른 방법은 Thread의 자식 객체로 만드는 것이다. Thread 클래스를 상속한 다음 run() 메서드를 재정의해서 스레드가 실행할 코드를 작성하고 객체를 생성하면 된다.
```java
public class WorkerThread extends Thread {
    @Override
    public void run() {
        //스레드가 실행할 코드
        
    }
}
//스레드 객체 생성
Thread thread = new WorkerThread();
```
실행은 thread.start(); 하면된다.
