import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int J, N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int testCase = 1; testCase <= T; testCase++){
            st = new StringTokenizer(br.readLine());
            J = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            arr = new int[N];

            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                int R = Integer.parseInt(st.nextToken());
                int C = Integer.parseInt(st.nextToken());

                arr[i] = R * C;
            }

            Arrays.sort(arr);

            int result = 0;
            for(int i = N - 1; i >= 0; i--){
                J -= arr[i];
                result++;

                if(J <= 0) break;
            }

            System.out.println(result);
        }
    }
}
