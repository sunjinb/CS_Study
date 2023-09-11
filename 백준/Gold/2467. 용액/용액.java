import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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

        Arrays.sort(arr);

        int onePointer = 0;
        int twoPointer = N - 1;

        int result1 = 0;
        int result2 = 0;
        int closeToZero = Integer.MAX_VALUE;

        while (onePointer <= twoPointer) {
            int tmp = arr[onePointer] + arr[twoPointer];

//            System.out.println(arr[onePointer] + " " + arr[twoPointer]);

            if (Math.abs(tmp) <= closeToZero) {
                closeToZero = Math.abs(tmp);
                result1 = arr[onePointer];
                result2 = arr[twoPointer];
            }

            if(tmp == 0) break;
            else if(tmp > 0){
                twoPointer--;
            }
            else{
                onePointer++;
            }

            if (onePointer == twoPointer) {
                break;
            }
        }

        System.out.println(result1 + " " + result2);
    }
}
