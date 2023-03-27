import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		while(N > 1) {
			myFunc(N);
		}
	}
	private static void myFunc(int value) {
		for(int i = 2; i <= value; i++) {
			if(value % i == 0) {
				System.out.println(i);
				N /= i;
				return;
			}
		}
	}
}