import java.io.*;
import java.util.*;

public class Main {
	static int M, N;
	static boolean flag;
	static boolean[][] visited;
	static int[][] map;
	static int[] dRow = {-1, 1, 0, 0};
	static int[] dCol = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
		for(int i = 0; i < M; i++) {
			String str = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		flag = false;
		visited = new boolean[M][N];
		for(int i = 0; i < N; i++) {
			if(map[0][i] == 0 && !visited[0][i]) {
				dfs(0, i);
				if(flag) break;
			}
		}
		
		if(flag) System.out.println("YES");
		else System.out.println("NO");
	}
	
	private static void dfs(int row, int col) {
		
//		System.out.println("row : " + row + " col : " + col);
		visited[row][col] = true;
		
		if(row == M - 1) {
			flag = true;
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			int nextRow = row + dRow[i];
			int nextCol = col + dCol[i];
			
			if(nextRow < 0 || nextCol < 0 || nextRow >= M || nextCol >= N) continue;
			
			if(!visited[nextRow][nextCol] && map[nextRow][nextCol] == 0) {
				dfs(nextRow, nextCol);
			}
			
		}
	}
}