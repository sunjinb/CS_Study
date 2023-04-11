import java.io.*;
import java.util.*;

public class Main {
	static int H, W;
	static char[][] map;
	static boolean[][] visited;
	static int[] dRow = {-1, 1, 0, 0};
	static int[] dCol = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        for(int testCase = 1; testCase <= T; testCase++) {
        	st = new StringTokenizer(br.readLine());
        	H = Integer.parseInt(st.nextToken());
        	W = Integer.parseInt(st.nextToken());
        	
        	map = new char[H][W];
        	for(int i = 0; i < H; i++) {
        		String str = br.readLine();
        		for(int j = 0; j < W; j++) {
        			map[i][j] = str.charAt(j);
        		}
        	}
        	
        	int count = 0;
        	visited = new boolean[H][W];
        	for(int i = 0; i < H; i++) {
        		for(int j = 0; j < W; j++) {
        			if(map[i][j] == '#' && !visited[i][j]) {
        				dfs(i, j);
        				count++;
        			}
        		}
        	}
        	System.out.println(count);
        }
    }
	private static void dfs(int row, int col) {
		visited[row][col] = true;
		
		for(int i = 0; i < 4; i++) {
			int nextRow = row + dRow[i];
			int nextCol = col + dCol[i];
			
			if(nextRow < 0 || nextCol < 0 || nextRow >= H || nextCol >= W) continue;
			
			if(visited[nextRow][nextCol]) continue;
			
			if(map[nextRow][nextCol] == '#') {
				dfs(nextRow, nextCol);
			}
		}
	}
}