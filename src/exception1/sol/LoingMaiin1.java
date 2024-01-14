package exception1.sol;

import java.util.Scanner;

public class LoingMaiin1 {
    public static void main(String[] args) throws Exception {
        boolean run = true;

        while(run) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Id를 입력하세요: ");
            String id = scanner.nextLine();
            System.out.print("Password를 입력하세요: ");
            String password = scanner.nextLine();

            if (id.equals("blue") && password.equals("12345")) {
                System.out.println("로그인 되었습니다 ! ");
                break;
            }
            try {
                login(id, password);
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public static void login(String id, String password) throws Exception {
        //id 가 blue 가 아니라면  NotExistIDException 발생
        if(!id.equals("blue")){
            throw new NotExistIDException("Id가 존재하지 않습니다.");
        }

        if(!password.equals("12345")){
            throw new WrongPasswordException("Password 가 틀렸습니다.");
        }


    }
}
