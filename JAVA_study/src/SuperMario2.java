import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SuperMario2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        int answer = 0;
        int diff = 100;

        for(int i = 0; i < 10; i++){
            result += Integer.parseInt(br.readLine());

            if(Math.abs(100 - result) <= diff){
                diff = Math.abs(100 - result);
                answer = result;
            }
        }
        System.out.println("answer = " + answer);
    }
}
