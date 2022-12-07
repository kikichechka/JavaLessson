
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class lesson1 {
    public static void main(String[] args) {
        writerFile();
    }

    static String readFile(){
        double a = 0.0;
        double b = 0.0;
        try{
            BufferedReader br = new BufferedReader(new FileReader("input.txt"));
            String str;
            while((str = br.readLine()) != null){
                String[] equal = str.split(" ");
                switch (equal[0]) {
                    case "a":
                        a = Integer.parseInt(equal[1]);
                        break;
                    case "b":
                        b = Integer.parseInt(equal[1]);
                        break;
                }
            }
            br.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        if (a == 0.0 && b == 0.0){
            String st = "Не определено";
            return st;
        } else { 
            return Double.toString(Math.pow(a, b));
        }
    }

    static void writerFile() {
        try (FileWriter fw = new FileWriter("output.txt", false)) {
            fw.write(readFile());;
            fw.flush();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
