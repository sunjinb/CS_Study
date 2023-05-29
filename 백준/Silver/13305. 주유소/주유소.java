import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] len;
    static int[] cost;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        len = new int[N - 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < len.length; i++){
            len[i] = Integer.parseInt(st.nextToken());
        }

        cost = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < cost.length; i++){
            cost[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int minCost = cost[0];

        for(int i = 0; i < N - 1; i++){
            if(cost[i] < minCost){
                minCost = cost[i];
            }
            sum += minCost * len[i];
        }

        System.out.println(sum);
    }
}
