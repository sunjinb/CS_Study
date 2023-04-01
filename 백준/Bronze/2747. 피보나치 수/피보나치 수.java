import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		dp = new int[N + 1];
		System.out.println(fibo(N));		
	}
	private static int fibo(int cur) {
		if(cur == 0) return 0;
		if(cur == 1) return 1;
		
		if(dp[cur] != 0) {
			return dp[cur];
		}
		
		return dp[cur] = fibo(cur - 2) + fibo(cur - 1);
	}
}
 