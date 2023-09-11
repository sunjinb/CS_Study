import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static class Point{
        int num, depth;
        public Point(int num, int depth){
            this.num = num;
            this.depth = depth;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int A = 0, K = 0;
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Queue<Point> q = new LinkedList<>();
        visited = new boolean[1000004];
        q.add(new Point(A, 0));
        visited[A] = true;

        int result = 0;
        while(!q.isEmpty()){
            Point now = q.poll();

            if(now.num == K){
                result = now.depth;
                break;
            }

            if(now.num > K){
                continue;
            }

            int nextPlus = now.num + 1;
            if (nextPlus < 1000004 && !visited[nextPlus]) {
                q.add(new Point(nextPlus, now.depth + 1));
                visited[nextPlus] = true;
            }

            int nextMul = now.num * 2;
            if(nextMul < 1000004 && !visited[nextMul]){
                q.add(new Point(nextMul, now.depth + 1));
                visited[nextMul] = true;
            }
        }
        System.out.println(result);
    }
}
