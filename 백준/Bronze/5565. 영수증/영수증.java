import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = Integer.parseInt(br.readLine());

        for(int i = 0; i < 9; i++){
            int tmp = Integer.parseInt(br.readLine());
            sum -= tmp;
        }

        System.out.println(sum);
    }
}
