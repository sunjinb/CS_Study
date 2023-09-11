import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int A, B, N, M;
    static int[] d;
    static boolean[] visited;
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

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        d = new int[3];
        d[0] = 1;
        d[1] = A;
        d[2] = B;

        Queue<Point> q = new LinkedList<>();
        visited = new boolean[100004];

        q.add(new Point(N, 0));
        visited[N] = true;

        int result = 0;
        while(!q.isEmpty()){
            Point now = q.poll();

            if(now.spot == M){
                result = now.depth;
                break;
            }

            for(int i = 0; i < 3; i++){
                int nextPlusSpot = now.spot + d[i];
                int nextMinusSpot = now.spot - d[i];

                if(nextPlusSpot < 100001 && !visited[nextPlusSpot]){
                    visited[nextPlusSpot] = true;
                    q.add(new Point(nextPlusSpot, now.depth + 1));
                }

                if(nextMinusSpot >= 0 && !visited[nextMinusSpot]){
                    visited[nextMinusSpot] = true;
                    q.add(new Point(nextMinusSpot, now.depth + 1));
                }
            }

            int mulASpot = now.spot * d[1];
            int mulBSpot = now.spot * d[2];

            if(mulASpot < 100001 && !visited[mulASpot]){
                visited[mulASpot] = true;
                q.add(new Point(mulASpot, now.depth + 1));
            }

            if(mulBSpot < 100001 && !visited[mulBSpot]){
                visited[mulBSpot] = true;
                q.add(new Point(mulBSpot, now.depth + 1));
            }
        }

        System.out.println(result);
    }
}
