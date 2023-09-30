import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static class Edge implements Comparable<Edge>{
        int to, cost;
        public Edge(int to, int cost){
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
    static int[] distance;
    static final int INF = Integer.MAX_VALUE;
    static boolean[] visited;
    static ArrayList<Edge>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int testCase = 1; testCase <= T; testCase++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            list = new ArrayList[N + 1];
            for(int i = 1; i <= N; i++){
                list[i] = new ArrayList<>();
            }

            for(int i = 0; i < M; i++){
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                list[from].add(new Edge(to, cost));
                list[to].add(new Edge(from, cost));
            }

            K = Integer.parseInt(br.readLine());
            int[] answer = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < K; i++){
                int person = Integer.parseInt(st.nextToken());
                dijkstra(person);
                for(int j = 1; j <= N; j++){
                    answer[j] += distance[j];
                }
            }

            int result = Integer.MAX_VALUE;
            int resultIdx = 0;

            for(int i = 1; i <= N; i++){
                if(answer[i] < result){
                    result = answer[i];
                    resultIdx = i;
                }
            }
            System.out.println(resultIdx);
        }
    }

    private static void dijkstra(int start) {
        distance = new int[N + 1];
        Arrays.fill(distance, INF);
        visited = new boolean[N + 1];

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Edge now = pq.poll();

            if(visited[now.to]) continue;
            visited[now.to] = true;

            for(Edge next: list[now.to]){
                if (distance[next.to] > distance[now.to] + next.cost) {
                    distance[next.to] = distance[now.to] + next.cost;
                    pq.add(new Edge(next.to, distance[next.to]));
                }
            }
        }
    }
}
