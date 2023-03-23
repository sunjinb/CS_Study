import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static boolean[][] melted;
	static int time, cheeseCount;
	static int[] dRow = {-1, 1, 0, 0};
	static int[] dCol = {0, 0, -1, 1};
	
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
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j < M; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        		if(map[i][j] == 1) cheeseCount++;
        	}
        }
        
        time = 0;
        
        while(true) {
        	if(cheeseCount == 0) {
        		break;
        	}
        	
        	visited = new boolean[N][M];
        	// 치즈 외곽 10으로 처리
        	edgeDfs(0, 0);
        	
        	melted = new boolean[N][M];
        	for(int i = 0; i < N; i++) {
        		for(int j = 0; j < M; j++) {
        			if(map[i][j] == 1 && canMelt(i, j)) {
        				melted[i][j] = true;
        				cheeseCount--;
        			}
        		}
        	}
        	melting();
        	time++;
        }
        
        System.out.println(time);
    }
    
	private static void melting() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(melted[i][j]) {
					map[i][j] = 10;
				}
			}
		}
		
	}
	
	private static boolean canMelt(int row, int col) {
		int count = 0;
		for(int i = 0; i < 4; i++) {
			int nextRow = row + dRow[i];
			int nextCol = col + dCol[i];
			
			if(nextRow < 0 || nextCol < 0 || nextRow >= N || nextCol >= M) continue;
			
			// 공기와 맞닿아있다면
			if(map[nextRow][nextCol] == 10) {
				count++;
			}
		}
		if(count >= 2) return true;
		else return false;
	}
	
	private static void edgeDfs(int row, int col) {
		visited[row][col] = true;
		map[row][col] = 10;
		
		for(int i = 0; i < 4; i++) {
			int nextRow = row + dRow[i];
			int nextCol = col + dCol[i];
			
			if(nextRow < 0 || nextCol < 0 || nextRow >= N || nextCol >= M 
					|| map[nextRow][nextCol] == 1) continue;
			
			if(!visited[nextRow][nextCol]) {
				edgeDfs(nextRow, nextCol);
			}
		}
	}
}