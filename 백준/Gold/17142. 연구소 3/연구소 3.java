import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int min, zeroCount, tmp;
	static int[][] map;
	static Point[] sel;
	static boolean[][] visited;
	static ArrayList<Point> virusList;
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
		
		map = new int[N][N];
		virusList = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) zeroCount++;
				if(map[i][j] == 2) virusList.add(new Point(i, j, 0));	
				
			}
		}
		
		sel = new Point[M];
		min = Integer.MAX_VALUE;
		comb(0, 0);
		if(min == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);
	}
	private static void comb(int idx, int count) {
		// M개의 시작 바이러스를 뽑음
		if(count == M) {
			if(bfs()) {
				if(tmp < min) min = tmp;
			}
			return;
		}
		
		for(int i = idx; i < virusList.size(); i++) {
			sel[count] = virusList.get(i);
			comb(i + 1, count + 1);
		}
		
	}
	private static boolean bfs() {
		Queue<Point> q = new LinkedList<>();
		visited = new boolean[N][N];
		int mustZero = zeroCount;
		for(int i = 0; i < sel.length; i++) {
			Point p = sel[i];
			visited[p.row][p.col] = true; 
			q.add(new Point(p.row, p.col, 0));
		}
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			if(map[p.row][p.col] == 0) {
				tmp = p.depth;
			}
			
			for(int i = 0; i < 4; i++) {
				int nextRow = p.row + dRow[i];
				int nextCol = p.col + dCol[i];
				
				if(nextRow < 0 || nextCol < 0 || nextRow >= N || nextCol >= N) continue;
				
				if(map[nextRow][nextCol] == 1) continue;
				
				if(!visited[nextRow][nextCol]) {
					if(map[nextRow][nextCol] == 0) mustZero--;
					visited[nextRow][nextCol]= true; 
					q.add(new Point(nextRow, nextCol, p.depth + 1));
				}
			}
		}
		
		if(mustZero == 0) return true;
		else return false;
	}
}