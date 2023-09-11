import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static boolean[] isNotPrime;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		isNotPrime = new boolean[1000004];
		isNotPrime[0] = isNotPrime[1] = true;
		for(int i = 2; i < Math.sqrt(isNotPrime.length); i++) {
			if(!isNotPrime[i]) {
				for(int j = i * 2; j < isNotPrime.length; j+=i) {
					isNotPrime[j] = true;
				}
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(br.readLine());
			
			int count = 0;
			for(int i = 1; i <= N / 2; i++) {
				if(!isNotPrime[i] && !isNotPrime[N - i]) {
					count++;
				}
			}
			sb.append(count + "\n");
		}
		System.out.println(sb);
	}
}
