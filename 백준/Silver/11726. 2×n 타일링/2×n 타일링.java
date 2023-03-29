import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static long[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		dp = new long[N + 1];
		dp[0] = 0;
		dp[1] = 1;
		
		if(N >= 2) {
			dp[2] = 2;
			for(int i = 3; i <= N; i++) {
				dp[i] =(dp[i - 2] + dp[i - 1])  % 10007;
			}	
		}
		System.out.println(dp[N]);
	}
}