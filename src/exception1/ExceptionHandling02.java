package exception1;

public class ExceptionHandling02 {
    public static void main(String[] args) {
        String[] array = {"100", "1oo"};

        for(int i = 0; i <= array.length; i++) {
            try{
                int value = Integer.parseInt(array[i]);
                System.out.println("array["+ i +"]: "+value);
            } catch (ArrayIndexOutOfBoundsException e){ 
                System.out.println("숫자로 변환할 수 없음 : "+ e.getMessage());
            } catch (Exception e){// 상위 예외 클래스는 아래에 작성, 순서바꾸면 안됨 java: exception java.lang.ArrayIndexOutOfBoundsException has already been caught
                System.out.println("배열 인덱스가 초과됨 "+ e.getMessage());
            }
        }
    }
}
