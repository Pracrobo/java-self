# Map Collection
Key 와 Value 로 구성된 Entry 객체를 저장한다. 여기서 키와 값은 모두 객체이다. 키는 중복 저장할 수 없지만 값은 중복 저장할 수 있다. 기존에 저장된 키와 동일한 키로 값을 저장하면 기존의 값은 없어지교 새로운 값으로 대치된다.
<br><br>
![img.png](img.png)
<br><br>
Map 컬레션에는 HashMap, Hashtable, LinkedHashMap, Properties, TreeMap 등이 있다.
Map 컬렉션에서 공통적으로 사용가능한 Map 인터페이스 메소드는 다음과 같다. 키로 객체들을 관리하기 때문에 키를 매개값으로 갖는 메소드가 많다.
<br><br>
![img_1.png](img_1.png)
<br><br>
K, V 타입 파라미터가 있는데 K는 키타입, V는 값타입을 말한다.

## HashMap
키로 사용할 객체가 hashCode() 메소드의 리턴값과 같고 equals() 메소드가 true를 리턴할 경우. 동일 키로 보고 중복 저장을 허용하지 않는다.
<br><br>
![img_2.png](img_2.png)
<br><br>
다음은 HashMap 컬렉션을 생성하는 방법이다. K와  V는 각각 키와  값의 타입을 지정할 수 있는 타입 파라미터이다.

```java
import java.util.HashMap;

Map<String, Integer> map = new HashMap<String, Integer>();
Map<String, Integer> map = new HashMap<>();
```
Map에 지정된 키와 값의 타입이  HashMap과 동일할 경우 HashMap<>을 사용할 수 있다.

```java
Map map = new HashMap();
```


## HashTable

HasMap과 동일한 내부구조를 가지고 있다. 차이점은 Hashtable 은 동기화된(synchronize) 메소드로 구성되어 있기 때문에 멀티 스레드가 동시에 Hashtable의 메소드들을 실행할 수 없다는 것이다.
땨라서 멀티 스레드 환경에서도 안전하게 객체를 추가, 삭제할 수 있다.

![img_4.png](img_4.png)
![img_3.png](img_3.png)


