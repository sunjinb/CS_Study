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
		
		HashMap<String, Integer> hashMap = new HashMap<>();
		HashMap<Integer, String> hashMapp = new HashMap<>();
		
		for(int i = 1; i <= N; i++) {
			String str = br.readLine();
			hashMap.put(str, i);
			hashMapp.put(i, str);
		}
		
		for(int i = 0; i < M; i++) {
			String str = br.readLine();
			
			// 알파벳인지 판단
			boolean isAllAlpha = true;
			
			for (int j = 0; j < str.length(); j++)
	        {
	            char c = str.charAt(j);
	            if (!(c >= 'A' && c <= 'Z') && !(c >= 'a' && c <= 'z')) {
	                isAllAlpha = false;
	                break;
	            }
	        }
			
			// 알파벳이라면
			if(isAllAlpha) {
				String tmp = str;
				int result = hashMap.get(tmp);
				sb.append(result + "\n");
			}
			// 숫자라면
			else {
				int tmpp = Integer.parseInt(str);
				String result = hashMapp.get(tmpp);
				sb.append(result + "\n");
			}
		}
		System.out.println(sb);
	}
}
