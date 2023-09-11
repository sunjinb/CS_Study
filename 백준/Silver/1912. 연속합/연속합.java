import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N];
        dp[0] = arr[0];
        for(int i = 1; i < N; i++){
            dp[i] = Math.max(arr[i], dp[i - 1] + arr[i]);
        }

        int result = -1001;
        for(int i = 0; i < N; i++){
            result = Math.max(result, dp[i]);
        }

        System.out.println(result);
    }
}
