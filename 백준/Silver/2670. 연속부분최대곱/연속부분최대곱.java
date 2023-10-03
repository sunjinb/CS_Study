import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static double[] arr;
    static double[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new double[N];
        dp = new double[N];
        for(int i = 0; i < N; i++){
            arr[i] = Double.parseDouble(br.readLine());
        }

        dp[0] = arr[0];
        double result = 0;
        for(int i = 1; i < N; i++){
            dp[i] = Math.max(dp[i - 1] * arr[i], arr[i]);
            result = Math.max(dp[i], result);
        }

        System.out.printf("%.3f", result);
    }
}
