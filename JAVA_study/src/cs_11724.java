import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class cs_11724 {

    static int N;
    static int[][] graph;  // 인접 행렬
    static boolean[] visited;  // 방문했는지

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 그래프 크기 할당
        graph = new int[N + 1][N + 1];

        // 간선의 양 끝 점 입력
        for(int i = 0 ; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            // 무방향그래프 두 방향에 값 할당
            graph[u][v] = 1;
            graph[v][u] = 1;
        }
        
        visited = new boolean[N + 1];
        int count = 0;

        // 아직 탐색하지 않았다면 탐색 후 요소 count++
        for(int i = 1; i < N + 1; i++){
            if(!visited[i]){
                dfs(i);
                count++;
            }
        }
        System.out.println(count);
    }

    public static void dfs(int node){
        // 방문한 정점으로 설정
        visited[node] = true;
        for(int i = 1; i <= N; i++){
            //아직 방문하지 않았고, 그래프에 값이 할당해있다면 탐색
            if(graph[node][i] == 1 && !visited[i]){
                dfs(i);
            }
        }
    }
}

