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
		st = new StringTokenizer(br.readLine());
		
		arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp = new int[N];
		
		for(int i = 0; i < N; i++) {
			dp[i] = 1;
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = i + 1; j < N; j++) {
				if(arr[i] > arr[j]) {
					dp[j] = Math.max(dp[j], dp[i] + 1);
				}
			}
		}
		
		int result = 0;
		for(int i = 0; i < N; i++) {
			result = Math.max(result, dp[i]);
		}
		
		System.out.println(result);
	}
}