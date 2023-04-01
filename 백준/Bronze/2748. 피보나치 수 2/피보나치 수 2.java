import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static long[] fibo;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		fibo = new long[N + 2];
		
		fibo[0] = 0;
		fibo[1] = 1;
		
		for(int i = 2; i <= N; i++) {
			fibo[i] = fibo[i - 2] + fibo[i - 1];
		}
		
		System.out.println(fibo[N]);
	}
}
 