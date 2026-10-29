package day_6.exceptionss;
import java.io.FileReader;
import java.io.IOException;

public class Throwss {
    static void readFile() throws IOException {
        FileReader reader = new FileReader("MultipleTryCarch.java");
        reader.close();
    }

    public static void main(String[] args) {
        try {
            funnct();
        }
        catch(IOException){
            System.out.println(e);
        }
    }
}
