import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static final int INF = 99999999;
    static int[] distance;
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
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ArrayList<Edge>[] list = new ArrayList[N + 1];

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

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        PriorityQueue<Edge> q = new PriorityQueue<>();
        distance = new int[N + 1];
        Arrays.fill(distance, INF);
        distance[S] = 0;

        q.add(new Edge(S, 0));
        while (!q.isEmpty()) {
            Edge now = q.poll();
            for(Edge next : list[now.to]){
                if (distance[now.to] + next.cost < distance[next.to]) {
                    distance[next.to] = distance[now.to] + next.cost;
                    q.add(new Edge(next.to, distance[next.to]));
                }
            }
        }
        System.out.println(distance[T]);
    }
}
