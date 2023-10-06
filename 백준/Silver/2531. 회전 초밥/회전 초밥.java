import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, D, K, C;
    static int[] eating;
    static int[] sushi;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        eating = new int[D + 1];
        eating[C] = 3001;
        sushi = new int[N];
        int count = 1;

        for (int i = 0; i < N; i++)
            sushi[i] = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            int sushiId = sushi[i];
            if (eating[sushiId] == 0)
                count++;
            eating[sushiId]++;
        }
        int max = count;

        for (int i = 0; i < N - 1; i++) {
            int sushiId = sushi[i];
            int eatingId = sushi[i + K < N ? i + K : (i + K) % N];
            if (--eating[sushiId] == 0)
                count--;
            if (++eating[eatingId] == 1)
                count++;
            max = Math.max(max, count);
        }
        System.out.println(max);
    }
}