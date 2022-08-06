import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class cs_7576 {
    static int M;
    static int N;
    static int[][] map;
    static Queue<int[]> q = new LinkedList<>();
    static int[] d_row = {-1, 0, 1, 0};
    static int[] d_col = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][N];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1){
                    // 큐에 삽입
                    q.add(new int[] {i, j});
                }
            }
        }
        System.out.println(bfs());
    }
    public static int bfs() {
        while (!q.isEmpty()) {
            // 노드 하나 꺼내서 x, y 값 추출
            int[] tail = q.poll();

            for (int i = 0; i < 4; i++) {
                int next_row = tail[0] + d_row[i];
                int next_col = tail[1] + d_col[i];

                if (next_row < 0 || next_row >= N || next_col < 0 || next_col >= M) {
                    continue;
                }
                if (map[next_row][next_col] == 0) {
                    continue;
                }
                // 같은 순위에 있는 큐들 삽입
                q.add(new int[]{next_row, next_col});
            }
        }
        return 1;
    }
}
