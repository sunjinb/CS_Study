import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] arr;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        result = 0;
        arr = new int[K];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < K; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        dfs(0);
        System.out.println(result);
    }

    private static void dfs(int now) {
        if(now > N) return;

        if(result < now) result = now;

        for(int i = K - 1; i >= 0; i--){
            dfs(now * 10 + arr[i]);
        }
    }
}
