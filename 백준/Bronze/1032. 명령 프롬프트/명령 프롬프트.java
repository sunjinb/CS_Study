import java.io.*;
import java.util.*;

public class Main {
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		
		String str[] = new String[N];
		for(int i = 0; i < N; i++) {
			str[i] = br.readLine();
		}
		
		boolean flag = true;
		boolean[] isPattern = new boolean[str[0].length()];
		
		for(int i = 0; i < str[0].length(); i++) {
			flag = true;
			char tmp = str[0].charAt(i);
			for(int j = 1; j < str.length; j++) {
				if(tmp != str[j].charAt(i)) {
					flag = false;
					break;
				}
			}
			if(flag) isPattern[i] = true;
			else isPattern[i] = false;
		}
		
		for(int i = 0; i < str[0].length(); i++) {
			if(isPattern[i]) sb.append(str[0].charAt(i));
			else sb.append("?");
		}
		
		System.out.println(sb);
		
	}
}
