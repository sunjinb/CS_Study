import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int vertexCount, edgeCount, caseCount;
    static StringBuilder sb;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;
        caseCount = 0;

        while(true){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            if(N == 0 && M == 0) break;

            visited = new boolean[N + 1];
            list = new ArrayList[N + 1];

            for(int i = 1; i <= N; i++){
                list[i] = new ArrayList<>();
            }

            for(int i = 0; i < M; i++){
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                list[from].add(to);
                list[to].add(from);
            }
            solution();
        }
        System.out.println(sb);
    }

    private static void solution() {
        caseCount++;
        int treeCount = 0;
        for(int i = 1; i <= N; i++){
            if(visited[i]) continue;
            vertexCount = 0;
            edgeCount = 0;
            dfs(i);
            if(edgeCount == (vertexCount - 1) * 2) treeCount++;
        }

        sb.append("Case ").append(caseCount).append(": ");
        if(treeCount == 0) sb.append("No trees.");
        else if(treeCount == 1) sb.append("There is one tree.");
        else sb.append("A forest of ").append(treeCount).append(" trees.");
        sb.append('\n');
    }

    private static void dfs(int now) {
        vertexCount++;
        edgeCount += list[now].size();
        visited[now] = true;
        for(int next: list[now]){
            if(visited[next]) continue;
            dfs(next);
        }
    }
}
