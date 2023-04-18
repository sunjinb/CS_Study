import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] dRow = {1, 0};
	static int[] dCol = {0, 1};
	static class Point{
		int row, col;
		public Point(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

	    N = Integer.parseInt(br.readLine());
	    map = new int[N][N];
	    
	    for(int i = 0; i < N; i++) {
	    	st = new StringTokenizer(br.readLine());
	    	for(int j = 0; j < N; j++) {
	    		map[i][j] = Integer.parseInt(st.nextToken());
	    	}
	    }
	    
	    Queue<Point> q = new LinkedList<>();
	    visited = new boolean[N][N];
	    
	    q.add(new Point(0, 0));
	    visited[0][0] = true;
	    
	    
	    boolean flag = false;
	    while(!q.isEmpty()) {
	    	Point now = q.poll();
	    	
	    	if(now.row == N - 1 && now.col == N - 1) {
	    		flag = true;
	    		break;
	    	}
	    	
	    	for(int i = 0; i < 2; i++) {
	    		int nextRow = now.row + dRow[i] * map[now.row][now.col];
	    		int nextCol = now.col + dCol[i] * map[now.row][now.col];
	    		
	    		if(nextRow < 0 || nextCol < 0 || nextRow >= N || nextCol >= N) continue;
	    		
	    		if(visited[nextRow][nextCol]) continue;
	    		visited[nextRow][nextCol] = true;
	    		q.add(new Point(nextRow, nextCol));
	    	}
	    }
	    
	    if(flag) System.out.println("HaruHaru");
	    else System.out.println("Hing");
	}
}