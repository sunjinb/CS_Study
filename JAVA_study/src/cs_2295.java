import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class cs_2295 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] U = new int[N];

        for(int i = 0; i < N; i++){
            U[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(U);

        int result = 0;


        System.out.println(result);
    }
}
