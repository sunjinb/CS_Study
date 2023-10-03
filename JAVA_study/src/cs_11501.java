import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class cs_11501 {
    static int N;
    static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int testCase = 1; testCase <= T; testCase++){
            N = Integer.parseInt(br.readLine());
            arr = new long[N];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                int tmp = Integer.parseInt(st.nextToken());
                arr[i] = tmp;
            }

            long max = 0;
            long result = 0;
            for(int i = N - 1; i >= 0; i--){
                if(arr[i] > max){
                    max = arr[i];
                }
                else{
                    result += max - arr[i];
                }
            }
            sb.append(result + "\n");
        }
        System.out.println(sb);
    }
}
