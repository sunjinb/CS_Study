import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
	static int N, M;
	static int result;
	static int[][] map;
	static int[][] tmpMap;
	static boolean[][] visited;
	static int[] virusPoint;
	static int wallCount;
	static int mustVirusCount;
	static int[] dRow = {-1, 1, 0, 0};
	static int[] dCol = {0, 0, -1, 1};
	static ArrayList<Point> canPutVirusList;
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

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][N];
        canPutVirusList = new ArrayList<>();
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j < N; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        		if (map[i][j] == 1) wallCount++;
        		else if(map[i][j] == 2) {
        			canPutVirusList.add(new Point(i, j, 0));
        			map[i][j] = 0;
        		}
        	}
        }
        result = Integer.MAX_VALUE;
        mustVirusCount = N * N - wallCount;
        virusPoint = new int[M];
        comb(0, 0);
        if(result == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(result);
    }

	private static void comb(int idx, int count) {
		if(count == M) {
//			makeTmpMap();
			int tmpResult = spread();
			if(checkAllVirus() && tmpResult < result) {
				result = tmpResult;
			}
			return;
		}
		
		for(int i = idx; i < canPutVirusList.size(); i++) {
			virusPoint[count] = i;
			comb(i + 1, count + 1);
		}
	}

	private static boolean checkAllVirus() {
		int count = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(visited[i][j]) {
					count++;
				}
			}
		}
		if(count == mustVirusCount) return true;
		else return false;
	}

	private static void makeTmpMap() {
		tmpMap = new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				tmpMap[i][j] = map[i][j];
			}
		}
		
	}

	private static int spread() {
		visited = new boolean[N][N];
		Queue<Point> q = new LinkedList<>();
		for(int i = 0; i < virusPoint.length; i++) {
			Point p = canPutVirusList.get(virusPoint[i]);
			visited[p.row][p.col] = true; 
			q.add(p);
		}
		
		Point now = null;
		while(!q.isEmpty()) {
			now = q.poll();
		
			for(int i = 0; i < 4; i++) {
				int nextRow = now.row + dRow[i];
				int nextCol = now.col + dCol[i];
				
				if(nextRow < 0 || nextCol < 0 || nextRow >= N || nextCol >= N || visited[nextRow][nextCol]) continue;
				
				if(map[nextRow][nextCol] != 1) {
					visited[nextRow][nextCol] = true;
					q.add(new Point(nextRow, nextCol, now.depth + 1));
				}
			}
		}
		
		return now.depth;
	}
}