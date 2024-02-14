package ioStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteExample03 {
    public static void main(String[] args) {
        try {
            OutputStream os = new FileOutputStream("D:/Test/test2.db");

            byte[] array = {10, 20, 30, 40, 50};

            os.write(array, 1,3); // 1번 인덱스부터 3번까지 출력
            os.flush();
            os.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
