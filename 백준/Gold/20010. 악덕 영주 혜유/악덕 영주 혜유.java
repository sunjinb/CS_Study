import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int startPoint, maxDistance;
    static int[] parents;
    static boolean[] visited;
    static ArrayList<Node>[] list;
    static ArrayList<Edge> minList;
    static class Edge implements Comparable<Edge>{
        int from, to, cost;
        public Edge(int from, int to, int cost){
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
    static class Node{
        int to, cost;
        public Node(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        list = new ArrayList[N];
        for(int i = 0; i < N; i++){
            list[i] = new ArrayList<>();
        }

        minList = new ArrayList<>();
        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            minList.add(new Edge(from, to, cost));
        }

        makeSet();
        Collections.sort(minList);

        int minCount = 0;
        int minResult = 0;
        for(int i = 0; i < minList.size(); i++){
            Edge now = minList.get(i);
            if(union(now.from, now.to)){
                minResult += now.cost;
                minCount++;
                list[now.from].add(new Node(now.to, now.cost));
                list[now.to].add(new Node(now.from, now.cost));
            }
            if(minCount == N - 1) break;
        }

        maxDistance = 0;
        visited = new boolean[N];
        visited[0] = true;
        dfs(0, 0);

        maxDistance = 0;
        visited = new boolean[N];
        visited[startPoint] = true;
        dfs2(startPoint, 0);

        System.out.println(minResult);
        System.out.println(maxDistance);
    }

    private static void dfs2(int point, int sum) {
        if(maxDistance < sum){
            maxDistance = sum;
        }

        for(Node next : list[point]){
            if(!visited[next.to]){
                visited[next.to] = true;
                dfs2(next.to, sum + next.cost);
//                visited[next.to] = false;
            }
        }
    }

    private static void dfs(int point, int sum) {
        if(maxDistance < sum){
            maxDistance = sum;
            startPoint = point;
        }

        for(Node next : list[point]){
            if(!visited[next.to]){
                visited[next.to] = true;
                dfs(next.to, sum + next.cost);
//                visited[next.to] = false;
            }
        }
    }

    private static boolean union(int from, int to) {
        int rootFrom = findRoot(from);
        int rootTo = findRoot(to);

        if(rootFrom == rootTo){
            return false;
        }
        else{
            parents[rootFrom] = rootTo;
            return true;
        }
    }

    private static int findRoot(int val) {
        if(parents[val] == val) return val;
        else return parents[val] = findRoot(parents[val]);
    }

    private static void makeSet() {
        parents = new int[N];
        for(int i = 0; i < N; i++){
            parents[i] = i;
        }
    }
}
