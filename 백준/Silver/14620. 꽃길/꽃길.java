import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int min;
	static int[][] map;
	static boolean[][] visited;
	static int[] dRow = {-1, 1, 0, 0};
	static int[] dCol = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		min = Integer.MAX_VALUE;
		dfs(0, 0);
		System.out.println(min);
	}
	
	private static void dfs(int depth, int sum) {
		if(depth == 3) {
			min = Math.min(min, sum);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(isPossible(i, j)) {
					int tmpCost = calCost(i, j);
					visitProcess(i, j, true);
					dfs(depth + 1, sum + tmpCost);
					visitProcess(i, j, false);
				}
			}
		}
		
	}

	private static void visitProcess(int row, int col, boolean flag) {
		visited[row][col] = flag;
		
		for(int i = 0; i < 4; i++) {
			visited[row + dRow[i]][col + dCol[i]] = flag;
		}
	}

	private static int calCost(int row, int col) {
		int sum = map[row][col];
		
		for(int i = 0; i < 4; i++) {
			sum += map[row + dRow[i]][col + dCol[i]];
		}
		
		return sum;
	}

	private static boolean isPossible(int row, int col) {
		boolean flag = true;
		
		if(visited[row][col]) flag = false;
		
		for(int i = 0; i < 4; i++) {
			int nextRow = row + dRow[i];
			int nextCol = col + dCol[i];
			
			if(nextRow < 0 || nextCol < 0 || nextRow >= N || nextCol >= N || visited[nextRow][nextCol]) {
				flag = false;
				break;
			}
		}
		
		return flag;
	}
}
