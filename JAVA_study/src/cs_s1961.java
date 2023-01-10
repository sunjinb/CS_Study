import java.util.Scanner;

public class cs_s1961 {
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for(int test_case = 1; test_case <= T; test_case++)
        {
            N = sc.nextInt();
            int[][] arr = new int[N][N];

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            System.out.println("#" + test_case);
            for(int i = 0; i < N; i++) {
                first(arr, i);
                second(arr, N - i);
                third(arr, N - i);
                System.out.println();
            }

        }
    }

    public static void first(int[][] arr, int col) {
        for(int i = N; i > 0; i--) {
            System.out.print(arr[i - 1][col]);
        }
        System.out.print(" ");
    }

    public static void second(int[][] arr, int row) {
        for(int i = N; i > 0; i--) {
            System.out.print(arr[row - 1][i - 1]);
        }

        System.out.print(" ");
    }

    public static void third(int[][] arr, int col) {
        for(int i = 0; i < N; i++) {
            System.out.print(arr[i][col - 1]);
        }
        System.out.print(" ");
    }
}
