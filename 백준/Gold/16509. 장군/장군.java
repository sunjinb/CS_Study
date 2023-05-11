import java.io.*;
import java.util.*;

public class Main {
	static int Srow, Scol, Krow, Kcol;
	static boolean[][] visited;
	static int[][] dRow = {
			{0, -1, -1, 0, 0, 1, 1, 0},
			{-1, -2, -2, -1, 1, 2, 2, 1},
			{-2, -3, -3, -2, 2, 3, 3, 2}
	};
	static int[][] dCol = {
			{-1, 0, 0, 1, 1, 0, 0, -1},
			{-2, -1, 1, 2, 2, 1, -1, -2},
			{-3, -2, 2, 3, 3, 2, -2, -3}
	};
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
		Srow = Integer.parseInt(st.nextToken());
		Scol = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		Krow = Integer.parseInt(st.nextToken());
		Kcol = Integer.parseInt(st.nextToken());
		
		Queue<Point> q = new LinkedList<>();
		visited = new boolean[10][9];
		
		q.add(new Point(Srow, Scol, 0));
		visited[Srow][Scol] = true;
		
		int result = -1;
		while(!q.isEmpty()) {
			Point now = q.poll();
			
			if(now.row == Krow && now.col == Kcol) {
				result = now.depth;
				break;
			}
			
			L:for(int i = 0; i < 8; i++) {
				
				int nextRow = 0;
				int nextCol = 0;
				
				for(int j = 0; j < 3; j++) {
					nextRow = now.row + dRow[j][i];
					nextCol = now.col + dCol[j][i];	
					
					if(nextRow < 0 || nextCol < 0 || nextRow >= 10 || nextCol >= 9) continue L;
					
					if(nextRow == Krow && nextCol == Kcol && j < 2) continue L;
				}
				
				if(visited[nextRow][nextCol]) continue;
				
				visited[nextRow][nextCol] = true;
				q.add(new Point(nextRow, nextCol, now.depth + 1));
			}
		}
		
		System.out.println(result);
	}
}
