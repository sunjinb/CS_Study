import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[] alpha = new int[27];
		String str = br.readLine();
		
		for(int i = 0; i < str.length(); i++) {
			char tmp = str.charAt(i);
			
			alpha[tmp - 96]++;
		}
		
		for(int i = 1; i <= 26; i++) {
			sb.append(alpha[i] + " ");
		}
		
		System.out.println(sb);
	}
}
