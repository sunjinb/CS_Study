import java.util.*;
import java.io.*;

public class Main {
	static int R, C, K;
	static int count;
	static char[][] map;
	static boolean[][] visited;
	static int[] dRow = {-1, 1, 0, 0};
	static int[] dCol = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		for(int i = 0; i < R; i++) {
			String str = br.readLine();
			for(int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		visited = new boolean[R][C];
		visited[R - 1][0] = true;
		dfs(R - 1, 0, 1);
		System.out.println(count);
	}
	private static void dfs(int row, int col, int depth) {
		if(row == 0 && col == C - 1) {
			if(depth == K) count++;
			return;
		}
//		System.out.println("row : " + row + " col " + col + " depth : " + depth);
		for(int i = 0; i < 4; i++) {
			int nextRow = row + dRow[i];
			int nextCol = col + dCol[i];
			
			if(nextRow < 0 || nextCol < 0 || nextRow >= R || nextCol >= C) continue;
			
			if(!visited[nextRow][nextCol] && map[nextRow][nextCol] == '.') {
				visited[nextRow][nextCol] = true;
				dfs(nextRow, nextCol, depth + 1);
				visited[nextRow][nextCol] = false;
			}
		}
	}
}