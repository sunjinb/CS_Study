import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class cs_s2071 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        double[] result = new double[T];

        for(int i = 0; i < T; i++){
            int sum = 0;
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 10; j++){
                sum += Integer.parseInt(st.nextToken());
            }
            result[i] = (double)sum / 10;
        }

        for(int i = 0; i < T; i++){
            System.out.printf("#%d %.0f\n", (i + 1), result[i]);
        }
    }
}
