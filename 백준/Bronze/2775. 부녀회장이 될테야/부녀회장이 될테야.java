import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		int T = Integer.parseInt(br.readLine());
		
		int[][] map = new int[15][15];
		for(int j = 0; j <= 14; j++) {
			map[0][j] = j;
		}
		
		for(int i = 0; i <= 14; i++) {
			map[i][0] = 0;
			map[i][1] = 1;
		}
		
		for(int i = 1; i <= 14; i++) {
			for(int j = 1; j <= 14; j++) {
				map[i][j] = map[i][j - 1] + map[i - 1][j];
			}
		}
		
		for(int testCase = 0; testCase < T; testCase++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			System.out.println(map[k][n]);
		}
	}

}