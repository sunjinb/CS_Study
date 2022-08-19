import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class cs_12851 {
    static int N, K;
    static int time;
    static int count;
    static int[] visited;

    static class Point {
        int point;
        int time;

        public Point(int point, int time){
            this.point = point;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new int[100001];

        bfs(N);
        System.out.println(time);
        System.out.println(count);
    }


    public static void bfs(int start){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(start, 0));
        visited[start] = 1;

        while (!q.isEmpty()) {
            Point current = q.poll();
            if(current.point == K){
                if(count == 0){
                    time = current.time;
                }
                if(time == current.time){
                    count++;
                }
                continue;
            }
            int array[] = {current.point - 1, current.point + 1, current.point * 2};
            for(int i = 0; i < 3; i++){
                int next = array[i];
                if(next < 0 || next > 100000){
                    continue;
                }
                if (visited[next] == 0 || visited[next] == current.time + 1) {
                    visited[next] = current.time + 1;
                    q.add(new Point(next, current.time + 1));
                }
            }
        }
    }
}
