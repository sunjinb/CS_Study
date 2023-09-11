import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] arr;
	static int[] dp; // 너 지금 최대합이 얼마냐?
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
			
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		dp = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = arr[i];
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = i + 1; j < N; j++) {
				if(arr[i] < arr[j]) {
					dp[j] = Math.max(dp[j], dp[i] + arr[j]);
//					dp[j] = dp[i] + arr[j];
				}
			}
		}
		
		int result = 0;
		for(int i = 0; i < N; i++) {
			if(result < dp[i]) result = dp[i];
		}
		System.out.println(result);		
	}
}