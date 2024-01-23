## 스레드 풀
병렬 작업 처리가 많아지면 스레드의 개수가 폭증하여  CPU 가 바빠지고 메모리 사용량이 늘어난다. 이에따라 애플리케이션의 성능 또한 급격히 저하된다. 이렇게 병렬 작업 증가로 인한 스레드의 폭증을 막으려면 Thread Pool 을 사용하는 것이 좋다.
스레드풀은 작업 처리에 사용되는 스레드를 제한된 갯수만큼 정해놓고 작업 queue에 들어오는 작업들을 스레드가 하나씩 맡아 처리하는 방식이다. 
작업처리가 끝난 스레드는 다시 작업 큐에서 새로운 작업을 가져와 처리한다. 이렇게 하면 작업량이 증가해도 스레드의 개수가 늘어나지 않아 애플리케이션의 성능이 급격히 저하되지 않는다.



### 스레드풀 생성
자바는 스레드풀을 생성하고 사용할 수 있도록 java.util.concurrent 패키지에서 ExecutorService 인터페이스와  Executors 클래스를 제공하고 있다.
 Excutors의 댜음 두 정적 메서드를 이용하면 간단하게 스레드풀인 ExecutorService 구현 객체를 만들 수 있다.

<table>
    <tr><td>메서드명(매개변수)</td> <td>초기수</td> <td>코어수</td> <td>최대 수</td></tr>
    <tr><td>newCachedThreadPool()</td> <td>0</td> <td>0</td> <td>Integer.MAX_VALUE</td></tr>
    <tr><td>newFixedThreadPool(int n Threads)</td> <td>0</td> <td>생성된 수</td> <td>nThread</td></tr>
</table>
초기수는 스레드출이 생성될 떄 기본적으로 생성되는 스레드 수를 말하고 코어수는 스레드가 증가된 후 사용되지 않는 스레드를 제거할때 최소한 풀에서 유지하는 스레드 수를 말한다. 
그리과 최대 수는 증가되는 스레드의 한도 수이다.
다음과 같이 newCachedThreadPool()메서드로 생성된 스레드풀의 초기 수와 코어 수는 0개이고 작업 개수가 많아지면 새 스레드를 생성시켜 작업을 처리한다. 60초 동안 스레드가 아무 작업을 하지 않으면 스레드를 풀에서 제거한다.

```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

ExecutorService executorService = Executors.newCachedThreadPool();
```
다음과 같이 newFixedThreadPool()로 샏ㅇ성된 스레드풀의 초기 수는 0개이고 작업 개수가 많아지면 최대 5개까지 스레드를 생성시켜 작업을 처리한다.
이 스레드풀의 특징은 생성된 스레드를 제거하지 않는다는 것이다.

```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

ExecutorService executorService = Executors.newFixedThreadPool();
```
위 두 메서드를 사용하지 않고 직접 ThreadPoolExecutor로 스레드풀을 생성할 수도 있다. 다음 예시는 초기 수 0개, 코어 수 3개, 최대 수 100개인 스레드풀을 생성하는 코드이다. 그리고 추가된 스레드가 120초 동안 놀고 있을 경우 해당 스레드를 풀에서 제거한다.

```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

ExecutorService threadPool = new ThreadPoolExecutor(
        3,                                // 코어 스레드 수
        100,                              // 최대 스레드 수
        120L,                             // 놀고 있는 시간 
        TimeUnit.SECONDS,                 // 놀고 있는 시간 단위 
        new SynchronousQueue<Runnable>()  // 직압 큐
);
```


### 스레드풀 종료
스래드풀의 스레드는 기본적으로 데몬 스레드가 아니기 때문에 main 스레드가 종료되더라도 작업을 처리하기 위해 계속 실행 상태로 남아 있다. 스레드풀의 모든 스레드를 종료하려면 ExecutorService의 다음 두 메소드 중 하나를 실행해야 한다.
<table>
    <tr><td>리턴타입</td> <td>메소드명(매개변수)</td> <td>설명</td></tr>
    <tr><td>void</td> <td>shutdown()</td> <td> 현재 처리 중인 작뿐 아니라 작업 큐에 대기하고 있는 모든 작업을 처리한 뒤에 스레드풀을 종료시킨다.</td></tr>
    <tr><td> List(Runnable) </td> <td>shutdownNow()</td> <td>현재 작업 처리 중인 스레드를 interrupt해서 작업을 중지시키고 스레드풀을 종료시킨다. 리턴값은 작업 큐에 있는 미처리된 작업(Runnnable)의 목록이다.</td></tr>
</table>
남아있는 작업을 마무리하고 스레드풀을 종료할때엔  shutdown()을 호출하고 남아있는 작업과는 상관없이 강제로 종료할 때에는 shutdownNow()를 호출하면 된다. 
ExecutorServiceExample.java의 경우 작업 생성과 처리 요청 코드가 없기 때문에 10라인을 실행하지 않아도 프로세스가 종료된다. 그 이유는 스레드풀에 생성된 스레드가 없기 때문이다.



### 작업 생성과 처리 요청
하나의 작업은 Runnable 또는 Callable 구현 클래스로 표현한다. Runnable 과 Callable의 차이점은 작업 처리 완료 후 리턴값이 있느냐 없느냐이다. 다음은 Runnable 과 Callable 구현 클래스를 작성하는 방법을 보여준다.

<table>
 <tr><td>Runnable 익명 구현 클래스 </td><td> Callable 익명 구현 클래스 </td></tr>
 <tr>
     <td> new Runnable() { @Override public void run() {// 스레드가 처리할 작업 내용 }} </td>
     <td> new Callable<T> { @Override  public T call() throws Exception { // 스래드가 처리할 작업 내용 return T; }} </td> 
</tr>
</table>

Runnalbe의 run() 메서드는 리턴값이 없고 ,  Callable의 call()메서드는 리턴값이 있다. call() 의 리턴 타입은 Callable<T>에서 지정한 T 타입 파라미터와 동일한 타입이어야 한다.
작업 처리 요청이란 ExecutorService의 작업 큐에 Runnable 또는 Callable 객체를 넣는 행위를 말한다. 작업 처리 요청을 위해 ExecutorService는 다음 두가지 메서드를 제공한다.

<table>
 <tr> <td>리턴 타입</td> <td>메소드 명(매개변수)</td> <td>설명</td> </tr>
 <tr> <td>void</td> <td>execute(Runnable command)</td> <td> - Runnable을 작업 큐에 저장<br> - 작업 처리 결과를 리턴하지 않음</td></tr>
 <tr> <td>Future<T>> </td> <td> submit(Calllable<T> task) </td> <td> - Callable을 작업 큐에 저장<br> - 작업 처리 결과를 얻을 수 있도록 Future을 리턴</td></tr>
</table>
Runnable 또는 Callable 객체가 ExecutorService의 작업 큐에 들어가면 ExecutorService는 처리할 스레드가 있는지 보고 없다면 스레드를 새로 생성시킨다. 스레드는 작업 큐에서 Runnable 또는 Callable 객체를 꺼내와 run() 또는 call() 메서드를 실행하면서 작업을 처리한다.


