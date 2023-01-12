import java.util.Scanner;

 class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for(int test_case = 1; test_case <= T; test_case++)
        {

            int N = sc.nextInt();
            int M = sc.nextInt();
            int[] N_arr = new int[N];
            int[] M_arr = new int[M];
            for(int i = 0; i < N; i++){
                N_arr[i] = sc.nextInt();
            }
            for(int i = 0; i < M; i++){
                M_arr[i] = sc.nextInt();
            }

            int max = 0;
            int sum = 0;

            if(N < M) {
                for(int i = 0; i < M - N + 1; i++){
                    for(int j = 0; j < N; j++){
                        sum += N_arr[j] * M_arr[j+i];
                    }
                    if(sum > max) {
                        max = sum;
                    }
                    sum = 0;
                }
            }
            else if(N > M){
                for(int i = 0; i < N - M + 1; i++){
                    for(int j = 0; j < M; j++){
                        sum += M_arr[j] * N_arr[j+i];
                    }
                    if(sum > max) {
                        max = sum;
                    }
                    sum = 0;
                }
            }
            else{
                for(int i = 0; i < N; i++){
                    sum += N_arr[i] * M_arr[i];
                }
            }
            System.out.println("#" + test_case + " " + max);
        }
    }
}
