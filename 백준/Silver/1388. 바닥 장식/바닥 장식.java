import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static char[][] map;
	static boolean[][] visited;
	static int[] d = {-1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		int count = 0;
		visited = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(visited[i][j] == false) {
					dfs(i, j);
					count++;
				}
			}
		}
		
		System.out.println(count);
		
	}
	private static void dfs(int row, int col) {
		visited[row][col] = true;
		
		// -일 경우 가로만을 탐색
		if(map[row][col] == '-') {
			for(int i = 0; i < 2; i++) {
				int nextRow = row;
				int nextCol = col + d[i];
				
				if(nextRow < 0 || nextCol < 0 || nextRow >= N || nextCol >= M) continue;
				
				if(map[nextRow][nextCol] == '-' && !visited[nextRow][nextCol]) {
					dfs(nextRow, nextCol);
				}
			}
		}
		
		// |일 경우 세로만을 탐색
		else if(map[row][col] == '|') {
			for(int i = 0; i < 2; i++) {
				int nextRow = row + d[i];
				int nextCol = col;
				
				if(nextRow < 0 || nextCol < 0 || nextRow >= N || nextCol >= M) continue;
				
				if(map[nextRow][nextCol] == '|' && !visited[nextRow][nextCol]) {
					dfs(nextRow, nextCol);
				}
			}
		}
	}
}