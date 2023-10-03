import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class cs_1904 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int result = 0;
        if(N == 1 || N == 2) result = N;
        else {
            int tmp1 = 1;
            int tmp2 = 2;
            int sum = 0;

            for (int i = 2; i < N; i++) {
                sum = (tmp2 + tmp1) % 15746;
                tmp1 = tmp2;
                tmp2 = sum;
            }
            result = sum;
        }
        System.out.println(result);
    }
}