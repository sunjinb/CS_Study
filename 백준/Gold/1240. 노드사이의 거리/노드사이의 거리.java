import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static boolean[] visited;
    static ArrayList<Node>[] list;
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

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < N - 1; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[from].add(new Node(to, cost));
            list[to].add(new Node(from, cost));
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            sb.append(bfs(from, to) + "\n");
        }
        System.out.println(sb);
    }

    private static int bfs(int from, int to) {
        Queue<Node> q = new LinkedList<>();
        visited = new boolean[N + 1];

        q.add(new Node(from, 0));
        visited[from] = true;

        int result = 0;
        while(!q.isEmpty()){
            Node now = q.poll();

            if(now.to == to){
                result = now.cost;
                break;
            }

            for(Node next : list[now.to]){
                if(!visited[next.to]){
                    visited[next.to] = true;
                    q.add(new Node(next.to, now.cost + next.cost));
                }
            }
        }
        return result;
    }
}
