import java.io.*;
import java.util.*;

public class Main {
	static long S;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		S = Long.parseLong(br.readLine());
		
		long sum = 0;
		long num = 1;
		
		while(true) {
			sum += num;
			
			if(sum > S) {
				break;
			}
			num++;
		}
		System.out.println(num - 1);
	}
}
