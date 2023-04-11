import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static final int INF = Integer.MAX_VALUE;
	static int[][] map;
	static int[][] breakCountMap;
	static boolean[][] visited;
	static int[] dRow = {-1, 1, 0, 0};
	static int[] dCol = {0, 0, -1, 1};
	static class Point implements Comparable<Point>{
		int row, col, breakCount;
		public Point(int row, int col, int breakCount) {
			this.row = row;
			this.col = col;
			this.breakCount = breakCount;
		}
		
		@Override
		public int compareTo(Point o) {
			return Integer.compare(this.breakCount, o.breakCount);
		}
	}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        breakCountMap = new int[N][N];
        
        for(int i = 0; i < N; i++) {
        	String str = br.readLine();
        	for(int j = 0; j < N; j++) {
        		map[i][j] = str.charAt(j) - '0';
        	}
        }
        
        visited = new boolean[N][N];
        
        for(int i = 0; i < N; i++) {
        	Arrays.fill(breakCountMap[i], INF);
        }
        
        breakCountMap[0][0] = 0;
        PriorityQueue<Point> q = new PriorityQueue<>();
        q.add(new Point(0, 0, 0));

        
        while(!q.isEmpty()) {
        	Point now = q.poll();
        	
        	if(visited[now.row][now.col]) continue;
        	visited[now.row][now.col] = true; 
        	
        	for(int i = 0; i < 4; i++) {
        		int nextRow = now.row + dRow[i];
        		int nextCol = now.col + dCol[i];
        		
        		if(nextRow < 0 || nextCol < 0 || nextRow >= N || nextCol >= N) continue;

        		
        		if(map[nextRow][nextCol] == 0) {
        			if(now.breakCount + 1 < breakCountMap[nextRow][nextCol]) {
        				breakCountMap[nextRow][nextCol] = now.breakCount + 1;
        				q.add(new Point(nextRow, nextCol, breakCountMap[nextRow][nextCol]));
        			}
        		}
        		else {
        			if(now.breakCount < breakCountMap[nextRow][nextCol]) {
        				breakCountMap[nextRow][nextCol] = now.breakCount;
        				q.add(new Point(nextRow, nextCol, breakCountMap[nextRow][nextCol]));
        			}
        		}
        	}
        }
        
        System.out.println(breakCountMap[N - 1][N - 1]);
    }
}