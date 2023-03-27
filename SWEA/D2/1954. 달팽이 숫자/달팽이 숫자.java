import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
				
		int count = 1;
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[][] map = new int[N][N];
			int row = 0;
			int col = 0;
			map[0][0] = 1;
			for(int i = 2; i <= N * N; i++) {
				if(count == 1) {
					col++;
					if(col >= N || map[row][col] != 0) {
						col--;
						count++;
						i--;
						continue;
					}
				}
				else if(count == 2) {
					row++;
					if(row >= N || map[row][col] != 0) {
						row--;
						count++;
						i--;
						continue;
					}
				}
				else if(count == 3) {
					col--;
					if(col < 0 || map[row][col] != 0) {
						col++;
						count++;
						i--;
						continue;
					}
				}
				else if(count == 4) {
					row--;
					if(row < 0 || map[row][col] != 0) {
						row++;
						count = 1;
						i--;
						continue;
					}
				}
				map[row][col] = i;
			}
			
			System.out.println("#" + test_case);
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}
