#  수정할 수 없는 컬렉션
unmodifiable 수정할 수 없는 컬렉션이란 요소를 추가, 삭제할 수 없는 컬렉션을 말한다. 
컬렉션 생성시 저장된 요소를 변경하고 싶지 않을 때 유용하다. 여러가지 방법으로 만들 수 있는데 먼저 첫번째 방법으로는 List, Set, Map 인터페이스의 정적메소드인 of() 로 생성할 수 있다.

```java
import java.util.List;
import java.util.Map;
import java.util.Set;

List<E> immutableList = List.of(E...element);
Set<E> immutableSet = Set.of(E...element);
Map<K, V> immutableMap = Map.of(K k1, V v1, K k2, V v2, ....);

```
두번째 방법은 List, Set, Map 인터페이스의 정적 메소드인 copyOf() 을 이용해 기존 컬렉션을 복사하여 수정할 수 없는 컬렉션을 만드는 것이다.

```java
import java.util.List;
import java.util.Map;
import java.util.Set;

List<E> immutableList = List.copyOf(Collection < E > coll);
Set<E> immutableSet = Set.copyOf(Collection < E > coll);
Map<K, V> immutableMap = Map.copyOf(Map(K, V)map);
```
세번째 방법은 배열로부터 수정할 수 없는 List 컬레션을 만들 수 있다.

```java
import java.util.Arrays;

String[] arr = {"A"."B"."C"};
List<String> immutableList = Arrays.asList(arr);
```

