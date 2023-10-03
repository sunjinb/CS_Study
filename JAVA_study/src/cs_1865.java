import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class cs_1865 {
    static int N, M, W;
    static final int INF = 987654321;
    static int[] distance;
    static ArrayList<Edge> list;
    static class Edge{
        int from, to, cost;
        public Edge(int from, int to, int cost){
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int testCase = 1; testCase <= T; testCase++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            list = new ArrayList<>();

            for(int i = 0; i < M; i++){
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                list.add(new Edge(from, to, cost));
                list.add(new Edge(to, from, cost));
            }

            for(int i = 0; i < W; i++){
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                // 웜홀은 단방향이고 가중치가 음수인 개념
                list.add(new Edge(from, to, -cost));
            }

            if(BellmanFord()) System.out.println("YES");
            else System.out.println("NO");
        }

    }

    // 그냥 음의 사이클이 발생하는지 안 하는지 여부만 판단하면 됨
    private static boolean BellmanFord() {
        distance = new int[N + 1];
        Arrays.fill(distance, INF);
        distance[1] = 0;

        // 시작점부터 이어지는 모든 연결된 부분들까지의 거리 최소 구해놓기
        for(int i = 1; i < N; i++){
            boolean flag = false;
            for(int j = 0; j < list.size(); j++){
                Edge edge = list.get(j);

                if(distance[edge.to] > distance[edge.from] + edge.cost){
                    distance[edge.to] = distance[edge.from] + edge.cost;
                    flag = true;
                }
            }
            if(!flag) break;
        }

        for(int i = 0; i < list.size(); i++){
            Edge edge = list.get(i);
            if(distance[edge.to] > distance[edge.from] + edge.cost){
                return true;
            }
        }
        return false;
    }
}
