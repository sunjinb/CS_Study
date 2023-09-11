import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int min;
	static int[][] memo;
	static int[][] cost;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		cost = new int[N][3];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		memo = new int[N][3];
		for(int j = 0; j < 3; j++) {
			memo[0][j] = cost[0][j];
		}
		
		for(int i = 1; i < N; i++) {
			for(int j = 0; j < 3; j++) {
				if(j == 0) memo[i][j] = Math.min(memo[i - 1][1], memo[i - 1][2]) + cost[i][j];
				else if(j == 1) memo[i][j] = Math.min(memo[i - 1][0], memo[i - 1][2]) + cost[i][j];
				else if(j == 2) memo[i][j] = Math.min(memo[i - 1][0], memo[i - 1][1]) + cost[i][j];
			}
		}
		
		int result = Integer.MAX_VALUE;
		for(int j = 0; j < 3; j++) {
			if(memo[N - 1][j] < result) result = memo[N - 1][j];
		}
		
		System.out.println(result);
		
	}
}