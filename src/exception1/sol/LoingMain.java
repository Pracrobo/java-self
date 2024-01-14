package exception1.sol;

import java.util.Scanner;

public class LoingMain {
    public static void main(String[] args) {

        try {
            login("white", "12345");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        try {
            login("blue", "54321");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
    public static void login(String id, String password) throws Exception {
        //id 가 blue 가 아니라면  NotExistIDException 발생
        if(!id.equals("blue")){
            throw new NotExistIDException("Id가 존재하지 않습니다.");
        }
        //pass 가 12345 가 아니라면 WrongPasswordException 발생
        if(!password.equals("12345")){
            throw new WrongPasswordException("password가 틀렸습니다.");
        }
    }
}
