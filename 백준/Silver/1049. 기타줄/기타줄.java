import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int minDas = Integer.MAX_VALUE;
        int minOne = Integer.MAX_VALUE;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int das = Integer.parseInt(st.nextToken());
            int one = Integer.parseInt(st.nextToken());

            if(das < minDas) minDas = das;
            if(one < minOne) minOne = one;
        }

        int needDas = N / 6;
        int needOne = N % 6;

        int result = Integer.MAX_VALUE;

        // 다스로만 구매할 경우
        result = Math.min(result, (needDas + 1) * minDas);

        // 낱개로만 구매할 경우
        result = Math.min(result, N * minOne);

        // 다스로 다 구매하고 낱개만 낱개로 구매
        result = Math.min(result, needDas * minDas + needOne * minOne);

        System.out.println(result);
    }
}
