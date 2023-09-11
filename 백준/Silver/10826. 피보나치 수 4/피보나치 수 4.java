import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	static int N;
	static BigInteger[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		dp = new BigInteger[N + 1];
		
		dp[0] = BigInteger.valueOf(0);
		if(N == 0) {
			System.out.println(0);
			System.exit(0);
		}
		
		dp[1] = BigInteger.valueOf(1);
		
		for(int i = 2; i <= N; i++) {
			dp[i] = dp[i - 2].add(dp[i - 1]);
		}
		
		System.out.println(dp[N]);		
	}
}