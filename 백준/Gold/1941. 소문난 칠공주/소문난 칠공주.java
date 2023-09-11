import java.io.*;
import java.util.*;

public class Main {
	static char[][] map;
	static int result;
	static boolean[][] visited;
	static int[] dRow = {-1, 1, 0, 0};
	static int[] dCol = {0, 0, -1, 1};
	
	static HashMap<Integer, Point> hashMap;
	
	static int[] sel;
	
	static class Point{
		int row, col;
		public Point(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        hashMap = new HashMap<>();
        
        map = new char[5][5];
        int cnt = 1;
	    for(int i = 0; i < 5; i++) {
	    	String str = br.readLine();
	    	for(int j = 0; j < 5; j++) {
	    		map[i][j] = str.charAt(j);
	    		hashMap.put(cnt, new Point(i, j));
	    		cnt++;
	    	}
	    }

	    sel = new int[7];
	    comb(1, 0);
	    System.out.println(result);
	}

	private static void comb(int idx, int count) {
		if(count == 7) {
			// 뽑았으니 7명이 인접해있는지 확인
			if(isNear() && isPrincessNumOverFour()) {
				result++;
			}
//			System.out.println(Arrays.toString(sel));
			return;
		}
		
		for(int i = idx; i <= 25; i++) {
			sel[count] = i;
			comb(i + 1, count + 1);
		}
	}

	private static boolean isPrincessNumOverFour() {
		int count = 0;
		for(int i = 0; i < sel.length; i++) {
			Point now = hashMap.get(sel[i]);
			if(map[now.row][now.col]== 'S' ) count++;
		}
		
		if(count >= 4) return true;
		else return false;
	}

	private static boolean isNear() {
		Queue<Point> q = new LinkedList<>();
		visited = new boolean[5][5];
		
		Point startPoint = hashMap.get(sel[0]);
		visited[startPoint.row][startPoint.col] = true;
		q.add(startPoint);
	
		int count = 0;
		while(!q.isEmpty()) {
			Point now = q.poll();
			count++;
			
			for(int i = 0; i < 4; i++) {
				int nextRow = now.row + dRow[i];
				int nextCol = now.col + dCol[i];
				
				if(nextRow < 0 || nextCol < 0 || nextRow >= 5 || nextCol >= 5) continue;
				
				if(visited[nextRow][nextCol]) continue;
				
				for(int j = 1; j < sel.length; j++) {
					Point next = hashMap.get(sel[j]);
					
					// 다음 갈 지점이 sel 배열에 들어있는 값이라면
					if(nextRow == next.row && nextCol == next.col) {
						if(!visited[nextRow][nextCol]) {
							visited[nextRow][nextCol] = true;
							q.add(new Point(nextRow, nextCol));
						}
					}
					
				}
			}
		}
		
		if(count >= 7) return true;
		else return false;
	}
}