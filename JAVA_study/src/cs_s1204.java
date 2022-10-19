import java.util.Scanner;

public class cs_s1204 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/


        for(int test_case = 1; test_case <= T; test_case++)
        {
            int[] arr = new int[101];
            int max = 0;
            int result = 0;
            int num = sc.nextInt();

            for(int i = 0; i < 1000; i++){
                int score = sc.nextInt();
                arr[score]++;
            }
            for(int i = 0; i < 101; i++){
                if(max <= arr[i]){
                    max = arr[i];
                    result = i;
                }
            }
            System.out.printf("#%d %d", test_case, result);
            System.out.println();
        }

    }
}
