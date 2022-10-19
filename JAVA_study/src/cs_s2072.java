import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class cs_s2072 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        int[] result = new int[T];
        int tmp = 0;

        for(int i = 0; i < T; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 10; j++){
                tmp = Integer.parseInt(st.nextToken());
                if(tmp % 2 == 1){
                    result[i] += tmp;
                }
            }
        }

        for(int i = 0; i < T; i++){
            System.out.println("#" + (i + 1) + " " + result[i]);
        }
    }
}
