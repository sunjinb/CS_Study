import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static boolean[][] relation;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		relation = new boolean[N][N];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			relation[from - 1][to - 1] = true;
		}
		
		for(int k = 0; k < N; k++) {
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(relation[i][k] && relation[k][j] && i != j) {
						relation[i][j] = true;
					}
				}
			}
		}
		
		int result = 0;
		for(int i = 0; i < N; i++) {
			int count = 0;
			for(int j = 0; j < N; j++) {
				if(relation[i][j] || relation[j][i]) {
					count++;
				}
			}
			if(count >= N - 1) {
				result++;
			}
		}
		System.out.println(result);
	}

}
