import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int A, B, T, W;
    static int[] distance;
    static final int INF = 1000001;
    static class Info {
        int to, cost, time;
        public Info(int to, int cost, int time) {
            this.to = to;
            this.cost = cost;
            this.time = time;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        List<Info>[] list = new ArrayList[N + 1];
        distance = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        Arrays.fill(distance, INF);

        PriorityQueue<Info> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            T = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            list[A].add(new Info(B, T, W));
        }

        pq.add(new Info(1, 0, 0));
        distance[1] = 0;

        while (!pq.isEmpty()){

            Info now = pq.poll();
            if (now.to == N){
                System.out.println(now.cost);
                break;
            }

            for (Info next : list[now.to]) {

                int cur = distance[now.to] % next.time == 0 ? distance[now.to] : distance[now.to] + next.time - distance[now.to] % next.time;

                if (distance[next.to] > cur + next.cost){
                    distance[next.to] = cur + next.cost;
                    pq.add(new Info(next.to, distance[next.to], next.time));
                }
            }
        }
    }
}