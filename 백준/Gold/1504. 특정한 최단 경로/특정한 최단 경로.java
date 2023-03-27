import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int sum;
    static int result;
    static final int INF = 200000000;
    static int mustA, mustB;
    static int[] distance;
    static boolean[] visited;
    static ArrayList<Node>[] list;
    static class Node implements Comparable<Node>{
        int to, cost;
        public Node(int to, int cost){
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

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
            list[from].add(new Node(to, cost));
            list[to].add(new Node(from, cost));
        }

        st = new StringTokenizer(br.readLine());
        mustA = Integer.parseInt(st.nextToken());
        mustB = Integer.parseInt(st.nextToken());

        result = Integer.MAX_VALUE;
        // 0에서 mustA까지, mustA에서 mustB까지, mustB에서 N까지
        sum = 0;
        boolean flag = true;
        if(dijkstra(1, mustA)) sum += distance[mustA];
        else flag = false;
        if(dijkstra(mustA, mustB)) sum += distance[mustB];
        else flag = false;
        if(dijkstra(mustB, N)) sum += distance[N];
        else flag = false;
        if(flag && sum < result) result = sum;

        // 0에서 mustB까지, mustB에서 mustA까지, mustA에서 N까지
        sum = 0;
        flag = true;
        if(dijkstra(1, mustB)) sum += distance[mustB];
        else flag = false;
        if(dijkstra(mustB, mustA)) sum += distance[mustA];
        else flag = false;
        if(dijkstra(mustA, N)) sum += distance[N];
        else flag = false;
        if(flag && sum < result) result = sum;

        if(result == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(result);
    }

    private static boolean dijkstra(int start, int end) {
        distance = new int[N + 1];
        visited = new boolean[N + 1];
        Arrays.fill(distance, INF);
        distance[start] = 0;
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(start, 0));

//        System.out.println("다익스트라 시작");
        while (!q.isEmpty()) {
            Node now = q.poll();
//            System.out.println("now : " + now.to + " cost : " + now.cost);
            if(visited[now.to]) continue;
            visited[now.to] = true;

            if(now.to == end) {
                break;
            }

            for(Node next : list[now.to]){
                if(distance[now.to] + next.cost < distance[next.to]){
                    distance[next.to] = distance[now.to] + next.cost;
                    q.add(new Node(next.to, distance[next.to]));
                }
            }
        }
            if(distance[end] == INF) return false;
            else {
                return true;
            }
    }
}
