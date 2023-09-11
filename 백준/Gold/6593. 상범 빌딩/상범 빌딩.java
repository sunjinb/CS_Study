import java.io.*;
import java.util.*;

public class Main {
	static int L, R, C;
	static char[][][] map;
	static boolean[][][] visited;
	static int[] dRow = {0, 0, 1, -1, 0, 0};
	static int[] dCol = {1, -1, 0, 0, 0, 0};
	static int[] dDepth = {0, 0, 0, 0, -1, 1};
	static class Point{
		int depth, row, col, time;
		public Point(int depth, int row, int col, int time) {
			this.depth = depth;
			this.row = row;
			this.col = col;
			this.time = time;
		}
	}
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    StringTokenizer st;
	    
	    while(true) {
	    	st = new StringTokenizer(br.readLine());
	    	L = Integer.parseInt(st.nextToken());
	    	R = Integer.parseInt(st.nextToken());
	    	C = Integer.parseInt(st.nextToken());
	    	
		    Queue<Point> q = new LinkedList<>();
		    Point start = null;
		    Point end = null;
		    
	    	if(L == 0 && R == 0 && C == 0) break;
	    	
	    	map = new char[L][R][C];
	    	
	    	for(int i = 0; i < L; i++) {
	    		for(int j = 0; j < R; j++) {
	    			String str = br.readLine();
	    			for(int k = 0; k < C; k++) {
	    				map[i][j][k] = str.charAt(k);
	    				if(map[i][j][k] == 'S') {
	    					start = new Point(i, j, k, 0);
	    				}
	    				if(map[i][j][k] == 'E') {
	    					end = new Point(i, j, k, 0);
	    				}
	    			}
	    		}
	    		String str = br.readLine();
	    	}
	    	
	    	q.add(start);
	    	visited = new boolean[L][R][C];
	    	
	    	visited[start.depth][start.row][start.col] = true;
	    	
	    	int result = -1;
	    	while(!q.isEmpty()) {
	    		Point now = q.poll();
	    		
	    		if(now.depth == end.depth && now.row == end.row && now.col == end.col) {
	    			result = now.time;
	    			break;
	    		}
	    		
	    		for(int i = 0; i < 6; i++) {
	    			int nextDepth = now.depth + dDepth[i];
	    			int nextRow = now.row + dRow[i];
	    			int nextCol = now.col + dCol[i];
	    			
	    			if(nextDepth < 0 || nextDepth >= L) continue;
	    			if(nextRow < 0 || nextRow >= R || nextCol < 0 || nextCol >= C) continue;
	    			
	    			if(visited[nextDepth][nextRow][nextCol]) continue;
	    			
	    			if(map[nextDepth][nextRow][nextCol] == '#') continue;
	    			
	    			visited[nextDepth][nextRow][nextCol] = true;
	    			q.add(new Point(nextDepth, nextRow, nextCol, now.time + 1));
	    		}
	    	}
	    	
	    	if(result == -1) System.out.println("Trapped!");
	    	else System.out.println("Escaped in " + result + " minute(s).");
	    
	    }
	}
}