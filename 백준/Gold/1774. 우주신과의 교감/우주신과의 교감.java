import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] parent;
    static ArrayList<Edge> edgeList;

    static class Point {
        int idx;
        double row;
        double col;

        Point(int idx, double row, double col) {
            this.idx = idx;
            this.row = row;
            this.col = col;
        }
    }
    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        double cost;

        Edge(int from, int to, double cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            if (cost < o.cost) {
                return -1;
            }
            return 1;
        }

    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        makeSet();

        Point[] pointList = new Point[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            double row = Double.parseDouble(st.nextToken());
            double col = Double.parseDouble(st.nextToken());

            pointList[i] = new Point(i, row, col);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            union(from, to);
        }

        edgeList = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            Point now = pointList[i];
            for (int j = i + 1; j <= N; j++) {
                Point next = pointList[j];
                double weight = Math.sqrt(Math.pow(now.row - next.row, 2) + Math.pow(now.col - next.col, 2));
                edgeList.add(new Edge(pointList[i].idx, pointList[j].idx, weight));
            }
        }
        Collections.sort(edgeList);

        double result = 0;

        for (int i = 0; i < edgeList.size(); i++) {
            Edge edge = edgeList.get(i);

            if (find(edge.from) != find(edge.to)) {
                result += edge.cost;
                union(edge.from, edge.to);
            }
        }
        System.out.println(String.format("%.2f", result) + "\n");
    }

    private static void makeSet() {
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
    }

    public static int find(int val) {
        if (val == parent[val]) return val;
        else return parent[val] = find(parent[val]);
    }

    public static void union(int from, int to) {
        int rootFrom = find(from);
        int rootTo = find(to);

        if (rootFrom != rootTo) {
            parent[rootTo] = rootFrom;
        }
    }

}