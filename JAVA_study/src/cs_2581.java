import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class cs_2581 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        int min = Integer.MAX_VALUE;

        boolean flag;

        for (int i = M; i <= N; i++){
            flag = true;
            if(i == 1){
                flag = false;
            }
            for(int j = 2; j < i; j++){
                if(i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if(flag == true){
                if(i < min){
                    min = i;
                }
                sum += i;
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
