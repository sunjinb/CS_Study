import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        char tmp = str.charAt(0);

        int result = 10;
        for(int i = 1; i < str.length(); i++){
            if(tmp == str.charAt(i)){
                result += 5;
            }
            else{
                result += 10;
                tmp = str.charAt(i);
            }
        }

        System.out.println(result);
    }
}
