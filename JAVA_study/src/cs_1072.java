import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class cs_1072 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        long X = Long.parseLong(st.nextToken());
        long Y = Long.parseLong(st.nextToken());

        long Z = 100 * Y / X;

        if(Z >= 99){
            System.out.println(-1);
        }
        else {
            long start = 0;
            long end = 2000000000;

            while (start < end){
                long mid = (start + end) / 2;
                long current = 100 * (Y + mid) / (X + mid);

                if(current > Z){
                    end = mid;
                }
                else{
                    start = mid + 1;
                }
            }
            System.out.println(end);
        }
    }
}
