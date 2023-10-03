import java.io.*;
import java.util.*;

public class cs_1003 {
    static int N;
    static int[][] memo = new int[41][2]; // 호출 횟수 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i = 0; i < 41; i++){
            for(int j = 0; j < 2; j++){
                memo[i][j] = -1;
            }
        }

        memo[0][0] = 1;
        memo[0][1] = 0;
        memo[1][0] = 0;
        memo[1][1] = 1;

        int T = Integer.parseInt(br.readLine());
        for(int testCase = 1; testCase <= T; testCase++) {
            N = Integer.parseInt(br.readLine());
            fibo(N);
            System.out.println(memo[N][0] + " " + memo[N][1]);
        }
    }
    private static int[] fibo(int n) {
        if(memo[n][0] == -1 || memo[n][1] == -1){
            memo[n][0] = fibo(n - 1)[0] + fibo(n - 2)[0];
            memo[n][1] = fibo(n - 1)[1] + fibo(n - 2)[1];
        }

        return memo[n];
    }
}
