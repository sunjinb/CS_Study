import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		
		int idx = 0;
		while(true) {
			sb.append(str.charAt(idx));
			if(idx % 10 == 9) sb.append("\n");
			
			idx++;
			if(idx == str.length()) break;
		}
		System.out.println(sb);
	}
}

