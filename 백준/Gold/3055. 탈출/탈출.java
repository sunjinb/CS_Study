import java.util.*;
import java.io.*;

public class Main {
	static int R, C;
	static int result;
	static char[][] map;
	static Point animal;
	static ArrayList<Point> list;
	static int[] dRow = {-1, 1, 0, 0};
	static int[] dCol = {0, 0, -1, 1};
	static boolean[][][] visited;
	static class Point{
		int row, col, depth;
		boolean isWater;
		public Point(int row, int col, int depth, boolean isWater) {
			this.row = row;
			this.col = col;
			this.depth = depth;
			this.isWater = isWater;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		list = new ArrayList<>();
		for(int i = 0; i < R; i++) {
			String str = br.readLine();
			for(int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'S') animal = new Point(i, j, 0, false);
				if(map[i][j] == '*') list.add(new Point(i, j, 0, true));
			}
		}
		
		result = Integer.MAX_VALUE;
		bfs();
		if(result == Integer.MAX_VALUE) System.out.println("KAKTUS");
		else System.out.println(result);
	}
	private static void bfs() {
		Queue<Point> q = new LinkedList<>();
		visited = new boolean[R][C][2];
		
		
		visited[animal.row][animal.col][0] = true;
		q.add(animal);
		
		for(int i = 0; i < list.size(); i++) {
			visited[list.get(i).row][list.get(i).col][1] = true;
			q.add(list.get(i));
		}
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			
			if(now.isWater == false) {
				if(map[now.row][now.col] == 'D') {
					result = now.depth;
					break;
				}
				
				if(map[now.row][now.col] == '*') continue;
				
				for(int i = 0; i < 4; i++) {
					int nextRow = now.row + dRow[i];
					int nextCol = now.col + dCol[i];
					
					if(nextRow < 0 || nextCol < 0 || nextRow >= R || nextCol >= C) continue;
					
					if(visited[nextRow][nextCol][0] || map[nextRow][nextCol] == 'X' || map[nextRow][nextCol] == '*') continue;
					
					visited[nextRow][nextCol][0] = true;
					q.add(new Point(nextRow, nextCol, now.depth + 1, false));
				}
			}
			
			else if(now.isWater == true) {
				for(int i = 0; i < 4; i++) {
					int nextRow = now.row + dRow[i];
					int nextCol = now.col + dCol[i];
					
					if(nextRow < 0 || nextCol < 0 || nextRow >= R || nextCol >= C) continue;
					
					if(visited[nextRow][nextCol][1] || map[nextRow][nextCol] == 'X' || map[nextRow][nextCol] == 'D') continue;
					
					visited[nextRow][nextCol][1] = true;
					map[nextRow][nextCol] = '*';
					q.add(new Point(nextRow, nextCol, now.depth + 1, true));
				}
			}
			
		}
	}
}