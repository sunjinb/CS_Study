import java.io.*;
import java.util.*;

public class Main {
	static int N, M, T;
	static int[][] map;
	static int[] dRow = {-1, 1, 0, 0};
	static int[] dCol = {0, 0, -1, 1};
	static boolean[][][] visited;
	static class Point{
		int row, col, time;
		boolean getSuperPower;
		
		public Point(int row, int col, int time, boolean getSuperPower) {
			this.row = row;
			this.col = col;
			this.time = time;
			this.getSuperPower = getSuperPower;
		}
	}
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    StringTokenizer st;
	    
	    st = new StringTokenizer(br.readLine());
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    T = Integer.parseInt(st.nextToken());
	    
	    map = new int[N][M];
	    for(int i = 0; i < N; i++) {
	    	st = new StringTokenizer(br.readLine());
	    	for(int j = 0; j < M; j++) {
	    		map[i][j] = Integer.parseInt(st.nextToken());
	    	}
	    }
	    
	    Queue<Point> q = new LinkedList<>();
	    visited = new boolean[N][M][2];
	    
	    visited[0][0][0] = true;
	    q.add(new Point(0, 0, 0, false));
	    
	    int result = -1;
	    while(!q.isEmpty()) {
	    	Point now = q.poll();
	    	
	    	if(now.time > T) continue;
	    	
	    	boolean nextPower = false;
	    	if(map[now.row][now.col] == 2 || now.getSuperPower) nextPower = true;
	    	
	    	if(now.row == N - 1 && now.col == M - 1) {
	    		result = now.time;
	    		break;
	    	}
	    	
	    	for(int i = 0; i < 4; i++) {
	    		int nextRow = now.row + dRow[i];
	    		int nextCol = now.col + dCol[i];
	    		
	    		// 범위를 벗어나면 일단 못 감
	    		if(nextRow < 0 || nextCol < 0 || nextRow >= N || nextCol >= M) continue;
	    		
	    		// 지금 벽을 뚫을 수 있는 녀석임
	    		if(nextPower) {
	    			// 아직 방문 안 한 곳이면 다 갈 수 있음
	    			if(!visited[nextRow][nextCol][1]) {
	    				visited[nextRow][nextCol][1] = true;
	    				q.add(new Point(nextRow, nextCol, now.time + 1, nextPower));
	    			}
	    			
	    		}
	    		// 벽을 뚫을 수 없는 녀석임
	    		else {
	    			// 벽이면 못 가고 이미 갔던 데면 갈 필요 없음
	    			if(map[nextRow][nextCol] != 1 && !visited[nextRow][nextCol][0]) {
	    				visited[nextRow][nextCol][0] = true;
	    				q.add(new Point(nextRow, nextCol, now.time + 1, nextPower));
	    			}
	    		}
	    	}
	    }
	    
	    if(result == -1 || result > T) System.out.println("Fail");
	    else System.out.println(result);
	
	}
}