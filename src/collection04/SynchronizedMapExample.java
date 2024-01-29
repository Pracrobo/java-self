package collection04;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SynchronizedMapExample {
    public static void main(String[] args) {
        Map<Integer, String> map = Collections.synchronizedMap(new HashMap<>());

        // 작업 스레드 객체 생성
        Thread threadA = new Thread() {
            @Override
            public void run() {
                for(int i  = 1; i <= 1000l; i ++) {
                    map.put(i, "내용"+i);
                }
            }
        };


        Thread threadB = new Thread(){
            @Override
            public void run() {
                for(int i = 1001; i <= 2000; i++) {
                    map.put(i, "내용"+i);
                }
            }
      };

        threadA.start();
        threadB.start();

        try {
            threadA.join();
            threadB.join();
        }catch (Exception e) {

        }

        //저장된 총 객체 수 얻기
         int size = map.size();
        System.out.print("총 객체 수 : " + size);
        System.out.println();
    }
}
