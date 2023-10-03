import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class cs_2847 {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int result = 0;
        for(int i = N - 1; i > 0; i--){
            if(arr[i - 1] >= arr[i]){
                result += arr[i - 1] - arr[i] + 1;
                arr[i - 1] = arr[i] - 1;
            }
        }
        System.out.println(result);
    }
}