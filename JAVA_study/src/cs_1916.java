import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class cs_1916 {
    static int N, M;
    static final int INF = Integer.MAX_VALUE;
    static int[] distance;
    static boolean[] visited;
    static Queue<Node> q;
    static HashMap<Integer, ArrayList<Node>> map;
    static class Node{
        int to, cost;
        public Node(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        map = new HashMap<Integer, ArrayList<Node>>();
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            if(map.containsKey(from)){
                map.get(from).add(new Node(to, cost));
            }else {
                ArrayList<Node> nodes = new ArrayList();
                nodes.add(new Node(to, cost));
                map.put(from, nodes);
            }
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        distance = new int[N + 1];
        visited = new boolean[N + 1];

        Arrays.fill(distance, INF);
        distance[start] = 0;

        q = new LinkedList<>();
        q.add(new Node(start, 0)); // 시작점, 시작점에서 시작점으로 가는 비용은 0

        while(!q.isEmpty()){
            Node now = q.poll();

            if(visited[now.to]) continue;

            // 현재 지점 방문 처리
            visited[now.to] = true;
            // 현재 지점과 인접한 노드가 존재한다면
            if(map.get(now.to) != null){
                for(Node next: map.get(now.to)){
                    if(distance[now.to] + next.cost < distance[next.to]){
                        distance[next.to] = distance[now.to] + next.cost;
                    }
                }
            }
            nextNode();
        }
        System.out.println(distance[end]);
    }

    private static void nextNode() {
        int min = INF;
        int next = -1;

        for(int i = 1; i <= N; i++){
            if(!visited[i] && distance[i] < min){
                next = i;
                min = distance[i];
            }
        }
        if(next > 0) q.add(new Node(next, min));
    }
}
