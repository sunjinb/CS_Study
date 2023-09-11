import java.io.*;
import java.util.*;

public class Main {
	static int K;
	static int W, H;
	static int[][] map;
	static boolean[][][] visited;
	static int[] dRow = {-1, 1, 0, 0};
	static int[] dCol = {0, 0, -1, 1};
	static int[] jRow = {-2, -2, -1, -1, 1, 1, 2, 2};
	static int[] jCol = {-1, 1, -2, 2, -2, 2, -1, 1};
	static class Point{
		int row, col, depth, jumpCount;
		public Point(int row, int col, int depth, int jumpCount) {
			this.row = row;
			this.col = col;
			this.depth = depth;
			this.jumpCount = jumpCount;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
			
		K = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H][W];
		for(int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int result = -1;
		visited = new boolean[H][W][K + 1];
		Queue<Point> q = new LinkedList<>();
		visited[0][0][0] = true;
		q.add(new Point(0, 0, 0, 0));
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			
			if(now.row == H - 1 && now.col == W - 1) {
				result = now.depth;
				break;
			}
			
			if(now.jumpCount < K) {
				for(int i = 0; i < 8; i++) {
					int nextRow = now.row + jRow[i];
					int nextCol = now.col + jCol[i];
					
					if(nextRow < 0 || nextCol < 0 || nextRow >= H || nextCol >= W) continue;
					
					if(visited[nextRow][nextCol][now.jumpCount + 1] || map[nextRow][nextCol] == 1) continue;
					
					visited[nextRow][nextCol][now.jumpCount + 1] = true;
					q.add(new Point(nextRow, nextCol, now.depth + 1, now.jumpCount + 1));
				}
			}
			
			for(int i = 0; i < 4; i++) {
				int nextRow = now.row + dRow[i];
				int nextCol = now.col + dCol[i];
				
				if(nextRow < 0 || nextCol < 0 || nextRow >= H || nextCol >= W) continue;
				
				if(visited[nextRow][nextCol][now.jumpCount] || map[nextRow][nextCol] == 1) continue;
				
				visited[nextRow][nextCol][now.jumpCount] = true;
				q.add(new Point(nextRow, nextCol, now.depth + 1, now.jumpCount));
			}
		}
		System.out.println(result);
	}
}