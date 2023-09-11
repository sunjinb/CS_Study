import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int P, W;
    static int C, V;
    static int[] parents;
    static ArrayList<Edge> list;
    static class Edge implements Comparable<Edge>{
        int from, to, width;
        public Edge(int from, int to, int width){
            this.from = from;
            this.to = to;
            this.width = width;
        }

        @Override
        public int compareTo(Edge o) {
            return o.width - this.width;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        P = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for(int i = 0; i < W; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int width = Integer.parseInt(st.nextToken());
            list.add(new Edge(from, to, width));
        }

        Collections.sort(list);
        makeSet();

        int result = -1;
        for(int i = 0; i < list.size(); i++){
            Edge now = list.get(i);

            int from = now.from;
            int to = now.to;

            if(union(from, to)){
                result = now.width;
            }

            if(findRoot(C) == findRoot(V)) break;
        }
        System.out.println(result);
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
        parents = new int[P];
        for(int i = 0; i < P; i++){
            parents[i] = i;
        }
    }
}
