import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] map;
	static int[][][] memo;
	static boolean[][][] visited;
	static int[] dRow = {0, 1, 1};
	static int[] dCol = {1, 1, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
			
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		memo = new int[N][N][3];
		visited = new boolean[N][N][3];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 1, 0);

		System.out.println(memo[0][1][0]);
	}

	private static int dfs(int row, int col, int dir) {
		if(row == N - 1 && col == N - 1) {
			memo[row][col][dir] = 1;
			return memo[row][col][dir];
			
//			return 1;
		}

		for(int d = 0; d < 3; d++) {
			if (dir - d > 1 || dir - d < -1) continue;
			
			int nextRow = row + dRow[d];
			int nextCol = col + dCol[d];
			
			if(nextRow < 0 || nextCol < 0 || nextRow >= N || nextCol >= N) continue;
			
			if(map[nextRow][nextCol] == 1) continue;
			
			if(d == 1 && (map[row + 1][col] == 1 || map[row][col + 1] == 1)) continue;
			
			if(visited[nextRow][nextCol][d]) {
				memo[row][col][dir] += memo[nextRow][nextCol][d];
			}
			else {
				visited[nextRow][nextCol][d] = true;
				memo[row][col][dir] += dfs(nextRow, nextCol, d);		
			}
		}
		
		return memo[row][col][dir];
	}
}