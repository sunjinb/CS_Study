import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class cs_17136 {
    static int result;
    static final int N = 10;
    static int[] paperCount = {0, 5, 5, 5, 5, 5};
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        result = Integer.MAX_VALUE;
        dfs(0, 0, 0);
        if(result == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(result);
    }

    private static void dfs(int row, int col, int count) {
        // 색종이 모든 부분 다 탐색 완료
        if(row == N){
            result = Math.min(result, count);
            return;
        }

        // 지도 가로 다 탐색했으면
        if(col >= N){
            dfs(row + 1, 0, count);
            return;
        }
        else{
            // 색종이로 덮어야하는 부분이면
            if(map[row][col] == 1){
                for(int i = 5; i > 0; i--){
                    if(paperCount[i] > 0){
                        int endRow = row + i;
                        int endCol = col + i;
                        // 색종이가 지도를 벗어나면 붙일 수 없음
                        if(endRow - 1 >= N || endCol - 1>= N) continue;

                        boolean canPut = true;
                        // 실제로 색종이를 붙여도 되는가 여부 확인
                        for(int r = row; r < endRow; r++){
                            for(int c = col; c < endCol; c++){
                                if(map[r][c] != 1){
                                    canPut = false;
                                    break;
                                }
                            }
                        }

                        // 붙일 수 있으면 붙이자
                        if(canPut){
                            for(int r = row; r < endRow; r++){
                                for(int c = col; c < endCol; c++){
                                    map[r][c] = 0;
                                }
                            }
                            paperCount[i]--;
                            // 붙이고 다음 지점 이동
                            dfs(row, col + i, count + 1);
                            paperCount[i]++;
                            // 다른거 붙여야하니까 색종이 다시 떼기
                            for(int r = row; r < endRow; r++){
                                for(int c = col; c < endCol; c++){
                                    map[r][c] = 1;
                                }
                            }
                        }
                    }
                }
            }

            // 아니면 그냥 다음 위치로 재귀
            else{
                dfs(row, col + 1, count);
            }
        }
    }
}
