import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
	static int N, M;
	static char[][] map;
	static int myPoint, enemyPoint;
	static boolean[][] visited;
	static int[] dRow = {-1, 1, 0, 0};
	static int[] dCol = {0, 0, -1, 1};
	static class Point{
		int row, col;
		char info;
		public Point(int row, int col, char info) {
			this.row = row;
			this.col = col;
			this.info = info;
		}
	}
	
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        
        map = new char[N][M];
        for(int i = 0; i < N; i++) {
        	String str = br.readLine();
        	for(int j = 0; j < M; j++) {
        		map[i][j] = str.charAt(j);
        	}
        }
        
        visited = new boolean[N][M];
        for(int i = 0; i < N; i++) {
        	for(int j = 0; j < M; j++) {
        		if(!visited[i][j]) {
        			bfs(i, j, map[i][j]);
        		}
        	}
        }
        System.out.println(myPoint + " " + enemyPoint);
    }

	private static void bfs(int row, int col, char info) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(row, col, info));
		visited[row][col] = true;
		
		int count = 0;
		while(!q.isEmpty()) {
			Point now = q.poll();
			
			count += 1;
			
			for(int i = 0; i < 4; i++) {
				int nextRow = now.row + dRow[i];
				int nextCol = now.col + dCol[i];
				
				if(nextRow < 0 || nextCol < 0 || nextRow >= N || nextCol >= M) continue;
				
				if(!visited[nextRow][nextCol] && now.info == map[nextRow][nextCol]) {
					visited[nextRow][nextCol] = true;
					q.add(new Point(nextRow, nextCol, map[nextRow][nextCol]));
				}
			}
		}
		
		if(info == 'W') {
			myPoint += count * count;
		}
		else if(info == 'B') {
			enemyPoint += count * count;
		}
	}
    
}