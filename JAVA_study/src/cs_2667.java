import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class cs_2667 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int count;
    static int[] result = new int[25 * 25];
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        // 지도, 방문했는지 여부 공간 할당
        map = new int[N][N];
        visited = new boolean[N][N];

        // 지도 그리기
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.toString();
            for(int j = 0; j < N; j++){
                map[i][j] = str.charAt(j);
            }
        }

        count = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j] && map[i][j] == 1){
                    count++;
                    dfs(i, j);
                }
            }
        }
        Arrays.sort(result);
        for(int o : result){
            if(result[o] != 0){
                System.out.println(result[o]);
            }
        }
    }

    public static void dfs(int row, int col){
        visited[row][col] = true;
        result[count]++;
        for(int i = 0; i < 4; i++){
            int next_row = row + dx[i];
            int next_col = col + dy[i];
            if(next_row < 0 || next_col < 0 || next_row >= N || next_col >= N) {
                continue;
            }

            if(!visited[next_row][next_col] && map[next_row][next_col] == 1){
                dfs(next_row, next_col);
                count++;
            }
        }
    }
}
