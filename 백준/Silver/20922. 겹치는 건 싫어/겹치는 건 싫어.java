import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int N, K;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        arr = new int[N];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] count = new int[100001];
        count[arr[0]]++;
        int start = 0;
        int answer = 1;

        for (int i = 1; i < N; i++) {
            count[arr[i]]++;
            if (count[arr[i]] > K) {
                for (int j = start; j < i; j++) {
                    count[arr[j]]--;
                    if (arr[i] == arr[j]) {
                        start = j + 1;
                        break;
                    }
                }
            }
            answer = Math.max(answer, i - start + 1);
        }

        System.out.println(answer);
    }
}
