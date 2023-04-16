import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] parents;
    static ArrayList<Edge> list;
    static class Edge implements Comparable<Edge>{
        int from, to, cost, alreadyLove;
        public Edge(int from, int to, int cost, int alreadyLove){
            this.from = from;
            this.to = to;
            this.cost = cost;
            this.alreadyLove = alreadyLove;
        }

        @Override
        public int compareTo(Edge o) {
            if (this.alreadyLove == o.alreadyLove) {
                return o.cost - this.cost;
            }
            else
                return o.alreadyLove - this.alreadyLove;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            int alreadyLove = Integer.parseInt(st.nextToken());
            list.add(new Edge(from, to, cost, alreadyLove));
        }

        Collections.sort(list);

        int giveUpLove = 0;
        makeSet();
        for(int i = 0; i < list.size(); i++){
            Edge edge = list.get(i);
            // 너넨 사랑할 수 없어
            if(!union(edge.from, edge.to)){
                giveUpLove += edge.cost;
            }
        }
        System.out.println(giveUpLove);
    }

    private static boolean union(int from, int to) {
        int rootFrom = findRoot(from);
        int rootTo = findRoot(to);

        // 둘의 부모가 같다면 삼각관계가 되는것이기에 불가능
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
        parents = new int[N + 1];
        for(int i = 1; i <= N; i++){
            parents[i] = i;
        }
    }
}
