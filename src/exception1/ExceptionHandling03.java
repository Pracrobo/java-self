package exception1;

public class ExceptionHandling03 {
    public static void main(String[] args) {
        String[] array = {"100", "1oo", null, "200"};

        for(int i = 0; i <= array.length; i++) {
            try{
                int value = Integer.parseInt(array[i]);
                System.out.println("array["+ i +"]: "+value);
            } catch (ArrayIndexOutOfBoundsException e){ 
                System.out.println("숫자로 변환할 수 없음 : "+ e.getMessage());
            } catch (NullPointerException | NumberFormatException e){// 두가지 에러 동일 처리 |
                System.out.println("데이터에 문제가 있음 "+ e.getMessage());
            }
        }
    }
}
