import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] student = new int[2][6];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			student[S][Y - 1]++;
		}
		
		int count = 0;
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 6; j++) {
				if(student[i][j] % 2 == 0) {
					count += student[i][j] / 2;
				}
				else {
					count += student[i][j] / 2 + 1;
				}
			}
		}
		System.out.println(count);
	}

}

