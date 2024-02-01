# Stream 이란?
 지금까지는 컭렉션 및 배열에 저장된 요소를 반복처리하기 위해 for문 ,  iterator 를 사용해 ㅆ따ㅣ
 List 컬렉션에서 요소흫 하나씩 처리하는 for문
 ```Java
 List<String> list = ...;
for(int i = 0; i < list.size(); i++) {
    Stream item = list.get(i);
   }
 ```
Set 에서 요소를 하나씩 처리하기 위해 Iterator를 다음과 같이 사용했다.
```Java
Set<String> set = ...;
Iterator<String> iterator = set.iterator();
while(iterator.hasNext()){
    String item = iterator.next();
    // 요소처리        
}
```

Java8부터 또다른 방법으로 컬렉션 및 배열의 요소를 반복처리하기 위해 Stream을 사용할 수 있다.
스트림은 요소들이 하나씩 흘러가면서 처리된다는 의미를 가지고 있다.
List컬렉션에서 요소를 반복처리하기 위해 스트림을 사용한다면 다음과 같다.

```Java
Stream<String> stream =  list.stream();
Stream.forEach( item -> ); //item 처리  
```
List() 컬렉션의 Stream() 메소드로 Stream 객체를 얻고 forEach() 메소드로 요소를 어떻게 처리할지ㄹ를 람다식으로 제공한다.
댜음 예제는  Set 컬렉션의 요소를 하나씩 읽고 출력하기 위해 스트림을 사용한다.

Stream 과 Iterator 는 비슷한 반복자이지만 다음과 같은 차이점이 있다.
```markdown
1. 내부 반복자이므로 처리 속도가 빠르고 병렬 처리에 효율적이다.
2. 람다식으로 다양한 요소 처리를 정의할 수 있다.
3. 중간 처리와 최종 처리를 수행하도록 파이프라인을 형성할 수 있다.
```


