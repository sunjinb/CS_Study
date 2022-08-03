import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class cs_2468 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int max_height = 0;
    static int count;
    static int[] d_row = {1, 0, -1, 0};
    static int[] d_col = {0, -1, 0, 1};
    static int max_count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        // 지도 공간 할당
        map = new int[N][N];

        // 지도 그리기, 지도 최대최소값 설정
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                // 최대 높이 설정
                if(map[i][j] > max_height){
                    max_height = map[i][j];
                }
            }
        }

        max_count = 0;

        // 물에 잠기는 높이 순회
        for(int h = 0; h <= max_height; h++) {
            // 방문여부 공간 초기화
            visited = new boolean[N][N];
            count = 0;
            // 지도 탐색
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && map[i][j] > h) {
                        dfs(i, j, h);
                    }
                }
            }
            if(count > max_count){
                max_count = count;
            }
        }
        System.out.println(max_count);
    }
    public static void dfs(int row, int col, int height){
        visited[row][col] = true;

        for(int i = 0; i < 4; i++){
            int next_row = row + d_row[i];
            int next_col = col + d_col[i];

            if(next_row >= 0 && next_row < N && next_col >= 0 && next_col < N){
                if(!visited[next_row][next_col] && map[next_row][next_col] > height){
                    count++;
                    dfs(next_row, next_col, height);
                }
            }
        }
    }
}
