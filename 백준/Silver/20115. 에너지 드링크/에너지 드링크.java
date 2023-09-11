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

        int max = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(max < arr[i]) max = arr[i];
        }

        double sum = max;
        for(int i = 0; i < N; i++){
            if(arr[i] == max) continue;
            else{
                sum += arr[i] / 2.0;
            }
        }

        System.out.println(sum);
    }
}
