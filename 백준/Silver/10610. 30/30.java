import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static String N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = br.readLine();
        arr = new int[N.length()];

        int count = 0;
        for(int i = 0; i < N.length(); i++){
            arr[i] = N.charAt(i) - '0';
            count += arr[i];
        }

        Arrays.sort(arr);
        if((count % 3 == 0) && (arr[0] == 0)){
            for(int i = N.length() - 1; i >= 0; i--){
                sb.append(arr[i]);
            }
        }
        else{
            sb.append(-1);
        }
        System.out.println(sb);

    }
}
