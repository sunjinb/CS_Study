import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class cs_2003 {
    static int N, M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int startPointer = 0;
        int endPointer = 0;
        int sum = 0;
        int result = 0;
        while(true){
            // 현재까지 S ~ E 더한게 목표보다 크거나 같다면!
            if(sum >= M){
                sum -= arr[startPointer];
                startPointer++;
            }
            else if(endPointer >= N){
                break;
            }
            // 현재까지 S ~ E 더한게 목표만큼 안 나온다면
            else{
                sum += arr[endPointer];
                endPointer++;
            }
            // 현재까지 S ~ E 더한게 목표라면!
            if(sum == M){
                result++;
            }
        }
        System.out.println(result);
    }
}
