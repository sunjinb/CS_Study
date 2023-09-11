import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine(), ",");
			int sum = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
			sb.append(sum + "\n");
		}
		
		System.out.println(sb);
	}
}
