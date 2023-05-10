import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		while(true) {
			String str = br.readLine();
			if(str.equals("0")) break;
			
			boolean isPelindrom = true;
			
			char[] arr = new char[str.length()];
			
			for(int i = 0; i < arr.length; i++) {
				arr[i] = str.charAt(i);
			}
			
			int mid = arr.length / 2;
			
			for(int i = 0; i < mid; i++) {
			if(arr[i] != arr[arr.length - i - 1]) {
				isPelindrom = false;
				break;
				}
			}
			
			if(isPelindrom) sb.append("yes\n");
			else sb.append("no\n");
		}
		
		System.out.println(sb);
	}
}
