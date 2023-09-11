import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), "-");
		
		int result = Integer.MAX_VALUE;
		
		while(st.hasMoreTokens()) {
			
			StringTokenizer sumSt = new StringTokenizer(st.nextToken(), "+");
		
			int tmp = 0;
			
			while(sumSt.hasMoreTokens()) {
				tmp += Integer.parseInt(sumSt.nextToken());
			}
			
//			System.out.println(tmp);
			
			if(result == Integer.MAX_VALUE) {
				result = tmp;
			}
			else {
				result -= tmp;
			}
		}
		
		System.out.println(result);
		
	}
}
