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
		for(int onePointer = 0; onePointer < N - 1; onePointer++) {
			int firstNum = arr[onePointer];
			for(int twoPointer = onePointer + 1; twoPointer < N; twoPointer++) {
				int secondNum = arr[twoPointer];
				
				int sum = firstNum + secondNum;
				
				if(sum > M) break;
				
				if(sum == M) result++;
			}
		}
		
		System.out.println(result);
	}
}
