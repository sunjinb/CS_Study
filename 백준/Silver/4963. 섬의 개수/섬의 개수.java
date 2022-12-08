import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int w, h;
    static int[][] map;
    static boolean[][] visited;
    static int count;
    static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int[] dy = {1, 1, 1, 0, 0, -1, -1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while(true){
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if(w == 0 && h == 0){
                break;
            }

            map = new int[h][w];
            visited = new boolean[h][w];
            count = 0;

            // 지도 그리기
            for(int i = 0; i < h; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < w; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            //땅 하나씩 섬인지 판별
            for(int i = 0; i < h; i++){
                for(int j = 0; j < w; j++){
                    //아직 방문하지 않았고, 육지라면 탐색
                    if(!visited[i][j] && map[i][j] == 1){
                        dfs(i, j);
                        count++;
                        // 주변이 모두 바다인지 확인 맞다면 count++;
                    }
                }
            }
            sb.append(count).append('\n');
        }
        System.out.println(sb);
    }

    public static void dfs(int row, int col){
        // 방문 했어
        visited[row][col] = true;
        // 현재 위치 기준 8면을 확인해야함
        for(int i = 0; i < 8; i++){
            int next_row = row + dy[i];
            int next_col = col + dx[i];

            //범위를 벗어낫을 경우
            if(next_row < 0 || next_row >= h || next_col < 0 || next_col >= w){
                continue;
            }

            //아직 방문하지 않았고, 그곳이 육지라면
            if(!visited[next_row][next_col] && map[next_row][next_col] == 1){
                dfs(next_row, next_col);
            }
        }
    }
}


