import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int cnt = 1;

		int[][] map = new int[1001][1001];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());

			for (int j = y; j < y + h; j++) {
				for (int k = x; k < x + w; k++) {
					map[j][k] = cnt;
				}
			}
			cnt++;
		}

		int[] count = new int[N + 1];

		for (int i = 0; i < 1001; i++) {
			for (int j = 0; j < 1001; j++) {
				for (int k = 1; k <= N; k++) {
					if (map[i][j] == k) {
						count[k]++;
					}
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			System.out.println(count[i]);
		}

	}
}