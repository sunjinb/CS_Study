import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        dp = new int[N + 1][M + 1];
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][1] = map[1][1];
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                int tmp1 = dp[i - 1][j - 1] + map[i][j];
                int tmp2 = dp[i - 1][j] + map[i][j];
                int tmp3 = dp[i][j - 1] + map[i][j];
                int max1 = Math.max(tmp1, tmp2);
                int max2 = Math.max(max1, tmp3);
                dp[i][j] = Math.max(max2, dp[i][j]);
//                System.out.println("dp[" + i + "]" + "[" + j + "] =" + dp[i][j]);
            }
        }

        System.out.println(dp[N][M]);
    }
}
