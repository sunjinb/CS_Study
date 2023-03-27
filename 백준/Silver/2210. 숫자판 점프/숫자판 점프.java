import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static char[][] map;
	static Set<String> set;
	static int[] dRow = {-1, 1, 0, 0};
	static int[] dCol = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = 5;
		map = new char[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = st.nextToken().charAt(0);
			}
		}

		set = new HashSet<>();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				String s = "";
				dfs(i, j, s + map[i][j]);
			}
		}
		
		System.out.println(set.size());
	}
	
	private static void dfs(int row, int col, String str) {
		if(str.length() == 6) {
			set.add(str);
			return;
		}
	
		for(int i = 0; i < 4; i++) {
			int nextRow = row + dRow[i];
			int nextCol = col + dCol[i];
			
			if(nextRow < 0 || nextCol < 0 || nextRow >= N || nextCol >= N) continue;
			
			dfs(nextRow, nextCol, str + map[nextRow][nextCol]);
		}
		
	}
}