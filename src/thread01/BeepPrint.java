package thread01;

import java.awt.*;

public class BeepPrint {
    public static void main(String[] args) {
        Toolkit toolkit = Toolkit.getDefaultToolkit(); //Toolkit 객체얻기
        for(int i = 0 ; i < 5 ; i++) {
            toolkit.beep();
            try{ Thread.sleep(500);} catch (Exception e) {} // 0.5초간 일시정지
        }
        for(int i = 0; i<5 ; i++) {
            System.out.println("띵!");
        } try{ Thread.sleep(500);} catch (Exception e) {} //0.5초간 일시 정지
    }
}
// 동시에 프린팅까지 하는 작업이지만, 메인스레드는 비프음을 모두 발생한 후 프린팅을 시작한다.
// 동시에 하고 싶다면 두 작업 중 하나를 작업 스레드에서 처리하도록 해야한다.
