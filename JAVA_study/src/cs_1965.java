import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class cs_1965 {
    static int N;
    static int[] dp;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 얘까지 최대 몇개를 넣을 수 있는지
        dp = new int[N];
        for(int i = 0; i < N; i++){
            dp[i] = 1;
            int tmpMax = 0;
            int maxIdx = -1;
            for(int j = 1; j <= i; j++){
                if(arr[j - 1] < arr[i]){
                    if(tmpMax < dp[j - 1]) {
                        tmpMax = dp[j - 1];
                        maxIdx = j - 1;
                    }
                }
            }
            if(maxIdx != -1) dp[i] = dp[maxIdx] + 1;
        }

        int max = 0;
        for(int i = 0; i < N; i++){
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
