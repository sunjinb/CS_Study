import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    static int N;
    static BigInteger[] arr;
    static BigInteger[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new BigInteger[N + 2];
        arr[1] = new BigInteger("1");
        arr[2] = new BigInteger("1");
        for(int i = 3; i <= N; i++){
            arr[i] = arr[i - 2].add(arr[i - 1]);
        }

        dp = new BigInteger[N + 2];
        dp[1] = new BigInteger("4");
        dp[2] = new BigInteger("6");
        for(int i = 3; i <= N; i++){
            dp[i] = dp[i - 2].add(dp[i - 1]);
        }

        System.out.println(dp[N]);
    }
}
