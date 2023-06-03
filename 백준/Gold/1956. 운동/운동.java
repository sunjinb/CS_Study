import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int V, E;
    static final int INF = 987654321;
    static int[][] cost;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        cost = new int[V + 1][V + 1];
        for(int i = 1; i <= V; i++){
            for(int j = 1; j <= V; j++){
                cost[i][j] = INF;
            }
        }

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            cost[a][b] = c;
        }

        for(int k = 1; k <= V; k++){
            for(int i = 1; i <= V; i++){
                if(i == k) continue;
                for(int j = 1; j <= V; j++){
                    if(j == k || i == j) continue;

                    if(cost[i][k] != INF && cost[k][j] != INF){
                        cost[i][j] = Math.min(cost[i][j], cost[i][k] + cost[k][j]);
                    }
                }
            }
        }

        int result = INF;
        for(int i = 1; i <= V; i++){
            for(int j = 1; j <= V; j++){
                if(i == j) continue;
                if(cost[i][j] != INF && cost[j][i] != INF){
                    result = Math.min(result, cost[i][j] + cost[j][i]);
                }
            }
        }

        if(result != INF) System.out.println(result);
        else System.out.println(-1);
    }
}
