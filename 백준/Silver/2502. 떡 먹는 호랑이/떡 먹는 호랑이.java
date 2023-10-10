import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int D, K;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        D = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dp = new int[D + 1];
        int result1 = 0;
        int result2 = 0;
        L:for(int i = 1; i <= K / 2; i++){
            for(int j = i + 1; j <= K; j++){
                dp[1] = i;
                dp[2] = j;
                for(int k = 3; k <= D; k++){
                    dp[k] = dp[k - 2] + dp[k - 1];
                }
                if(dp[D] == K){
                    result1 = i;
                    result2 = j;
                    break L;
                }
            }
        }

        System.out.println(result1);
        System.out.println(result2);
    }
}
