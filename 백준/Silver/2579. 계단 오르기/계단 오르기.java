import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] dp;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		dp = new int[N];
		dp[0] = arr[0];
		
		int result = -1;
		if(N == 1) result = dp[0];
		else if(N == 2) {
			dp[1] = arr[0] + arr[1];
			result = dp[1];
		}
		else {
			dp[1] = arr[0] + arr[1];
			dp[2] = Math.max(arr[0]+arr[2], arr[1]+arr[2]);
			
			for(int i = 3; i < N; i++) {
				int visitBefore = dp[i - 3] + arr[i - 1] + arr[i];
				int unvisitBefore = dp[i - 2] + arr[i];
			
				dp[i] = Math.max(visitBefore, unvisitBefore);
			}
			result = dp[N - 1];
		}
		System.out.println(result);
	}
}