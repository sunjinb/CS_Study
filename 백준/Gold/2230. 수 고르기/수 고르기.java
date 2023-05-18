import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		int onePointer = 0;
		int twoPointer = 0;
		
		int result = Integer.MAX_VALUE;

		while(twoPointer < N) {
			if(arr[twoPointer] - arr[onePointer] < M) {
				twoPointer++;
				continue;
			}
			
			else {
				result = Math.min(result, arr[twoPointer] - arr[onePointer]);
				onePointer++;
			}
			
			if(result == M) break;
		}
		
		System.out.println(result);
	}
}
