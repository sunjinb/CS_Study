import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int maxDepth, maxValue;
	static int[][] map;
	static boolean[][] visited;
	static int[] dRow = {-1, 1, 0, 0};
	static int[] dCol = {0, 0, -1, 1};
	static class Point{
		int row, col, depth;
		public Point(int row, int col, int depth) {
			this.row = row;
			this.col = col;
			this.depth = depth;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int resultDepth = -1;
		int resultValue = -1;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] != 0) {
					int startValue = map[i][j];
					int[] tmpAns = bfs(i, j);
					if(resultDepth < tmpAns[0]) {
						resultDepth = tmpAns[0];
						resultValue = tmpAns[1] + startValue;
					}
					else if(resultDepth == tmpAns[0]) {
						if(resultValue < tmpAns[1] + startValue) {
							resultValue = tmpAns[1] + startValue;
						}
					}
//					System.out.println("row : " + i + " col : " + j);
//					System.out.println(Arrays.toString(tmpAns));
//					System.out.println("rD : " + resultDepth + " rV : " + resultValue);
				}
			}
		}
		
		System.out.println(resultValue);
	}
	private static int[] bfs(int row, int col) {
		Queue<Point> q = new LinkedList<>();
		visited = new boolean[N][M];
		
		q.add(new Point(row, col, 0));
		visited[row][col] = true;
		
		maxDepth = -1;
		maxValue = -1;
		while(!q.isEmpty()) {
			Point now = q.poll();
			
			if(maxDepth < now.depth) {
				maxDepth = now.depth;
				maxValue = map[now.row][now.col];
			}
			else if(maxDepth == now.depth) {
				if(maxValue < map[now.row][now.col]) {
					maxValue = map[now.row][now.col];
				}
			}
			
			for(int i = 0; i < 4; i++) {
				int nextRow = now.row + dRow[i];
				int nextCol = now.col + dCol[i];
				
				if(nextRow < 0 || nextCol < 0 || nextRow >= N || nextCol >= M) continue;
				
				if(visited[nextRow][nextCol] || map[nextRow][nextCol] == 0) continue;
				
				visited[nextRow][nextCol] = true;
				q.add(new Point(nextRow, nextCol, now.depth + 1));
			}
		}
		
		int[] result = new int[2];
		result[0] = maxDepth;
		result[1] = maxValue;
		return result;
	}
}