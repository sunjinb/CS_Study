import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int result = 0;
		Arrays.sort(arr);
		
		int onePointer = 0;
		int twoPointer = N - 1;
		
		while(onePointer != twoPointer && onePointer < twoPointer) {
			int sum = arr[onePointer] + arr[twoPointer];
			if(sum > M) twoPointer--;
			else if(sum < M) onePointer++;
			else if(sum == M) {
				result++;
				onePointer++;
				twoPointer--;
			}
		}
		
		System.out.println(result);
	}
}
