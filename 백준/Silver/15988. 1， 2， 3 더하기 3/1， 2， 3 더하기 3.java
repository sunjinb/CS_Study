import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] dp;
	static long[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		arr = new long[1000005];
		
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 4;
		for(int i = 4; i < 1000005; i++) {
			arr[i] = (arr[i - 3] + arr[i - 2] + arr[i - 1]) % 1000000009; 
		}
		
		for(int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(br.readLine());
			System.out.println(arr[N]);
		}
	}
}