import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, S;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int onePointer = 0;
        int twoPointer = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        while(true){
            // 현재까지 합이 S이상일 경우
            if(S <= sum){
                sum -= arr[onePointer];
                onePointer++;
                int tmpLength = twoPointer - onePointer + 1;
                minLength = Math.min(tmpLength, minLength);
            }
            else if(twoPointer == N){
                break;
            }
            // 조건 충족 안되는 경우
            else{
                sum += arr[twoPointer];
                twoPointer++;
            }
        }

        if(minLength == Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(minLength);
    }
}
