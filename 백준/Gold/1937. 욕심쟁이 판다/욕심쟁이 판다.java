import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int result;
	static int[][] map;
	static int[][] memo;
	static boolean[][] visited;
	static int[] dRow = {-1, 1, 0, 0};
	static int[] dCol = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		memo = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		result = -1;
		visited = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				int tmpResult = dfs(i, j);
				if(result < tmpResult) result = tmpResult;
			}
		}
		
		System.out.println(result);
	}
	private static int dfs(int row, int col) {
		
		if(visited[row][col]) {
			return memo[row][col];
		}
		
		visited[row][col] = true;
		
		boolean flag = false;
		
		for(int i = 0; i < 4; i++) {
			int nextRow = row + dRow[i];
			int nextCol = col + dCol[i];
			
			if(nextRow < 0 || nextCol < 0 || nextRow >= N || nextCol >= N) continue;
			
			if(map[row][col] < map[nextRow][nextCol]) {
				flag = true;
				
				// 방문 했든 안 했든 어차피 갔다 오면 1이나 그 자리 값이니까 조건 걸 필요가 없음
				int nextValue = dfs(nextRow, nextCol);
				if(memo[row][col] < nextValue + 1) memo[row][col] = nextValue + 1;
			}
		}
		
		// 갈 수 있는 곳이 없어요
		if(!flag) memo[row][col] =  1;
		
		return memo[row][col];
	}
}