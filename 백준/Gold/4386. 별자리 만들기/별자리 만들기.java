import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] parents;
    static Star[] stars;
    static ArrayList<Edge> list;
    static class Star{
        int num;
        double x;
        double y;
        public Star(int num, double x, double y){
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }
    static class Edge implements Comparable<Edge>{
        int from, to;
        double cost;
        public Edge(int from, int to, double cost){
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            if(this.cost < o.cost){
                return -1;
            }
            else return 1;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        stars = new Star[N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            stars[i] = new Star(i, x, y);
        }
        list = new ArrayList<>();

        parents = new int[N];
        for(int i = 0; i < N; i++){
            parents[i] = i;
        }

        for(int i = 0; i < N; i++){
            for(int j = i + 1; j < N; j++){
                double cost = Math.sqrt(Math.pow(stars[i].x - stars[j].x, 2) + Math.pow(stars[i].y - stars[j].y, 2));
                list.add(new Edge(stars[i].num, stars[j].num, cost));
            }
        }

        Collections.sort(list);

        double result = 0;

        for(int i = 0; i < list.size(); i++){
            Edge now = list.get(i);

            int rootFrom = findRoot(now.from);
            int rootTo = findRoot(now.to);

            if(rootFrom != rootTo){
                result += now.cost;
                parents[rootFrom] = rootTo;
            }
        }

        System.out.println(result);

    }

    private static int findRoot(int val) {
        if(parents[val] == val) return val;
        else return parents[val] = findRoot(parents[val]);
    }
}
