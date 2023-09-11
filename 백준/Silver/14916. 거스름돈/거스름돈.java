import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[100004];

        dp[0] = -1;
        dp[1] = -1;
        dp[2] = 1;
        dp[3] = -1;
        dp[4] = 2;
        dp[5] = 1;

        for(int i = 6; i <= N; i++){
            int tmpFive = Integer.MAX_VALUE;
            // 5원짜리로 거스를 수 있으면?
            if(dp[i - 5] != -1) tmpFive = dp[i - 5] + 1;

            int tmpTwo = Integer.MAX_VALUE;
            // 2원짜리로 거스를 수 있으면?
            if(dp[i - 2] != -1) tmpTwo = dp[i - 2] + 1;

            if(tmpFive != Integer.MAX_VALUE || tmpTwo != Integer.MAX_VALUE){
                dp[i] = Math.min(tmpFive, tmpTwo);
            }
            else{
                dp[i] = -1;
            }
        }

        System.out.println(dp[N]);
    }
}
