import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int row = 0;
		int col = 0;
		int max = -1;
		
		for(int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 9; j++) {
				int value = Integer.parseInt(st.nextToken());
				if(max < value) {
					max = value;
					row = i + 1;
					col = j + 1;
				}
			}
		}
		System.out.println(max);
		System.out.println(row + " " + col);
		

	}

}