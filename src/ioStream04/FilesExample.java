package ioStream04;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesExample {
    public static void main(String[] args) {
        try{
            String data = "" + "id: winter\n" + "email: winter@mycompany.com\n" + "tel: 010-123-3456";

            Path path  = Paths.get("D:/Test/user.txt");

            Files.writeString(Paths.get("D:/Test/user.txt"), data, Charset.forName("UTF-8"));

            System.out.println("퍄일 유형 : " + Files.probeContentType(path));
            System.out.println("파일 크기 : " + Files.size(path) + "bytes");

            String content = Files.readString(path, Charset.forName("UTF-8"));
            System.out.println(content);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
