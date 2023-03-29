import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	static int N;
	static BigInteger[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		dp = new BigInteger[251];
		dp[1] = BigInteger.valueOf(1);
		dp[2] = BigInteger.valueOf(3);
		for(int i = 3; i <= 250; i++) {
			dp[i] = dp[i - 2].multiply(BigInteger.valueOf(2)).add(dp[i - 1]);
		}
		
		while(true) {
			String str = br.readLine();
			if(str == null) break;
			
			N = Integer.parseInt(str);
			
			if(N == 0) System.out.println(1);
			else System.out.println(dp[N]);
		}
	}
}