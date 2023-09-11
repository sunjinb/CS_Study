import java.io.*;
import java.util.*;

public class Main {
	static int min;
	static final int size = 10;
	static int[][] map;
	static boolean[][] visited;
	static int[] paperCount = {0, 5, 5, 5, 5, 5};
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        map = new int[size][size];
        visited = new boolean[size][size];
        
        for(int i = 0; i < size; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j < size; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        min = Integer.MAX_VALUE;
        int cnt = 0;
        solve(0, 0, cnt);
        if(min == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);
	}
	private static void solve(int row, int col, int cnt) {
		// 모든 구역 탐색 완료 -> 종료
		if(row > 9 && col == 0) {
			if(cnt < min) min = cnt;
			return;
		}
		
		if(col > 9) {
			solve(row + 1, 0, cnt);
			return;
		}
		
		else {
			if(map[row][col] == 1) {
				// 5 -> 1까지 무슨 색종이를 붙일 수 있을지 판단
				for(int paper = 5; paper > 0; paper--) {
					if(paperCount[paper] < 1) {
						continue;
					}
					
					if(row + paper > size || col + paper > size) {
						continue;
					}
					
					// 원하는 크기의 색종이가 남아있다면
					else {
						boolean canPut = true;
						L:for(int i = row; i < row + paper; i++) {
							for(int j = col; j < col + paper; j++) {
								if(map[i][j] != 1) {
									canPut = false;
									break L;
								}
							}
						}
						// 원하는 크기의 색종이를 붙일 수 있다면, 
						if(canPut) {
//							System.out.println("r : " + r + ", c : " + c + ", paperSize : "+ paper);
							paperCount[paper]--;
							for(int i = row; i < row + paper; i++) {
								for(int j = col; j < col + paper; j++) {
									map[i][j] = 0;
								}
							}
							solve(row, col + 1, cnt + 1);
							
							for(int i = row; i < row + paper; i++) {
								for(int j = col; j < col + paper; j++) {
									map[i][j] = 1;
								}
							}
							paperCount[paper]++;
						}
					}
				}		
			}
			else {
				solve(row, col + 1, cnt);
			}
		}
	}
}
