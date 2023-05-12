import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[] coin = {500, 100, 50, 10, 5, 1};
		
		int N = Integer.parseInt(br.readLine());
		
		int rest = 1000 - N;
		
		int count = 0;
		
		for(int i = 0; i < 6; i++) {
			if(rest >= coin[i]) {
				int tmp = rest / coin[i];
				rest -= tmp * coin[i];
				count += tmp;
			}
		}
		
		System.out.println(count);
	}
}
