import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] dp;
    static int[] path;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        dp = new int[N + 1];
        path = new int[N + 1];
        for(int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;
            path[i] = i - 1;
            if (i % 3 == 0 && dp[i / 3] + 1 < dp[i]) {
                dp[i] = dp[i / 3] + 1;
                path[i] = i / 3;
            }
            if (i % 2 == 0 && dp[i / 2] + 1 < dp[i]) {
                dp[i] = dp[i / 2] + 1;
                path[i] = i / 2;
            }
        }

        System.out.println(dp[N]);
        while(true){
            if(N < 1) break;
            sb.append(N + " ");
            N = path[N];
        }
        System.out.println(sb);
    }
}
