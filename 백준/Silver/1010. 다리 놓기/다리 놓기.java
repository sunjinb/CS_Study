import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
			
		int[][] comb = new int[31][31];
		
		for(int i = 0; i < 31; i++) {
			comb[i][0] = 1;
		}
		
		for(int i = 1; i < 31; i++) {
			for(int j = 0; j < 31; j++) {
				if(j == 0 || j == i) {
					comb[i][j] = 1;
				}
				else {
					comb[i][j] = comb[i - 1][j - 1] + comb[i - 1][j];
				}
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			System.out.println(comb[K][N]);
		}
	}
}