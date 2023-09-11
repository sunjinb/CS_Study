import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] arr;
	static int[] dp; // 이 날까지 최대 얼마의 일을 할 수 있는지
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1][2];
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		
		dp = new int[N + 7];
		
		for(int i = 1; i <= N; i++) {
			dp[i] = Math.max(dp[i], dp[i - 1]);
			int nextTime = i + arr[i][0];
			dp[nextTime] = Math.max(dp[nextTime], dp[i] + arr[i][1]); 
		} 
		
		int result = 0;
		for(int i = 1; i <= N + 1; i++) {
			if(result < dp[i]) result = dp[i];
		}
		
		System.out.println(result);
	}
}