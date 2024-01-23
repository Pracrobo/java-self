## Daemon Thread 데몬 스레드
 주 스레드의 작업을 돕느 보조적인 역할을 수행하는 스레드다. 주 스레드가 종료되면 데몬 스레드도 따라서 자동으로 종료된다. 
 데몬 스레드를 적용한 예로는 워드프레세서의 자동 저장, 미디어 플레이어의 동영상 및 음악 재생, 가비지 컬렉터 등이 있는데 여기서 주 스레드(워드프레세스, 미디어 플레이어, JVM)가
 종료되면 데몬 스레데ㅡ도 같이 종료된다. 스레드를 데몬으로 만들기 위해서는 주 스레드가 데몬이 될 스레드의  setDaemon(true)를 호출하면ㅇ 된다.
 
예를 보면 메인 스레드는 주 스레드, AutoSaveThread는 데몬 스레드가 된다.
```Java
public static void main(String[] args){
    AutoSaveThread thread = new AutoSaveThread();
    thread.setDaemon(true);
    thread.start();
}
```
