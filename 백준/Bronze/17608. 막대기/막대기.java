import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int H;
    static int[] arr;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new int[N];
        arr = new int[N];

        dp[N - 1] = 1;
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int max = arr[N - 1];
        for(int i = N - 2; i >= 0; i--){
            if(arr[i] > max){
                dp[i] = dp[i + 1] + 1;
                max = arr[i];
            }
            else{
                dp[i] = dp[i + 1];
            }
        }

        System.out.println(dp[0]);
    }
}
