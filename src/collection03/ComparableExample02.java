package collection03;

import java.util.TreeSet;

public class ComparableExample02 {
    public static void main(String[] args) {
        TreeSet<Fruit> treeset = new TreeSet<Fruit>(new FruitComparator());

        treeset.add(new Fruit("포도", 3000));
        treeset.add(new Fruit("수박", 10000));
        treeset.add(new Fruit("딸기", 6000));

        for(Fruit fruit : treeset){
            System.out.println(fruit.name + ":"  + fruit.price);
        }
    }
}
