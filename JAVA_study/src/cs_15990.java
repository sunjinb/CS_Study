import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class cs_15990 {
    static int N;
    static int[][] dp; // 너 마지막으로 끝나는 숫자 몇 개 갖고 있냐?
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        dp = new int[100004][4];
        dp[1][1] = 1;
        dp[1][2] = 0;
        dp[1][3] = 0;

        dp[2][1] = 0;
        dp[2][2] = 1;
        dp[2][3] = 0;

        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for(int i = 4; i <= 100000; i++){
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % 1000000009;
            dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % 1000000009;
            dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % 1000000009;
        }

        for(int testCase = 1; testCase <= T; testCase++){
            N = Integer.parseInt(br.readLine());
            int result = 0;
            for(int i = 1; i <= 3; i++){
                result = (result + dp[N][i]) % 1000000009;
            }
            System.out.println(result);
        }
    }
}
