import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static long[][] dp; // 너 숫자개수별 합 몇개씩 갖고 있냐?
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        dp = new long[1004][1004];
        
        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 2;
        dp[3][3] = 1;
        
        for(int i = 4; i <= 1000; i++) {
        	for(int j = 1; j <= i; j++) {
    			dp[i][j] = (dp[i - 1][j - 1] + dp[i - 2][j - 1] + dp[i - 3][j - 1]) % 1000000009;
    		}
        }
        
        int T = Integer.parseInt(br.readLine());
        for(int testCase = 1; testCase <= T; testCase++) {
        	st = new StringTokenizer(br.readLine());
        	N = Integer.parseInt(st.nextToken());
        	M = Integer.parseInt(st.nextToken());
        	
        	System.out.println(dp[N][M]);
        }

    }
}