import java.io.*;
import java.util.*;

public class Main {
	static int w, h;
	static char[][] map;
	static int[] dRow = {-1, 1, 0, 0};
	static int[] dCol = {0, 0, -1, 1};
	static Point person;
	static boolean[][][] visited;
	static ArrayList<Point> fireList;
	static StringBuilder sb;
	static class Point{
		int row, col, depth;
		boolean isFire;
		public Point(int row, int col, boolean isFire, int depth) {
			this.row = row;
			this.col = col;
			this.isFire = isFire;
			this.depth = depth;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			fireList = new ArrayList<>();
			map = new char[h][w];
			for(int i = 0; i < h; i++) {
				String str = br.readLine();
				for(int j = 0; j < w; j++) {
					map[i][j] = str.charAt(j);
					if(map[i][j] == '@') {
						person = new Point(i, j, false, 0);
//						map[i][j] = '.';
					}
					if(map[i][j] == '*') fireList.add(new Point(i, j, true, 0));
				}
			}
			
			bfs();
		}
		System.out.println(sb);
	}
	private static void bfs() {
		Queue<Point> q = new LinkedList<>();
		visited = new boolean[h][w][2];
		
		q.add(person);
		visited[person.row][person.col][0] = true;
		
		for(Point fire : fireList) {
			q.add(fire);
			visited[fire.row][fire.col][1] = true;
		}
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			
			// 사람이라면
			if(!now.isFire) {
				// 불이 현재 자리를 먹었으면
				if(map[now.row][now.col]== '*') continue;
				for(int i = 0; i < 4; i++) {
					int nextRow = now.row + dRow[i];
					int nextCol = now.col + dCol[i];
					
					// 탈출 성공 조건
					if(nextRow < 0 || nextCol < 0 || nextRow >= h || nextCol >= w) {
						sb.append((now.depth + 1) + "\n");
						return;
					}
					
					// 벽이거나 불이거나 이미 갔던 곳이라면 못 감
					if(map[nextRow][nextCol] == '#' || map[nextRow][nextCol] == '*' || visited[nextRow][nextCol][0]) continue;
					
					// 갈 수 있는 곳이라면
					visited[nextRow][nextCol][0] = true;
					q.add(new Point(nextRow, nextCol, false, now.depth + 1));
				}
			}
			
			// 불이라면
			else {
				for(int i = 0; i < 4; i++) {
					int nextRow = now.row + dRow[i];
					int nextCol = now.col + dCol[i];
					
					// 범위 벗어나면 못 감
					if(nextRow < 0 || nextCol < 0 || nextRow >= h || nextCol >= w) continue;
					
					// 벽이거나 이미 갔던 곳이라면 못 감
					if(map[nextRow][nextCol] == '#' || visited[nextRow][nextCol][1]) continue;
					
					// 갈 수 있는 곳이라면
					visited[nextRow][nextCol][1] = true;
					map[nextRow][nextCol] = '*';
					q.add(new Point(nextRow, nextCol, true, now.depth + 1));
				}
			}
		}
		sb.append("IMPOSSIBLE" + "\n");
	}
}