import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 누적합 넣어놓는 개념
        arr = new int[1000004];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            arr[x] += g;
        }

        int sum = 0;
        for(int i = 0; i < 1 + 2*K && i <= 1000000; i++){
            sum += arr[i];
        }

        int max = sum;
        for(int i = 1 + 2*K, j = 0; i <= 1000000; i++, j++){
            sum -= arr[j];
            sum += arr[i];
            if(sum > max) max = sum;
        }

        System.out.println(max);
    }
}
