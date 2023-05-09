import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		HashSet<String> listen = new HashSet<>();
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			listen.add(str);
		}
		
		int count = 0;
		ArrayList<String> result = new ArrayList<>();
		
		for(int i = 0; i < M; i++) {
			String str = br.readLine();
			if(listen.contains(str)) {
				count++;
				result.add(str);
			}
		}
		
		
		Collections.sort(result);
		System.out.println(count);
		for(String str : result) {
			System.out.println(str);
		}
	}
}
