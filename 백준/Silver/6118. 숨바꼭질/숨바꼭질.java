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
    static ArrayList<Integer>[] list;
    static class Point{
        int to, cost;
        public Point(int to, int cost){
            this.to = to;
            this.cost = cost;
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

            list[from].add(to);
            list[to].add(from);
        }

        visited = new boolean[N + 1];
        Queue<Point> q = new LinkedList<>();
        visited[1] = true;
        q.add(new Point(1, 0));

        int distance = 0;
        int hidePoint = 0;
        int count = 0;

        while(!q.isEmpty()){
            Point now = q.poll();

            if(now.cost > distance){
                distance = now.cost;
                hidePoint = now.to;
                count = 1;
            }

            else if(now.cost == distance){
                if(hidePoint > now.to) hidePoint = now.to;
                count++;
            }

            for(int next : list[now.to]){
                if(!visited[next]){
                    visited[next] = true;
                    q.add(new Point(next, now.cost + 1));
                }
            }
        }

        System.out.println(hidePoint + " " + distance + " " + count);
    }
}
