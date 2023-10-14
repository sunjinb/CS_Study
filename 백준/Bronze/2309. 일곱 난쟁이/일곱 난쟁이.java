import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static final int N = 9;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int sum = 0;

        arr = new int[N];
        for(int i = 0; i < N; i++){
            int tmp = Integer.parseInt(br.readLine());
            arr[i] = tmp;
            sum += arr[i];
        }

        Arrays.sort(arr);

        L:for(int i = 0; i < N; i++){
            for(int j = i + 1; j < N; j++){
                int tmpSum = sum - arr[i] - arr[j];

                if(tmpSum == 100){
                    for(int k = 0; k < N; k++){
                        if(i == k || j == k) continue;
                        sb.append(arr[k] + "\n");
                    }
                    break L;
                }
            }
        }
        System.out.println(sb);
    }
}
