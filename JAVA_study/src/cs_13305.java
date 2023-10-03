import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class cs_13305 {
    static int N;
    static long[] len;
    static long[] cost;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        len = new long[N - 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < len.length; i++){
            len[i] = Long.parseLong(st.nextToken());
        }

        cost = new long[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < cost.length; i++){
            cost[i] = Long.parseLong(st.nextToken());
        }

        long sum = 0;
        long minCost = cost[0];

        for(int i = 0; i < N - 1; i++){
            if(cost[i] < minCost){
                minCost = cost[i];
            }
            sum += minCost * len[i];
        }

        System.out.println(sum);
    }
}
