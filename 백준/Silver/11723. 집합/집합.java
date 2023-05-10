import java.io.*;
import java.util.*;

public class Main {
	static int M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		M = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			
			if(str.equals("all")) {
				hashMap.clear();
				for(int j = 1; j <= 20; j++) {
					hashMap.put(j, 1);
				}
			}
			else if(str.equals("empty")) {
				hashMap.clear();
			}
			else {
				int x = Integer.parseInt(st.nextToken());
				if(str.equals("add")) {
					if(!hashMap.containsKey(x)) {
						hashMap.put(x, 1);
					}
				}
				else if(str.equals("remove")) {
					if(hashMap.containsKey(x)) {
						hashMap.remove(x);
					}
				}
				else if(str.equals("check")) {
					if(hashMap.containsKey(x)) {
						sb.append("1\n");
					}
					else {
						sb.append("0\n");
					}
				}
				else if(str.equals("toggle")) {
					if(hashMap.containsKey(x)) {
						hashMap.remove(x);
					}
					else {
						hashMap.put(x, 1);
					}
				}
			}
		}
		System.out.println(sb);
	}
}
