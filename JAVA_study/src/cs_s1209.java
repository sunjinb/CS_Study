import java.util.Scanner;

public class cs_s1209 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int testCaseCount = sc.nextInt();
            int[][] arr = new int[100][100];

            // 배열에 값 채워넣기
            for(int i = 0;  i < 100; i++){
                for(int j = 0; j < 100; j++){
                    arr[i][j] = sc.nextInt();
                }
            }

            int sum = 0;
            int max = 0;

            for(int i = 0; i < 100; i++){
                sum = 0;
                for(int j = 0; j < 100; j++){
                    sum += arr[i][j];
                }
                if(sum >= max) max = sum;
            }

            for(int j = 0; j < 100; j++){
                sum = 0;
                for(int i = 0; i < 100; i++){
                    sum += arr[i][j];
                }
                if(sum >= max) max = sum;
            }

            sum = 0;
            for(int i = 0; i < 100; i++){
                sum += arr[i][i];
            }
            if(sum >= max) max = sum;

            sum = 0;
            for(int i = 99, j = 0; i >= 0; i--, j++){
                sum += arr[j][i];
            }
            if(sum >= max) max = sum;

            System.out.println("#" + testCaseCount + " " + max);
        }
    }
}
