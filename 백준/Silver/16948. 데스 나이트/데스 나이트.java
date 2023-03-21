import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
	static int N;
	static int[] cur;
	static int[] goal;
	static boolean[][] visited;
	static int[] dRow = {-2, -2, 0, 0, 2, 2};
	static int[] dCol = {-1, 1, -2, 2, -1, 1};
	static class Point{
		int row, col, depth;
		public Point(int row, int col, int depth) {
			this.row = row;
			this.col = col;
			this.depth = depth;
		}
	}
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        
        cur = new int[2];
        goal = new int[2];
        cur[0] = Integer.parseInt(st.nextToken());
        cur[1] = Integer.parseInt(st.nextToken());
        goal[0] = Integer.parseInt(st.nextToken());
        goal[1] = Integer.parseInt(st.nextToken());
        
        visited = new boolean[N][N];
        System.out.println(bfs());
    }
	private static int bfs() {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(cur[0], cur[1], 0));
		visited[cur[0]][cur[1]] = true;
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			
			if(now.row == goal[0] && now.col == goal[1]) {
				return now.depth;
			}
			
			for(int i = 0; i < 6; i++) {
				int nextRow = now.row + dRow[i];
				int nextCol = now.col + dCol[i];
				
				if(nextRow < 0 || nextCol < 0 || nextRow >= N || nextCol >= N) continue;
				
				if(!visited[nextRow][nextCol]) {
					visited[nextRow][nextCol] = true;
					q.add(new Point(nextRow, nextCol, now.depth + 1));
				}
			}
		}
		return -1;
	}
}