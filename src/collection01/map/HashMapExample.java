package collection01.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapExample {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();


        //객체 저장
        map.put("신영권", 85);
        map.put("홍길동", 90);
        map.put("동장군", 50);
        map.put("홍길동", 95);
        System.out.println("총 Entry 수 : " + map.size());
        System.out.println();


        String key = "홍길동";
        int value = map.get(key);
        System.out.println(key + ":"+ map.get("홍길동"));
        System.out.println();

        Set<String> keySet = map.keySet();
        Iterator<String> keyIterator = keySet.iterator();
        while(keyIterator.hasNext()){
            String k = keyIterator.next();
            Integer v = map.get(key);
            System.out.println( k + " : " + v);
        }
        System.out.println();


        Set<Entry<String, Integer>> entrySet = map.entrySet();
        Iterator<Entry<String, Integer>> entryIterator = entrySet.iterator();
        while(entryIterator.hasNext()){
            Entry<String, Integer> entry = entryIterator.next();
            String k = entry.getKey();
            Integer v = entry.getValue();
            System.out.println(k + ": " + v);
        }
        System.out.println();
        //키로 엔트리 삭제
        map.remove("홍길동");
        System.out.println("총 Entry  수 : " + map.size());
    }
}
