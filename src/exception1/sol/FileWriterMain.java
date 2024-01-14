package exception1.sol;

import javax.imageio.IIOException;
import java.io.IOException;

public class FileWriterMain {
    public static void main(String[] args) throws Exception{
        try(FileWriter fw = new FileWriter("file.txt")){
            fw.write("Java");
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}
