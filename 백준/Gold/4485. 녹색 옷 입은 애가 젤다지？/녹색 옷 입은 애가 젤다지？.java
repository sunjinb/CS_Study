import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
	static int N;
	static final int INF = Integer.MAX_VALUE;
	static int[][] distance;
	static boolean[][] visited; 
	static int[][] map;
	static int[] dRow = {-1, 1, 0, 0};
	static int[] dCol = {0, 0, -1, 1};
	static class Point implements Comparable<Point>{
		int row, col, costSum;
		public Point(int row, int col, int costSum) {
			this.row = row;
			this.col = col;
			this.costSum = costSum;
		}
		@Override
		public int compareTo(Main.Point o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.costSum, o.costSum);
		}
	}
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int cnt = 0;
        while(true) {
        	N = Integer.parseInt(br.readLine());
        	cnt++;
        	if(N == 0) break;
        	
        	map = new int[N][N];
        	for(int i = 0; i < N; i++) {
        		st = new StringTokenizer(br.readLine());
        		for(int j = 0; j < N; j++) {
        			map[i][j] = Integer.parseInt(st.nextToken());
        		}
        	}
        	
        	dijkstra();
        	System.out.println("Problem " + cnt + ": " + distance[N - 1][N - 1]);
        }
        
    }
	private static void dijkstra() {
		distance = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			Arrays.fill(distance[i], INF);
		}
		
		distance[0][0] = map[0][0];
		
		PriorityQueue<Point> q = new PriorityQueue<>();
		q.add(new Point(0, 0, map[0][0]));
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			
			if(visited[now.row][now.col]) continue;
			
			visited[now.row][now.col]= true;
			
			for(int i = 0; i < 4; i++) {
				int nextRow = now.row + dRow[i];
				int nextCol = now.col + dCol[i];
				
				if(nextRow < 0 || nextCol < 0 || nextRow >= N || nextCol >= N) continue;
				
				if(now.costSum + map[nextRow][nextCol] < distance[nextRow][nextCol]) {
					distance[nextRow][nextCol] = now.costSum + map[nextRow][nextCol];
					q.add(new Point(nextRow, nextCol, distance[nextRow][nextCol]));
				}
			}
		}
		
	}
}