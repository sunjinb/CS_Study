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

        int left = 0;
        int right = N - 1;
        int result = Integer.MAX_VALUE;
        while(true){
            if(left == right) break;

            int diff = arr[left] + arr[right];
            if(Math.abs(diff) < Math.abs(result)){
                result = diff;
            }

            if(diff == 0) break;
            else if(diff < 0){
                left++;
            }
            else if(diff > 0){
                right--;
            }
        }

        System.out.println(result);
    }
}
