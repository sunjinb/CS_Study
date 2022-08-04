import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class cs_2583 {
    static int[][] map;
    static boolean[][] visited;
    static int M;
    static int N;
    static int K;
    static ArrayList<Integer> result;
    static int count;
    static int[] d_row = {-1, 0, 1, 0};
    static int[] d_col = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        // 입력 받기
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 지도, 그릴 사각형 좌표 공간 할당
        map = new int[M][N];
        int[] point = new int[4];

        // 사각형 좌표 입력
        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < point.length; j++){
                point[j] = Integer.parseInt(st.nextToken());
            }
            // 지도 그리기
            for(int height = point[1]; height < point[3]; height++){
                for(int width = point[0]; width < point[2]; width++){
                    map[M - 1 - height][width] = 1;
                }
            }
        }

//         지도 잘 그려졌는지 확인
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        count = 0;

        visited = new boolean[M][N];
        result = new ArrayList<Integer>();

        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j] && map[i][j] == 0){
                    count = 0;
                    dfs(i, j);
                    result.add(count);
                }
            }
        }
        System.out.println(result.size());
        Collections.sort(result);
        for(int r : result){
            System.out.print(r + " ");
        }
    }

    public static void dfs(int row, int col){
        visited[row][col] = true;
        count++;

        for(int i = 0; i < 4; i++){
            int next_row = row + d_row[i];
            int next_col = col + d_col[i];

            if(next_row >= 0 && next_row < M && next_col >= 0 && next_col < N){
                if(!visited[next_row][next_col] && map[next_row][next_col] == 0){
                    dfs(next_row, next_col);
                }
            }
            else{
                continue;
            }
        }
    }
}
