import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int result;
	static int[] arr;
	static int[] sel;
	static boolean[] visited;
	static boolean[] erased;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        result = 0;
        sel = new int[N - 2];
        visited = new boolean[N];
        // 지울 순서 뽑기
        perm(0);
        System.out.println(result);
    }
	private static void perm(int idx) {
		if(idx == N - 2) {
			// 지울 순서 다 뽑았다~
//			System.out.println(Arrays.toString(sel));
			// 에너지 모아보자~
			int tmp = getEnergy();
//			System.out.println(tmp);
			result = Math.max(result, tmp);
			return;
		}
		
		for(int i = 1; i < N - 1; i++) {
			if(!visited[i]) {
				sel[idx] = i;
				visited[i] = true;
				perm(idx + 1);
				visited[i] = false;
			}
		}
		
	}
	private static int getEnergy() {
		int sum = 0;
		erased = new boolean[N];
		for(int i = 0; i < sel.length; i++) {
			// 이번턴에 지울 인덱스
			int idx = sel[i];
			erased[idx] = true;
			int leftTmpIdx = idx;
			int rightTmpIdx = idx;
			// 왼쪽으로 쭉가면서 살아있는 값 찾기
			int mulLeft = 1;
			int mulRight = 1;
			while(true) {
				leftTmpIdx -= 1;
				if(!erased[leftTmpIdx]) {
					mulLeft = arr[leftTmpIdx];
					break;
				}
			}
			// 오른쪽으로 쭉 가면서 살아있는 값 찾기
			while(true) {
				rightTmpIdx += 1;
				if(!erased[rightTmpIdx]) {
					mulRight = arr[rightTmpIdx];
					break;
				}
			}
			sum = sum + mulLeft * mulRight;
		}
		return sum;
	}
}