import java.util.*;
import java.io.*;

public class Main {
	static int R, C;
	static int sheepCount, wolfCount;
	static int sheepResult, wolfResult;
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
		
		map = new char[R][C];
		for(int i = 0; i < R; i++) {
			String str = br.readLine();
			for(int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		visited = new boolean[R][C];
		for(int i = 0 ; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(!visited[i][j] && map[i][j] != '#') {
					sheepCount = 0;
					wolfCount = 0;
					dfs(i, j);
					
					if(wolfCount < sheepCount) sheepResult += sheepCount;
					else wolfResult += wolfCount;
				}
			}
		}
		
		System.out.println(sheepResult + " " + wolfResult);
	}
	private static void dfs(int row, int col) {
		visited[row][col] = true;
		char value = map[row][col];
		
		if(value == 'v') wolfCount++;
		else if(value == 'k') sheepCount++;
		
		for(int i = 0; i < 4; i++) {
			int nextRow = row + dRow[i];
			int nextCol = col + dCol[i];
			
			if(nextRow < 0 || nextCol < 0 || nextRow >= R || nextCol >= C) continue;
			
			if(visited[nextRow][nextCol] || map[nextRow][nextCol] == '#') continue;
			
			dfs(nextRow, nextCol);
		}
		
	}
}