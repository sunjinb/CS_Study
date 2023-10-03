import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class cs_27498 {
    static int N, M;
    static int totalLove;
    static int totalCost;
    static boolean[] visited;
    static ArrayList<Node>[] list;
    static class Node implements Comparable<Node>{
        int to, cost, alreadyLove;
        public Node(int to, int cost, int alreadyLove){
            this.to = to;
            this.cost = cost;
            this.alreadyLove = alreadyLove;
        }
        @Override
        public int compareTo(Node o) {
            if(this.alreadyLove == o.alreadyLove){
                return o.cost - this.cost;
            }
            else{
                return o.alreadyLove - this.alreadyLove;
            }
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
            int alreadyLove = Integer.parseInt(st.nextToken());

            totalCost += cost;
            list[from].add(new Node(to, cost, alreadyLove));
            list[to].add(new Node(from, cost, alreadyLove));
        }

        prim();
        System.out.println(totalCost - totalLove);
    }

    private static void prim() {
        PriorityQueue<Node> q = new PriorityQueue<>();
        visited = new boolean[N + 1];
        q.add(new Node(1, 0, 0));

        while(!q.isEmpty()){
            Node now = q.poll();

            if(visited[now.to]) continue;
            visited[now.to] = true;

            totalLove += now.cost;
            for(Node next : list[now.to]){
                if(visited[next.to]) continue;
                else{
                    q.add(new Node(next.to, next.cost, next.alreadyLove));
                }
            }
        }
    }
}
