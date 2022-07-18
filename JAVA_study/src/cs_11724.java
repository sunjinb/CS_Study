import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class cs_11724 {

    static int N;
    static int M;
    static int[][] adj;  // 인접 행렬

    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u][v] = 1;
            adj[v][u] = 1;
        }

        visit = new boolean[N + 1];

        int count = 0; // 연결 요소 개수

        // 방문 배열을 돌면서 방문하지 않은 정점이 있으면 탐색하고 연결요소 개수 1 증가
        for(int i = 1; i < N + 1; i++){
            if(!visit[i]){
                dfs(i);
                count++;
            }
        }
        System.out.println(count);
    }
    public static void dfs(int start){
        visit[start] = true;
        
        // 방문 배열 처음부터 돌면서 간선이 연결되어 있고, 방문을 하지 않았다면 탐색
        for(int i = 1; i <= N; i++){
            if(adj[start][i] == 1 && !visit[i]){
                dfs(i);
            }
        }
    }
}
