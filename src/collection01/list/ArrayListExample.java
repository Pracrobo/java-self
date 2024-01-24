package collection01.list;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {
    public static void main(String[] args) {
        List<Board> list = new ArrayList<>();

        list.add(new Board("제목1", "내용1", "글쓴이1"));
        list.add(new Board("제목2", "내용2", "글쓴이2"));
        list.add(new Board("제목3", "내용3", "글쓴이3"));
        list.add(new Board("제목4", "내용4", "글쓴이4"));
        list.add(new Board("제목5", "내용5", "글쓴이5"));

        //저장된 총 객체 수 얻기
        int size = list.size();
        System.out.println("총 객체 수 : " + size);
        System.out.println();

        Board board = list.get(2);
        System.out.println(board.getSubject() +" / " + board.getContent() + " / " + board.getWriter());
        System.out.println();


        //모든 객체 하나씩 가져오기
        for(int i = 0; i < size ; i++) {
            Board b = list.get(i);
            System.out.println(b.getSubject() +" / " + b.getContent() + " / " + b.getWriter());
        }
        System.out.println();


        list.remove(1);
        list.remove(1);
        // 1번 인덱스를 삭제 하면 2번 인덱스가 1번이 되기에 또 1번 인덱스 삭제가 가능하다

        for (Board b : list) {
            System.out.println(b.getSubject() +" / " + b.getContent() + " / " + b.getWriter());
        }
    }
}
