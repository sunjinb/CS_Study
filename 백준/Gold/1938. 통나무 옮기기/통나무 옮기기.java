import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] map;
	static boolean[][][] visited;
	static int[] dRow = {-1, 1, 0, 0, 0};
	static int[] dCol = {0, 0, -1, 1, 0};
	static class Point{
		int row, col, depth;
		boolean dir;
		// true -> 가로, false -> 세로
		public Point(int row, int col, boolean dir, int depth) {
			this.row = row;
			this.col = col;
			this.dir = dir;
			this.depth = depth;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		int startTreeOrder = 0;
		int endTreeOrder = 0;
		
		
		Point startTree = null;
		Point endTree = null;
		
//		true : 가로 / 방문배열 0
//		false : 세로 / 방문배열 1
		visited = new boolean[N][N][2];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			int tmpStartTreeCount = 0;
			int tmpEndTreeCount = 0;
			for(int j = 0; j < N; j++) {
				char input = str.charAt(j);
				
				if(input == 'B') {
					tmpStartTreeCount++;
					startTreeOrder++;
					// 나무 중앙지점이라면
					if(startTreeOrder == 2) {
						// 가로녀석이라면
						if(tmpStartTreeCount == 2) {
							startTree = new Point(i, j, true, 0);
							visited[i][j][0] = true;
						}
						// 세로 녀석이라면
						else {
							startTree = new Point(i, j, false, 0);
							visited[i][j][1] = true;
						}
					}
					map[i][j] = 0;
				}
				
				else if(input == 'E') {
					tmpEndTreeCount++;
					endTreeOrder++;
					// 나무 중앙지점이라면
					if(endTreeOrder == 2) {
						// 가로녀석이라면
						if(tmpEndTreeCount == 2) {
							endTree = new Point(i, j, true, 0);
						}
						// 세로 녀석이라면
						else {
							endTree = new Point(i, j, false, 0);
						}
					}
					map[i][j] = 0;
				}
				
				else {
					if(input == '0') map[i][j] = 0;
					else if(input == '1') map[i][j] = 1;
				}
			}
		}
		
//		true : 가로 / 방문배열 0
//		false : 세로 / 방문배열 1
		Queue<Point> q = new LinkedList<>();
		q.add(startTree);
		
		int result = 0;
		while(!q.isEmpty()) {
			Point now = q.poll();
			// 목적지 도달 방향도 맞아야함
			if(now.row == endTree.row && now.col == endTree.col && now.dir == endTree.dir) {
				result = now.depth;
				break;
			}
			
			for(int order = 0; order < 5; order++) {
				int nextRow = now.row + dRow[order];
				int nextCol = now.col + dCol[order];
				
				boolean nextDir = now.dir;

				// 중앙지점은 강사리를 갈 수 없으니
				if(order == 4) {
					nextDir = !nextDir;
					if(nextRow < 1 || nextCol < 1 || nextRow >= N - 1 || nextCol >= N - 1) continue;
				}

				// 가로 녀석이면
				if(nextDir) {
					if(nextRow < 0 || nextCol < 1 || nextRow >= N || nextCol >= N - 1) continue;
				}
				// 세로 녀석이면
				else {
					if(nextRow < 1 || nextCol < 0 || nextRow >= N - 1 || nextCol >= N) continue;
				}
				
				// 기둥 처리
				boolean canMove = true;
				if(nextDir) {
					for(int i = nextCol - 1; i <= nextCol + 1; i++) {
						if(map[nextRow][i] == 1) canMove = false;
					}
				}
				else {
					for(int i = nextRow - 1; i <= nextRow + 1; i++) {
						if(map[i][nextCol] == 1) canMove = false;
					}
				}
				
				if(order == 4) {
					for(int i = nextRow - 1; i <= nextRow + 1; i++) {
						for(int j = nextCol - 1; j <= nextCol + 1; j++) {
							if(map[i][j] == 1) canMove = false;
						}
					}
				}
				
				// 기둥에 막혀 못 간다면
				if(!canMove) continue;
				
				// 다음 가볼 녀석이 가로 녀석이라면
				if(nextDir) {
					if(visited[nextRow][nextCol][0]) continue;
					visited[nextRow][nextCol][0] = true;
					q.add(new Point(nextRow, nextCol, nextDir, now.depth + 1));
				}
				// 다음 가볼 녀석이 세로 녀석이라면
				else {
					if(visited[nextRow][nextCol][1]) continue;
					visited[nextRow][nextCol][1] = true;
					q.add(new Point(nextRow, nextCol, nextDir, now.depth + 1));
				}
			}
		}
		
		System.out.println(result);
	}
}
