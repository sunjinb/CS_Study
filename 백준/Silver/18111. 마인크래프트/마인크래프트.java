import java.io.*;
import java.util.*;

public class Main {
	static int N, M, B;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		int max = 0;
		int min = 256;
		
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				map[i][j] = tmp;
				min = Math.min(tmp, min);
				max = Math.max(tmp, max);
			}
		}
		
		int resultTime = Integer.MAX_VALUE;
		int resultHeight = -1;
		
		for(int height = min; height <= max; height++) {
			int removeBlock = 0;
			int putBlock = 0;
			int time = 0;
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < M; c++) {
					int now = map[r][c];
					
					// 현재 지점이 목표 높이보다 작다면
					if(now < height) {
						putBlock += height - now;
					}
					else if(now > height) {
						removeBlock += now - height;
					}
				}
			}
			
			if(putBlock > removeBlock + B) continue;
			time = removeBlock * 2 + putBlock;
			
			if(time < resultTime) {
				resultTime = time;
				resultHeight = height;
			}
			else if(time == resultTime) {
				resultHeight = Math.max(resultHeight, height);
			}
		}
		
		System.out.println(resultTime + " " + resultHeight);
	}
}
