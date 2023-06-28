import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, S, E;
    static boolean[] visited;
    static ArrayList<Integer>[] list;
    static class Point{
        int spot, depth;
        public Point(int spot, int depth){
            this.spot = spot;
            this.depth = depth;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list[x].add(y);
            list[y].add(x);
        }

        Queue<Point> q = new LinkedList<>();
        visited = new boolean[N + 1];

        q.add(new Point(S, 0));
        visited[S] = true;

        int result = 0;
        while (!q.isEmpty()) {
            Point now = q.poll();

            if(now.spot == E){
                result = now.depth;
                break;
            }

            int nextMinus = now.spot - 1;
            int nextPlus = now.spot + 1;

            if (nextMinus >= 1 && !visited[nextMinus]) {
                q.add(new Point(nextMinus, now.depth + 1));
                visited[nextMinus] = true;
            }

            if(nextPlus <= N && !visited[nextPlus]){
                q.add(new Point(nextPlus, now.depth + 1));
                visited[nextPlus] = true;
            }

            for (int key : list[now.spot]) {
                if(!visited[key]){
                    q.add(new Point(key, now.depth + 1));
                    visited[key] = true;
                }
            }
        }
        System.out.println(result);
    }
}
