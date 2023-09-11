import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] dp;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(br.readLine());
			
			arr = new int[12];
			
			arr[1] = 1;
			arr[2] = 2;
			arr[3] = 4;
			for(int i = 4; i <= N; i++) {
				arr[i] = arr[i - 3] + arr[i - 2] + arr[i - 1]; 
			}
			
			System.out.println(arr[N]);
		}
	}
}