import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] dp;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        dp = new int[N + 1][N + 1];
        arr = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + arr[i][j];
            }
        }
        int result = 0;
        for (int i = 1; i <= N; i++) {
            if (result < dp[N][i]) result = dp[N][i];
        }

        System.out.println(result);
    }
}