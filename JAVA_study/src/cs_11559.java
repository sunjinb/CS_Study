import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class cs_11559 {
    static char[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;
    static List<int[]> connect_list;
    static int result;
    static int connect_count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 공간 할당
        map = new char[12][6];

        // 뿌요 그리기
        for(int i = 0; i < 12; i++){
            String str  = new String(br.readLine());
            for(int j = 0; j < 6; j++){
                map[i][j] = str.charAt(j);
            }
        }
        
        while(true){
            // 종료 조건
            boolean enough = false;
            for(int i = 0; i < 12; i++){
                for(int j = 0; j < 6; j++){
                    // 뿌요 만나면
                    if(map[i][j] != '.'){
                        char color = map[i][j];
                        // 방문 여부 초기화
                        visited = new boolean[12][6];
                        connect_list = new ArrayList<>();
                        connect_count = bfs(i, j, color);
                        // 연결 요소가 4 이상이라면 
                        if(connect_count >= 4){
                            enough = true;
                            // 뿌요들 지우고 . 으로 채우기 
                            for (int[] change : connect_list) {
                                int change_x = change[0], change_y = change[1];
                                map[change_x][change_y]	= '.';
                            }
                        }
                    }
                }
            }
            // 아무 반응 없었다면
            if(!enough){
                break;
            }
            // 뿌요가 터졌다면 다음 루프
            else{
                // 시간 올리고 맵 업데이트
                result++;
                mapUpdate();
            }
        }
        System.out.println(result);
    }

    public static int bfs(int row, int col, char color){
        Queue<int[]> q = new LinkedList();
        visited[row][col] = true;

        q.add(new int[]{row, col});
        connect_list.add(new int[]{row, col});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cur_row = cur[0];
            int cur_col = cur[1];

            for(int i = 0; i < 4; i++){
                int next_row = cur_row + dx[i];
                int next_col = cur_col + dy[i];

                if (next_row < 0 || next_row > 11 || next_col < 0 || next_col > 5) {
                    continue;
                }

                if (!visited[next_row][next_col] && map[next_row][next_col] == color) {
                    // 연결요소 리스트에 추가
                    connect_list.add(new int[]{next_row, next_col});
                    // 방문 여부 
                    visited[next_row][next_col] = true;
                    // 큐에 추가
                    q.add(new int[]{next_row,next_col});
                }
            }
        }
        return connect_list.size();
    }

    public static void mapUpdate(){
        for (int i = 11; i > 0; i--) {
            for (int j = 0; j < 6; j++) {
                // 밑에가 지워지고, 위에 뿌요가 남아있는 상황이라면
                if (map[i][j] == '.' && map[i - 1][j] != '.') {
                    map[i][j] = map[i - 1][j];
                    map[i - 1][j] = '.';
                }
            }
        }
    }
}
