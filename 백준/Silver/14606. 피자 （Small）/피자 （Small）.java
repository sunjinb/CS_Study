import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[11];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 3;

        for(int i = 4; i <= N; i++){
            for(int j = i - 1; j >= i / 2; j--){
                dp[i] = Math.max(dp[i], (j * (i - j)) + dp[j] + dp[i - j]);
            }
        }

        System.out.println(dp[N]);
    }
}