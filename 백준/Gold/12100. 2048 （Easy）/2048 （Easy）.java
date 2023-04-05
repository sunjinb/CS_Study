import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int result;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        result = Integer.MIN_VALUE;
        dfs(0);
        System.out.println(result);
    }

    private static void dfs(int depth) {
        if(depth == 5){
            // 가장 수가 큰 블록 찾기
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    result = Math.max(result, map[i][j]);
                }
            }
            return;
        }

        // 다음 재귀 타고 map 건들겠지? 그럼 돌아왔을때는 그 전 상태의 맵으로 작업해야겠지? 그러니까 복사 해놔야겠지?
        int[][] tmpMap = new int[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                tmpMap[i][j] = map[i][j];
            }
        }

        for(int dir = 0; dir < 4; dir++){
            move(dir);
            dfs(depth + 1);
            // 재귀 타고 다시 돌아오면 map을 기억해놨던 걸로 다시 복사해서 써야겠지?
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    map[i][j] = tmpMap[i][j];
                }
            }
        }
    }

    // map으로 작업을 하자 왜냐하면 tmpMap이 이전 상태를 기억해줄테니
    private static void move(int dir) {
        // 위로 블록을 밀어보자
        if(dir == 0){
            for(int j = 0; j < N; j++){
                int index = 0;
                int block = 0;
                for(int i = 0; i < N; i++){
                    if(map[i][j] != 0){
                        if(map[i][j] == block){
                            map[index - 1][j] = block * 2;
                            block = 0;
                            map[i][j] = 0;
                        }
                        else{
                            block = map[i][j];
                            map[i][j] = 0;
                            map[index][j] = block;
                            index++;
                        }
                    }
                }
            }
        }

        // 아래로 블록을 밀어보자
        else if(dir == 1){
            for(int j = 0; j < N; j++){
                int index = N - 1;
                int block = 0;
                for(int i = N - 1; i >= 0; i--){
                    if(map[i][j] != 0){
                        if(block == map[i][j]){
                            map[index + 1][j] = block * 2;
                            block = 0;
                            map[i][j] = 0;
                        }
                        else{
                            block = map[i][j];
                            map[i][j] = 0;
                            map[index][j] = block;
                            index--;
                        }
                    }
                }
            }
        }

        // 왼쪽으로 블록을 밀어보자
        else if(dir == 2){
            for(int i = 0; i < N; i++){
                int index = 0;
                int block = 0;
                for(int j = 0; j < N; j++){
                    if(map[i][j] != 0){
                        if(block == map[i][j]){
                            map[i][index - 1] = block * 2;
                            block = 0;
                            map[i][j] = 0;
                        }
                        else{
                            block = map[i][j];
                            map[i][j] = 0;
                            map[i][index] = block;
                            index++;
                        }
                    }
                }
            }
        }

        // 오른쪽으로 블록을 밀어보자
        else if(dir == 3){
            for(int i = 0; i < N; i++){
                int index = N - 1;
                int block = 0;
                for(int j = N - 1; j >= 0; j--){
                    if(map[i][j] != 0){
                        if(block == map[i][j]){
                            map[i][index + 1] = block * 2;
                            block = 0;
                            map[i][j] = 0;
                        }
                        else{
                            block = map[i][j];
                            map[i][j] = 0;
                            map[i][index] = block;
                            index--;
                        }
                    }
                }
            }
        }
    }
}
