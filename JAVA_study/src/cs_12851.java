import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class cs_12851 {
    static int N, K;
    static int min_time;
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
        System.out.println(min_time);
        System.out.println(count);
    }


    public static void bfs(int start){
        Queue<Point> q = new LinkedList<>();
        // 시작점, 걸린 시간
        q.add(new Point(start, 0));

        // 첫 방문이기에 1로 설정
        visited[start] = 1;

        while (!q.isEmpty()) {
            Point current = q.poll();

            // 현재 위치가 목표 지점일 경우
            if(current.point == K){
                // 최초 도달일 경우
                if(count == 0){
                    // 최소 시간 설정
                    min_time = current.time;
                }
                // 도착 시간이 최소 시간일 경우
                if(min_time == current.time){
                    // 도달 방법 추가
                    count++;
                }
                continue;
            }

            // 이동 경로 3가지 설정
            int array[] = {current.point - 1, current.point + 1, current.point * 2};

            for(int i = 0; i < 3; i++){
                int next = array[i];
                // 범위 벗어났을 경우
                if(next < 0 || next > 100000){
                    continue;
                }
                // 아직 방문하지 않았거나, 방문했지만 최소 시간이라 판단했을 경우
                if (visited[next] == 0 || visited[next] == current.time + 1) {
                    // 다음 지점 시간 + 1;
                    visited[next] = current.time + 1;
                    q.add(new Point(next, current.time + 1));
                }
            }
        }
    }
}
