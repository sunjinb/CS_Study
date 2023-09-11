import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int min = Integer.MAX_VALUE;
        int sum = 0;

        for(int i = 0; i < 7; i++){
            int tmp = Integer.parseInt(br.readLine());
            if(tmp % 2 == 1){
                sum += tmp;
                if(tmp < min){
                    min = tmp;
                }
            }
        }

        if(sum == 0){
            System.out.println(-1);
        }
        else{
            System.out.println(sum);
            System.out.println(min);
        }
    }
}
