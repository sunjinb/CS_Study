import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K, B;
    static int[] sum;
    static boolean[] isBroken;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        sum = new int[N + 1];
        isBroken = new boolean[N + 1];
        for(int i = 0; i < B; i++){
            int tmp = Integer.parseInt(br.readLine());
            isBroken[tmp] = true;
        }

        int count = 0;
        for(int i = 1; i <= K; i++){
            if(isBroken[i]) count++;
        }

        sum[K] = count;

        int result = count;

        for(int i = K + 1; i <= N; i++){
            int tmp = sum[i - 1];
            if(isBroken[i]) tmp++;
            if(isBroken[i - K]) tmp--;

            sum[i] = tmp;
            result = Math.min(result, tmp);
        }

        System.out.println(result);
    }
}
