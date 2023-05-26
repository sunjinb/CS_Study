import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while(true) {
			int N = Integer.parseInt(br.readLine());
			
			if(N == -1) break;
			
			int[] arr = new int[N + 1];
			
			int sum = 0;
			for(int i = 1; i < N; i++) {
				// 약수라면
				if(N % i == 0) {
					arr[i] = 1;
					sum += i;
				}
			}
			
			if(sum == N) {
				sb.append(N + " = 1");
				
				for(int i = 2; i < N; i++) {
					if(arr[i] == 1) {
						sb.append(" + " + i);
					}
				}
			}
			else {
				sb.append(N + " is NOT perfect.");
			}
			sb.append("\n");
			
		}
		
		System.out.println(sb);
		
	}
}
