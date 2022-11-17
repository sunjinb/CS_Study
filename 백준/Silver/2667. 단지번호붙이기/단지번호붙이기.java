import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.util.Collections.sort;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int count;
    static ArrayList<Integer> result;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
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
            String str = br.readLine();
            for(int j = 0; j < N; j++){
                map[i][j] = str.charAt(j)-'0';
            }
        }

        // 단지별 세대수
        count = 0;
        
        // 단지별 세대수가 몇개인지 저장
        result = new ArrayList<>();

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j] && map[i][j] == 1){
                    count = 1;
                    dfs(i, j);
                    result.add(count);
                }
            }
        }
        sort(result);
        System.out.println(result.size());
        for(int c : result){
            System.out.println(c);
        }

    }

    public static void dfs(int row, int col){
        visited[row][col] = true;
        
        for(int i = 0; i < 4; i++){
            int next_row = row + dy[i];
            int next_col = col + dx[i];
            if(next_row < 0 || next_col < 0 || next_row >= N || next_col >= N) {
                continue;
            }

            if(!visited[next_row][next_col] && map[next_row][next_col] == 1){
                count++;
                dfs(next_row, next_col);
            }
        }
    }
}
