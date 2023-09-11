import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int result;
	static int[] arr;
	static int[] sel;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		result = 0;
		sel = new int[N];
		visited = new boolean[N];
		perm(0);
		System.out.println(result);
	}
	private static void perm(int idx) {
		if(idx == N) {
//			System.out.println(Arrays.toString(sel));
			int tmp = calc();
//			System.out.println(tmp);
			result = Math.max(tmp, result);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				sel[idx] = i;
				visited[i] = true;
				perm(idx + 1);
				visited[i] = false;
			}
		}
		
	}
	private static int calc() {
		int sum = 0;
		for(int i = 0; i < N - 1; i++) {
			sum = sum + Math.abs(arr[sel[i]] - arr[sel[i + 1]]);
		}
		return sum;
	}
}