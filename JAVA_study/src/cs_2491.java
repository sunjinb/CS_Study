import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class cs_2491 {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 증가 찾기
        int plusMax = 1;
        int plusCount = 1;
        for(int i = 0; i < N - 1; i++){
            if(arr[i] <= arr[i + 1]){
                plusCount++;
            }
            else{
                plusCount = 1;
            }
            if(plusMax < plusCount) plusMax = plusCount;
        }

        // 감소 찾기
        int minusMax = 1;
        int minusCount = 1;
        for(int i = 0; i < N - 1; i++){
            if(arr[i] >= arr[i + 1]){
                minusCount++;
            }
            else{
                minusCount = 1;
            }
            if(minusMax < minusCount) minusMax = minusCount;
        }

        System.out.println(Math.max(plusMax, minusMax));
    }
}
