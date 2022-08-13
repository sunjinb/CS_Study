import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class cs_5014 {
    static int F, S, G, U, D;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 건물의 총 층수
        F = Integer.parseInt(st.nextToken());
        // 강호가 지금 있는 층
        S = Integer.parseInt(st.nextToken());
        // 스타트링크의 위치 (가야할 곳)
        G = Integer.parseInt(st.nextToken());
        // 위로 U층을 가는 버튼
        U = Integer.parseInt(st.nextToken());
        // 아래로 D층을 가는 버튼
        D = Integer.parseInt(st.nextToken());

        int[] arr = new int[F + 1];
        System.out.println(bfs(F, S, G, U, D, arr));
    }
    public static String bfs(int floor, int start, int end, int up, int down, int[] arr){
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);
        arr[start] = 1;

        while (!q.isEmpty()) {
            int current = q.poll();
            if (current == end) {
                return String.valueOf(arr[current] - 1);
            }
            //다음 up 이동할 위치가 최대값보다 작고 방문하지 않은 지점이여야 한다.
            if (current + up <= floor) {
                if (arr[current + up] == 0) {
                    arr[current + up] = arr[current] + 1;
                    q.add(current + up);
                }

            }
            //다음 down 이동할 위치가 최대값보다 작고 방문하지 않은 지점이여야 한다.
            if (current - down > 0) {
                if (arr[current - down] == 0) {
                    arr[current - down] = arr[current] + 1;
                    q.add(current - down);
                }
            }

        }
        return "use the stairs";
    }
}
