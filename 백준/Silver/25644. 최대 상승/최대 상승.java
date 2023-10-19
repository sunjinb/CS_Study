import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        int sell = arr[0];
        for(int i = 0; i < N; i++){
            int buy = arr[i] - sell;
            if(arr[i] < sell) sell = arr[i];
            max = Math.max(buy, max);
        }

        System.out.println(max);
    }
}
