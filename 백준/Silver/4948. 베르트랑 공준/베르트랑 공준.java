import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n == 0) break;
			boolean[] isPrime = new boolean[n * 2 + 1];
			isPrime[0] = isPrime[1] = true;
			int count = 0;
			for(int i = 2; i <= n * 2; i++) {
				if(isPrime[i] == false) {
					if(i > n) count++;
					for(int j = i * 2; j <= n * 2; j += i) {
						isPrime[j] = true;
					}
				}
			}
			sb.append(count + "\n");
		}
		
		System.out.println(sb);
	}
}
