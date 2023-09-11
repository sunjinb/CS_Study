import java.io.*;
import java.util.*;

public class Solution {
	static int D, W, K;
	static int result;
	static int[][] map;
	static int[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[D][W];
			for(int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			visited = new int[D];
			result = Integer.MAX_VALUE;
			powerSet(0, 0);
			System.out.printf("#%d %d\n", testCase, result);
		}
	}
	
	// 행 기준
	private static void powerSet(int idx, int injectionCount) {
		if(idx == D) {
			// 약품 투입 준비 완료
			// 약품 투입 해보자
			// 이제 성능검사 통과하는지 확인해보자
			if(isPass()) {
				// 통과하면 최솟값인지 확인해보자
				result = Math.min(result, injectionCount);
			}
			return;
		}
		
		// 아무것도 주입하지 않을거야
		visited[idx] = -1;
		powerSet(idx + 1, injectionCount);
		
		// A를 여기에 주입할거야
		visited[idx] = 0;
		powerSet(idx + 1, injectionCount + 1);
		
		// B를 여기에 주입할거야
		visited[idx] = 1;
		powerSet(idx + 1, injectionCount + 1);

	}

	private static boolean isPass() {
		for(int j = 0; j < W; j++) {
			boolean passLine = false;
			int criteriaValue = map[0][j];
			if(visited[0] == 0) criteriaValue = 0;
			else if(visited[0] == 1) criteriaValue = 1;
			
			int sameCount = 1;
			for(int i = 1; i < D; i++) {
				// 주입된 행이라면
				if(visited[i] == 0 || visited[i] == 1) {
					if(criteriaValue == visited[i]) {
						sameCount++;
					}
					else {
						criteriaValue = visited[i];
						sameCount = 1;
					}
				}
				// 주입되지 않은 행이라면
				else {
					if(criteriaValue == map[i][j]) {
						sameCount++;
					}
					else {
						criteriaValue = map[i][j];
						sameCount = 1;
					}
				}
				if(sameCount == K) {
					passLine = true;
					break;
				}
			}
			if(!passLine) {
				return false;
			}
		}
		return true;
	}
}
