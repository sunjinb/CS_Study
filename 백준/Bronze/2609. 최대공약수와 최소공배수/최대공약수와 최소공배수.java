import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 최대 공약수 찾기
		int maxdiv = 0;
		maxdiv = gcd(N, M);
		// 최소 공배수 찾기
		int minMul = N * M / maxdiv;
		
		System.out.println(maxdiv);
		System.out.println(minMul);
	}
	private static int gcd(int n1, int n2) {
		while(n2 != 0) {
			int r = n1 % n2;
			
			n1 = n2;
			n2 = r;
		}
		
		return n1;
	}
}
