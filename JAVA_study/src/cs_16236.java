import java.io.*;
import java.util.*;

public class cs_16236{
    static int max_val = Integer.MAX_VALUE;
    static int max_int = Integer.MAX_VALUE;
    static int N;
    static int shark_row;
    static int shark_col;
    static int min_dist;
    static int min_row;
    static int min_col;
    static int result;
    static int eat_count = 0;
    static int shark_size = 2;
    static int [][] map, visited;
    static int [] d_row = {0, 0, 1, -1};
    static int [] d_col = {-1, 1, 0, 0};

    static class Shark {
        int row, col;

        Shark(int row, int col){
            this.row = row;
            this.col = col;
        }
    };

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        // 지도, 방문 여부 공간 할당
        map = new int[N][N];
        visited = new int[N][N];

        // 지도 그리기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                // 아기 상어가 있는 위치 기억하고, 지도에는 0으로 표기
                if (map[i][j] == 9) {
                    shark_row = i;
                    shark_col = j;
                    map[i][j] = 0;
                }
            }
        }

        // 먹이를 먹는 과정
        while(true){
            // 방문 여부 초기화, 최소 거리 초기화
            init_visited();

            // bfs로는 상어의 위치를 토대로 먹이들을 찾는 과정
            bfs(shark_row, shark_col);

            // 먹이를 찾았을 경우
            if(min_row != max_int && min_col != max_int){

                // 먹이를 잡아먹은 시간 추가
                result += visited[min_row][min_col];

                // 먹이 먹은 개수 증가
                eat_count++;
                // 아기 상어 몸집 크기만큼 먹이를 먹었다면
                if(eat_count == shark_size){
                    // 아기 상어 크기 증가, 먹이 먹은 개수 초기화
                    shark_size++;
                    eat_count = 0;
                }

                // 먹힌 먹이 지도에 0으로 표기
                map[min_row][min_col] = 0;

                // 상어의 위치 재설정
                shark_row = min_row;
                shark_col = min_col;
            }
            else{
                break;
            }
        }
        System.out.println(result);
    }

    // 상어의 위치가 변함에 따라 정보 초기화
    public static void init_visited(){
        min_dist = max_val;
        min_row = max_int;
        min_col = max_int;

        for(int i = 0; i< N; i++){
            for(int j = 0; j< N; j++){
                visited[i][j] = -1;
            }
        }
    }

    // 먹이를 찾는 과정
    public static void bfs(int row, int col){
        Queue<Shark> q = new LinkedList<Shark>();
        // 상어의 첫 위치의 방문 여부(거리)를 0으로 초기화
        visited[row][col] = 0;
        q.add(new Shark(row, col));

        while(!q.isEmpty()){
            Shark current = q.poll();
            row = current.row;
            col = current.col;

            for (int i = 0; i < 4; i++) {
                int next_row = row + d_row[i];
                int next_col = col + d_col[i];

                // 지도 이외의 공간 탐색 제외
                if (next_row < 0 || next_row >= N || next_col < 0 || next_col >= N) {
                    continue;
                }
                // 이미 방문했거나, 상어의 크기보다 큰 물고기가 있으면 제외
                if (visited[next_row][next_col] != -1 || map[next_row][next_col] > shark_size) {
                    continue;
                }

                // 다음 장소까지의 거리를 + 1
                visited[next_row][next_col] = visited[row][col] + 1;

                // 먹을 수 있는 물고기일 경우
                if (map[next_row][next_col] != 0 && map[next_row][next_col] < shark_size) {
                    // 현재 물고기까지의 이동 시간이 더 짧은 경우
                    if (min_dist > visited[next_row][next_col]) {
                        min_row = next_row;
                        min_col = next_col;
                        min_dist = visited[next_row][next_col];
                    }
                    // 현재 물고기까지의 이동 시간이 같을 경우
                    else if (min_dist == visited[next_row][next_col]) {
                        // 가장 위쪽
                        if (min_row == next_row) {
                            if (min_col > next_col) {
                                min_row = next_row;
                                min_col = next_col;
                            }
                        }
                        else if (min_row > next_row) {
                            min_row = next_row;
                            min_col = next_col;
                        }
                    }
                }
                // 물고기의 위치를 큐에 넣음
                q.add(new Shark(next_row, next_col));
            }
        }
    }
}

