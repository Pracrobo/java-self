package collection01.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class VectorExample {
    public static void main(String[] args) {
        List<Board> list = new Vector<>(); // 객체수 2000개
        // List<Board> list = new ArrayList<>(); // 객체의 수 1960개로 2000개가 나오지 않는다

        Thread threadA  = new Thread() {
            @Override
            public void run() {
                for(int i = 1; i <= 1000; i++) {
                    list.add(new Board("제목"+i, "내용"+i, " 글쓴이"+i));
                };
            }
        };
        Thread threadB  = new Thread() {
            @Override
            public void run() {
                for(int i = 1001; i <= 2000; i++) {
                    list.add(new Board("제목"+i, "내용"+i, " 글쓴이"+i));
                };
            }
        };

        //작업 스레드 실행
        threadA.start();
        threadB.start();

        //작업 스레드들이 모두 종료될때까지 메인 스레드를 기다리게 함
        try {
            threadA.join();
            threadB.join();
        }catch (Exception e){

        }



        int size  = list.size();
        System.out.println("총 객체의 수 : " + size);
        System.out.println();

    }
}
