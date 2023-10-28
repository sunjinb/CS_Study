import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[][] dp = new long[65][10];
        for(int i = 0; i < 10; i++){
            dp[1][i] = 1;
        }

        for(int i = 2; i <= 64; i++){
            for(int j = 0; j <= 9; j++){
                for(int k = j; k <= 9; k++){
                    dp[i][j] += dp[i - 1][k];
                }
            }
        }

        int T = Integer.parseInt(br.readLine());
        for(int testCase = 1; testCase <= T; testCase++){
            int N = Integer.parseInt(br.readLine());
            long result = 0;

            for(int i = 0; i <= 9; i++){
                result += dp[N][i];
            }

            System.out.println(result);
        }
    }
}
