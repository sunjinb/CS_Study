import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class Main {
    static int N, K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
 
        int result = solve(N, K);
		System.out.println(result);
	}
	
	static int solve(int n, int k) {
		if(n == k || k == 0) {
			return 1;
		}
		return solve(n - 1, k - 1) + solve(n - 1, k);
	}
}