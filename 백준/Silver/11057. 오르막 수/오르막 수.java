import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1][10];

        // 1자리 수일때는 모두 오르막수
        for(int i = 0; i < 10; i++){
            dp[1][i] = 1;
        }

        // 자리 수
        for(int i = 2; i <= N; i++){
            // 마지막 자리 숫자
            for(int j = 0; j < 10; j++){
                for(int k = 0; k <= j; k++){
                    dp[i][j] = (dp[i][j] + dp[i - 1][k]) % 10007;
                }
            }
        }

        int result = 0;
        for(int i = 0; i < 10; i++){
            result += dp[N][i] % 10007;
        }

        System.out.println(result % 10007);
    }
}